package me.abcabc.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	
	public static boolean checkVerifyCode(HttpServletRequest request)
	{
		System.out.println(2+"------------------");
		String verifyCodeExpected = (String)request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		System.out.println("verifyCodeActual:"+verifyCodeActual+"--verifyCodeExpected"+verifyCodeExpected);
		if(verifyCodeActual == null||!verifyCodeActual.equals(verifyCodeExpected))
		{
			
			return false;
		}
		
		return true;
	}

}
