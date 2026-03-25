package com.rishabh.sqldemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Properties props = new Properties();
        InputStream input = DBConnection.class
                .getClassLoader()
                .getResourceAsStream("application.properties");

        props.load(input);

        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.username"),
                props.getProperty("db.password")
        );
    }
}
