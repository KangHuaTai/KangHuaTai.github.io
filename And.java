import java.io.*;
import java.net.*;
public class And{
	public static void main(String[] args) {
		File f = new File("A.txt");
		try {
			Socket s = new Socket("192.168.199.165",1018);
			InputStream is = new FileInputStream(f);
			byte[] bytes = new byte[(int) f.length()];
			is.read(bytes);
			OutputStream a = s.getOutputStream();
			a.write(bytes);
			a.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
