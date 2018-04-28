package me.abcabc.o2o.service.impl;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.abcabc.o2o.dao.ShopDao;
import me.abcabc.o2o.dto.ShopExcution;
import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.enums.ShopStateEnum;
import me.abcabc.o2o.exceptions.ShopOperationException;
import me.abcabc.o2o.service.ShopService;
import me.abcabc.o2o.util.ImageUtil;
import me.abcabc.o2o.util.PathUtil;
@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	ShopDao ShopDao;
	@Override
	//��֤�������������Լ�ԭ���ԣ������������runtimeException�쳣�׳�����ô�ûع�����δ���״̬
	@Transactional
	public ShopExcution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
		if(shop==null)
		{
			return new ShopExcution(ShopStateEnum.NULL_SHOP);
		}
		try {
			//��������Ϣ����ʼֵ
			shop.setEnableStatus(0);
			shop.setCreateTime(new java.util.Date());
			shop.setLastEditTime(new java.util.Date());
			//��ӵ�����Ϣ
			int effectNum = ShopDao.insertShop(shop);
			if(effectNum<=0)
			{
				throw new ShopOperationException("���̴���ʧ��");
			}else
			{
				
				if(shopImgInputStream!=null)
				{
					//�洢ͼƬ
					try {
						addShopImg(shop,shopImgInputStream,fileName);
					}catch(Exception e){
						System.out.println("ShopServiceImpl:"+"���ͼƬ����");
						throw new ShopOperationException("addShopImg ERROR"+e.getMessage());
					}
					//���µ��̵�ͼƬ��ַ
					effectNum = ShopDao.updateShop(shop);
					if(effectNum<=0)
					{
						System.out.println("ShopServiceImpl:"+"����ͼƬ��ַ����");
						throw new ShopOperationException("����ͼƬ��ַʧ��");
					}
				}
			}	
		}catch(Exception e)
		{
			System.out.println("ShopServiceImpl:"+"����");
			throw new ShopOperationException("addShop ERROR"+e.getMessage());
		}
		return new ShopExcution(ShopStateEnum.CHECK,shop);
	}
	private void addShopImg(Shop shop,InputStream shopImgInputStream,String fileName) 
	{
		//��ȡshopͼƬĿ¼�����ֵ·��
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName,dest);
		shop.setShopImg(shopImgAddr);
	}
}
