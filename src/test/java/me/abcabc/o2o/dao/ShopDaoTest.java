package me.abcabc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

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
	//@Test
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
		shop.setShopName("���̹�ɫ");
		shop.setShopDesc("һ������,���˹�ɫ");
		shop.setShopAddr("test");
		shop.setPhone("18815598680");
		shop.setShopImg("noimage");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("����");
		int e = shopDao.insertShop(shop);
		assertEquals(1, e);
	}
	@Test
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
		shop.setShopName("���̹�ɫ");
		shop.setShopDesc("һ������,���˹�ɫ");
		shop.setShopAddr("����·���ý�888��");
		shop.setPhone("18815598680");
		shop.setShopImg("noimage");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("����");
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}
