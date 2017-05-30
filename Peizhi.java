import java.util.*;
import java.io.*;
public class Peizhi{
	public static void main(String[] agre){
		Scanner scanner = new Scanner(System.in);
		File file = new File("Peizhi.txt");
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		String userInput="";
		System.out.println("请输入文件内容");
		userInput=scanner.nextLine();
		RandomAccessFile randomAccessFile = null;
		try{
			randomAccessFile = new RandomAccessFile(file,"rw");
			randomAccessFile.seek(file.length());
			randomAccessFile.write(userInput.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (randomAccessFile!=null){
				try{
					randomAccessFile.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}

		/*FileWriter fileWriter = null;

		try{
			fileWriter=new FileWriter(file);
			fileWriter.write(userInput);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fileWriter!=null){
			}
		}*/
	}
}