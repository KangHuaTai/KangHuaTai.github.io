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
			System.out.println("===1.����=======");
			System.out.println("===2.�ۻ�=======");
			System.out.println("===3.�鿴�ֿ�===");
			System.out.println("===4.�˳�=======");
			System.out.println("================");
			int i=sc.nextInt();
			switch(i){
				case 1: jin();a=false;break;
				case 2: shou();a=false;break;
				case 3: cang();a=false;break;
				case 4: System.out.println("�˳��ɹ����ټ���");a=false;break;
				default: System.out.println("��������������ѡ��");break;
			}
		}
	}
//�����������������ݣ�
	public static void jin(){
		System.out.print("��������Ʒ���ƣ�");
		String name=sc.next();
		System.out.print("��������Ʒ�۸�: ");
		float jia=sc.nextFloat();
		System.out.print("��������Ʒ����: ");
		int cun=sc.nextInt();
		Chao chao2 = new Chao(name,jia,cun);
		for(int i=0;i<100;i++){
			if(chao[i]==null){
				chao[i]=chao2;
				k++;
				break;
			}
		}
		System.out.println("�����ɹ����Ƿ����������\n1.���� 2.���ز˵���");
		boolean ad=true;
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1: jin();ad=false;break;
				case 2: caidan();ad=false;break;
				default: System.out.println("������������������\n1.���� 2.���ز˵���");break;
			}
		}
	}
//�ۻ�
	public static void shou(){
		boolean ad=true;
		while(ad){
		System.out.println("================");
		System.out.println("===1.����ȫ��===");
		System.out.println("===2.��������===");
		System.out.println("================");
			int in=sc.nextInt();
			switch(in){
				case 1:s_1();ad=false;break;
				case 2:s_2();ad=false;break;
				default:System.out.println("�����������������룺");

			}
		}
	}
//����ȫ��
	public static void s_1(){
		System.out.print("������Ҫ����������: ");
		int shu=sc.nextInt();
		int hh=0;
		for(int i=0;i<k;i++){
			if(chao[i].cun-shu<0){
				System.out.println("�Բ��𣬲ֿ�������");
				hh++;
				break;
			}
		}
		boolean ad=true;
		if(hh==0){
			for(int i=0;i<k;i++){
				chao[i].cun=chao[i].cun-shu;
			}
			System.out.println("�����ɹ����Ƿ��������\n1.������Ʒ 2.���ز˵�");
		}else{
			System.out.println("�Ƿ��������\n1.������Ʒ 2.���ز˵�");
		}
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1:shou();ad=false;break;
				case 2:caidan();ad=false;break;
				default:System.out.println("������������������\n1.������Ʒ 2.���ز˵�");
			}
		}
	}
//��������
	public static void s_2(){
		System.out.print("������Ҫ���������ƣ� ");
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
			System.out.println("����û�д���Ʒ\n�Ƿ��������\n1.������Ʒ 2.���ز˵�");
		}else{
			System.out.print("������Ҫ������������ ");
			int shu=sc.nextInt();
			if(chao[dd].cun-shu<0){
				System.out.println("�Բ��𣬲ֿ���������\n�Ƿ��������\n1.������Ʒ 2.���ز˵�");
			}else{
				chao[dd].cun=chao[dd].cun-shu;
				System.out.println("�����ɹ����Ƿ��������\n1.������Ʒ 2.���ز˵�");
			}
		}
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1:shou();ad=false;break;
				case 2:caidan();ad=false;break;
				default:System.out.println("������������������\n1.������Ʒ 2.���ز˵�");
			}
		}	
	}
//�ֿ�
	public static void cang(){
		boolean ad=true;
		while(ad){
		System.out.println("================");
		System.out.println("===1.�鿴ȫ��===");
		System.out.println("===2.��Ʒ�鿴===");
		System.out.println("================");
			int in=sc.nextInt();
			switch(in){
				case 1: c_1();ad=false;break;
				case 2: c_2();ad=false;break;
				default: System.out.println("��������������ѡ��");break;
			}
		}
	}
//�鿴�ֿ�ȫ��
	public static void c_1(){
		int i;
		for(i=0;i<k;i++){
			chao[i].chao2();
		}
		boolean ad=true;
		System.out.println("�鿴�ɹ����Ƿ�����鿴\n1.�鿴�ֿ� 2.���ز˵���"); 
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1: cang();ad=false;break;
				case 2: caidan();ad=false;break;
				default: System.out.println("��������������ѡ��\n1.�鿴�ֿ� 2.���ز˵���");break;
			}
		}
	}
//�鿴�ֿⵥƷ
	public static void c_2(){
		System.out.print("��������Ʒ���ƣ�");
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
			System.out.println("����û�д���Ʒ���Ƿ�����鿴\n1.�鿴�ֿ� 2.���ز˵���");
		}else{
			System.out.println("�鿴�ɹ����Ƿ�����鿴\n1.�鿴�ֿ� 2.���ز˵���"); 
		}
		while(ad){
			int in=sc.nextInt();
			switch(in){
				case 1: cang();ad=false;break;
				case 2: caidan();ad=false;break;
				default: System.out.println("��������������ѡ��\n1.�鿴�ֿ� 2.���ز˵���");break;
			}
		}
	}
}
