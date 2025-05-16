package com.example.assignment2;

public class Country {
    private String name;
    private int flagResId;

    public Country(String name, int flagResId) {
        this.name = name;
        this.flagResId = flagResId;
    }

    public String getName() {
        return name;
    }

    public int getFlagResId() {
        return flagResId;
    }
}