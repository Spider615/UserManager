package userpack.UIMAIN;

import java.util.Scanner;

import userpack.LoginAndRegister;
import userpack.User;
import userpack.FLIGHT.UIFlight;
import userpack.SHOP.UIShop;

public class UIMain {

	public boolean Into() {
		Scanner scanner = new Scanner(System.in);
		boolean allow = true;
		do {
			System.out.println("*********欢迎使用*******");
			System.out.println("*      1、用户登录     *");
			System.out.println("*      2、用户注册     *");
			System.out.println("*      3、退出系统     *");
			System.out.println("*      请输入选择：    *");
			System.out.println("***********************");
			boolean T = true;
			while(T) {
				try {
					Scanner scan = new Scanner(System.in);
					int choise = scan.nextInt();
					T = false;
					switch(choise) {
						case 1:		//登录
							LoginAndRegister login = new LoginAndRegister();
							login.dol();
							allow = false;
							break;
						case 2:		//注册
							LoginAndRegister login1 = new LoginAndRegister();
							login1.reg();
							break;
						case 3:		//退出
							System.out.println("See you!");
							System.exit(0);
							break;
					}
				}catch(Exception e) {
					System.out.println("输入格式错误！请重新输入！");
				}
			}
		}while (allow);
		return !allow;
	}
	
	//选择系统
	public void ChooseSystem() {
		Scanner scanner = new Scanner(System.in);
		boolean allow = true;
		do {
			System.out.println("**********************");
			System.out.println("*   1、商城管理系统   *");
			System.out.println("*   2、航班管理系统   *");
			System.out.println("*   按其他数字退出    *");
			System.out.println("*   请输入选择：      *");
			System.out.println("**********************");
			boolean T = true;
			while(T) {
				try {
					Scanner scan = new Scanner(System.in);
					int choise = scan.nextInt();
					switch(choise) {
						case 1:		//商城管理系统
							UIShop uishop = new UIShop();
							uishop.Main();
							T = false;
							break;
						case 2:		//航班管理系统
							UIFlight uiflight = new UIFlight();
							uiflight.Main();
							T = false;
							break;
						default:
							T = false;
							allow = false;
							System.out.println("拜拜您嘞！");
							break;
					}
				}catch(Exception e) {
					System.out.println("输入格式错误！请重新输入！");
				}
			}
		}while (allow);
	}
	
	public void Main() {
		while (true) {
			boolean allow = Into();
			if (allow) {
				ChooseSystem();
			}
		}
	}

}
