package me.abcabc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.abcabc.o2o.entity.Shop;

public interface ShopDao {
	
	/**
	 * 
	 * @param shopCondition
	 * @param rowIndex�ӵڼ��п�ʼȡ
	 * @param pageSizeȡ���ٸ�����
	 * * ��ҳ��ѯ���̣�������������У���������ģ������
	 * ����״̬�������������ID,owner
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,@Param("rowIndex")int rowIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 * ����queryShopList����
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition")Shop shopCondition);
	
	
	
	
	/**
	 *ͨ��shop id��ѯ���� 
	 * @param shopId
	 * @return shop
	 */
	Shop queryByShopId(long shopId);

	/**
	 * ����µĵ���
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * ���µ���
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
