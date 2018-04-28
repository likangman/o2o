package me.abcabc.o2o.enums;

import me.abcabc.o2o.entity.Shop;

public enum ShopStateEnum {

	CHECK(0,"�����"),
	OFFLINE(-1,"�Ƿ�����"),
	SUCCESS(1,"�����ɹ�"),
	PASS(2,"ͨ����֤"),
	INNER_ERROR(-1001,"�ڲ�ϵͳ����"),
	NULL_SHOPID(-1002,"ShopIdΪ��"),
	NULL_SHOP(-1003,"shop��ϢΪ��");
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
	 * ���ݴ����state������Ӧ��enumֵ
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
