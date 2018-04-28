package me.abcabc.o2o.enums;

import me.abcabc.o2o.entity.Shop;

public enum ShopStateEnum {

	CHECK(0,"审核中"),
	OFFLINE(-1,"非法店铺"),
	SUCCESS(1,"操作成功"),
	PASS(2,"通过认证"),
	INNER_ERROR(-1001,"内部系统错误"),
	NULL_SHOPID(-1002,"ShopId为空"),
	NULL_SHOP(-1003,"shop信息为空");
	private int state;
	public int getState() {
		return state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	private String stateInfo;
	private ShopStateEnum(int state,String stateInfo)
	{
		this.state = state;
		this.stateInfo = stateInfo;
	}
	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static ShopStateEnum stateOf(int state)
	{
		for(ShopStateEnum shopStateEnum:values())
		{
			if(shopStateEnum.getState()==state)
			{
				return shopStateEnum;
			}
		}
		return null;
	}
	
}
