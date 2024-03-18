package org.example.project.model;

import org.example.project.entity.Post;
import org.example.project.network.ApiClient;
import org.example.project.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;

public class PostModel {

    public Optional<Response<List<Post>>> fetchPosts() {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<List<Post>> call = service.getPosts();
        Optional<Response<List<Post>>> optional;

        try {
            Response<List<Post>> response = call.execute();
            optional = Optional.of(response);
        } catch (Exception ex) {
            optional = Optional.empty();
        }

        return optional;
    }

    // REST api/users/{id}
    public Optional<Response<Post>> fetchPostById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<Post> call = service.getPostById(id);
        Optional<Response<Post>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception ex) {
            optional = Optional.empty();
        }

        return optional;
    }
}

