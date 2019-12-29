package com.mybatis;

import java.sql.*;
import java.util.HashMap;

public class MybatisDemo {
    private static String URL = "jdbc:mysql://192.168.1.101:3306/db_test?serverTimezone=GMT%2B8";
    private static String USERNAME = "root";
    private static String PASSWORD = "182028";

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//        System.out.println(connection);

        testdb(connection);
        connection.close();
    }

    public static void testdb(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");

            ResultSetMetaData metaData = resultSet.getMetaData();

            // 列数
            int columnCount = metaData.getColumnCount();
            // 列名
            HashMap<Integer, String> nameMap = new HashMap<>();

            while (resultSet.next()){
                String columnName ="";
                for (int i = 1; i <= columnCount; i++) {
                    columnName = metaData.getColumnName(i);

                    System.out.print(columnName+":"+resultSet.getObject(columnName)+"\t");
                }
                System.out.println();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
