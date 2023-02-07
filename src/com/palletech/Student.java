package com.palletech;

import java.sql.*;

public class Student {
	Connection con=null;
	Statement s=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private String url="jdbc:mysql://localhost:3306/palle";
	private String username="root";
	private String password="admin";
	
	
	public void creating() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","admin");
			String qry="create table Student( sno int primary key auto_increment,sname varchar(50),sub varchar(50),email varchar(50))";
			s=con.createStatement();
			s.executeUpdate(qry);
			
		} catch (ClassNotFoundException e) {
						
			e.printStackTrace();
		}
		catch(SQLSyntaxErrorException e) 
		{
			System.out.println("table already");
			}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(s!=null)
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		
	}
	
	public void inserting(String sname,String sub,String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			
			String qry="insert into Student(sname,sub,email) values(?,?,?)";
			ps=con.prepareStatement(qry);
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}
	
	
	public void update(String mail, String sub, int no)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="update student set email=?,sub=? where sno=?";
			
			ps=con.prepareStatement(qry);
			ps.setString(1,mail);
			ps.setString(2,sub);
			ps.setInt(3, no); 
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void delete(int sno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="delete from Student where sno=?";
			ps=con.prepareStatement(qry);
			ps.setInt(1, sno);
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			s=con.createStatement();
			String qry="select * from student";
			rs=s.executeQuery(qry);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(s!=null)
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	

}
