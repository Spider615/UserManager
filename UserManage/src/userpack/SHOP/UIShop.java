package userpack.SHOP;

import java.util.List;
import java.util.Scanner;
import userpack.User;

public class UIShop {
	
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
	
	//添加商品
	public static void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入商品名称：");
		String shopName = scan.next();
		System.out.println("请输入商品价格：");
		double shopPrice = isTrue();
		System.out.println("请输入商品销售量：");
		int shopSell = isTrue();
		System.out.println("请输入商品库存量：");
		int shopRepertory = isTrue();
		Shop shop=new Shop(0, shopName, shopPrice, shopSell, shopRepertory);
		ShopDaoImpl shopdao = new ShopDaoImpl();
		shopdao.addShop(shop);
	}
	
	//显示所有商品
	public static void display() {
		ShopDaoImpl shopdao = new ShopDaoImpl();
		List<Shop> list = shopdao.ListShop();
		list.forEach(System.out::println);
	}
	
	//修改商品信息
	public static void change() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入商品编号：");
		int shopId = isTrue();
		System.out.println("请输入商品名称：");
		String shopName = scan.next();
		System.out.println("请输入商品价格：");
		double shopPrice = isTrue();
		System.out.println("请输入商品销售量：");
		int shopSell = isTrue();
		System.out.println("请输入商品库存量：");
		int shopRepertory = isTrue();
		Shop shop=new Shop(shopId, shopName, shopPrice, shopSell, shopRepertory);
		ShopDaoImpl shopdao = new ShopDaoImpl();
		shopdao.updateShop(shop);
	}
	
	//通过编号查询商品
	public static void Id() {
		System.out.println("请输入商品编号：");
		int shopId = isTrue();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		Shop shop = shopdao.getShopId(shopId);
		if (shop!=null) {
			System.out.println(shop.toString());
		}else {
			System.out.println("查询失败！不存在此商品！");
		}
	}
	
	//删除商品信息
	public static void del() {
		System.out.println("请输入要删除的商品编号：");
		int shopId = isTrue();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		shopdao.deleteShop(shopId);
	}

	//通过名称查询
	public static void Name() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入商品名称：");
		String shopName = scan.next();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		List<Shop> list = shopdao.getShopName(shopName);
		if(list.size()==0) {
			System.out.println("查询失败！");
		}else {
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	//模糊匹配查询
	public static void MH() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入商品名称：");
		String str = scan.next();
		ShopDaoImpl shopdao = new ShopDaoImpl();
		List<Shop> list = shopdao.getShopDim(str);
		if (list.size() == 0) {
			System.out.println("没有此商品！");
		}else {
			list.forEach(System.out::println);
		}
	}
	
	public void Main() {
		boolean juage = true;
		do {
			System.out.println("*******欢迎使用商场管理系统*******");
			System.out.println("*      1、添加商品信息           *");
			System.out.println("*      2、删除商品信息           *");
			System.out.println("*      3、修改商品信息           *");
			System.out.println("*      4、显示商品信息           *");
			System.out.println("*      5、通过编号显示信息       *");
			System.out.println("*      6、通过名称显示信息       *");
			System.out.println("*      7、模糊匹配查询           *");
			System.out.println("*      按其他数字退出            *");
			System.out.println("*********************************");
			System.out.println("请选择：");
			boolean T = true;
			try {
				Scanner scan = new Scanner(System.in);
				int choose = scan.nextInt();
				switch (choose) {
					case 1:		//添加
						add();
						break;
					case 2:		//删除
						del();
						break;
					case 3:		//修改
						change();
						break;
					case 4:		//显示
						display();
						break;
					case 5:		//通过编号显示
						Id();
						break;
					case 6:		//通过名称显示
						Name();
						break;
					case 7:		//模糊
						MH();
						break;
					default:
						System.out.println("感谢使用商品管理系统！后会有期！");
						juage = false;
						break;
				}
			}catch(Exception e) {
				System.out.println("输入格式错误！请重新输入！");
			}
		}while(juage);
	}
}
