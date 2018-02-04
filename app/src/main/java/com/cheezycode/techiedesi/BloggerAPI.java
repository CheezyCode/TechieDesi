package com.cheezycode.techiedesi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerAPI {

    private static final String key = "AIzaSyAVgAw1TDa-mZzcr18-3FKXAKAXEIyubM0";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/394040623688436172/posts/";

    public static PostService postService = null;

    public static PostService getService()
    {
        if(postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService {
        @GET("?key=" + key)
        Call<PostList> getPostList();
    }


}
