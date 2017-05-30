import java.io.*;
import java.util.*;
public class Ab{
	//public static Scanner sc=new Scanner(System.in);
	public static void main(String[] age) throws Exception{
	File f2 = new File("K.txt");
	File f = new File("KA.txt");
	if(!f.exists())
	try{
		f.createNewFile();
	}catch(Exception e){
		e.printStackTrace();
	}
	FileInputStream fis = new FileInputStream(f);
//	StringBuffer s = new StringBuffer();
	FileOutputStream fos = new FileOutputStream(f2);
	byte[] bytes = new byte[(int)f.length()];
	int a = 0;   
	while((a=fis.read(bytes))!=-1){
		//s.append( new String(bytes,0,a));
		fos.write(bytes);
	}
	System.out.println(s.toString());
	}
}