package com.javatpoint.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.javatpoint.bean.User;

public class UserDao {

	public static Connection getConnection() {
	    Connection con = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(
	           "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC",
	            "root", "varshini@2005"
	        );
	        System.out.println("DB Connected!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return con;
	}


    // 2️⃣ Save new user
    public static int save(User u) {
        int status = 0;
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO register(name,password,email,sex,country) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSex());
            ps.setString(5, u.getCountry());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // 3️⃣ Update existing user
    public static int update(User u) {
        int status = 0;
        Connection con = null;
        try {
            con = getConnection();
            if(con == null) {
                System.out.println("Connection is null! Cannot update.");
                return 0;
            }

            String sql = "UPDATE register SET name=?, password=?, email=?, sex=?, country=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSex());
            ps.setString(5, u.getCountry());
            ps.setInt(6, u.getId());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // 4️⃣ Delete user
    public static int delete(User u) {
        int status = 0;
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM register WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // 5️⃣ Get all users
    public static List<User> getAllRecords() {
        List<User> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM register";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 6️⃣ Get user by ID
    public static User getRecordById(int id) {
        User u = null;
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM register WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}
