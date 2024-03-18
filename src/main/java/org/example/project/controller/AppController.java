package org.example.project.controller;

import org.example.project.model.AppModel;
import org.example.project.view.AppView;

public class AppController {

    private final AppModel model;
    private final AppView view;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        int choice = view.getMenu();
        switch (choice) {
            case 1 -> model.readPosts();
            case 2 -> model.readPostById();
            case 0 -> {
                view.getOutput("App closed.");
            }
            default -> view.getOutput("Invalid value. Try again.");
        }
    }
}
