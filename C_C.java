import java.awt.event.*;
import javax.swing.*;
public class C_C extends JFrame{
	/*public C_C(){
		this.setLayout(null);//���ò��ֹ�����
		JLabel jl = new JLabel();//����һ����ǩ
		jl.setText("��һ��Swing����");//������ʾ������
		jl.setBounds(50,50,400,50);//���ñ�ǩ�Ĵ�С��λ��
		this.add(jl);//����ǩ�ŵ�������
		this.setBounds(300,300,500,200);//���ô��ڵĴ�С��λ��
		this.setVisible(true);//���ô����ǿɼ���
	
	}
	public static void main(String ager[]){
		new C_C();
	}*/
	public C_C(){
		this.setLayout(null);
		Icon icon = new ImageIcon("ao.jpg");
		JLabel jLabel = new JLabel();
		jLabel.setText("�ξ�");
		jLabel.setBounds(30,30,300,300);
		jLabel.setIcon(icon);
		JButton jButton = new JButton();
		jButton.setText("��ť");
		jButton.setBounds(50,50,50,50);
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("�Ż���");
				jLabel.setText("�Ż���");
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