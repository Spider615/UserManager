package userpack.SHOP;

import java.util.List;
import userpack.User;

public interface ShopDao {
			//登录
			public User doLogin(String userName,String userPassword);
			//新增
			public int addShop(Shop shop);
			//删除
			public int deleteShop(int ShopId);
			//修改
			public int updateShop(Shop shop);
			//查询全部
			public List<Shop> ListShop();
			//根据id查询具体商品
			public Shop getShopId(int ShopId);
			//根据名称查询商品
			public List<Shop> getShopName(String shopName);
			//模糊匹配查询
			public List<Shop> getShopDim(String str);

}
