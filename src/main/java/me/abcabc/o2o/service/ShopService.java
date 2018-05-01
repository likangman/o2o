package me.abcabc.o2o.service;

import java.io.File;
import java.io.InputStream;

import me.abcabc.o2o.dto.ShopExcution;
import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	
	
	
	/***
	 * 根据shopCondition分页返回相应的店铺列表
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExcution getShopList(Shop shopCondition,int pageIndex,int pageSize);
	/**
	 * 通过店铺Id获取店铺信息
	 * 
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	/***
	 * 更新店铺信息，包括对图片的处理
	 * @param shop
	 * @param shopImgInputStream
	 * @return
	 */
	ShopExcution modifyShop(Shop shop,InputStream shopImgInputStream,String fileName)throws ShopOperationException;
	/**
	 * 注册店铺信息，包括图片处理
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExcution addShop(Shop shop,
			InputStream shopImgInputStream,String fileName);

}
