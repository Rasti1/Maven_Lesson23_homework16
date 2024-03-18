package org.example.project.controller;

import org.example.project.entity.Post;
import org.example.project.model.PostModel;
import org.example.project.utils.AppStarter;
import org.example.project.utils.Constants;
import org.example.project.view.PostByIdView;
import retrofit2.Response;

import java.util.Optional;

public class PostByIdController {

    private final PostModel model;
    private final PostByIdView view;

    public PostByIdController(PostModel model, PostByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getPostById() {
        view.getOutput(readPostById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();
    }

    private String readPostById(int id) {
        Optional<Response<Post>> optional = model.fetchPostById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Response<Post> response = optional.get();
            if (!response.isSuccessful() || response.body() == null) {
                return Constants.NO_DATA_MSG;
            }

            Post post = response.body();

            String str = "";
            if (post.getUserId() > 0) {

                str += "Post: \nuserId: " + post.getUserId() + "; ";

            } else {

                str += "User: id: " + post.getId() + "; ";

            }
            str += "\nid: " + post.getId() + "; ";
            str += "\ntitle: " + post.getTitle() + "; ";
            str += "\nbody: " + post.getBody();

            return str;
        }
    }
}
