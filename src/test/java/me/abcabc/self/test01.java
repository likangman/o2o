package me.abcabc.self;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.core.annotation.SynthesizingMethodParameter;

class apple{
	int num;
}
public class test01 {
	public test01(apple a)
	{
		ss(a);
		System.out.println(a.num);
	}
	public void ss(apple a)
	{
		a.num=100;
	}
	public static void main(String[] args) {
		apple apple = new apple();
		apple.num = 1;
		test01 sTest01 = new test01(apple);
	}
}
