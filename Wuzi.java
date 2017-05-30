import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Wuzi extends JFrame{
	public Wuzi(){
		this.setLayout(null);
		TestPaint testPaint = new TestPaint();
		testPaint.setBounds(0,0,560,560);
		this.setTitle("������");
		this.add(testPaint);
		this.setBounds(100,100,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] a){
		new Wuzi();
	}
}
class TestPaint extends JComponent implements MouseListener{
	java.util.List<Point> pointList = new ArrayList<Point>();
	private boolean isHei = true;
	private int currentX = 0;//��ǰ����Xλ��
	private int currentY = 0;//��ǰ����Yλ��
	int hei_h=0,bai_h=0;
	int a,b;
	public TestPaint(){
		this.addMouseListener(this);
	}
	public void paint(Graphics g){
		for(int i=0;i<=600;i=i+20){
			//����
			if(i==0){
				i+=30;
				g.drawLine(30,i,550,i);
				g.drawLine(i,30,i,550);
			}else{
				g.drawLine(30,i,550,i);
				g.drawLine(i,30,i,550);
			}
		}
		//����
		for(Point p:pointList){
			if(p.getX()>=30&&p.getY()>=30){
				a=p.getX();
				b=p.getY();
				g.setColor(p.getColor());
				g.fillOval(a-10,b-10,20,20);
				//Point.POINT_SIZE,Point.POINT_SIZE
			}
		}
		isWin();

		//����
		/*bai_h=0;
		hei_h=0;
		for(Point p:pointList){	
		for(int i=30;i<=550;i+=20){
				if(a==p.getX()&&p.getY()==i){
					if(p.getColor()==Color.black){
						hei_h++;
						bai_h=0;
					}else if(p.getColor()==Color.white){
						hei_h=0;
						bai_h++;
					}
				}
			}
		}
		System.out.println(hei_h+"  "+bai_h);
		if(hei_h==5){
			System.out.println("����Ӯ");
		}
		if(bai_h==5){
			System.out.println("����Ӯ");
		}*/
	}
			//�ж���Ӯ�Ĺ���
		public void isWin(){
		int dongxi = 0;
		//��
		for(int nowX =currentX,i = 0;i<5&&nowX<=550;nowX+=20,i++){
			Point point = findPoint(nowX,currentY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongxi++;
					}else{
						break;
					}
				}
				//��ǰ�����ǰ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongxi++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//��
		for(int nowX=currentX-20,i = 0;i<5&&nowX>=0;nowX-=20,i++){
			Point point = findPoint(nowX,currentY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongxi++;
					}else{
						break;
					}
				}
				//��ǰ�����Ǻ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongxi++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(dongxi>=5){
			if(isHei!=true){
				System.out.println("����Ӯ��");
			}else{
				System.out.println("����Ӯ��");
			}
		}
		int nanbei = 0;
		//��
		for(int nowY =currentY,i = 0;i<5&&nowY<=550;nowY+=20,i++){
			Point point = findPoint(currentX,nowY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						nanbei++;
					}else{
						break;
					}
				}
				//��ǰ�����ǰ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						nanbei++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		
		//��
		for(int nowY=currentY-20,i = 0;i<5&&nowY>=0;nowY-=20,i++){
			Point point = findPoint(currentX,nowY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						nanbei++;
					}else{
						break;
					}
				}
				//��ǰ�����Ǻ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						nanbei++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(nanbei>=5){
			if(isHei!=true){
				System.out.println("����Ӯ��");
			}else{
				System.out.println("����Ӯ��");
			}
		}

		//����
		
		int dongbeixinan = 0;
		for(int nowX = currentX,nowY = currentY,i=0;nowY>=0&&nowX<=520&&i<5;nowY-=20,nowX+=20,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongbeixinan++;
					}else{
						break;
					}
				}
				//��ǰ�����ǰ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongbeixinan++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//����
		for(int nowX = currentX-20,nowY = currentY+20,i=0;nowY<=520&&nowX>=0&&i<5;nowY+=20,nowX-=20,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongbeixinan++;
					}else{
						break;
					}
				}
				//��ǰ�����ǰ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongbeixinan++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(dongbeixinan>=5){
			if(isHei!=true){
				System.out.println("����Ӯ��");
			}else{
				System.out.println("����Ӯ��");
			}
		}
		//����
		int xibeidongnan = 0;
		for(int nowX = currentX,nowY = currentY,i=0;nowY>=0&&nowX<=520&&i<5;nowY+=20,nowX+=20,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						xibeidongnan++;
					}else{
						break;
					}
				}
				//��ǰ�����ǰ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						xibeidongnan++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//����
		for(int nowX = currentX-20,nowY = currentY-20,i=0;nowY<=520&&nowX>=0&&i<5;nowY-=20,nowX-=20,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						xibeidongnan++;
					}else{
						break;
					}
				}
				//��ǰ�����ǰ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						xibeidongnan++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(xibeidongnan>=5){
			if(isHei!=true){
				System.out.println("����Ӯ��");
			}else{
				System.out.println("����Ӯ��");
			}
		}

		}

	//�ҵ�
	public Point findPoint(int x,int y ){
		for(Point p:pointList){
			if(p.getX() == x&&p.getY() == y){
				//�ж������Ƿ�����ͬ�ġ�
				return p;
			}
		}
		return null;
	}
	public void mouseClicked(MouseEvent e){
		int x = (int)(Math.round((e.getX()-30)/20.0)*20+30);
		int y = (int)(Math.round((e.getY()-30)/20.0)*20+30);
		//��¼��ǰ����λ��
		currentX = x;
		currentY = y;
		int an=0;
		Point point = new Point(x,y);
		for(Point p:pointList){
			if(p.getX()==x&&p.getY()==y){
				an++;
			}
		}
		if(an==0){
			if(isHei == true){//����
				point.setColor(Color.black);
				isHei = false;
			}else{//����
				point.setColor(Color.white);
				isHei = true;
			}
			pointList.add(point);
			this.repaint();
		}else{
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
}
