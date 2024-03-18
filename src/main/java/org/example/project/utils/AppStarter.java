package org.example.project.utils;


import org.example.project.controller.AppController;
import org.example.project.model.AppModel;
import org.example.project.model.PostModel;
import org.example.project.view.AppView;

public class AppStarter {

    public static void startApp() {

        PostModel postModel = new PostModel();
        AppModel appModel = new AppModel(postModel);
        AppView appView = new AppView();
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
