import java.text.*;
import java.util.*;
public class Shijian{
	public static void main(String[] ages){
	//得到long类型当前时间
	//long l = System.currentTimeMillis();
	//new日期对象
	Date date = new Date();
	//转换提日期输出格式
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(dateFormat.format(date));
	}
}
