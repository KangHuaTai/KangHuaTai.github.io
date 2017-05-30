import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Wu extends JFrame{
	public Wu(){
		this.setLayout(null);
		TestPaint testPaint = new TestPaint();
		testPaint.setBounds(0,0,1500,2000);
		JLabel jLabel = new JLabel();
		jLabel.setBounds(0,0,1500,2000);
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.orange);
		jLabel.add(testPaint);
		this.add(jLabel);
		this.setBounds(100,100,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] ages){
		new Wu();
	}
}
class TestPaint extends JComponent implements MouseListener{
	public void paint(Graphics g){
		for(int i=20;i<=2000;i=i+20){
			g.drawLine(0,i,1500,i);
			g.drawLine(i,0,i,1500);
			
		}
		g.drawOval(110,110,20,20);
		g.drawOval(110,90,20,20);
			
	}
}