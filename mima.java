import java.util.*;//TheMass,  Come and Get It ,Doat  ,Walk OnWater ,All I Ever Wanted
public class mima{
	public static void main(String[] age){
		Scanner sc=new Scanner(System.in);
		String a;
		for(;true;){
			System.out.print("qing shu ru 8~16 wei de mi ma:");
			a=sc.next();
			if(a.length()>=8&a.length()<=16){
				break;
			}
			System.out.println("shu ru cuo wu!");
		}
		System.out.println(a);
		String Z="[a-zA-Z]{8,16}";
		String S="[0-9]{8,16}";
		String F="[!@#$%^&*()_+|}{:\"?><~]{8,16}";
		String zs="[a-zA-Z0-9]{8,16}";
		String zf="[a-zA-Z!@#$%^&*()_+|}{:\"?><~]{8,16}";
		String sf="[0-9!@#$%^&*()_+|}{:\"?><~]{8,16}";
		String q="[a-zA-Z0-9!@#$%^&*()_+|}{:\"?><~]{8,16}";
		if(a.matches(Z)||a.matches(S)||a.matches(F)){
			System.out.println("ruo");
		}else if(a.matches(zs)||a.matches(zf)||a.matches(sf)){
			System.out.println("zhong");
		}else if(a.matches(q)){
			System.out.println("qiang");
		}
	}
}
