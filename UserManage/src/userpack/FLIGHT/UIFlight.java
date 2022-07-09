package userpack.FLIGHT;

import java.util.List;
import java.util.Scanner;

import userpack.User;
import userpack.SHOP.Shop;
import userpack.SHOP.ShopDaoImpl;

public class UIFlight {
	
	//�ж���������������Ƿ����
	public static int isTrue() {
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int n = scan.nextInt();
				return n;
			}catch(Exception e) {
				System.out.println("�����ʽ�������������룡");
			}
		}
	}
	
	//�ж���������������Ƿ����
	public static double istrue() {
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int n = scan.nextInt();
				return n;
			}catch(Exception e) {
				System.out.println("�����ʽ�������������룡");
			}
		}
	}
	
	//��Ӻ���
	public static void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����뺽��Ŀ�ĵأ�");
		String flightTo = scan.next();
		System.out.println("���������ʱ�䣺");
		double flightTime = istrue();
		System.out.println("�����뺽�����ʱ�䣺");
		double flightSetTime = istrue();
		Flight flight = new Flight(0, flightTo, flightTime, flightSetTime);
		FlightDaoImpl userdao = new FlightDaoImpl();
		userdao.addFlight(flight);
	}
	
	//��ʾ���к���
	public static void display() {
		FlightDaoImpl userdao = new FlightDaoImpl();
		List<Flight> list = userdao.ListFlight();
		list.forEach(System.out::println);
	}
	
	//�޸ĺ�����Ϣ
	public static void change() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����뺽���ţ�");
		int flightId = isTrue();
		System.out.println("�����뺽��Ŀ�ĵأ�");
		String flightTo = scan.next();
		System.out.println("���������ʱ�䣺");
		double flightTime = istrue();
		System.out.println("�����뺽�����ʱ�䣺");
		double flightSetTime = istrue();
		Flight flight = new Flight(flightId, flightTo, flightTime, flightSetTime);
		FlightDaoImpl userdao = new FlightDaoImpl();
		userdao.updateFlight(flight);
	}
	
	//ͨ����Ų�ѯ����
	public static void Id() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����뺽���ţ�");
		int flightId = isTrue();
		FlightDaoImpl userdao = new FlightDaoImpl();
		Flight flight = userdao.getFlightId(flightId);
		if (flight!=null) {
			System.out.println(flight.toString());
		}else {
			System.out.println("��ѯʧ�ܣ������ں���ţ�");
		}
	}
	
	//ɾ��������Ϣ
	public static void del() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ҫɾ���ĺ����ţ�");
		int flightId = isTrue();
		FlightDaoImpl userdao = new FlightDaoImpl();
		userdao.deleteFlight(flightId);
	}

	//ģ��ƥ���ѯ
	public static void MH() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ŀ�ĵأ�");
		String str = scan.next();
		FlightDaoImpl flightdao = new FlightDaoImpl();
		List<Flight> list = flightdao.getFlightDim(str);
		if (list.size() == 0) {
			System.out.println("û�д˺��࣡");
		}else {
			list.forEach(System.out::println);
		}
	}
	
	public void Main() {
		boolean juage = true;
		do {
			System.out.println("*******��ӭʹ�ú������ϵͳ*******");
			System.out.println("*      1����Ӻ�����Ϣ           *");
			System.out.println("*      2��ɾ��������Ϣ           *");
			System.out.println("*      3���޸ĺ�����Ϣ           *");
			System.out.println("*      4����ʾ������Ϣ           *");
			System.out.println("*      5��ͨ�������ʾ��Ϣ       *");
			System.out.println("*      6��ģ��ƥ���ѯ           *");
			System.out.println("*      �����������˳�            *");
			System.out.println("*********************************");
			System.out.println("��ѡ��");
			boolean T = true;
			while (T) {
				try {
					Scanner scan = new Scanner(System.in);
					int choose = scan.nextInt();
					switch (choose) {
						case 1:		//���
							add();
							T = false;
							break;
						case 2:		//ɾ��
							del();
							T = false;
							break;
						case 3:		//�޸�
							change();
							T = false;
							break;
						case 4:		//��ʾ
							display();
							T = false;
							break;
						case 5:		//ͨ�������ʾ
							Id();
							T = false;
							break;
						case 6:		//ģ��ƥ��
							MH();
							T = false;
							break;
						default:
							T = false;
							System.out.println("��лʹ�ú������ϵͳ��������ڣ�");
							juage = false;
							break;
					}
				}catch(Exception e) {
					System.out.println("�����ʽ�������������룡");
				}
			}
		}while(juage);
	}
}
