import java.io.*;
import java.util.*;
public class DengLu{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		File f = new File("denglu.properties");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		menu(f);
	}

	public static void menu(File f){
		System.out.println("======��ѡ��======");
		System.out.println("======1.��¼======");
		System.out.println("======2.ע��======");
		System.out.println("======3.�˳�======");
		int in = sc.nextInt();
		boolean ad=true;
		while(ad){
			switch(in){
				case 1:ad=false;dengLu(f);break;
				case 2:ad=false;zhuCe(f);break;
				case 3:ad=false;System.out.println("�˳��ɹ����ټ���");break;
				default :System.out.println("������������������");
			}
		}
	}

	public static void dengLu(File f){
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("�û�����");
		String username = sc.next();
		System.out.print("�ܡ��룺");
		String password = sc.next();
		Iterator<String> it=prop.stringPropertyNames().iterator();
		boolean ab = false;
		while(it.hasNext()){
			if(it.next().equals(username)){
				ab = true;
				break;
			}
		}
		if(ab){
			if(prop.getProperty(username).equals(password)){
				System.out.println("��¼�ɹ���");
				menu(f);
			}else{
				System.out.println("�������");
				menu(f);
			}
		}else if(!ab){
			System.out.println("û�д��û���");
			menu(f);
		}
	}

	public static void zhuCe(File f){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(f,"rw");
			String username = null;
			String password = null;
			System.out.print("���û�����");
			username = sc.next();
			System.out.print("���룺");
			password = sc.next();
			raf.seek(raf.length());
			raf.write((username+"="+password+"\r").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("ע��ɹ���");
			menu(f);
		}
	}
}
