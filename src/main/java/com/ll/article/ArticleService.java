package com.ll.article;

import java.util.List;

public class ArticleService {


    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int create(String title, String content, int memberId) {
        return articleRepository.create(title, content, memberId);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    public void remove(Article article) {
        articleRepository.remove(article);
    }

    public void modify(Article article, String modifyTitle, String modifyContent) {
        articleRepository.modify(article, modifyTitle, modifyContent);
    }

    public Member login( String userid, String password) {
        return articleRepository.findByLoginInfo(userid, password);
    }

    public int signin(String userid, String password) {
        int newMemberId = articleRepository.signin(userid, password);
        return newMemberId;
    }
}
