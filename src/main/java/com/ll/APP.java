package com.ll;

import java.util.Scanner;

public class APP {
    Scanner sc;
    APP(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        int lastId = 1;
        System.out.println("==게시판 앱 ==");



        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();
            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("제목 : ");
                String subject = sc.nextLine();
                System.out.print("내용 : ");
                String content = sc.nextLine();
                System.out.printf("%d번 게시물이 등록되었습니다.\n", lastId);
                lastId++;
            } else if (command.equals("목록")) {
                System.out.print("번호 / 제목 / 내용");

            }
        }

    }
}
