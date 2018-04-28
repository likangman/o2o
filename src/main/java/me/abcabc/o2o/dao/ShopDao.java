package me.abcabc.o2o.dao;

import me.abcabc.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 添加新的店铺
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * 更新店铺
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
