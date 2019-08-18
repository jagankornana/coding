package com.hackerrank.java;

public class Deadlock {

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();

        new Thread(() -> gaston.bow(alphonse)).start();
    }

    static class Friend {
        private final String name;

        Friend(String name) {
            this.name = name;
        }

        String getName() {
            return this.name;
        }

        synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name,
                    bower.getName());
            System.out.println("Waiting for " + bower.getName());
            bower.bowBack(this);
        }

        synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name,
                    bower.getName());
        }
    }
}