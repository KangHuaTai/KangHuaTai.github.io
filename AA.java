import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

public class AA extends JFrame{
	public AA(){

		JMenuItem jMenuItem1 = new JMenuItem();
		jMenuItem1.setText("新建");
		JMenuItem jMenuItem2 = new JMenuItem();
		jMenuItem2.setText("打开");
		JMenuItem jMenuItem3 = new JMenuItem();
		jMenuItem3.setText("关闭");
		JMenu jMenu1 = new JMenu();
		jMenu1.setText("文件");
		jMenu1.add(jMenuItem1);
		jMenu1.add(jMenuItem2);
		jMenu1.add(jMenuItem3);

		JMenuItem jMenuItem_1 = new JMenuItem();
		jMenuItem_1.setText("撤销");
		JMenuItem jMenuItem_2 = new JMenuItem();
		jMenuItem_2.setText("重做");
		JMenu jMenu2 = new JMenu();
		jMenu2.setText("编辑");
		jMenu2.add(jMenuItem_1);
		jMenu2.add(jMenuItem_2);

		JMenuBar jMenuBar1 = new JMenuBar();
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenu2);
		JMenuBar jMenuBar2 = new JMenuBar();
		//jMenuBar2.add(jMenu2);
		//setJMenuBar(jMenuBar1);
		setJMenuBar(jMenuBar1);
		
		JTextArea jtextArea = new JTextArea();
		jtextArea.setBounds(0,0,100,100);
		jtextArea.setFont(new Font("宋体",Font.PLAIN,20));
		this.add(jtextArea);
		this.setBounds(100,100,240,180);
		this.setVisible(true);
	}
	public static void main(String[] ages){
		new AA();
	}
	
}