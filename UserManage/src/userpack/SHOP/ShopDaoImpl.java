package userpack.SHOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import userpack.User;
import userpack.FLIGHT.Flight;

public class ShopDaoImpl implements ShopDao{
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

	//添加商品
	@Override
	public int addShop(Shop shop) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=-1;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="INSERT INTO SHOP VALUE(null,?,?,?,?);";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,shop.getShopName());
			pstmt.setDouble(2,shop.getShopPrice());
			pstmt.setInt(3, shop.getShopSell());
			pstmt.setInt(4, shop.getShopRepertory());
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

	//删除
	@Override
	public int deleteShop(int ShopId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=-1;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="DELETE FROM SHOP WHERE SHOPID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ShopId);
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

	//修改
	@Override
	public int updateShop(Shop shop) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=-1;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="UPDATE SHOP SET SHOPNAME=?,SHOPPRICE=?,SHOPSELL=?,SHOPREPERTORY=? WHERE SHOPID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, shop.getShopName());
			pstmt.setDouble(2, shop.getShopPrice());
			pstmt.setInt(3, shop.getShopSell());
			pstmt.setInt(4, shop.getShopRepertory());
			pstmt.setInt(5, shop.getShopId());
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

	//显示
	@Override
	public List<Shop> ListShop() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Shop shop=null;
		List<Shop> list=new ArrayList<Shop>();
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM SHOP; ";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int shopId=rs.getInt("shopId");
				String shopName=rs.getString("shopName");
				double shopPrice=rs.getDouble("shopPrice");
				int shopSell=rs.getInt("shopSell");
				int shopRepertory=rs.getInt("shopRepertory");
				shop=new Shop(shopId, shopName, shopPrice, shopSell, shopRepertory);
				list.add(shop);
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

	//通过编号查询
	@Override
	public Shop getShopId(int shopId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		Shop shop=null;
		ResultSet rs=null;
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM SHOP WHERE SHOPID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, shopId);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int shopId1=rs.getInt("shopId");
				String shopName=rs.getString("shopName");
				double shopPrice=rs.getDouble("ShopPrice");
				int shopSell=rs.getInt("shopSell");
				int shopRepertory=rs.getInt("shopRepertory");
				shop=new Shop(shopId1, shopName, shopPrice, shopSell, shopRepertory);
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
		return shop;
	}
	
	//通过名称查询
	@Override
	public List<Shop> getShopName(String shopName) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Shop shop=null;
		List<Shop> list=new ArrayList<Shop>();
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM SHOP WHERE SHOPNAME=?; ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,shopName);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int shopId=rs.getInt("shopId");
				String shopName1=rs.getString("shopName");
				double shopPrice=rs.getDouble("shopPrice");
				int shopSell=rs.getInt("shopSell");
				int shopRepertory=rs.getInt("shopRepertory");
				shop=new Shop(shopId, shopName1, shopPrice, shopSell, shopRepertory);
				list.add(shop);
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

	//模糊匹配查询
	@Override
	public List<Shop> getShopDim(String str) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Shop shop=null;
		List<Shop> list=new ArrayList<Shop>();
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
			String sql="SELECT *FROM SHOP WHERE SHOPNAME like concat('%',?,'%')";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,str);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int shopId=rs.getInt("shopId");
				String shopName1=rs.getString("shopName");
				double shopPrice=rs.getDouble("shopPrice");
				int shopSell=rs.getInt("shopSell");
				int shopRepertory=rs.getInt("shopRepertory");
				Shop shop1 = new Shop(shopId, shopName1, shopPrice, shopSell, shopRepertory);
				list.add(shop1);
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
