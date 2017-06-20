package com.ahsanburney;

/**
 * Created by Kulsum on 6/19/2017.
 */
public  abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
