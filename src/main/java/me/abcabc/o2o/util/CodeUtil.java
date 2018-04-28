package me.abcabc.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	
	public static boolean checkVerifyCode(HttpServletRequest request)
	{
		System.out.println(2+"------------------");
		String verifyCodeExpected = (String)request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		if(verifyCodeActual == null||!verifyCodeActual.equals(verifyCodeExpected))
		{
			System.out.println(2.1+"------------------");
			return false;
		}
		System.out.println(2.2+"------------------");
		return true;
	}

}
