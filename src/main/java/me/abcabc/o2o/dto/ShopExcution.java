package me.abcabc.o2o.dto;

import java.util.List;

import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.enums.ShopStateEnum;

public class ShopExcution {

	//���״̬
	private int state;
	//״̬��ʶ
	private String stateInfo;
	
	//��������
	private int count;
	//������shop����ɾ�Ĳ���̵�ʱ���õ���
	private Shop shop;
	//shop�б�(��ɾ�Ĳ��ʱ���õ�)
	public List<Shop> shopList;
	
	public ShopExcution()
	{
		
	}
	//���̲���ʧ�ܵ�ʱ��ʹ�õĹ�����
	public ShopExcution(ShopStateEnum shopStateEnum)
	{
		this.state = shopStateEnum.getState();
		this.stateInfo=shopStateEnum.getStateInfo();
	}
	//���̲����ɹ���ʱ��ʹ�õĹ�����
	public ShopExcution(ShopStateEnum shopStateEnum,Shop shop)
	{
		this.state = shopStateEnum.getState();
		this.stateInfo=shopStateEnum.getStateInfo();
		this.shop = shop;
	}
	//���̲����ɹ���ʱ��ʹ�õĹ�����
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
