//import java.awt.*;
import javax.swing.*;
class QQ extends JFrame{

	public QQ(){

		this.setLayout(null);

		JLabel jLabel1 = new JLabel();
		jLabel1.setText("用户名：");
		jLabel1.setBounds(30,30,300,20);
		this.add(jLabel1);

		JLabel jLabel2 = new JLabel();
		jLabel2.setText("密码：");
		jLabel2.setBounds(30,50,300,20);
		this.add(jLabel2);

		JTextField jTextField1 = new JTextField();
		jTextField1.setBounds(80,30,100,20);
		this.add(jTextField1);

		JTextField jTextField2 = new JTextField();
		jTextField2.setBounds(80,50,100,20);
		this.add(jTextField2);


		JButton jButton = new JButton();//定义控件
		jButton.setText("登陆");//设置实现
		jButton.setBounds(80,80,70,30);//设置位置
		//jButton.setBackground(Color.BLUE);
		this.add(jButton);//添加到窗口
		this.setBounds(100,100,240,180);
		this.setVisible(true);
	}
	public static void main(String[] ages){
		new QQ();
	}
}