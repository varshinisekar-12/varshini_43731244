package com.Webapp.dao;
import java.sql.*;
import java.util.*;
import com.Webapp.model.User;
public class UserDao {
	  
	    public static int save(User u){
	        int status = 0;
	        try{
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "INSERT INTO register(name, password) VALUES (?,?)"
	            );
	            ps.setString(1, u.getName());
	            ps.setString(2, u.getPassword());
	            status = ps.executeUpdate();
	            con.close();
	        }catch(Exception e){ e.printStackTrace(); }
	        return status;
	    }

	    // READ
	    public static List<User> getAllUsers(){
	        List<User> list = new ArrayList<>();
	        try{
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM register");
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()){
	                User u = new User();
	                u.setId(rs.getInt("id"));
	                u.setName(rs.getString("name"));
	                u.setPassword(rs.getString("password"));
	                list.add(u);
	            }
	            con.close();
	        }catch(Exception e){ e.printStackTrace(); }
	        return list;
	    }

	    // READ (By ID)
	    public static User getUserById(int id){
	        User u = new User();
	        try{
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "SELECT * FROM register WHERE id=?"
	            );
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if(rs.next()){
	                u.setId(rs.getInt("id"));
	                u.setName(rs.getString("name"));
	                u.setPassword(rs.getString("password"));
	            }
	            con.close();
	        }catch(Exception e){ e.printStackTrace(); }
	        return u;
	    }

	    // UPDATE
	    public static int update(User u){
	        int status = 0;
	        try{
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "UPDATE register SET name=?, password=? WHERE id=?"
	            );
	            ps.setString(1, u.getName());
	            ps.setString(2, u.getPassword());
	            ps.setInt(3, u.getId());
	            status = ps.executeUpdate();
	            con.close();
	        }catch(Exception e){ e.printStackTrace(); }
	        return status;
	    }

	    // DELETE
	    public static int delete(int id){
	        int status = 0;
	        try{
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "DELETE FROM register WHERE id=?"
	            );
	            ps.setInt(1, id);
	            status = ps.executeUpdate();
	            con.close();
	        }catch(Exception e){ e.printStackTrace(); }
	        return status;
	    }
	}


