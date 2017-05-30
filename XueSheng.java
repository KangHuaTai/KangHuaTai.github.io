import java.util.*;
public class Xue{
	static Scanner sc=new Scanner(System.in);
	static String name;
	static int age;
	static char sex;
	static int in=0;
	static String [] an=new String[100];

	public static void main(String[] ages){
		caidan();
	}
//菜单
	public static void caidan(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.添加==============");
			System.out.println("=====2.删除==============");
			System.out.println("=====3.修改==============");
			System.out.println("=====4.查询==============");
			System.out.println("=====5.退出==============");
			System.out.println("=========================");
			int i=sc.nextInt();
			switch(i){
			case 1:tianjia();a=false;break;
			case 2:shanchu();a=false;break;
			case 3:xiugai();a=false;break;
			case 4:chaxun();a=false;break;
			case 5:System.out.println("退出成功！再见");a=false;break;
			default:System.out.println("输入有误！请重新输入：");
			}
		}
		
	}
//添加
	public static void tianjia(){
		boolean a=true;
//开始循环
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.添加学生信息======");
			System.out.println("=====2.返回菜单==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//添加学生信息
			if(i==1){
//输入学生姓名
				System.out.print("请输入学生姓名：");
				name=sc.next();
//输入学生年龄
				System.out.print("请输入学生年龄（0~100）：");
//规定必须输入0~100，不然死循环
				while(true){
					age=sc.nextInt();
					if(age>=0&age<=100){
						break;
					}
					System.out.println("输入有误！请重新输入学生年龄（0~100）：");
				}
//输入学生性别
				System.out.print("请输入学生性别（男，女）：");
//规定必须输入男，女，不然死循环
				while(true){
					sex=sc.next().charAt(0);
					if(sex=='男'|sex=='女'){
						break;
					}
					System.out.println("输入有误！请重新输入学生性别（男，女）：");
				}
				System.out.println("添加成功！");
//保存学生信息
				an[in] = name+","+age+","+sex;
				in++;
//返回菜单
			}else if(i==2){
				caidan();
				a=false;
//输入错误继续循环
			}else{
				System.out.println("输入有误！请重新输入：");
			}
		}
	}
//删除
	public static void shanchu(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.删除单人==========");
			System.out.println("=====2.删除所有==========");
			System.out.println("=====3.返回菜单==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//删除单人
			if(i==1){
				System.out.println("请输入学生姓名：");
				String b=sc.next();
				int j;
				for(j=0;j<in;j++){
					String[] ca=an[j].split(",");
					if(ca[0].equals(b)){
								an[j]=null;
					}
				}
//删除所有学生信息
			}else if(i==2){
				for(int j=0;j<i;j++){
						an[j]=null;
				}
//返回菜单
			}else if(i==3){
				caidan();
				a=false;
//输入错误继续循环
			}else{
				System.out.println("输入有误！请重新输入：");
			}
		}
	}
//修改
	public static void xiugai(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.单人修改==========");
			System.out.println("=====2.全部修改==========");
			System.out.println("=====3.返回菜单==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//修改单人信息
			if(i==1){
				System.out.println("请输入学生姓名：");
				String b=sc.next();
				int j;
				for(j=0;j<in;j++){
					if(an[j]!=null){
						String[] ca=an[j].split(",");
						if(ca[0].equals(b)){
//输入学生姓名
						System.out.print("请输入学生姓名：");
						name=sc.next();
//输入学生年龄
						System.out.print("请输入学生年龄（0~100）：");
//规定必须输入0~100，不然死循环
						while(true){
							age=sc.nextInt();
							if(age>=0&age<=100){
							break;
						}
						System.out.println("输入有误！请重新输入学生年龄（0~100）：");
						}
//输入学生性别
						System.out.print("请输入学生性别（男，女）：");
//规定必须输入男，女，不然死循环
						while(true){
							sex=sc.next().charAt(0);
							if(sex=='男'|sex=='女'){
							break;
							}
						}
							an[j]=name+","+age+","+sex;
						}
					}
				}

				
//修改所有学生信息
			}else if(i==2){
//输入学生姓名
				System.out.print("请输入学生姓名：");
				name=sc.next();
//输入学生年龄
				System.out.print("请输入学生年龄（0~100）：");
//规定必须输入0~100，不然死循环
				while(true){
					age=sc.nextInt();
					if(age>=0&age<=100){
					break;
				}
				System.out.println("输入有误！请重新输入学生年龄（0~100）：");
			}
//输入学生性别
			System.out.print("请输入学生性别（男，女）：");
//规定必须输入男，女，不然死循环
			while(true){
				sex=sc.next().charAt(0);
				if(sex=='男'|sex=='女'){
					break;
				}
			}
			for(int j=0;j<i;j++){
				an[j] = name+","+age+","+sex;
			}
//返回菜单
			}else if(i==3){
				caidan();
				a=false;
//输入错误继续循环
			}else{
				System.out.println("输入有误！请重新输入：");
			}
		}
	}
