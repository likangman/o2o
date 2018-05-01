package me.abcabc.o2o.service;

import java.io.File;
import java.io.InputStream;

import me.abcabc.o2o.dto.ShopExcution;
import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	
	
	
	/***
	 * ����shopCondition��ҳ������Ӧ�ĵ����б�
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExcution getShopList(Shop shopCondition,int pageIndex,int pageSize);
	/**
	 * ͨ������Id��ȡ������Ϣ
	 * 
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	/***
	 * ���µ�����Ϣ��������ͼƬ�Ĵ���
	 * @param shop
	 * @param shopImgInputStream
	 * @return
	 */
	ShopExcution modifyShop(Shop shop,InputStream shopImgInputStream,String fileName)throws ShopOperationException;
	/**
	 * ע�������Ϣ������ͼƬ����
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExcution addShop(Shop shop,
			InputStream shopImgInputStream,String fileName);

}
