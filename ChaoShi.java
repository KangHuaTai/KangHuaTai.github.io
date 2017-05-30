import java.util.*;
public class ChaoShi{
	static Chao[] chao=new Chao[100];
	static int k=0;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] ages){
		caidan();
	}

	public static void caidan(){
		boolean a=true;
		while(a){
			System.out.println("================");
			System.out.println("===1.进货=======");
			System.out.println("===2.售货=======");
			System.out.println("===3.查看仓库===");
			System.out.println("===4.退出=======");
			System.out.println("================");
			int i=sc.nextInt();
			switch(i){
				case 1: jin();a=false;break;
				case 2: shou();a=false;break;
				case 3: cang();a=false;break;
				case 4: System.out.println("退出成功！再见！");a=false;break;
				default: System.out.println("输入有误！请重新选择：");break;
			}
		}
	}
//进货（进货存入数据）
	public static void jin(){
		System.out.print("请输入商品名称：");
		String name=sc.next();
		System.out.print("请输入商品价格: ");
		float jia=sc.nextFloat();
		System.out.print("请输入商品数量: ");
		int cun=sc.nextInt();
		Chao chao2 = new Chao(name,jia,cun);
		for(int i=0;i<100;i++){
			if(chao[i]==null){
				chao[i]=chao2;
				k++;
				break;
			}
		}
		System.out.println("进货成功！是否继续进货。\n1.进货 2.返回菜单：");
		boolean ad=true;
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1: jin();ad=false;break;
				case 2: caidan();ad=false;break;
				default: System.out.println("输入有误！请重新输入\n1.进货 2.返回菜单：");break;
			}
		}
	}
//售货
	public static void shou(){
		boolean ad=true;
		while(ad){
		System.out.println("================");
		System.out.println("===1.售卖全部===");
		System.out.println("===2.售卖单个===");
		System.out.println("================");
			int in=sc.nextInt();
			switch(in){
				case 1:s_1();ad=false;break;
				case 2:s_2();ad=false;break;
				default:System.out.println("输入有误！请重新输入：");

			}
		}
	}
//售卖全部
	public static void s_1(){
		System.out.print("请输入要卖出的数量: ");
		int shu=sc.nextInt();
		int hh=0;
		for(int i=0;i<k;i++){
			if(chao[i].cun-shu<0){
				System.out.println("对不起，仓库存货不够");
				hh++;
				break;
			}
		}
		boolean ad=true;
		if(hh==0){
			for(int i=0;i<k;i++){
				chao[i].cun=chao[i].cun-shu;
			}
			System.out.println("售卖成功！是否继续售卖\n1.售卖商品 2.返回菜单");
		}else{
			System.out.println("是否继续售卖\n1.售卖商品 2.返回菜单");
		}
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1:shou();ad=false;break;
				case 2:caidan();ad=false;break;
				default:System.out.println("输入有误！请重新输入\n1.售卖商品 2.返回菜单");
			}
		}
	}
//售卖单个
	public static void s_2(){
		System.out.print("请输入要卖出的名称： ");
		String s_name=sc.next();
		int hh=0;
		int dd=500;
		for(int i=0;i<k;i++){
			if(chao[i].name.equals(s_name)){
				dd=i;
			}
		}
		boolean ad=true;
		if(dd==500){
			System.out.println("超市没有此商品\n是否继续售卖\n1.售卖商品 2.返回菜单");
		}else{
			System.out.print("请输入要卖出的数量： ");
			int shu=sc.nextInt();
			if(chao[dd].cun-shu<0){
				System.out.println("对不起，仓库存货不够！\n是否继续售卖\n1.售卖商品 2.返回菜单");
			}else{
				chao[dd].cun=chao[dd].cun-shu;
				System.out.println("售卖成功！是否继续售卖\n1.售卖商品 2.返回菜单");
			}
		}
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1:shou();ad=false;break;
				case 2:caidan();ad=false;break;
				default:System.out.println("输入有误！请重新输入\n1.售卖商品 2.返回菜单");
			}
		}	
	}
//仓库
	public static void cang(){
		boolean ad=true;
		while(ad){
		System.out.println("================");
		System.out.println("===1.查看全部===");
		System.out.println("===2.单品查看===");
		System.out.println("================");
			int in=sc.nextInt();
			switch(in){
				case 1: c_1();ad=false;break;
				case 2: c_2();ad=false;break;
				default: System.out.println("输入有误！请重新选择：");break;
			}
		}
	}
//查看仓库全部
	public static void c_1(){
		int i;
		for(i=0;i<k;i++){
			chao[i].chao2();
		}
		boolean ad=true;
		System.out.println("查看成功！是否继续查看\n1.查看仓库 2.返回菜单："); 
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1: cang();ad=false;break;
				case 2: caidan();ad=false;break;
				default: System.out.println("输入有误！请重新选择\n1.查看仓库 2.返回菜单：");break;
			}
		}
	}
//查看仓库单品
	public static void c_2(){
		System.out.print("请输入商品名称：");
		String j=sc.next();
		int hh=0;
		for(int i=0;i<k;i++){
			if(chao[i].name.equals(j)){
				chao[i].chao2();
				hh++;
			}
		}
		boolean ad=true;
		if(hh==0){
			System.out.println("超市没有此商品！是否继续查看\n1.查看仓库 2.返回菜单：");
		}else{
			System.out.println("查看成功！是否继续查看\n1.查看仓库 2.返回菜单："); 
		}
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1: cang();ad=false;break;
				case 2: caidan();ad=false;break;
				default: System.out.println("输入有误！请重新选择\n1.查看仓库 2.返回菜单：");break;
			}
		}
	}
}
