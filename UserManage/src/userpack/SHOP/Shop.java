package userpack.SHOP;

public class Shop {
	private int shopId;		//��Ʒ���
	private String shopName;		//��Ʒ����
	private double shopPrice;		//��Ʒ�۸�
	private int shopSell;		//������
	private int shopRepertory;		//���
	public Shop(int shopId, String shopName, double shopPrice, int shopSell, int shopRepertory) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopPrice = shopPrice;
		this.shopSell = shopSell;
		this.shopRepertory = shopRepertory;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public double getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public int getShopSell() {
		return shopSell;
	}
	public void setShopSell(int shopSell) {
		this.shopSell = shopSell;
	}
	public int getShopRepertory() {
		return shopRepertory;
	}
	public void setShopRepertory(int shopRepertory) {
		this.shopRepertory = shopRepertory;
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", shopPrice=" + shopPrice + ", shopSell="
				+ shopSell + ", shopRepertory=" + shopRepertory + "]";
	}
	
}
