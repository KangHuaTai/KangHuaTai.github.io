import java.awt.event.*;
import javax.swing.*;
public class B extends JFrame{
	boolean add = true;
	public B(){
		this.setLayout(null);
		JTextField jTextField = new JTextField();
		jTextField.setBounds(200,50,60,30);
		JLabel j = new JLabel();
		j.setText("输入0~5中任意一个数");
		j.setBounds(100,20,200,30);
		this.add(j);
		JLabel jLabel = new JLabel();
		jLabel.setText("点击开始");
		jLabel.setBounds(100,50,60,30);
		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(130,150,150,30);
		JButton jButton = new JButton();
		jButton.setText("开始");
		jButton.setBounds(100,100,60,40);
		JButton jButton1 = new JButton();
		jButton1.setText("结束");
		jButton1.setBounds(200,100,60,40);
		jButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				add = false;
				synchronized(jLabel1){
					if(jLabel.getText().equals(jTextField.getText())){
						jLabel1.setText("恭喜你！你赢了！");
					}else{
						jLabel1.setText("很遗憾！你输了！");
					}
				}
			}
		});
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Thread(new Runnable(){
					public void run(){
						jLabel1.setText(" ");
						int i = 0;
						add = true;
						while(add){
							synchronized(jLabel1){
								try{
									Thread.sleep(10);
								}catch(Exception g){}
								jLabel.setText(i+"");
								i++;
								if(i==5){
									i=0;
								}
							}
						}
					}
				}).start();
			}
		});
		
		this.add(jTextField);
		this.add(jButton);
		this.add(jButton1);
		this.add(jLabel);
		this.add(jLabel1);
		this.setBounds(100,100,500,500);
		this.setVisible(true);
	}
	public static void main(String[] ages){
		new B();
	}

		
}

