package com.rishabh.sqldemo;


import com.rishabh.sqldemo.dao.UserDao;

public class Main {

    public static void main(String[] args) throws Exception {

        UserDao dao = new UserDao();

        String username = "admin";
        String password = "' OR '1'='1"; // injection

        System.out.println("Using Statement");
        boolean result1 = dao.loginWithStatement(username, password);
        System.out.println(result1 ? "Login SUCCESS" : "Login FAILED");

        System.out.println("\nUsing PreparedStatement");
        boolean result2 = dao.loginWithPreparedStatement(username, password);
        System.out.println(result2 ? "Login SUCCESS" : "Login FAILED");
    }
}
