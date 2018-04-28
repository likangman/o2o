package me.abcabc.self;

class Banana
{
	int a=10;
	
}
public class Test02 {
	
	public Test02(Banana banana)
	{
		banana.a++;
	}
	
	

	public static void main(String[] args) {
		Banana banana = new Banana();
		System.out.println(banana.a);
		new Test02(banana);
		System.out.println(banana.a);
	}
}
