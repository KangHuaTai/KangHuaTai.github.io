import java.util.*;
import java.util.*;
public class Zhou{
	public static void main(String[] ages){
		Scanner sc=new Scanner(System.in);
		System.out.print("������Բ�İ뾶: ");
		double b=sc.nextDouble();
		yuan y=new yuan();
		y.zh(b);
		System.out.print("�����������εı߳�(��һ����): ");
		double q=sc.nextDouble();
		System.out.print("�����������εı߳�(�ڶ�����): ");
		double w=sc.nextDouble();
		System.out.print("�����������εı߳�(��������): ");
		double e=sc.nextDouble();
		sanjiao s=new sanjiao();
		s.zh(q,w,e);
		
	}
}
//Բ
class yuan{
	public void zh(double b){
		System.out.println("�ܳ�="+(b*b*3.14));
	}
}
//������
class sanjiao{
	public void zh(double a,double b,double c){
		System.out.println("�ܳ�="+(a+b+c));
	}
}