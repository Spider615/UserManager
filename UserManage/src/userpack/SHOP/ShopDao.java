package userpack.SHOP;

import java.util.List;
import userpack.User;

public interface ShopDao {
			//��¼
			public User doLogin(String userName,String userPassword);
			//����
			public int addShop(Shop shop);
			//ɾ��
			public int deleteShop(int ShopId);
			//�޸�
			public int updateShop(Shop shop);
			//��ѯȫ��
			public List<Shop> ListShop();
			//����id��ѯ������Ʒ
			public Shop getShopId(int ShopId);
			//�������Ʋ�ѯ��Ʒ
			public List<Shop> getShopName(String shopName);
			//ģ��ƥ���ѯ
			public List<Shop> getShopDim(String str);

}
