import java.io.*;
import java.net.*;
public class B{
	public static void main(String[] ages){
		try{
			//
			Socket socket = new Socket("192.168.199.165",1122);
			//socket.connect();
			System.out.println("是否连接成功"+socket.isConnected());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}