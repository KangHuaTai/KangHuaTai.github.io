import java.awt.event.*;
import javax.swing.*;
public class C_C extends JFrame{
	/*public C_C(){
		this.setLayout(null);//设置布局管理器
		JLabel jl = new JLabel();//定义一个标签
		jl.setText("第一个Swing程序");//设置显示的文字
		jl.setBounds(50,50,400,50);//设置标签的大小和位置
		this.add(jl);//将标签放到窗口中
		this.setBounds(300,300,500,200);//设置窗口的大小和位置
		this.setVisible(true);//设置窗口是可见的
	
	}
	public static void main(String ager[]){
		new C_C();
	}*/
	public C_C(){
		this.setLayout(null);
		Icon icon = new ImageIcon("ao.jpg");
		JLabel jLabel = new JLabel();
		jLabel.setText("宋军");
		jLabel.setBounds(30,30,300,300);
		jLabel.setIcon(icon);
		JButton jButton = new JButton();
		jButton.setText("按钮");
		jButton.setBounds(50,50,50,50);
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("着火了");
				jLabel.setText("着火了");
			}
		});
		this.add(jButton);
		this.add(jLabel);
		this.setBounds(200,200,500,500);
		this.setVisible(true);
	}
	public static void main(String[] ages){
		new C_C();
	}
}