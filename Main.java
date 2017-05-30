import java.io.*;
public class Main{
	public static void main(String[] ages){
		File file = new File("test.txt");
		if(file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		String s = "songjun";
		FileOutputStream outputStream = null;
		try{
			outputStream = new FileOutputStream(file);
			outputStream.write(s.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}
//		FileInputStream fileInputStream = null
//		try{
//			fileInputStream = new FileInputStream(file);
//			fileInputStream.
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
}