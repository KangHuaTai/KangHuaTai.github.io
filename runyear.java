import java.util.*;
public class runyear{
	public static void main(String k[]){
	Scanner in=new Scanner(System.in);
	int a;
	System.out.println("a:");
	a=in.nextInt();
	if(a%4==0&& a%100!=0||a%400==0){
		System.out.println("a is runyear");
	}else{
		System.out.println("a no is runyear");
	}
	}

}