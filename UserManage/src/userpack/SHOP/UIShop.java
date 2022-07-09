package userpack.SHOP;

import java.util.List;
import java.util.Scanner;
import userpack.User;

public class UIShop {
	
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
	
	//�����Ʒ
	public static void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������Ʒ���ƣ�");
		String shopName = scan.next();
		System.out.println("��������Ʒ�۸�");
		double shopPrice = isTrue();
		System.out.println("��������Ʒ��������");
		int shopSell = isTrue();
		System.out.println("��������Ʒ�������");
		int shopRepertory = isTrue();
		Shop shop=new Shop(0, shopName, shopPrice, shopSell, shopRepertory);
		ShopDaoImpl shopdao = new ShopDaoImpl();
		shopdao.addShop(shop);
	}
	
	//��ʾ������Ʒ
	public static void display() {
		ShopDaoImpl shopdao = new ShopDaoImpl();
		List<Shop> list = shopdao.ListShop();
		list.forEach(System.out::println);
	}
	
	//�޸���Ʒ��Ϣ
	public static void change() {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������Ʒ��ţ�");
		int shopId = isTrue();
		System.out.println("��������Ʒ���ƣ�");
		String shopName = scan.next();
		System.out.println("��������Ʒ�۸�");
		double shopPrice = isTrue();
		System.out.println("��������Ʒ��������");
		int shopSell = isTrue();
		System.out.println("��������Ʒ�������");
		int shopRepertory = isTrue();
		Shop shop=new Shop(shopId, shopName, shopPrice, shopSell, shopRepertory);
		ShopDaoImpl shopdao = new ShopDaoImpl();
		shopdao.updateShop(shop);
	}
	
	//ͨ����Ų�ѯ��Ʒ
	public static void Id() {
		System.out.println("��������Ʒ��ţ�");
		int shopId = isTrue();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		Shop shop = shopdao.getShopId(shopId);
		if (shop!=null) {
			System.out.println(shop.toString());
		}else {
			System.out.println("��ѯʧ�ܣ������ڴ���Ʒ��");
		}
	}
	
	//ɾ����Ʒ��Ϣ
	public static void del() {
		System.out.println("������Ҫɾ������Ʒ��ţ�");
		int shopId = isTrue();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		shopdao.deleteShop(shopId);
	}

	//ͨ�����Ʋ�ѯ
	public static void Name() {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������Ʒ���ƣ�");
		String shopName = scan.next();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		List<Shop> list = shopdao.getShopName(shopName);
		if(list.size()==0) {
			System.out.println("��ѯʧ�ܣ�");
		}else {
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	//ģ��ƥ���ѯ
	public static void MH() {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������Ʒ���ƣ�");
		String str = scan.next();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		List<Shop> list = shopdao.getShopDim(str);
		if (list.size() == 0) {
			System.out.println("û�д���Ʒ��");
		}else {
			list.forEach(System.out::println);
		}
	}
	
	public void Main() {
		boolean juage = true;
		do {
			System.out.println("*******��ӭʹ���̳�����ϵͳ*******");
			System.out.println("*      1�������Ʒ��Ϣ           *");
			System.out.println("*      2��ɾ����Ʒ��Ϣ           *");
			System.out.println("*      3���޸���Ʒ��Ϣ           *");
			System.out.println("*      4����ʾ��Ʒ��Ϣ           *");
			System.out.println("*      5��ͨ�������ʾ��Ϣ       *");
			System.out.println("*      6��ͨ��������ʾ��Ϣ       *");
			System.out.println("*      7��ģ��ƥ���ѯ           *");
			System.out.println("*      �����������˳�            *");
			System.out.println("*********************************");
			System.out.println("��ѡ��");
			boolean T = true;
			try {
				Scanner scan = new Scanner(System.in);
				int choose = scan.nextInt();
				switch (choose) {
					case 1:		//���
						add();
						break;
					case 2:		//ɾ��
						del();
						break;
					case 3:		//�޸�
						change();
						break;
					case 4:		//��ʾ
						display();
						break;
					case 5:		//ͨ�������ʾ
						Id();
						break;
					case 6:		//ͨ��������ʾ
						Name();
						break;
					case 7:		//ģ��
						MH();
						break;
					default:
						System.out.println("��лʹ����Ʒ����ϵͳ��������ڣ�");
						juage = false;
						break;
				}
			}catch(Exception e) {
				System.out.println("�����ʽ�������������룡");
			}
		}while(juage);
	}
}
