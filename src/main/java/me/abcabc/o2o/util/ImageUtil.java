package me.abcabc.o2o.util;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	
	static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
	
	String basePath = Thread.currentThread().getContextClassLoader()
			.getResource("").getPath();
	private static final SimpleDateFormat
	S_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static final Random r = new Random();
	
	public static String generateThumbnail(InputStream thumbnailInputStream,String fileName,String targetAddr)
	{
		
	
		String realFileName = getRandomFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr+realFileName+extension;
		logger.debug("relativeAddr--"+relativeAddr);
		File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
		logger.debug("dest--"+dest);
		try {
			Thumbnails.of(thumbnailInputStream)
			.size(1000,1000)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("F:/images/space02.jpg")),0.35f)
			.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		}
		return relativeAddr;
	}
	/**
	 * 创建目标路径上所涉及的目录
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		// TODO Auto-generated method stub
		String realFileParentPath  = PathUtil.getImgBasePath()+targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists())
		{
			dirPath.mkdirs();
		}
		
	}
	/**
	 * 获取文件输入流放入扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String  fileName) {
		

		
		return fileName.substring(fileName.lastIndexOf("."));
	}
	/**
	 * 生成随机文件名
	 * @return
	 */
	public  static String getRandomFileName()
	{
		//获取无为随机数
		int rannum = r.nextInt(89999)+10000;
		String nowTimestr = S_DATE_FORMAT.format(new Date());
		return nowTimestr+rannum;
	}
	
	public static void deleteFileOrPath(String storePath)
	{
		File fileOrPath = new File(PathUtil.getImgBasePath()+storePath);
		if(fileOrPath.exists())
		{
			//如果判断为文件路径
			if(fileOrPath.isDirectory())
			{
				File files[] = fileOrPath.listFiles();
				for(int i=0;i<files.length;i++)
				{
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	
	}
	public static void main(String[] args) {
		
		
		try {
			Thumbnails.of(new File("F:\\images\\21080416001.jpg"))
			.size(1000,1000)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("F:/images/space02.jpg")),0.95f)
			.outputQuality(0.8f).toFile("F:\\images\\11111.jpg");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
