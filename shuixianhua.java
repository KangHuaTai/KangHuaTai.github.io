import java.util.*;
public class shuixianhua{
	public static void main(String k[]){
	int a=1,b,c,d;
	Scanner in=new Scanner(System.in);
	for(;a!=0;){
	System.out.print("Please enter a three bit integer:");
	a=in.nextInt();
	if(a>99&&a<1000){
	break;
	}
	}
	b=a%10;
	c=a/10%10;
	d=a/100%10;
	if(a==b*b*b+c*c*c+d*d*d){
	System.out.println(a+" is shuixianhuashui");
	}else{System.out.println(a+" no is shuixianhuashui");}
	}

}