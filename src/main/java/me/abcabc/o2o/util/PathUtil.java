package me.abcabc.o2o.util;

public class PathUtil {
	
	private static String seperator = System.getProperty("file.separator");
	
	public static String getImgBasePath()
	{
		String os  = System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win"))
		{
			basePath = "F:/images/";
		}else
		{
			basePath = "/home/xiangze/images/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	public static String getShopImagePath(long shopId)
	{
		String imagePath = ""+shopId+"/";
		return imagePath.replace("/", seperator);
	}
}
