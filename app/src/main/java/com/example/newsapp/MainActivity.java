package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//d58bef585b2248c8a2bcc91d9bbe7f2e

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsRV;
    private Adapter adapter;
    private ArrayList<articles> articlesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRV=findViewById(R.id.newsRV);
        articlesArrayList=new ArrayList<>();
        adapter=new Adapter(articlesArrayList,this);
        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(adapter);

        getNews();
        adapter.notifyDataSetChanged();

    }

    private void getNews (){
        String url="https://newsapi.org/v2/top-headlines?country=in&excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apiKey=d58bef585b2248c8a2bcc91d9bbe7f2e";
        String BASE_URL="https://newsapi.org/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        networkingAPI NetworkingAPI=retrofit.create(networkingAPI.class);

        Call<NewsModel> call;
        call=NetworkingAPI.getAllNews(url);

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {

                NewsModel newsModel=response.body();
                ArrayList<articles>  articles=newsModel.getArticles();
                for(int i=0;i<articles.size();i++){
                    articlesArrayList.add(new articles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrl(),articles.get(i).getUrlToImage(),articles.get(i).getContent()));

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}