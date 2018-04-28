package me.abcabc.o2o.Service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.abcabc.o2o.BaseTest;
import me.abcabc.o2o.dto.ShopExcution;
import me.abcabc.o2o.entity.Area;
import me.abcabc.o2o.entity.PersonInfo;
import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.entity.ShopCategory;
import me.abcabc.o2o.enums.ShopStateEnum;
import me.abcabc.o2o.service.ShopService;


public class ShopServiceTest extends BaseTest {

	@Autowired
	ShopService shopService;
	@Test 
	public void shopServiceTest() throws FileNotFoundException
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
		shop.setShopName("≤‚ ‘µÍ∆Ã3");
		shop.setShopDesc("a apple is beautiful");
		shop.setShopAddr("tt");
		shop.setPhone("18815598680");
		shop.setShopImg("noimage");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("…Û∫À÷–");
		File shopImg = new File("F:/images/space01.jpg");
		InputStream iStream = new FileInputStream(shopImg);
		ShopExcution sExcution = shopService.addShop(shop,iStream,shopImg.getName());
		assertEquals(ShopStateEnum.CHECK.getState(), sExcution.getState());
	}
}
