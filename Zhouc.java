import java.util.*;
public class Zhouc{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] ages){
		zhou y=new yuan();
		zhou s=new sanjiao();
		boolean ad=true;
		while(ad){
			System.out.println("==============");
			System.out.println("===1.Բ��=====");
			System.out.println("===2.������===");
			System.out.println("==============");
			int a=sc.nextInt();
			switch(a){
				case 1:y.zhou();ad=false;break;
				case 2:s.zhou();ad=false;break;
				default : System.out.println("�����������������룺");
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
		System.out.println("������Բ�İ뾶");
		double y=sc.nextDouble();
		System.out.println("Բ���ܳ�="+(y*y*3.14));
	}
}
class sanjiao extends zhou{
	static Scanner sc=new Scanner(System.in);
	public void zhou(){
		System.out.print("�����������εı߳�(��һ����): ");
		double q=sc.nextDouble();
		System.out.print("�����������εı߳�(�ڶ�����): ");
		double w=sc.nextDouble();
		System.out.print("�����������εı߳�(��������): ");
		double e=sc.nextDouble();
		System.out.println("Բ���ܳ�="+(q+w+e));
	}
}