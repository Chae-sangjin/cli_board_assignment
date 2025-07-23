package com.ll.article;

import com.ll.Container;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    int lastId = 1;


    public int create(String title, String content, int memberId) {
        String sql = String.format("insert ignore into article set title='%s', content='%s', memberid=%d, regDate=NOW()", title, content, memberId);
        int id = Container.getDBConnection().insert(sql);

        return id;
    }

    public List<Article> findAll() {
        List<Article> articleList = new ArrayList<>();

        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from article");

        for (Map<String, Object> row : rows) {
            Article article = new Article(row);
            articleList.add(article);
        }

        return articleList;
    }

    public Article findById(int id) {
        List<Article> articleList = this.findAll();
        for ( Article item : articleList ) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void remove(Article article) {
        String sql = String.format("DELETE from article where id = %d", article.getId());
        Container.getDBConnection().delete(sql);
    }

    public void modify(Article article, String modifyTitle, String modifyContent) {
        String sql = String.format("update article set title='%s', content='%s' where id = %d", modifyTitle, modifyContent, article.getId());
        Container.getDBConnection().update(sql);
    }

    public Member findByLoginInfo(String userid, String password) {
        String sql = String.format("SELECT * FROM member WHERE userId='%s' and password='%s'", userid, password);
        Map<String, Object> row = Container.getDBConnection().selectRow(sql);

        if (row == null || row.isEmpty()) {
            return null;
        }

        return new Member(
                (int) row.get("id"),
                (String) row.get("userId"),
                (String) row.get("password"),
                ((LocalDateTime) row.get("regDate")).toString()
        );

    }

    public int signin(String userid, String password) {
        String sql = String.format("insert into member set userid='%s', password='%s', regDate=NOW()", userid, password);
        return Container.getDBConnection().insert(sql);
    }
}

