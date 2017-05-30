import java.util.*;
import java.util.*;
public class Zhou{
	public static void main(String[] ages){
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入圆的半径: ");
		double b=sc.nextDouble();
		yuan y=new yuan();
		y.zh(b);
		System.out.print("请输入三角形的边长(第一条边): ");
		double q=sc.nextDouble();
		System.out.print("请输入三角形的边长(第二条边): ");
		double w=sc.nextDouble();
		System.out.print("请输入三角形的边长(第三条边): ");
		double e=sc.nextDouble();
		sanjiao s=new sanjiao();
		s.zh(q,w,e);
		
	}
}
//圆
class yuan{
	public void zh(double b){
		System.out.println("周长="+(b*b*3.14));
	}
}
//三角形
class sanjiao{
	public void zh(double a,double b,double c){
		System.out.println("周长="+(a+b+c));
	}
}