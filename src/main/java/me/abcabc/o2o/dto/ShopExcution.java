package me.abcabc.o2o.dto;

import java.util.List;

import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.enums.ShopStateEnum;

public class ShopExcution {

	//结果状态
	private int state;
	//状态标识
	private String stateInfo;
	
	//店铺数量
	private int count;
	//操作的shop（增删改查店铺的时候用到）
	private Shop shop;
	//shop列表(增删改查的时候用到)
	public List<Shop> shopList;
	
	public ShopExcution()
	{
		
	}
	//店铺操作失败的时候使用的构造器
	public ShopExcution(ShopStateEnum shopStateEnum)
	{
		this.state = shopStateEnum.getState();
		this.stateInfo=shopStateEnum.getStateInfo();
	}
	//店铺操作成功的时候使用的构造器
	public ShopExcution(ShopStateEnum shopStateEnum,Shop shop)
	{
		this.state = shopStateEnum.getState();
		this.stateInfo=shopStateEnum.getStateInfo();
		this.shop = shop;
	}
	//店铺操作成功的时候使用的构造器
	public ShopExcution(ShopStateEnum shopStateEnum,List<Shop> shopList)
	{
		this.state = shopStateEnum.getState();
		this.stateInfo=shopStateEnum.getStateInfo();
		this.shopList = shopList;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public List<Shop> getShopList() {
		return shopList;
	}
	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
}
