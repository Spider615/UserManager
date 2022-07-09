package userpack.FLIGHT;

import java.util.List;

import userpack.User;

public interface FlightDao {
		//��¼
		public User doLogin(String userName,String userPassword);
		//����
		public int addFlight(Flight flight);
		//ɾ��
		public int deleteFlight(int FlightId);
		//�޸�
		public int updateFlight(Flight flight);
		//��ѯȫ��
		public List<Flight> ListFlight();
		//����id��ѯ�����û�
		public Flight getFlightId(int flightId);
		//ģ����ѯ
		public List<Flight> getFlightDim(String str);
		
		
}
