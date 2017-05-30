import java.util.*;
public class Xue11{
	static Scanner sc=new Scanner(System.in);
	static String name;
	static int age;
	static char sex;
	static int in=0;
	static String [] an=new String[100];

	public static void main(String[] ages){
		caidan();
	}
//�˵�---------------------------------------------------------------------
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
//���---------------------------------------------------------------------
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
//ɾ��--------------------------------------------------------------------------
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
//�޸�--------------------------------------------------------------------
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
//��ѯ-------------------------------------------------------------------------
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
//����ѧ������
				System.out.println("������ѧ��������");
				String [] can=new String[100];
				String b=sc.next();
//���ü�������
				int j;
				int g=0;
				int jj=0;
				for(j=0;j<in;j++){
//��ʼ�����ж�
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
//�����жϽ���	
				boolean ad=true;
				while(ad){
				System.out.println("=========================");
				System.out.println("=====1.��ʾ����==========");
				System.out.println("=====2.��ʾ����==========");
				System.out.println("=========================");
//ѡ����ʾ
				i=sc.nextInt();
				if(i==1){
//��ʾ�����������ϵ���
					ad=false;
					for(j=0;j<=g;j++){
						if(can[j]!=null){
							System.out.println(can[j]);
						}
					}
//��ѯ���
					System.out.println("��ѯ�ɹ���");
//��ѯ����
				}else if(i==2){
					ad=false;
					System.out.println("������ѧ�����䣺");
					String [] cca=new String[100];
					b=sc.next();
					int gg=0;
					jj=0;
//��ʼ�ж�����
					for(j=0;j<=g;j++){
						if(can[j]!=null){
							String[] ca=can[j].split(",");
							if(ca[1].equals(b)){
								gg++;
								while(jj<=gg){
									if(can[j]!=null){
										cca[jj]=can[j];
										jj++;
									}
								}
							}
						}
					}
//�жϽ���
					ad=true;
					while(ad){
						System.out.println("=========================");
						System.out.println("=====1.��ʾ����==========");
						System.out.println("=====2.��ʾ����==========");
						System.out.println("=========================");
//ѡ����ʾ
						i=sc.nextInt();
						if(i==1){
//��ʾ����������ϵ���
							ad=false;
							for(j=0;j<=g;j++){
								if(cca[j]!=null){
									System.out.println(cca[j]);
								}
							}
//��ѯ���
							System.out.println("��ѯ�ɹ���");
//��ѯ�Ա�
						}else if(i==2){
							ad=false;
							System.out.println("������ѧ���Ա�");
							b=sc.next();
							int ggg=0;
							jj=0;
							for(j=0;j<=gg;j++){
								if(cca[j]!=null){
									String[] ca=cca[j].split(",");
									if(ca[2].equals(b)){
										ggg++;
										while(jj<=ggg){
//�жϲ���������Ա����
											if(can[j]!=null){
												System.out.println(cca[j]);
												jj++;
											}
										}
									}
								}
							}
							if(ggg==0){
								System.out.println("���޴���");
								continue;
							}
						}else{

						}
					}
					if(gg==0){
						System.out.println("���޴���");
						continue;
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