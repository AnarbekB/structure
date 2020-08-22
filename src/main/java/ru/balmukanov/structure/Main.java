package ru.balmukanov.structure;

import ru.balmukanov.structure.binary.BinaryTree;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        String[] keys = {"aaa", "a", "ccc", "two", "aa", "aab", "aac", "one"};

        for (String key: keys) {
            binaryTree.insert(key, getRandomString());
        }

        System.out.println("EXIT");
    }

    public static String getRandomString() {
        String SALTCELLARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCELLARS.length());
            salt.append(SALTCELLARS.charAt(index));
        }
        return salt.toString();
    }
}
