package com.ll;

import com.ll.db.DBConnection;
import com.ll.article.Member;
import java.util.Scanner;

import static com.ll.article.Member.loginMember;


public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {

        sc.close();
    }

    public static Scanner getSc() {

        return sc;
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }



    public static Member getLoginMember() {
        return loginMember;
    }

    public static void setLoginMember(Member member) {
        loginMember = member;
    }


}
