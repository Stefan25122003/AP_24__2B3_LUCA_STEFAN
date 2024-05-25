package com.mycompany.serveraplicattion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Map<String, GameSession> games;
    private final Map<String, List<ClientHandler>> gameClientHandlers;
    private GameSession gameSession;
    private String gameName;
    private int playerIndex;

    public ClientHandler(Socket clientSocket, Map<String, GameSession> games, Map<String, List<ClientHandler>> gameClientHandlers) throws IOException {
        this.clientSocket = clientSocket;
        this.dis = new DataInputStream(clientSocket.getInputStream());
        this.dos = new DataOutputStream(clientSocket.getOutputStream());
        this.games = games;
        this.gameClientHandlers = gameClientHandlers;
    }

    @Override
    public void run() {
        try {
            dos.writeUTF("Welcome! Please create or join a game.");
            while (true) {
                String clientMessage = dis.readUTF();
                processClientMessage(clientMessage);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            cleanup();
        }
    }

private void processClientMessage(String clientMessage) {
    String[] parts = clientMessage.split("\\s+");
    if (parts.length >= 2) {
        switch (parts[0].toLowerCase()) {
            case "create":
                createGame(parts[1]);
                break;
            case "join":
                joinGame(parts[1]);
                break;
            case "attack":
                if (parts.length == 3) {
                    try {
                        int x = Integer.parseInt(parts[1]);
                        int y = Integer.parseInt(parts[2]);
                        String result = gameSession.processAttack(playerIndex, x, y);
                        sendToClient(result);
                        if (gameSession.isGameOver()) {
                            sendToClient("Game Over! You win!");
                            for (ClientHandler client : gameClientHandlers.get(gameName)) {
                                if (client != this) {
                                    client.sendToClient("Game Over! You lose!");
                                }
                            }
                        } else {
                            gameSession.switchPlayer();
                            relayMessageToClients();
                        }
                    } catch (NumberFormatException e) {
                        sendToClient("Invalid coordinates for attack. Use integers.");
                    }
                } else {
                    sendToClient("Invalid attack command format. Use: attack [x] [y]");
                }
                break;
            default:
                sendToClient("Unknown command.");
                break;
        }
    } else {
        sendToClient("Invalid command.");
    }
}


    private void createGame(String gameName) {
        if (games.containsKey(gameName)) {
            sendToClient("Game with this name already exists.");
        } else {
            gameSession = new GameSession();
            games.put(gameName, gameSession);
            gameClientHandlers.put(gameName, new ArrayList<>());
            gameClientHandlers.get(gameName).add(this);
            this.gameName = gameName;
            this.playerIndex = 0;
            sendToClient("Game created and joined successfully.");
        }
    }

    private void joinGame(String gameName) {
        if (!games.containsKey(gameName)) {
            sendToClient("Game with this name does not exist.");
        } else {
            gameSession = games.get(gameName);
            List<ClientHandler> clients = gameClientHandlers.get(gameName);
            if (clients.size() < 2) {
                clients.add(this);
                this.gameName = gameName;
                this.playerIndex = 1;
                sendToClient("Joined game successfully.");
                if (clients.size() == 2) {
                    for (ClientHandler client : clients) {
                        client.sendToClient("Both players joined. Game starts now.");
                    }
                    relayMessageToClients();
                }
            } else {
                sendToClient("Game is already full.");
            }
        }
    }

   private void relayMessageToClients() {
    try {
        List<ClientHandler> clients = gameClientHandlers.get(gameName);
        for (ClientHandler client : clients) {
            boolean isCurrentClient = client == this;
            String[][] board = isCurrentClient ? gameSession.getPlayerView(playerIndex) : gameSession.getOpponentView(playerIndex);
            StringBuilder messageWithBoard = new StringBuilder();

            messageWithBoard.append("Current Player: ").append(gameSession.getCurrentPlayer() + 1).append("\n\n");

            messageWithBoard.append("Your Board:\n");
            appendBoardToMessage(messageWithBoard, gameSession.getPlayerView(client.playerIndex));
            messageWithBoard.append("\n");

            messageWithBoard.append("Opponent's Board:\n");
            appendBoardToMessage(messageWithBoard, gameSession.getOpponentView(client.playerIndex));
            messageWithBoard.append("\n");

            client.dos.writeUTF(messageWithBoard.toString());
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

private void appendBoardToMessage(StringBuilder message, String[][] board) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            message.append(board[i][j]).append(" ");
        }
        message.append("\n");
    }
}


    private void sendToClient(String message) {
        try {
            dos.writeUTF(message);
            dos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void cleanup() {
        if (gameName != null && gameClientHandlers.containsKey(gameName)) {
            gameClientHandlers.get(gameName).remove(this);
        }

        try {
            dis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
