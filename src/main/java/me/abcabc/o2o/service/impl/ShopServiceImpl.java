package me.abcabc.o2o.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
import me.abcabc.o2o.util.PageCalculator;
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
	
	
	
	
	@Override
	public Shop getByShopId(long shopId) {
		// TODO Auto-generated method stub
		return ShopDao.queryByShopId(shopId);
	}
	
	
	
	
	/**
	 * 修改店铺信息
	 */
	@Override
	public ShopExcution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName)
			throws ShopOperationException {
		
		if(shop==null||shop.getShopId()==null)
		{
			return new ShopExcution(ShopStateEnum.NULL_SHOP);
		}else {
			
			
			
			//1判断是否需要处理图片
			try {
			if(shopImgInputStream!=null&&fileName!=null&&!"".equals(fileName))
			{
				Shop tempShop = ShopDao.queryByShopId(shop.getShopId());
				if(tempShop.getShopImg()!=null)
				{
					ImageUtil.deleteFileOrPath(tempShop.getShopImg());
				}
				addShopImg(shop, shopImgInputStream, fileName);
			}
			
			
			//2更新店铺信息
			shop.setLastEditTime(new Date());
			int effectedNum = ShopDao.updateShop(shop);
			if(effectedNum <= 0)
			{
				return new ShopExcution(ShopStateEnum.INNER_ERROR);
			}else
			{
				shop = ShopDao.queryByShopId(shop.getShopId());
				return new ShopExcution(ShopStateEnum.SUCCESS,shop);
			}
			}catch(Exception e)
			{
				throw new ShopOperationException("modifyShop error:"+e.getMessage());
			}
			
			
			
		}
	}
	
	
	@Override
	public ShopExcution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList = ShopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = ShopDao.queryShopCount(shopCondition);
		ShopExcution shopExcution = new ShopExcution();
		if(shopList!=null)
		{
			shopExcution.setShopList(shopList);
			shopExcution.setCount(count);
		}else
		{
			shopExcution.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return shopExcution;
	}
}
