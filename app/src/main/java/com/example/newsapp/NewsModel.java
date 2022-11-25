package com.example.newsapp;

import java.util.ArrayList;

public class NewsModel {

    private int totalResults;
    private String status;
    private ArrayList<articles> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<com.example.newsapp.articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<com.example.newsapp.articles> articles) {
        this.articles = articles;
    }

    public NewsModel(int totalResults, String status, ArrayList<com.example.newsapp.articles> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;
    }
}
