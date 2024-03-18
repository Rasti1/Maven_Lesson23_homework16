package org.example.project.controller;

import org.example.project.entity.Post;
import org.example.project.model.PostModel;
import org.example.project.utils.AppStarter;
import org.example.project.utils.Constants;
import org.example.project.view.PostsView;
import retrofit2.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PostsController {

    private final PostModel model;
    private final PostsView view;

    public PostsController(PostModel model, PostsView view) {
        this.model = model;
        this.view = view;
    }

    public void getPosts() {
        view.getOutput(readPosts());
        AppStarter.startApp();
    }

    private String readPosts() {
        Optional<Response<List<Post>>> optional = model.fetchPosts();
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Response<List<Post>> response = optional.get();
            if (!response.isSuccessful() || response.body() == null) {
                return Constants.NO_DATA_MSG;
            }

            List<Post> posts = response.body();

            Set<Integer> userIds = new HashSet<>();
            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);

            for (Post post : posts) {
                String str = cnt.incrementAndGet() + ") ";

                if (userIds.contains(post.getUserId())) {

                    str += "Post: \nuserId: " + post.getUserId() + "; ";

                } else {

                    str += "User: id: " + post.getUserId() + "; ";
                    userIds.add(post.getUserId());

                }

                str += "\nid: " + post.getId() + "; ";
                str += "\ntitle: " + post.getTitle() + "; ";
                str += "\nbody: " + post.getBody() + "\n";

                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }
    }
}
