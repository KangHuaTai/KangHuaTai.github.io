import java.net.*;
import java.io.*;
public class A{
	public static void main(String[] ages){
		try{
			//创建服务端 并开通注册端口
			ServerSocket serverSocket = new ServerSocket(1122);
			while(true){
				System.out.println("服务器端创建成功");
				//监听对应端口
				Socket sockect = serverSocket.accept();
				System.out.println("正在监听端口");
				String address = sockect.getLocalAddress().getHostAddress();
				//getHostName()
				System.out.println("有人来访问地址是："+address);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}