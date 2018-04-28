package me.abcabc.o2o.service;

import java.util.List;

import me.abcabc.o2o.entity.ShopCategory;

public interface ShopCategoryService {
	List<ShopCategory>  getShopCategoryList(ShopCategory shopCategoryCondition);

}
