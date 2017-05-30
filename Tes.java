import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tes extends JFrame{
	public Tes(){
		this.setLayout(null);
		TestPaint testPaint = new TestPaint();
		testPaint.setBounds(0,0,551,551);
		this.setTitle("五子棋");
		this.add(testPaint);
		this.setBounds(100,100,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] a){
		new Tes();
	}
}
class TestPaint extends JComponent implements MouseListener{
	private String s;
	Graphics gg;
	int i=0;
	int[] x = new int[1000];
	int[] y = new int[1000];
	public TestPaint(){
		this.addMouseListener(this);
	}
	public void paint(Graphics g){
		boolean ad=true;
		gg=g;
		for(int i=0;i<=600;i=i+20){
			if(i==0){
				i+=30;
				g.drawLine(30,i,550,i);
				g.drawLine(i,30,i,550);
			}else{
				g.drawLine(30,i,550,i);
				g.drawLine(i,30,i,550);
			}
		}
		for(int i=0;i<1000;i++){
			if(x[i]>0){
				if(ad){
					int a=(int)(Math.round(x[i]/20.0)*20+30);
					int b=(int)(Math.round(y[i]/20.0)*20+30);
					gg.setColor(Color.black);
					gg.fillOval(a-10,b-10,20,20);
					ad=false;
				}else{
					int a=(int)(Math.round(x[i]/20.0)*20+30);
					int b=(int)(Math.round(y[i]/20.0)*20+30);
					gg.setColor(Color.white);
					gg.fillOval(a-10,b-10,20,20);
					ad=true;
				}
			}
		}
		//g.drawString(s,100,100);
		//g.drawRect(100,100,100,100);
		//g.drawOval(110,110,20,20);
		//g.drawOval(110,90,20,20);
		//g.setColor(Color.red);
		//g.fillOval(100,100,100,100);
		
	}	
	public void mouseClicked(MouseEvent e){
		x[i] = e.getX()-30;
		y[i] = e.getY()-30;
		System.out.println("点了"+x[i]+"  "+y[i]);
		this.repaint();
		i++;
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
}