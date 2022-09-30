package com.example.form.dao;

import com.example.form.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static Connection connection;
    static PreparedStatement ps;
    private Connection conn;

    public UserDao(Connection conn) {
        super();
        this.conn=conn;
    }
    public void addUser(User user) {
        String sql = "INSERT INTO userss(name,surname,email,image) VALUES(?,?,?,?)";

        try {
            connection = DbConnection.connectDb();
            ps = connection.prepareStatement(sql); {
                ps.setString(1, user.getName());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getImage());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }




    public List<User> getAllUsers(){
        ArrayList<User> list=new ArrayList<User>();

        try {
            connection = DbConnection.connectDb();
            ps=connection.prepareStatement("select * from userss");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSurname(rs.getString("surname"));
                u.setEmail(rs.getString("email"));
                u.setImage(rs.getString("image"));
                list.add(u);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }



}
