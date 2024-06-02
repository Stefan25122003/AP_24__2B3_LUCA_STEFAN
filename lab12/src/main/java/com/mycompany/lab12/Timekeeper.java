
package com.mycompany.lab12;


public class Timekeeper extends Thread {
    private final long limit;
    private final Thread[] players;

    public Timekeeper(long limit, Thread... players) {
        this.limit = limit;
        this.players = players;
        setDaemon(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(limit);
            System.out.println("Time limit reached. Stopping all players.");
            for (Thread player : players) {
                player.interrupt();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


