package com.ll.article;

import java.util.Map;

public class Article {
    private int id;
    private String title;
    private String content;

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
    }



    int getId() {
        return this.id;
    }

    String getTitle() {
        return this.title;

    }

    String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
