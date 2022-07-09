package userpack.FLIGHT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import userpack.User;
import userpack.SHOP.Shop;

public class FlightDaoImpl implements FlightDao{
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/myschool?serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String USERPASSWORD="root";
	
	//登录
	@Override
	public User doLogin(String userName, String userPassword) {
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
	
	//添加航班
	@Override
	public int addFlight(Flight flight) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=-1;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="INSERT INTO FLIGHT VALUE(null,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, flight.getFlightTo());
			pstmt.setDouble(2, flight.getFlightSetTime());
			pstmt.setDouble(3, flight.getFlightTime());
			result=pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("新增成功！");
			}
			else
			{
				System.out.println("新增失败！");
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
	
	//删除航班
	@Override
	public int deleteFlight(int FlightId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=-1;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="DELETE FROM FLIGHT WHERE FLIGHTID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, FlightId);
			result=pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("删除成功！");
			}
			else
			{
				System.out.println("删除失败！");
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
	
	//修改航班信息
	@Override
	public int updateFlight(Flight flight) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=-1;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="UPDATE FLIGHT SET FLIGHTTO=?,FLIGHTSETTIME=?,FLIGHTTIME=? WHERE FLIGHTID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, flight.getFlightTo());
			pstmt.setDouble(2, flight.getFlightSetTime());
			pstmt.setDouble(3, flight.getFlightTime());
			pstmt.setInt(4, flight.getFlightId());
			result=pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("修改成功！");
			}
			else
			{
				System.out.println("修改失败！");
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
	
	//显示所有航班
	@Override
	public List<Flight> ListFlight() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Flight> list=new ArrayList<Flight>();
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM FLIGHT; ";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int flightId=rs.getInt("flightId");
				String flightTo=rs.getString("flightTo");
				double flightTime=rs.getDouble("flightTime");
				double flightSetTime=rs.getDouble("flightSetTime");
				Flight flight = new Flight(flightId, flightTo, flightTime, flightSetTime);
				System.out.println(flight.toString());
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
		return list;
		
	}
	
	//通过编号查询单个航班
	@Override
	public Flight getFlightId(int flightId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		Flight flight=null;
		ResultSet rs=null;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM FLIGHT WHERE FLIGHTID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, flightId);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int flightId1=rs.getInt("flightId");
				String flightTo=rs.getString("flightTo");
				double flightTime=rs.getDouble("flightTime");
				double flightSetTime=rs.getDouble("flightSetTime");
				flight = new Flight(flightId1, flightTo, flightTime, flightSetTime);
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
		return flight;
	}
	
	//模糊匹配查询
	@Override
	public List<Flight> getFlightDim(String str) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Flight> list=new ArrayList<Flight>();
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM FLIGHT WHERE FLIGHTTO like concat('%',?,'%')";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,str);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int flightId=rs.getInt("flightId");
				String flightTo=rs.getString("flightTo");
				double flightTime=rs.getDouble("flightTime");
				double flightSetTime=rs.getDouble("flightSetTime");
				Flight flight = new Flight(flightId, flightTo, flightTime, flightSetTime);
				list.add(flight);
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
		return list;
	}

}
