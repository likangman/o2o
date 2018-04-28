package me.abcabc.o2o.web.shopadmin;

import static org.hamcrest.CoreMatchers.nullValue;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.abcabc.o2o.dto.ShopExcution;
import me.abcabc.o2o.entity.Area;
import me.abcabc.o2o.entity.PersonInfo;
import me.abcabc.o2o.entity.Shop;
import me.abcabc.o2o.entity.ShopCategory;
import me.abcabc.o2o.enums.ShopStateEnum;
import me.abcabc.o2o.exceptions.ShopOperationException;
import me.abcabc.o2o.service.AreaService;
import me.abcabc.o2o.service.ShopCategoryService;
import me.abcabc.o2o.service.ShopService;
import me.abcabc.o2o.util.CodeUtil;
import me.abcabc.o2o.util.HttpServletRequestUtil;
import me.abcabc.o2o.util.ImageUtil;
import me.abcabc.o2o.util.PathUtil;

@Controller
@RequestMapping(value="/shopadmin")
public class ShopManagementController {

	@Autowired
	ShopService shopService;
	
	@Autowired
	private ShopCategoryService ShopCategoryService;
	@Autowired
	private AreaService areaService;
	
	
	@RequestMapping(value="/getshopinitinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> getShopInitInfo()
	{
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		List<Area> areaList = new ArrayList<Area>();
		try {
			shopCategoryList = ShopCategoryService.getShopCategoryList(new ShopCategory());
			areaList = areaService.getAreaList();
			modelMap.put("shopCategoryList", shopCategoryList);
			modelMap.put("areaList",areaList);
			modelMap.put("success",true);
		}catch(Exception e)
		{
			modelMap.put("success",false);
			modelMap.put("errMsg",e.getMessage());
		}
		return modelMap;
	}
	
	
	
	@RequestMapping(value="/registershop")
	@ResponseBody
	public Map<String, Object> registerShop(HttpServletRequest request)
	{
		Map<String, Object> modelMap = new HashMap<String,Object>();
		
		//������֤����ȷ����֤

		System.out.println("��Ц��ô");
		if(!CodeUtil.checkVerifyCode(request))
		{
			modelMap.put("success",false);
			modelMap.put("errMsg","�����˴������֤��");
			return modelMap;
		}
		//1.���ܲ�ת����Ӧ�Ĳ���������������Ϣ�Լ�ͼƬ��Ϣ
		String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr,Shop.class);
		}catch (Exception e) {
			modelMap.put("success",false);
			modelMap.put("errMsg",e.getMessage());
			System.out.println(e.getMessage());
			return modelMap;
		}    
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver
		=new CommonsMultipartResolver(request.getSession().getServletContext());
		//�ж��Ƿ�����ļ���
		if(commonsMultipartResolver.isMultipart(request))
		{
			//ǿ��ת������ȡ�ļ���
			MultipartHttpServletRequest multipartHttpServletRequest
			=(MultipartHttpServletRequest)request;
			shopImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");

		}else
		{
			modelMap.put("success", false);
			modelMap.put("errMsg", "�ϴ�ͼƬ����Ϊ��");
			return modelMap;
		}
		//2.ע�����
		if(shop!=null&&shopImg!=null)
		{
			PersonInfo owner = new PersonInfo();
			owner.setUserId(1L);
			shop.setOwner(owner);
//			File shopImgFile = new File(PathUtil.getImgBasePath()+ImageUtil.getRandomFileName());
//			try {
//				shopImgFile.createNewFile();
//			}catch(IOException e)
//			{
//				modelMap.put("success",false);
//				modelMap.put("errMsg",e.getMessage());
//				return modelMap;
//			}
//			try {
//				InputStreamToFile(shopImg.getInputStream(),shopImgFile);
//			} catch (IOException e) {
//				modelMap.put("success",false);
//				modelMap.put("errMsg",e.getMessage());
//				return modelMap;
//			}
			//���е���ע��
			ShopExcution sException;
			try {
				sException = shopService.addShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
				
				if(sException.getState()==ShopStateEnum.CHECK.getState())
				{
					modelMap.put("success",true);
				}else
				{
					modelMap.put("success",false);
					modelMap.put("errMsg",sException.getStateInfo());
				}
			} catch (Exception e) {
				modelMap.put("success",false);
				modelMap.put("errMsg",e.getMessage());
			}
			return modelMap;
		}else
		{
			modelMap.put("success", false);
			modelMap.put("errMsg", "�����������Ϣ");
			return modelMap;
		}
	}

//	private void InputStreamToFile(InputStream ins, File file) {
//		// TODO Auto-generated method stub
//		FileOutputStream osFileOutputStream=null;
//		try
//		{
//			osFileOutputStream = new FileOutputStream(file);
//			int bytesRead = 0;
//			byte[] buffer = new byte[1024];
//			while((bytesRead = ins.read(buffer))!=-1)
//			{
//				osFileOutputStream.write(buffer,0,bytesRead);
//			}
//		}catch(Exception e)
//		{
//			throw new RuntimeException("����inputStreamToFile�����쳣"+e.getMessage());
//		}finally {
//			try {if(osFileOutputStream!=null) {osFileOutputStream.close();}
//				if(ins!=null) {ins.close();}
//			}catch(IOException e)
//			{
//				throw new RuntimeException("inputStreamToFile�ر�IO�����쳣"+e.getMessage());
//			}
//			
//		}
//	}
}
