package com.copypasteit.androidversionhistory.main.data.remote;

import com.copypasteit.androidversionhistory.main.model.Post;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/api/post")
    Call<List<Post>> getpost();

    @GET("/api/post")
    Call<List<Post>> getUsers(@Query("name") String keyword);
}
