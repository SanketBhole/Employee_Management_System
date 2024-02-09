package com.Sanket.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/db_practice","root","root");
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
    public void clenup(){
        try{
            connection.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
