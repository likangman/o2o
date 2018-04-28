package me.abcabc.o2o.service.impl;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.abcabc.o2o.dao.ShopDao;
import me.abcabc.o2o.dto.ShopExcution;
import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.enums.ShopStateEnum;
import me.abcabc.o2o.exceptions.ShopOperationException;
import me.abcabc.o2o.service.ShopService;
import me.abcabc.o2o.util.ImageUtil;
import me.abcabc.o2o.util.PathUtil;
@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	ShopDao ShopDao;
	@Override
	//保证添加事务的完整性即原子性，如果方法中有runtimeException异常抛出，那么久回滚事务到未添加状态
	@Transactional
	public ShopExcution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
		if(shop==null)
		{
			return new ShopExcution(ShopStateEnum.NULL_SHOP);
		}
		try {
			//给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new java.util.Date());
			shop.setLastEditTime(new java.util.Date());
			//添加店铺信息
			int effectNum = ShopDao.insertShop(shop);
			if(effectNum<=0)
			{
				throw new ShopOperationException("店铺创建失败");
			}else
			{
				
				if(shopImgInputStream!=null)
				{
					//存储图片
					try {
						addShopImg(shop,shopImgInputStream,fileName);
					}catch(Exception e){
						System.out.println("ShopServiceImpl:"+"添加图片错误");
						throw new ShopOperationException("addShopImg ERROR"+e.getMessage());
					}
					//更新店铺的图片地址
					effectNum = ShopDao.updateShop(shop);
					if(effectNum<=0)
					{
						System.out.println("ShopServiceImpl:"+"更新图片地址错误");
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}	
		}catch(Exception e)
		{
			System.out.println("ShopServiceImpl:"+"错误");
			throw new ShopOperationException("addShop ERROR"+e.getMessage());
		}
		return new ShopExcution(ShopStateEnum.CHECK,shop);
	}
	private void addShopImg(Shop shop,InputStream shopImgInputStream,String fileName) 
	{
		//获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName,dest);
		shop.setShopImg(shopImgAddr);
	}
}
