import java.util.*;
public class Xue1{
	static Scanner sc=new Scanner(System.in);
	static String name;
	static int age;
	static char sex;
	static int in=0;
	static String [] an=new String[100];

	public static void main(String[] ages){
		caidan();
	}
//�˵�
	public static void caidan(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.���==============");
			System.out.println("=====2.ɾ��==============");
			System.out.println("=====3.�޸�==============");
			System.out.println("=====4.��ѯ==============");
			System.out.println("=====5.�˳�==============");
			System.out.println("=========================");
			int i=sc.nextInt();
			switch(i){
			case 1:tianjia();a=false;break;
			case 2:shanchu();a=false;break;
			case 3:xiugai();a=false;break;
			case 4:chaxun();a=false;break;
			case 5:System.out.println("�˳��ɹ����ټ�");a=false;break;
			default:System.out.println("�����������������룺");
			}
		}
		
	}
//���
	public static void tianjia(){
		boolean a=true;
//��ʼѭ��
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.���ѧ����Ϣ======");
			System.out.println("=====2.���ز˵�==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//���ѧ����Ϣ
			if(i==1){
//����ѧ������
				System.out.print("������ѧ��������");
				name=sc.next();
//����ѧ������
				System.out.print("������ѧ�����䣨0~100����");
//�涨��������0~100����Ȼ��ѭ��
				while(true){
					age=sc.nextInt();
					if(age>=0&age<=100){
						break;
					}
					System.out.println("������������������ѧ�����䣨0~100����");
				}
//����ѧ���Ա�
				System.out.print("������ѧ���Ա��У�Ů����");
//�涨���������У�Ů����Ȼ��ѭ��
				while(true){
					sex=sc.next().charAt(0);
					if(sex=='��'|sex=='Ů'){
						break;
					}
					System.out.println("������������������ѧ���Ա��У�Ů����");
				}
				System.out.println("��ӳɹ���");
//����ѧ����Ϣ
				an[in] = name+","+age+","+sex;
				in++;
//���ز˵�
			}else if(i==2){
				caidan();
				a=false;
//����������ѭ��
			}else{
				System.out.println("�����������������룺");
			}
		}
	}
//ɾ��
	public static void shanchu(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.ɾ������==========");
			System.out.println("=====2.ɾ������==========");
			System.out.println("=====3.���ز˵�==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//ɾ������
			if(i==1){
				System.out.println("������ѧ��������");
				String b=sc.next();
				int j;
				for(j=0;j<in;j++){
					String[] ca=an[j].split(",");
					if(ca[0].equals(b)){
								an[j]=null;
					}
				}
//ɾ������ѧ����Ϣ
			}else if(i==2){
				for(int j=0;j<i;j++){
						an[j]=null;
				}
//���ز˵�
			}else if(i==3){
				caidan();
				a=false;
//����������ѭ��
			}else{
				System.out.println("�����������������룺");
			}
		}
	}
