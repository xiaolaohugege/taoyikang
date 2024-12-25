package com.gsm.dao.impl;

import com.gsm.bean.Users;
import com.gsm.dao.inter.IUsersDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements IUsersDAO {

    public void add(Users users) {

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);


            String sql  = "insert into users(username ,password_hash , email) values(? , ? , ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1  , users.getUsername());
            statement.setString(2 , users.getPasswordHash());
            statement.setString(3 , users.getEmail());

            statement.executeUpdate();

            statement.close();
            connection.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);


            String sql  = "delete from users where user_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1  , id);

            statement.executeUpdate();

            statement.close();
            connection.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void update(Users users) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);


            String sql  = "update users set username=? ,password_hash=? , email=? where user_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1  , users.getUsername());
            statement.setString(2 , users.getPasswordHash());
            statement.setString(3 , users.getEmail());
            statement.setInt(4  ,users.getUserId());

            statement.executeUpdate();

            statement.close();
            connection.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Users load(int id) {

        Users users = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            String sql = "select * from users where user_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1 , id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                users = new Users();

                users.setUserId(resultSet.getInt("user_id"));
                users.setUsername(resultSet.getString("username"));
                users.setPasswordHash(resultSet.getString("password_hash"));
                users.setEmail(resultSet.getString("email"));

            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return users;
    }

    public Users load(String username) {

        Users users = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            String sql = "select * from users where username=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1 , username);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                users = new Users();

                users.setUserId(resultSet.getInt("user_id"));
                users.setUsername(resultSet.getString("username"));
                users.setPasswordHash(resultSet.getString("password_hash"));
                users.setEmail(resultSet.getString("email"));

            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return users;
    }

    public List<Users> list() {

        List<Users> userses = new ArrayList<Users>();

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select user_id , username , email from users");

            while(resultSet.next())
            {
                Users users = new Users();
                users.setUserId(resultSet.getInt("user_id"));
                users.setUsername(resultSet.getString("username"));
                users.setEmail(resultSet.getString("email"));

                userses.add(users);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return userses;
    }
}
