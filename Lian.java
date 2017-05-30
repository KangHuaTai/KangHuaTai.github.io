import java.net.*;
import java.io.*;
public class Lian{
	public static void main(String[] ages){
		try{
			Socket socket = new Socket("192.168.199.165",1125);
			OutputStream out = socket.getOutputStream();
			out.write("康华太，玩的".getBytes());
			socket.close();
		}catch(Exception e){
		
		}
		System.out.println("运行完成");
	}
}