//�޸�
	public static void xiugai(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.�����޸�==========");
			System.out.println("=====2.ȫ���޸�==========");
			System.out.println("=====3.���ز˵�==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//�޸ĵ�����Ϣ
			if(i==1){
				System.out.println("������ѧ��������");
				String b=sc.next();
				int j;
				for(j=0;j<in;j++){
					if(an[j]!=null){
						String[] ca=an[j].split(",");
						if(ca[0].equals(b)){
//����ѧ������
						System.out.print("������ѧ��������");
						name=sc.next();
//����ѧ������
						System.out.print("������ѧ�����䣨0~100����");
//�涨��������0~100����Ȼ��ѭ��
						while(true){
							age=sc.nextInt();
							if(age>=0&age<=100){
							break;
						}
						System.out.println("������������������ѧ�����䣨0~100����");
						}
//����ѧ���Ա�
						System.out.print("������ѧ���Ա��У�Ů����");
//�涨���������У�Ů����Ȼ��ѭ��
						while(true){
							sex=sc.next().charAt(0);
							if(sex=='��'|sex=='Ů'){
							break;
							}
						}
							an[j]=name+","+age+","+sex;
						}
					}
				}

				
//�޸�����ѧ����Ϣ
			}else if(i==2){
//����ѧ������
				System.out.print("������ѧ��������");
				name=sc.next();
//����ѧ������
				System.out.print("������ѧ�����䣨0~100����");
//�涨��������0~100����Ȼ��ѭ��
				while(true){
					age=sc.nextInt();
					if(age>=0&age<=100){
					break;
				}
				System.out.println("������������������ѧ�����䣨0~100����");
			}
//����ѧ���Ա�
			System.out.print("������ѧ���Ա��У�Ů����");
//�涨���������У�Ů����Ȼ��ѭ��
			while(true){
				sex=sc.next().charAt(0);
				if(sex=='��'|sex=='Ů'){
					break;
				}
			}
			for(int j=0;j<i;j++){
				an[j] = name+","+age+","+sex;
			}
//���ز˵�
			}else if(i==3){
				caidan();
				a=false;
//����������ѭ��
			}else{
				System.out.println("�����������������룺");
			}
		}
	}
//��ѯ
	public static void chaxun(){
		boolean a=true;
		while(a){
			System.out.println("=========================");
			System.out.println("=====1.�����鿴==========");
			System.out.println("=====2.�鿴����==========");
			System.out.println("=====3.���ز˵�==========");
			System.out.println("=========================");
			int i=sc.nextInt();
//���˲�ѯ
			if(i==1){
				System.out.println("������ѧ��������");
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
					System.out.println("=====1.��ʾ����==========");
					System.out.println("=====2.��ʾ����==========");
					System.out.println("=========================");
					int ii=sc.nextInt();
					if(ii==1){
						ad=false;
						for(int k=0;k<=g;k++){
							if(can[k]!=null){
								System.out.println(can[k]);
							}
						}
						System.out.println("��ѯ�ɹ���");
					}else if(ii==2){
						ad=false;
						System.out.println("������ѧ�����䣺");
						String bb=sc.next();
						int jjj;
						int gg=0;
						for(jjj=0;jjj<=g;jjj++){
							if(can[jjj]!=null){
								String[] cca=can[jjj].split(",");
								if(cca[1].equals(bb)){
									String [] ccaa=new String[100];
									gg++;
									for(jj=0;jj<=gg;jj++){
										ccaa[jj]=can[jjj];
									}
									boolean add=true;
									while(add){
										System.out.println("=========================");
										System.out.println("=====1.��ʾ����==========");
										System.out.println("=====2.��ʾ����==========");
										System.out.println("=========================");
										ii=sc.nextInt();
										if(ii==1){
											add=false;
											for(int k=0;k<=g;k++){
												if(ccaa[k]!=null){
													System.out.println(ccaa[k]);
												}
											}
											System.out.println("��ѯ�ɹ���");
										}else if(ii==2){
											add=false;
											System.out.println("������ѧ���Ա�");
											String xb=sc.next();
											int qq;
											int ww=0;
											String [] ddw=new String[100];
											for(qq=0;qq<=g;qq++){
												if(ccaa[qq]!=null){
													String[] dda=ccaa[qq].split(",");
													if(dda[2].equals(xb)){
														ww++;
														for(jj=0;jj<=ww;jj++){
															if(ddw[jj]!=null){
																System.out.print(ccaa[qq]);
															}
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
					System.out.println("���޴���");
				}
				
//��ʾ����ѧ����Ϣ
			}else if(i==2){
				for(int j=0;j<in;j++){
					if(an[j]!=null){
						System.out.println(an[j]);
					}
				}
//���ز˵�
			}else if(i==3){
				caidan();
				a=false;
//����������ѭ��
			}else{
				System.out.println("�����������������룺");
			}
		}
	}
}