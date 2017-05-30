import java.util.Scanner;
public class jisuan{
	public static void main(String[] ags){
		Scanner k=new Scanner(System.in);
		double a,b;
		System.out.println("qing shu ru liang ge shu:");
		a=k.nextDouble();
		b=k.nextDouble();
		System.out.println(a+" + "+b+" = "+(a+b)+"\n"
		+a+" - "+b+" = "+(a-b)+"\n"
		+a+" * "+b+" = "+(a*b)+"\n"
		+a+" / "+b+" = "+(a/b));

	}
}