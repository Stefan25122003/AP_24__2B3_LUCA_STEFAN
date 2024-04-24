package mycompany;
import org.example.util.Token;
import java.util.HashSet;
import java.util.Set;

public class Player implements Runnable {
    private final String name;
    private final Bag bag;
    private final Set<Token> collectedTokens = new HashSet<>();
    private int maxSequence = 0;

    public Player(String name, Bag bag) {
        this.name = name;
        this.bag = bag;
    }

    @Override
    public void run() {
        while (true) {
            Token token = bag.extractToken();
            if (token == null) break; 
            collectedTokens.add(token);

            tryCalculatingSequence();
            System.out.println(name + " extracted " + token + " (Max Sequence: " + maxSequence + ")");
        }
    }

    private void tryCalculatingSequence() {
        for (Token startToken : collectedTokens) {
            Set<Token> visited = new HashSet<>();
            int sequence = findMaxSequence(startToken, startToken, visited, 0);
            if (sequence > maxSequence) {
                maxSequence = sequence;
            }
        }
    }

    private int findMaxSequence(Token current, Token startToken, Set<Token> visited, int length) {
        int max = length;
        visited.add(current); 

        for (Token next : collectedTokens) {
            if (current.getToken2() == next.getToken1() && !visited.contains(next)) {
                int candidate = findMaxSequence(next, startToken, new HashSet<>(visited), length + 1);
                max = Math.max(max, candidate);
            } else if (current.getToken2() == startToken.getToken1() && length > 0) {
                max = Math.max(max, length + 1);  
            }
        }
        return max;
    }

    public int getMaxSequence() {
        return maxSequence;
    }

    public String getName() {
        return name;
    }
}
