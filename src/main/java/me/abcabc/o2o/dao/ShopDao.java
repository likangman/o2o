package me.abcabc.o2o.dao;

import me.abcabc.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * ����µĵ���
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * ���µ���
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
