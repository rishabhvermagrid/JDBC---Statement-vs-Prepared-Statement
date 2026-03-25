package com.rishabh.sqldemo.dao;

import java.sql.*;
import com.rishabh.sqldemo.db.DBConnection;

public class UserDao {

    // Code with statement : vulnerable
    public boolean loginWithStatement(String username, String password) throws Exception {
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();

        String query = "SELECT * FROM users WHERE username = '"
                + username + "' AND password = '" + password + "'";

        System.out.println("Query: " + query);

        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }

    // Using Prepared Statement : Secure
    public boolean loginWithPreparedStatement(String username, String password) throws Exception {
        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement pstmt = con.prepareStatement(query);

        pstmt.setString(1, username);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
}