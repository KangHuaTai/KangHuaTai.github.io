import java.util.*;
public class CaiPiao{
	static int a[]=new int[5];
	static int b[]=new int[5];
	static int k=0;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] agrs){
		shuRu();
	}
	public static void shuRu(){
		for(int i=0;i<5;i++){
			System.out.println("������5����(1~8)����"+(i+1)+"����");
			b[i]=sc.nextInt();
		}
		jiang();
	}
	public static void jiang(){
		for(int i=0;i<5;i++){
			a[i]=(int)(Math.random()*(9-1)+1);
			System.out.println("�н�����:"+a[i]);
			System.out.println("���Ѻע:"+b[i]);
			if(a[i]==b[i]){
				k++;
			}
		}
		jieguo();
	}
	public static void jieguo(){
		System.out.println("********************");
		if(k==0){
			System.out.println("�����н��Ͳ�һ��");
		}
		if(k==1){
			System.out.println("��ϲ�㣬��Ƚ�");
		}
		if(k==2){
			System.out.println("��ϲ�㣬�ĵȽ�");
		}
		if(k==3){
			System.out.println("��ϲ�㣬���Ƚ�");
		}
		if(k==4){
			System.out.println("��ϲ�㣬���Ƚ�");
		}
		if(k==5){
			System.out.println("��ϲ�㣬һ�Ƚ�");
		}
	}
}