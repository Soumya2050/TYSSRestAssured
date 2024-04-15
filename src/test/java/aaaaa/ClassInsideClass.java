package aaaaa;

public class ClassInsideClass {
	
	static int a=10;
	
	public static class abc{
		static int b=20;
	}
	public static void main(String[] args) {
		System.out.println(a);
		System.out.println(abc.b);
	}
		
	}
