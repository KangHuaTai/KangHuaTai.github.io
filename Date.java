import java.text.*;
import java.util.*;
public class Date{
	public static void main(String[] args) {
		String format = "yyyy-MM-dd HH:mm:ss";
		String ret = date2String(new Date(), format);
		System.out.println(ret);
		//Date date = string2Date(null, format);
		//System.out.println(date);
	}
	public static String date2String(Date date, String format) {
		if (date != null) {
			if (format == null) {
				format = "yyyy-MM-dd";
			}
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern(format);
			return sdf.format(date);
		}
		return null;
	}
	/*public static String date2String(Date date) {
		return date2String(date, null);
	}*/
	/*public static Date string2Date(String date, String format) {
		if (hasLength(date)) {
			if(format == null) {
				format = "yyyy-MM-ss";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try {
				System.out.println("-->" + date);
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}*/
	/*public static Date string2Date(String date) {
		return string2Date(date,null);
	}*/
	/*public static boolean hasLength(String s) {
		return s != null;
	}*/
}
