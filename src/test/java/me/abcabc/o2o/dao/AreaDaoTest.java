package me.abcabc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.abcabc.o2o.BaseTest;
import me.abcabc.o2o.entity.Area;
//me.abcabc.o20.entity.Area
public class AreaDaoTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;
	@Test
	public void testQueryArea()
	{
		List<Area> areaList  = areaDao.queryArea();
		for(Area area:areaList)
		{
			System.out.println(area.getAreaName());
		}
		assertEquals(2, areaList.size());	
	}

}
