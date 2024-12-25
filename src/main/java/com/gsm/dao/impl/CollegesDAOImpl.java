package com.gsm.dao.impl;

import com.gsm.bean.Colleges;
import com.gsm.dao.inter.ICollegesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollegesDAOImpl implements ICollegesDAO {

    public void add(Colleges colleges) {

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);


            String sql  = "insert into colleges(name,school_code,department,location,address,education_level,remarks,contact_info) values(? , ? , ?, ? , ?, ? , ?, ? )";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1  , colleges.getName());
            statement.setString(2 , colleges.getSchoolCode());
            statement.setString(3 , colleges.getDepartment());
            statement.setString(4 , colleges.getLocation());
            statement.setString(5 , colleges.getAddress());
            statement.setString(6 , colleges.getEducationLevel());
            statement.setString(7 , colleges.getRemarks());
            statement.setString(8 , colleges.getContactInfo());

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


            String sql  = "delete from colleges where college_id=?";

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

    public void update(Colleges colleges) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);


            String sql  = "update  colleges set name=?,school_code=?,department=?,location=?,address=?,education_level=?,remarks=?,contact_info=? where college_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1  , colleges.getName());
            statement.setString(2 , colleges.getSchoolCode());
            statement.setString(3 , colleges.getDepartment());
            statement.setString(4 , colleges.getLocation());
            statement.setString(5 , colleges.getAddress());
            statement.setString(6 , colleges.getEducationLevel());
            statement.setString(7 , colleges.getRemarks());
            statement.setString(8 , colleges.getContactInfo());
            statement.setInt(9 , colleges.getCollegeId());

            statement.executeUpdate();

            statement.close();
            connection.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Colleges load(int id) {

        Colleges colleges = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            String sql = "select * from colleges where college_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1 , id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                colleges = new Colleges();

                colleges.setCollegeId(resultSet.getInt("college_id"));
                colleges.setName(resultSet.getString("name"));
                colleges.setSchoolCode(resultSet.getString("school_code"));
                colleges.setDepartment(resultSet.getString("department"));
                colleges.setLocation(resultSet.getString("location"));
                colleges.setAddress(resultSet.getString("address"));
                colleges.setEducationLevel(resultSet.getString("education_level"));
                colleges.setRemarks(resultSet.getString("remarks"));
                colleges.setContactInfo(resultSet.getString("contact_info"));

            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return colleges;
    }

    public List<Colleges> list() {

        List<Colleges> collegeses = new ArrayList<Colleges>();

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from colleges");

            while(resultSet.next())
            {
                Colleges colleges = new Colleges();

                colleges.setCollegeId(resultSet.getInt("college_id"));
                colleges.setName(resultSet.getString("name"));
                colleges.setSchoolCode(resultSet.getString("school_code"));
                colleges.setDepartment(resultSet.getString("department"));
                colleges.setLocation(resultSet.getString("location"));
                colleges.setAddress(resultSet.getString("address"));
                colleges.setEducationLevel(resultSet.getString("education_level"));
                colleges.setRemarks(resultSet.getString("remarks"));
                colleges.setContactInfo(resultSet.getString("contact_info"));


                collegeses.add(colleges);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return collegeses;
    }

    public List<Colleges> query(String nameKey) {

        List<Colleges> collegeses = new ArrayList<Colleges>();

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/job_web?useUnicode=true&characterEncoding=UTF-8";
            String name = "root";
            String password = "123456";

            Connection connection = DriverManager.getConnection( url , name , password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from colleges where name like '%"+nameKey+"%'");

            while(resultSet.next())
            {
                Colleges colleges = new Colleges();

                colleges.setCollegeId(resultSet.getInt("college_id"));
                colleges.setName(resultSet.getString("name"));
                colleges.setSchoolCode(resultSet.getString("school_code"));
                colleges.setDepartment(resultSet.getString("department"));
                colleges.setLocation(resultSet.getString("location"));
                colleges.setAddress(resultSet.getString("address"));
                colleges.setEducationLevel(resultSet.getString("education_level"));
                colleges.setRemarks(resultSet.getString("remarks"));
                colleges.setContactInfo(resultSet.getString("contact_info"));


                collegeses.add(colleges);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return collegeses;
    }
}
