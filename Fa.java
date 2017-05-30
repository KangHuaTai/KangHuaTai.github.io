import javax.swing.*;
import java.util.*;
import java.net.*;
import java.io.*;
public class Fa implements Runnable{
	Socket socket;
	JLabel jLabel;
	public Fa(Socket socket,JLabel jLabel){
		this.socket = socket;
		this.jLabel = jLabel;

	}
	public void run(){
		while(true){
			try{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String aa = bufferedReader.readLine();
				jLabel.setText(jLabel.getText()+aa);

			}catch(Exception e){}
		}
	}
}