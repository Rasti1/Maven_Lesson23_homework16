package org.example.project.model;


import org.example.project.controller.PostByIdController;
import org.example.project.controller.PostsController;
import org.example.project.view.PostByIdView;
import org.example.project.view.PostsView;

public class AppModel {

    private final PostModel postModel;

    public AppModel(PostModel postModel) {
        this.postModel = postModel;
    }

    public void readPosts() {
        PostsView view = new PostsView();
        PostsController controller = new PostsController(postModel, view);
        controller.getPosts();
    }

    public void readPostById() {
        PostByIdView view = new PostByIdView();
        PostByIdController controller = new PostByIdController(postModel, view);
        controller.getPostById();
    }
}
