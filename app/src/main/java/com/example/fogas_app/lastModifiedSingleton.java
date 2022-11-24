package com.example.fogas_app;

public class lastModifiedSingleton {
    public int getLastModified() {
        return lastModified;
    }

    public void setLastModified(int lastModified) {
        this.lastModified = lastModified;
    }

    private int lastModified;

    private static lastModifiedSingleton instance;

    public static lastModifiedSingleton getInstance() {
        if (instance == null)
            instance = new lastModifiedSingleton();
        return instance;
    }
}
