import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class C extends JFrame{
	Map<String,String> map = new HashMap();
	int i=0,j=0;
	public C(){
		this.setLayout(null);
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("用户名");
		jLabel1.setBounds(50,40,80,30);
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("密码");
		jLabel2.setBounds(50,80,80,30);
		JTextField jTextField1 = new JTextField();
		jTextField1.setText("");
		jTextField1.setBounds(100,40,150,30);
		JTextField jTextField2 = new JTextField();
		jTextField2.setText("");
		jTextField2.setBounds(100,80,150,30);
		JButton jButton1 = new JButton();
		jButton1.setText("登陆");
		jButton1.setBounds(50,120,90,40);
		jButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int k=0;
				j=0;
				jLabel1.setText("用户名");
				jLabel2.setText("密码");
				jLabel1.setBounds(50,40,80,30);
				jLabel2.setBounds(50,80,80,30);
				jTextField1.setBounds(100,40,150,30);
				jTextField2.setBounds(100,80,150,30);
				if(i!=0){
					Iterator iter = map.keySet().iterator();
					while(iter.hasNext()){
						Object key = iter.next();
						Object val = map.get(key);
						if(jTextField1.getText().equals(key)){
							k++;
							if(jTextField2.getText().equals(val)){
								System.out.println("登陆成功");
							}else{
								System.out.println("密码错误");
							}
						}
					}
					if(k==0){
						System.out.println("对不起，没有这个用户");
					}
				}
				i++;
			}
		});
		JButton jButton2 = new JButton();
		JButton jButton3 = new JButton();
		jButton2.setText("注册用户");
		jButton2.setBounds(150,120,90,40);
		jButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				i=0;
				jLabel1.setText("用户名(注册)");
				jLabel2.setText("密码(注册)");
				jLabel1.setBounds(40,40,80,30);
				jLabel2.setBounds(40,80,80,30);
				jTextField1.setBounds(120,40,150,30);
				jTextField2.setBounds(120,80,150,30);
				if(j!=0){
					map.put(jTextField1.getText(),jTextField2.getText());
				}
				j++;
				
			}
		});
		
		this.add(jLabel1);
		this.add(jLabel2);
		this.add(jTextField1);
		this.add(jTextField2);
		this.add(jButton1);
		this.add(jButton2);
		this.setVisible(true);
		this.setBounds(100,100,300,300);
	}
	public static void main(String[] ages){
		new C();
	}

}