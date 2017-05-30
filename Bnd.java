import java.io.*;
import java.net.*;
public class Bnd{
	public static void main(String[] args) {
		try {
			System.out.println("服务器创建成功");
			ServerSocket ss = new ServerSocket(1018);//建立服务端的Socket服务
			while(true){
				File f = new File("wenjian.txt");
				if(!f.exists()){
					f.createNewFile();
				}
				System.out.println("正在监听端口");
				Socket s = ss.accept();//获取客户端对象
				long startTime=System.currentTimeMillis();   //获取开始时间
				InputStream inputStream = s.getInputStream();
				OutputStream os = new FileOutputStream(f);
				byte[] bytes = new byte[1024];
				int len = 0;
				while((len = inputStream.read(bytes))!=-1){
					os.write(bytes);
				}
				inputStream.close();
				long endTime=System.currentTimeMillis(); //获取结束时间
				System.out.println("文件下载时间： "+(endTime-startTime)+"ms");
				String ip = s.getInetAddress().getHostAddress();
				System.out.println("有人来访问地址是"+ip);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
