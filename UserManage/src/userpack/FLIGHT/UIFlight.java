package userpack.FLIGHT;

import java.util.List;
import java.util.Scanner;

import userpack.User;
import userpack.SHOP.Shop;
import userpack.SHOP.ShopDaoImpl;

public class UIFlight {
	
	//判断输入的数据类型是否错误
	public static int isTrue() {
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int n = scan.nextInt();
				return n;
			}catch(Exception e) {
				System.out.println("输入格式错误！请重新输入！");
			}
		}
	}
	
	//判断输入的数据类型是否错误
	public static double istrue() {
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int n = scan.nextInt();
				return n;
			}catch(Exception e) {
				System.out.println("输入格式错误！请重新输入！");
			}
		}
	}
	
	//添加航班
	public static void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入航班目的地：");
		String flightTo = scan.next();
		System.out.println("请输入飞行时间：");
		double flightTime = istrue();
		System.out.println("请输入航班出发时间：");
		double flightSetTime = istrue();
		Flight flight = new Flight(0, flightTo, flightTime, flightSetTime);
		FlightDaoImpl userdao = new FlightDaoImpl();
		userdao.addFlight(flight);
	}
	
	//显示所有航班
	public static void display() {
		FlightDaoImpl userdao = new FlightDaoImpl();
		List<Flight> list = userdao.ListFlight();
		list.forEach(System.out::println);
	}
	
	//修改航班信息
	public static void change() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入航班编号：");
		int flightId = isTrue();
		System.out.println("请输入航班目的地：");
		String flightTo = scan.next();
		System.out.println("请输入飞行时间：");
		double flightTime = istrue();
		System.out.println("请输入航班出发时间：");
		double flightSetTime = istrue();
		Flight flight = new Flight(flightId, flightTo, flightTime, flightSetTime);
		FlightDaoImpl userdao = new FlightDaoImpl();
		userdao.updateFlight(flight);
	}
	
	//通过编号查询航班
	public static void Id() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入航班编号：");
		int flightId = isTrue();
		FlightDaoImpl userdao = new FlightDaoImpl();
		Flight flight = userdao.getFlightId(flightId);
		if (flight!=null) {
			System.out.println(flight.toString());
		}else {
			System.out.println("查询失败！不存在航班号！");
		}
	}
	
	//删除航班信息
	public static void del() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要删除的航班编号：");
		int flightId = isTrue();
		FlightDaoImpl userdao = new FlightDaoImpl();
		userdao.deleteFlight(flightId);
	}

	//模糊匹配查询
	public static void MH() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入目的地：");
		String str = scan.next();
		FlightDaoImpl flightdao = new FlightDaoImpl();
		List<Flight> list = flightdao.getFlightDim(str);
		if (list.size() == 0) {
			System.out.println("没有此航班！");
		}else {
			list.forEach(System.out::println);
		}
	}
	
	public void Main() {
		boolean juage = true;
		do {
			System.out.println("*******欢迎使用航班管理系统*******");
			System.out.println("*      1、添加航班信息           *");
			System.out.println("*      2、删除航班信息           *");
			System.out.println("*      3、修改航班信息           *");
			System.out.println("*      4、显示航班信息           *");
			System.out.println("*      5、通过编号显示信息       *");
			System.out.println("*      6、模糊匹配查询           *");
			System.out.println("*      按其他数字退出            *");
			System.out.println("*********************************");
			System.out.println("请选择：");
			boolean T = true;
			while (T) {
				try {
					Scanner scan = new Scanner(System.in);
					int choose = scan.nextInt();
					switch (choose) {
						case 1:		//添加
							add();
							T = false;
							break;
						case 2:		//删除
							del();
							T = false;
							break;
						case 3:		//修改
							change();
							T = false;
							break;
						case 4:		//显示
							display();
							T = false;
							break;
						case 5:		//通过编号显示
							Id();
							T = false;
							break;
						case 6:		//模糊匹配
							MH();
							T = false;
							break;
						default:
							T = false;
							System.out.println("感谢使用航班管理系统！后会有期！");
							juage = false;
							break;
					}
				}catch(Exception e) {
					System.out.println("输入格式错误！请重新输入！");
				}
			}
		}while(juage);
	}
}
