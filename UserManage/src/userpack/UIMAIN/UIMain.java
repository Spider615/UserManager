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
			System.out.println("*********��ӭʹ��*******");
			System.out.println("*      1���û���¼     *");
			System.out.println("*      2���û�ע��     *");
			System.out.println("*      3���˳�ϵͳ     *");
			System.out.println("*      ������ѡ��    *");
			System.out.println("***********************");
			boolean T = true;
			while(T) {
				try {
					Scanner scan = new Scanner(System.in);
					int choise = scan.nextInt();
					T = false;
					switch(choise) {
						case 1:		//��¼
							LoginAndRegister login = new LoginAndRegister();
							login.dol();
							allow = false;
							break;
						case 2:		//ע��
							LoginAndRegister login1 = new LoginAndRegister();
							login1.reg();
							break;
						case 3:		//�˳�
							System.out.println("See you!");
							System.exit(0);
							break;
					}
				}catch(Exception e) {
					System.out.println("�����ʽ�������������룡");
				}
			}
		}while (allow);
		return !allow;
	}
	
	//ѡ��ϵͳ
	public void ChooseSystem() {
		Scanner scanner = new Scanner(System.in);
		boolean allow = true;
		do {
			System.out.println("**********************");
			System.out.println("*   1���̳ǹ���ϵͳ   *");
			System.out.println("*   2���������ϵͳ   *");
			System.out.println("*   �����������˳�    *");
			System.out.println("*   ������ѡ��      *");
			System.out.println("**********************");
			boolean T = true;
			while(T) {
				try {
					Scanner scan = new Scanner(System.in);
					int choise = scan.nextInt();
					switch(choise) {
						case 1:		//�̳ǹ���ϵͳ
							UIShop uishop = new UIShop();
							uishop.Main();
							T = false;
							break;
						case 2:		//�������ϵͳ
							UIFlight uiflight = new UIFlight();
							uiflight.Main();
							T = false;
							break;
						default:
							T = false;
							allow = false;
							System.out.println("�ݰ����ϣ�");
							break;
					}
				}catch(Exception e) {
					System.out.println("�����ʽ�������������룡");
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
