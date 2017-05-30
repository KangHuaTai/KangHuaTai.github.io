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
		System.out.println("======请选择======");
		System.out.println("======1.登录======");
		System.out.println("======2.注册======");
		System.out.println("======3.退出======");
		int in = sc.nextInt();
		boolean ad=true;
		while(ad){
			switch(in){
				case 1:ad=false;dengLu(f);break;
				case 2:ad=false;zhuCe(f);break;
				case 3:ad=false;System.out.println("退出成功！再见！");break;
				default :System.out.println("输入有误！请重新输入");
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
		System.out.print("用户名：");
		String username = sc.next();
		System.out.print("密　码：");
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
				System.out.println("登录成功！");
				menu(f);
			}else{
				System.out.println("密码错误！");
				menu(f);
			}
		}else if(!ab){
			System.out.println("没有此用户！");
			menu(f);
		}
	}

	public static void zhuCe(File f){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(f,"rw");
			String username = null;
			String password = null;
			System.out.print("新用户名：");
			username = sc.next();
			System.out.print("密码：");
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
			System.out.println("注册成功！");
			menu(f);
		}
	}
}