//查询
	public static void chaxun(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.姓名查看==========");
			System.out.println("=====2.查看所有==========");
			System.out.println("=====3.返回菜单==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//单人查询
			if(i==1){
				System.out.println("请输入学生姓名：");
				String [] can=new String[100];
				String b=sc.next();
				int j;
				int g=0;
				int jj=0;
				for(j=0;j<in;j++){
					
					if(an[j]!=null){
						String[] ca=an[j].split(",");
						if(ca[0].equals(b)){
							g++;
							while(jj<g){
								can[jj]=an[j];
								jj++;
							}
						}
					}
				}
				boolean ad=true;
				while(ad){
					System.out.println("=========================");
					System.out.println("=====1.显示所有==========");
					System.out.println("=====2.显示单人==========");
					System.out.println("=========================");
					int ii=sc.nextInt();
					if(ii==1){
						ad=false;
						for(int k=0;k<=g;k++){
							if(can[k]!=null){
								System.out.println(can[k]);
							}
						}
						System.out.println("查询成功！");
					}else if(ii==2){
						ad=false;
						System.out.println("请输入学生年龄：");
						String bb=sc.next();
						int jjj;
						int gg=0;
						for(jjj=0;jjj<=g;jjj++){
							if(can[jjj]!=null){
								String[] cca=can[jjj].split(",");
								if(cca[1].equals(bb)){
									String [] ccaa=new String[100];
									gg++;
									for(int jj=0;jj<=gg;jj++){
										ccaa[jj]=can[jjj];
									}
									boolean add=true;
									while(add){
										System.out.println("=========================");
										System.out.println("=====1.显示所有==========");
										System.out.println("=====2.显示单人==========");
										System.out.println("=========================");
										int ii=sc.nextInt();
										if(ii==1){
											add=false;
											for(int k=0;k<=g;k++){
												if(ccaa[k]!=null){
													System.out.println(ccaa[k]);
												}
											}
											System.out.println("查询成功！");
										}else if(ii==2){
											add=false
											System.out.println("请输入学生性别：");
											String xb=sc.next();
											int qq;
											int ww=0;
											for(qq=0;qq<=g;qq++){
												if(can[qq]!=null){
													String[] cca=can[qq].split(",");
													if(cca[2].equals(xb)){
														String [] ccaa=new String[100];
														ww++;
														for(int jj=0;jj<=ww;jj++){
															ccaa[jj]=can[qq];
														}
													}
												}
											}
										}else{
										}
									}
								}
							}
						}
					}else{
					}
				}
				if(g==0){
					System.out.println("查无此人");
				}
				
//显示所有学生信息
			}else if(i==2){
				for(int j=0;j<in;j++){
					if(an[j]!=null){
						System.out.println(an[j]);
					}
				}
//返回菜单
			}else if(i==3){
				caidan();
				a=false;
//输入错误继续循环
			}else{
				System.out.println("输入有误！请重新输入：");
			}
		}
	}
}