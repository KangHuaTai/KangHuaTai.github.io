import java.io.*;
import java.net.*;
public class Bnd{
	public static void main(String[] args) {
		try {
			System.out.println("�����������ɹ�");
			ServerSocket ss = new ServerSocket(1018);//��������˵�Socket����
			while(true){
				File f = new File("wenjian.txt");
				if(!f.exists()){
					f.createNewFile();
				}
				System.out.println("���ڼ����˿�");
				Socket s = ss.accept();//��ȡ�ͻ��˶���
				long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
				InputStream inputStream = s.getInputStream();
				OutputStream os = new FileOutputStream(f);
				byte[] bytes = new byte[1024];
				int len = 0;
				while((len = inputStream.read(bytes))!=-1){
					os.write(bytes);
				}
				inputStream.close();
				long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
				System.out.println("�ļ�����ʱ�䣺 "+(endTime-startTime)+"ms");
				String ip = s.getInetAddress().getHostAddress();
				System.out.println("���������ʵ�ַ��"+ip);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}