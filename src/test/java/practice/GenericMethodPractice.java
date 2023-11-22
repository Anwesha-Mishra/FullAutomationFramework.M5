package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {//caller
		// TODO Auto-generated method stub
		
		int sum=add(78,68);
		System.out.println(sum);
	}
	
	public static int add(int a ,int b)//called
	{
		int c=a+b;
		return c;
	}

}
