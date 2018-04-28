package me.abcabc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.abcabc.o2o.entity.ShopCategory;

public interface ShopCategoryDao {
	List<ShopCategory> queryShopcategory(@Param("shopCategoryCondition")ShopCategory shopCategoryCondition);

}
