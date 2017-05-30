public class Chao{
	String name;
	float jia;
	int cun;
	public Chao(String name,float jia,int cun){
		this.name=name;
		this.jia=jia;
		this.cun=cun;
	}
	public void chao2(){
		System.out.println("商品名称："+name+"\t| 价格："+jia+"\t| 库存："+cun);
	}
public static void main(String[]ages){
	System.out.println(isTel("0\\1"));
	System.out.println(isDate("haha"));
}
public static boolean isTel(String s) {
	 String regex = 
		"[0]\\d{2}-[1-9]\\d{7}|[0]\\d{3}-[1-9]\\d{6}";
	 return s.matches(regex);
}

public static boolean isDate(String s){
	 String regex = "\\d{2,4}-\\d{1,2}-\\d{1,2}";
	 return s.matches(regex);
}

}