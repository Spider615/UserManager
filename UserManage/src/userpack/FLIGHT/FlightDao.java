package userpack.FLIGHT;

import java.util.List;

import userpack.User;

public interface FlightDao {
		//登录
		public User doLogin(String userName,String userPassword);
		//新增
		public int addFlight(Flight flight);
		//删除
		public int deleteFlight(int FlightId);
		//修改
		public int updateFlight(Flight flight);
		//查询全部
		public List<Flight> ListFlight();
		//根据id查询具体用户
		public Flight getFlightId(int flightId);
		//模糊查询
		public List<Flight> getFlightDim(String str);
		
		
}
