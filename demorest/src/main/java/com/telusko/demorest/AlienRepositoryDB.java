package com.telusko.demorest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AlienRepositoryDB {
	
	Connection con=null;
	
	AlienRepositoryDB()
	{
		String url = "jdbc:postgresql://localhost:5432/restdb";
		String user = "postgres";
	    String password = "postgres";
		
		try 
		{
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Alien> getAliens()
	{
		System.out.println("get aliens called");
		List<Alien> la=new ArrayList<Alien>(); 
		
		String psql="select * from alien";
		
		try 
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(psql);
			
			while(rs.next())
			{
				Alien a=new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				
				la.add(a);
			}
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return la;
	}
	
	public Alien getAlien(int id)
	{
		System.out.println("get alien called");
		
		Alien a=new Alien();
		
		String psql="select * from alien where id="+id;
		
		try 
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(psql);
			
			while(rs.next())
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				
				
			}
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
		
	}
	
	public Alien createAlien(Alien a)
	{
		
		System.out.println("create alien called");
		
		String psql="insert into alien values (?,?)";
		try 
		{
			PreparedStatement pst=con.prepareStatement(psql);
			
			pst.setInt(1, a.getId());
			pst.setString(2, a.getName());
			
			pst.executeUpdate();
				
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
		
	}

	
	
	public Alien updateAlien(Alien a)
	{
		
		System.out.println("update alien called");
		
		String psql="update alien set name=? where id=?";
		try 
		{
			PreparedStatement pst=con.prepareStatement(psql);
			
			pst.setInt(2, a.getId());
			pst.setString(1, a.getName());
			
			pst.executeUpdate();
				
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
		
	}


	public void deleteAlien(int id) 
	{
		System.out.println("delete alien called");
		
		String psql="delete from alien where id=?";
		try 
		{
			PreparedStatement pst=con.prepareStatement(psql);
			
			pst.setInt(1, id);
			
			pst.executeUpdate();
				
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
