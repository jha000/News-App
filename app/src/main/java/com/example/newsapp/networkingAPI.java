package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface networkingAPI {

    @GET
    Call<NewsModel> getAllNews (@Url String url);

}
