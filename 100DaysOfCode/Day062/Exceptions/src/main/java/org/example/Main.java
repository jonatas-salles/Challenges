package org.example;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        User user1 = new User("John");
        User user2 = new User("Lea");

        // Adding user1
        try {
            userManager.addUser(user1);
            System.out.println("Success! User " + user1.getName() + " added\n");
        }
        catch (AlreadyExistsException e) {
            e.printStackTrace();
        }

        // Printing current users
        Iterator<User> userIterator = userManager.listUsers();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next().toString());
        }

        // Trying to add user1 again so it raises an exception
        try {
            userManager.addUser(user1);
            System.out.println("Success! User " + user1.getName() + " added\n");
        }
        catch (AlreadyExistsException e) {
            e.printStackTrace();
        }

        // Trying to remove a user that has not been added
        try {
            userManager.removeUser(user2);
            System.out.println("Success! User " + user2.getName() + " removed\n");
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }

        // Removing user1
        try {
            userManager.removeUser(user1);
            System.out.println("Success! User " + user1.getName() + " removed\n");
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }

        // Printing current users
        userIterator = userManager.listUsers();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next().toString());
        }

        // Adding all users
        try {
            userManager.addUser(user1);
            System.out.println("Success! User " + user1.getName() + " added\n");
            userManager.addUser(user2);
            System.out.println("Success! User " + user2.getName() + " added\n");
        }
        catch (AlreadyExistsException e) {
            e.printStackTrace();
        }

        // Printing current users
        userIterator = userManager.listUsers();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next().toString());
        }
    }
}