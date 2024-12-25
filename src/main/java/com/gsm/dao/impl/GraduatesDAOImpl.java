package com.gsm.dao.impl;

import com.gsm.bean.Graduate;
import com.gsm.dao.inter.IGraduatesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GraduatesDAOImpl implements IGraduatesDAO {

    public void add(Graduate graduate) {

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);


            String sql  = "insert into graduates(college_id,name,student_number,gender,major,graduation_year,degree) values(? , ? , ?, ? , ?, ? , ? )";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1  , graduate.getCollegeId());
            statement.setString(2 , graduate.getName());
            statement.setString(3 , graduate.getStudentNumber());
            statement.setString(4 , graduate.getGender());
            statement.setString(5 , graduate.getMajor());
            statement.setInt(6 , graduate.getGraduationYear());
            statement.setString(7 , graduate.getDegree());

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


            String sql  = "delete from graduates where college_id=?";

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

    public void update(Graduate graduate) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);


            String sql  = "update graduates set college_id=?,name=?,student_number=?,gender=?,major=?,graduation_year=?,degree=? where graduate_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1  , graduate.getCollegeId());
            statement.setString(2 , graduate.getName());
            statement.setString(3 , graduate.getStudentNumber());
            statement.setString(4 , graduate.getGender());
            statement.setString(5 , graduate.getMajor());
            statement.setInt(6 , graduate.getGraduationYear());
            statement.setString(7 , graduate.getDegree());
            statement.setInt(8  , graduate.getGraduateId());

            statement.executeUpdate();

            statement.close();
            connection.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Graduate load(int id) {

        Graduate graduate = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            String sql = "select * from graduates where graduate_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1 , id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                graduate = new Graduate();

                graduate.setGraduateId(resultSet.getInt("graduate_id"));
                graduate.setCollegeId(resultSet.getInt("college_id"));
                graduate.setStudentNumber(resultSet.getString("student_number"));
                graduate.setGender(resultSet.getString("gender"));
                graduate.setMajor(resultSet.getString("major"));
                graduate.setGraduationYear(resultSet.getInt("graduation_year"));
                graduate.setDegree(resultSet.getString("degree"));

            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return graduate;
    }

    public List<Graduate> list() {

        List<Graduate> graduatees = new ArrayList<Graduate>();

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from graduates");

            while(resultSet.next())
            {
                Graduate graduate = new Graduate();

                graduate.setGraduateId(resultSet.getInt("graduate_id"));
                graduate.setCollegeId(resultSet.getInt("college_id"));
                graduate.setName(resultSet.getString("name"));
                graduate.setStudentNumber(resultSet.getString("student_number"));
                graduate.setGender(resultSet.getString("gender"));
                graduate.setMajor(resultSet.getString("major"));
                graduate.setGraduationYear(resultSet.getInt("graduation_year"));
                graduate.setDegree(resultSet.getString("degree"));


                graduatees.add(graduate);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return graduatees;
    }

    public List<Graduate> query(String nameKey) {

        List<Graduate> graduatees = new ArrayList<Graduate>();

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from graduate where name like '%"+nameKey+"%'");

            while(resultSet.next())
            {
                Graduate graduate = new Graduate();

                graduate.setGraduateId(resultSet.getInt("graduate_id"));
                graduate.setCollegeId(resultSet.getInt("college_id"));
                graduate.setStudentNumber(resultSet.getString("student_number"));
                graduate.setGender(resultSet.getString("gender"));
                graduate.setMajor(resultSet.getString("major"));
                graduate.setGraduationYear(resultSet.getInt("graduation_year"));
                graduate.setDegree(resultSet.getString("degree"));


                graduatees.add(graduate);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return graduatees;
    }
}
