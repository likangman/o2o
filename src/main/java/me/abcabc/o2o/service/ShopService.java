package me.abcabc.o2o.service;

import java.io.File;
import java.io.InputStream;

import me.abcabc.o2o.dto.ShopExcution;
import me.abcabc.o2o.entity.Shop;

public interface ShopService {
	ShopExcution addShop(Shop shop,
			InputStream shopImgInputStream,String fileName);

}
