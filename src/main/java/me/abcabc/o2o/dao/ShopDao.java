package me.abcabc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.abcabc.o2o.entity.Shop;

public interface ShopDao {
	
	/**
	 * 
	 * @param shopCondition
	 * @param rowIndex从第几行开始取
	 * @param pageSize取多少个数据
	 * * 分页查询店铺，可输入的条件有：店铺名（模糊），
	 * 店铺状态，店铺类别，区域ID,owner
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,@Param("rowIndex")int rowIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 * 返回queryShopList总数
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition")Shop shopCondition);
	
	
	
	
	/**
	 *通过shop id查询店铺 
	 * @param shopId
	 * @return shop
	 */
	Shop queryByShopId(long shopId);

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
