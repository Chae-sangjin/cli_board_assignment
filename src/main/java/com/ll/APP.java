package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.system.SystemController;


public class APP {
    ArticleController articleController;
    SystemController systemController;


    APP() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();

        articleController = new ArticleController();
        systemController = new SystemController();
    }
    public void run() {

        System.out.println("==게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine();

            Request request = new Request(command);

            if (request.getActionCode().equals("종료")) {
                systemController.exit();
                break;
            } else if (request.getActionCode().equals("등록")) {
                articleController.write();

            } else if (request.getActionCode().equals("목록")) {
                articleController.list();

            } else if( request.getActionCode().startsWith("삭제")) {
                articleController.delete(request);

            } else if (request.getActionCode().startsWith("수정")) {
                articleController.modify(request);

            } else if ( request.getActionCode().equals("로그인")) {
                articleController.login(request);

            } else if (request.getActionCode().equals("회원가입")) {
                articleController.signin(request);

            } else if (request.getActionCode().equals("로그아웃")) {
                articleController.logout(request);
            }


            }
        }


    }



