import java.net.*;
import java.io.*;
public class A{
	public static void main(String[] ages){
		try{
			//��������� ����ͨע��˿�
			ServerSocket serverSocket = new ServerSocket(1122);
			while(true){
				System.out.println("�������˴����ɹ�");
				//������Ӧ�˿�
				Socket sockect = serverSocket.accept();
				System.out.println("���ڼ����˿�");
				String address = sockect.getLocalAddress().getHostAddress();
				//getHostName()
				System.out.println("���������ʵ�ַ�ǣ�"+address);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}