package userpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import userpack.SHOP.Shop;

public class LoginAndRegister {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/myschool?serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String USERPASSWORD="root";
	
	//Á¬½Óuser±í
	public User LoginLink(String userName, String userPassword) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM USER WHERE userName=? and userPassword=? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPassword);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int userId=rs.getInt("userId");
				String userNameStr=rs.getString("userName");
				String password=rs.getString("userPassword");
				String sex=rs.getString("userSex");
				String address=rs.getString("userAddress");
				user=new User(userId,userNameStr,password,sex,address);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return user;
	}
	
	//µÇÂ¼
	public void dol() {
		boolean islogin=false;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("ÇëÊäÈëÕËºÅ£º");
			String userName = scan.next();
			System.out.println("ÇëÊäÈëÃÜÂë£º");
			String userPassword = scan.next();
			User user = LoginLink(userName,userPassword);
			if (user!=null) {
				islogin = false;
				System.out.println("µÇÂ¼³É¹¦");
			}else {
				islogin = true;
				System.out.println("ÕËºÅ»òÃÜÂë´íÎó£¬ÇëÖØÐÂÊäÈë£¡");
			}
		}while(islogin);
	}
	
	//×¢²á
	public void reg() {
		boolean isreg = false;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("ÇëÊäÈëÕËºÅ£º");
			String userName = scan.next();
			System.out.println("ÇëÊäÈëÃÜÂë£º");
			String userPassword = scan.next();
			System.out.println("ÇëÊäÈëÐÔ±ð£º");
			String userSex = scan.next();
			System.out.println("ÇëÊäÈëµØÖ·£º");
			String userAddress = scan.next();
			User user = LoginLink(userName,userPassword);
			if (user==null) {
				isreg = false;
				User us = new User(0,userName,userPassword,userSex,userAddress);
				addUser(us);
			}else {
				isreg = true;
				System.out.println("ÒÑÓÐ´ËÕËºÅ£¡ÇëÖØÐÂÊäÈë£¡");
			}
		}while(isreg);
	}
	
	public int addUser(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=-1;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="INSERT INTO USER VALUE(null,?,?,?,?);";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getUserPassword());
			pstmt.setString(3, user.getUserSex());
			pstmt.setString(4, user.getAddress());
			result=pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("×¢²á³É¹¦£¡");
			}
			else
			{
				System.out.println("×¢²áÊ§°Ü£¡");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
}
