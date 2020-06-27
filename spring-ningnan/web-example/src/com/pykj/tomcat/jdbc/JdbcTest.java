package com.pykj.tomcat.jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/spring_boot?useUnicode=true&characterEncoding=UTF-8";
            String user = "root";
            String password = "zhang";
            Connection connection = DriverManager.getConnection(url, user, password);
            /*String sql = "insert into users(id,email,nick_name,pass_word,reg_time,user_name) values(100,'q@qq.com','zhang','pass_word','2020-01-01','user_name')";
            //String sql = "update users set email = '163.com' where id = 100";
            //String sql = "delete from users where id = 100";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println(result);*/
           /* String sql = "select  * from users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);*/
            String email = "q@qq.com";
            String nick_name = "zhang1";
            String sql = "select  * from users where email= ? and nick_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, nick_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String email1 = resultSet.getString(2);
                String nick_name1 = resultSet.getString(3);
                System.out.println(id + "-" + email1 + "-" + nick_name1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
