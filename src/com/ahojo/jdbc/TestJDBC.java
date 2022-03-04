package com.ahojo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/hb01onetooneuni";
        String user = "root";
        String password = "password";

        try {
            System.out.println("Connecting to the database " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("We have successfully connected to postgres");

        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
