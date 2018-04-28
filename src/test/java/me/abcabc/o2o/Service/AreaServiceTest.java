package me.abcabc.o2o.Service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.abcabc.o2o.BaseTest;
import me.abcabc.o2o.entity.Area;
import me.abcabc.o2o.service.AreaService;

public class AreaServiceTest extends BaseTest{

	@Autowired
	private AreaService areaService;
	@Test
	public void testGetAreaList()
	{
		List<Area> areaList = areaService.getAreaList();
		assertEquals("西苑", areaList.get(0).getAreaName());
	}
}
