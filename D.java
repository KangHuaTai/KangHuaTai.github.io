import javax.swing.*;
public class D extends JFrame{
	public D(){
		JLabel jLabel = new JLabel();
		//jLabel.setBounds(100,100,100,500);
		Icon icon1 = new ImageIcon("ºìµÆ.jpg");
		Icon icon2 = new ImageIcon("»ÆµÆ.jpg");
		Icon icon3 = new ImageIcon("ÂÌµÆ.jpg");
		this.setVisible(true);
		this.setBounds(100,100,200,200);
		while(true){
			try{
				jLabel.setIcon(icon1);
				Thread.sleep(1000);
				jLabel.setIcon(icon2);
				Thread.sleep(300);
				jLabel.setIcon(icon3);
				Thread.sleep(2000);
			}catch(Exception e){}
			this.add(jLabel);
		}
		
		
	}
	public static void main(String[] ages){
		new D();
	}
}