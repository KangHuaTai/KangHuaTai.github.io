import java.util.*;
public class Zhouc{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] ages){
		zhou y=new yuan();
		zhou s=new sanjiao();
		boolean ad=true;
		while(ad){
			System.out.println("==============");
			System.out.println("===1.圆形=====");
			System.out.println("===2.三角形===");
			System.out.println("==============");
			int a=sc.nextInt();
			switch(a){
				case 1:y.zhou();ad=false;break;
				case 2:s.zhou();ad=false;break;
				default : System.out.println("输入有误！请重新输入：");
			}
		}
	}
}
abstract class zhou{
	abstract void zhou();
}
class yuan extends zhou{
	static Scanner sc=new Scanner(System.in);
	public void zhou(){
		System.out.println("请输入圆的半径");
		double y=sc.nextDouble();
		System.out.println("圆的周长="+(y*y*3.14));
	}
}
class sanjiao extends zhou{
	static Scanner sc=new Scanner(System.in);
	public void zhou(){
		System.out.print("请输入三角形的边长(第一条边): ");
		double q=sc.nextDouble();
		System.out.print("请输入三角形的边长(第二条边): ");
		double w=sc.nextDouble();
		System.out.print("请输入三角形的边长(第三条边): ");
		double e=sc.nextDouble();
		System.out.println("圆的周长="+(q+w+e));
	}
}