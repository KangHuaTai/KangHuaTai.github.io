import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
public class Qun extends JFrame{
	public Qun(Socket socket){
		this.setLayout(null);
		JLabel jLabel = new JLabel();
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.white);
		jLabel.setBounds(20,20,280,300);
		this.add(jLabel);
		JTextField field = new JTextField();
		field.setBounds(20,320,200,30);
		this.add(field);
		JButton jButton = new JButton("·¢ËÍ");
		jButton.setBounds(220,320,80,30);
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String aa = field.getText();
				if(!"".equals(aa)){
					try{
						PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
						printWriter.write(aa+"\n");
						printWriter.flush();
					}catch(Exception e1){}
				}
				field.setText("");


			}
		});
		this.add(jButton);
		this.setBounds(200,200,350,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] ages){
		Socket socket = null;
		try{
			socket = new Socket("192.168.199.166",9900);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("¸ßöÎ\n");
			printWriter.flush();
			new Qun(socket);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}
}