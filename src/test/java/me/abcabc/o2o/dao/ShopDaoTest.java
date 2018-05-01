package me.abcabc.o2o.dao;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import me.abcabc.o2o.BaseTest;
import me.abcabc.o2o.entity.Area;
import me.abcabc.o2o.entity.PersonInfo;
import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{

	@Autowired
	ShopDao shopDao;
	
	@Test
	public void testQueryShopListAndCount()
	{
		Shop shopCondition = new Shop();
//		PersonInfo owner = new PersonInfo();
//		owner.setUserId(3L);
//		shopCondition.setOwner(owner);
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryId(2L);
		shopCondition.setShopCategory(shopCategory);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺总数"+count);
		System.out.println("店铺列表大小"+shopList.size());
	}
	
	public void testQueryByShopId() {
		long shopId=1;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println(shop.getArea().getAreaName());
		System.out.println(shop.getShopCategory().getShopCategoryId());

	}
	
	@Test
	@Ignore
	public void testInsertShop()
	{
		Shop shop = new Shop();
		PersonInfo personInfo = new PersonInfo();
		ShopCategory shopCategory = new ShopCategory();
		Area area = new Area();
		personInfo.setUserId(1L);
		shopCategory.setShopCategoryId(1L);
		area.setAreaId(1);
		shop.setArea(area);
		shop.setOwner(personInfo);
		shop.setShopCategory(shopCategory);
		shop.setShopName("天滋果色");
		shop.setShopDesc("一代天资,天姿国色");
		shop.setShopAddr("test");
		shop.setPhone("18815598680");
		shop.setShopImg("noimage");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("可以");
		int e = shopDao.insertShop(shop);
		assertEquals(1, e);
	}
	
	@Test
	@Ignore
	public void testUpdateShop()
	{
		Shop shop = new Shop();
		shop.setShopId(3L);
		PersonInfo personInfo = new PersonInfo();
		ShopCategory shopCategory = new ShopCategory();
		Area area = new Area();
		personInfo.setUserId(1L);
		shopCategory.setShopCategoryId(1L);
		area.setAreaId(1);
		shop.setArea(area);
		shop.setOwner(personInfo);
		shop.setShopCategory(shopCategory);
		shop.setShopName("天滋果色");
		shop.setShopDesc("一代天资,天姿国色");
		shop.setShopAddr("天堂路天堂街888号");
		shop.setPhone("18815598680");
		shop.setShopImg("noimage");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("可以");
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}
