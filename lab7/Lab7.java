package mycompany;

public class Lab7 {
    public static void main(String[] args) {
        final int n = 5; 
        Bag bag = new Bag(n);

        Player player1 = new Player("Player 1", bag);
        Player player2 = new Player("Player 2", bag);
        Player player3 = new Player("Player 3", bag);

        Thread t1 = new Thread(player1);
        Thread t2 = new Thread(player2);
        Thread t3 = new Thread(player3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("The game was interrupted.");
        }

        determineWinner(new Player[] { player1, player2, player3 });
    }

    private static void determineWinner(Player[] players) {
        Player winner = null;
        int maxScore = 0;
        for (Player player : players) {
            int score = player.getMaxSequence();
            if (score > maxScore) {
                maxScore = score;
                winner = player;
            }
            System.out.println(player.getName() + " final score: " + score);
        }

        if (winner != null) {
            System.out.println("Winner: " + winner.getName() + " with score: " + maxScore);
        } else {
            System.out.println("It's a tie.");
        }
    }
}
