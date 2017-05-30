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
			System.out.println("ÇëÊäÈë5¸öÊý(1~8)£¬µÚ"+(i+1)+"¸ö£º");
			b[i]=sc.nextInt();
		}
		jiang();
	}
	public static void jiang(){
		for(int i=0;i<5;i++){
			a[i]=(int)(Math.random()*(9-1)+1);
			System.out.println("ÖÐ½±ºÅÂë:"+a[i]);
			System.out.println("ÄãµÄÑº×¢:"+b[i]);
			if(a[i]==b[i]){
				k++;
			}
		}
		jieguo();
	}
	public static void jieguo(){
		System.out.println("********************");
		if(k==0){
			System.out.println("ÄãÀëÖÐ½±¾Í²îÒ»²½");
		}
		if(k==1){
			System.out.println("¹§Ï²Äã£¬ÎåµÈ½±");
		}
		if(k==2){
			System.out.println("¹§Ï²Äã£¬ËÄµÈ½±");
		}
		if(k==3){
			System.out.println("¹§Ï²Äã£¬ÈýµÈ½±");
		}
		if(k==4){
			System.out.println("¹§Ï²Äã£¬¶þµÈ½±");
		}
		if(k==5){
			System.out.println("¹§Ï²Äã£¬Ò»µÈ½±");
		}
	}
}