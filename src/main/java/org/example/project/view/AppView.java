package org.example.project.view;

import java.util.Scanner;

public class AppView {

    private final Scanner scanner = new Scanner(System.in);

    public int getMenu() {
        System.out.println("""
                                                
                _____ MENU ________________
                1 - Get all posts.
                2 - Get post by id.
                0 - Close the application.
                """);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void getOutput(String output) {
         System.out.println(output);
    }
}
