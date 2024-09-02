package org.example;

// using composite design pattern...
public class Main {
    public static void main(String[] args) {
        Directory movies = new Directory("Movies");
        FileSystem movie1 = new File("Titanic");
        movies.add(movie1);
        Directory comedy = new Directory("ComedyMovie");
        FileSystem movie2 = new File("ScaryMovie");
        comedy.add(movie2);
        movies.add(comedy);
        movies.ls();
    }
}