import java.text.*;
import java.util.*;
public class Shijian{
	public static void main(String[] ages){
	//�õ�long���͵�ǰʱ��
	//long l = System.currentTimeMillis();
	//new���ڶ���
	Date date = new Date();
	//ת�������������ʽ
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(dateFormat.format(date));
	}
}
