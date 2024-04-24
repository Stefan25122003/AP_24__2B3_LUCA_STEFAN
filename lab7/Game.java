
package mycompany;

import java.util.ArrayList;
import java.util.List;

public class Game {
 List<Player> playersList;


    public Game() {
        this.playersList = new ArrayList<>();
    }



    public void addNewPlayer(Player player)
    {
        this.playersList.add(player);
    }

    public void play() {
        for (Player player: this.playersList)
        {
            Thread thread = new Thread(player);
            thread.start();
        }
    }   
}
