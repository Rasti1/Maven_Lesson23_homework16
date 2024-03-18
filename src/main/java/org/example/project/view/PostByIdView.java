package org.example.project.view;

import java.util.Scanner;

public class PostByIdView {

    private final Scanner scanner = new Scanner(System.in);

    public String getData() {
        System.out.print("Input user's id: ");
        return scanner.nextLine();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
