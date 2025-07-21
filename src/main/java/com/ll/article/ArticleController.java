package com.ll.article;

import com.ll.Container;
import com.ll.Request;

import java.util.List;

public class ArticleController {
    ArticleService articleService;


    public ArticleController() {
        articleService = new ArticleService();
    }


    public void write() {
        System.out.print("title : ");
        String title = Container.getSc().nextLine().trim();
        System.out.print("content : ");
        String content = Container.getSc().nextLine().trim();

        Member loginMember = Container.getLoginMember();
        if (loginMember == null) {
            System.out.println("로그인 후 사용 가능합니다.");
            return;
        }


        int memberId =  Container.getLoginMember().getId();

        int id = articleService.create(title, content, memberId);
        System.out.printf("%d번 게시글이 등록 되었습니다\n", id);

    }

    public void list() {
        List<Article> articleList = articleService.findAll();
        System.out.println("번호 / 제목 / 내용");
        System.out.println("---------------");

        for (int i = articleList.size() -1; i >=0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s\n", article.getId(), article.getTitle(), article.getContent());
        }

    }

    public void delete(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if (id == 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }


        Article article = articleService.findById(id);


        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);

        } else {
            articleService.remove(article);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
        }
    }

    public void modify(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if (id == 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = articleService.findById(id);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
        }


        else {
            System.out.printf("제목(기존) : %s\n", article.getTitle());
            System.out.print("제목 : ");
            String modifySubject = Container.getSc().nextLine();

            System.out.printf("내용(기존) : %s\n", article.getContent());
            System.out.print("내용 : ");
            String modifyContent = Container.getSc().nextLine();
            articleService.modify(article, modifySubject, modifyContent);


            System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
        }


    }

    private int _getIntParam(String id) {
        int defaultValue = 0;
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void login(Request request) {

        if (Container.getLoginMember() != null) {
            System.out.println("로그아웃 후 다시 시도해주세요");
            return;
        }

        System.out.print("아이디를 입력해주세요 : ");
        String userid = Container.getSc().nextLine();

        System.out.print("비밀번호를 입력해주세요 : ");
        String password = Container.getSc().nextLine();

        Member member = articleService.login(userid, password);

        if (member == null) {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다");
            return;
        }

        Container.setLoginMember(member);
        System.out.println("로그인 성공 했습니다");

    }

    public void logout(Request request) {
        if (Container.getLoginMember() == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        Container.setLoginMember(null);
        System.out.println("로그아웃 했습니다.");
    }



    public void signin(Request request) {
        System.out.print("아이디를 등록해주세요 : ");
        String userid = Container.getSc().nextLine().trim();

        System.out.print("비밀번호를 등록해주세요 : ");
        String password = Container.getSc().nextLine().trim();


        int id = articleService.signin(userid, password);

        if (id > 0 ) {
            System.out.printf("%s님, 가입 완료되었습니다\n", userid);
        } else {
            System.out.println("회원가입 실패, 아이디 중벅 여부를 확인해주새요.");
        }

    }

}
