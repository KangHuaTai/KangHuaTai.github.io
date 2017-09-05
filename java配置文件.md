# Java配置文件
### Java Properties类：(Java.util.Properties)
主要用于读取Java的配置文件，其配置文件为".properties"文件，Properties类继承自Hashtable类，所以说Properti也是以键值对的形式存储数据的，也就是说.properties文件的内容的格式为"Key（键）=Value（值）"格式。文本注释信息可以用"#"来注释。

Propertis类的几个主要方法：

    1.  getProperty ( String key)：用指定的键在此属性列表中搜索属性。也就是通过参数 key ，得到 key 所对应的 value。
    2． load ( InputStream inStream)：从输入流中读取属性列表（键和元素对）。通过对指定的文件（比如说上面的 test.properties 文件）进行装载来获取该文件中的所有键 - 值对。以供 getProperty ( String key) 来搜索。
    3． setProperty ( String key, String value) ：调用 Hashtable 的方法 put 。他通过调用基类的put方法来设置 键 - 值对。
    4． store ( OutputStream out, String comments)：以适合使用 load 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。与 load 方法相反，该方法将键 - 值对写入到指定的文件中去。
    5． clear ()：清除所有装载的 键 - 值 对。该方法在基类中提供。

#### 读取配置文件：
使用Java.util.Properties类的load()方法
##### 示例： 
    import java.io.File;
    import java.io.FileInputStream;
    import java.util.Iterator;
    import java.util.Properties;

    public class Properties01 {

    	public static void main(String[] args) {
    		try {
    			//创建Properties对象
    			Properties prop = new Properties();
    			//创建一个输入流
    			FileInputStream fis = new FileInputStream(new File("a.properties"));
    			//load()方法可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象
    			prop.load(fis);
    			//关闭流
    			fis.close();
    			//创建一个迭代器，迭代输出配置文件内容
    			Iterator<String> it=prop.stringPropertyNames().iterator();
    			while(it.hasNext()){
    				String key = it.next();
    				String value = prop.getProperty(key);
    				System.out.println(key+"="+value);
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    
Java虚拟机（JVM）有自己的系统配置文件（system.properties），我们可以通过下面的方式来获取：


    import java.util.Properties;
    
    public class ReadJVM {
        public static void main(String[] args) {
            Properties pps = System.getProperties();
            pps.list(System.out);
        }
    }

**下面是利用配置文件做的一个登陆注册小程序：**

    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.RandomAccessFile;
    import java.util.Iterator;
    import java.util.Properties;
    import java.util.Scanner;
    
    public class Main2 {
    	public static Scanner sc = new Scanner(System.in);
    	public static void main(String[] args){
    		//获取文件
    		File f = new File("a.properties");
    		//如果不存在就创建
    		try {
    			f.createNewFile();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		//菜单
    		menu(f);
    	}
    	//菜单
    	public static void menu(File f){
    		System.out.println("-------请选择-------");
    		System.out.println("   1.登录");
    		System.out.println("   2.注册");
    		int num = sc.nextInt();
    		if(num==1){//登录
    			System.out.println("-------登录-------");
    			enter(f);
    		}else if(num==2){//注册
    			System.out.println("-------注册-------");
    			login(f);
    		}
    	}
    	//登录
    	public static void enter(File f){
    		//
    		Properties prop = new Properties();
    		try {
    			FileInputStream fis = new FileInputStream(f);
    			prop.load(fis);//这个方法可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象
    			fis.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		//输入用户名&密码
    		System.out.print("用户名：");
    		String username = sc.next();
    		System.out.print("密　码：");
    		String password = sc.next();
    		//创建一个迭代器，迭代判断用户名(也就是prop的key)是否存在
    		Iterator<String> it=prop.stringPropertyNames().iterator();
    		//boolean b 如果存在b=true，如果不存在b=false
    		boolean b = false;
    		while(it.hasNext()){
    			if(it.next().equals(username)){
    				b = true;
    				break;
    			}
    		}
    		if(b){//如果存在该用户，那么判断该用户的密码是否输入争取
    			if(prop.getProperty(username).equals(password)){
    				System.out.println("登录成功！");
    				menu(f);
    			}else{
    				System.out.println("密码错误！");
    				menu(f);
    			}
    		}else if(!b){//如果不存在该用户，提示没有此用户
    			System.out.println("没有此用户！");
    			menu(f);
    		}
    	}
    	//注册
    	public static void login(File f){
    		RandomAccessFile raf = null;
    		try {
    			raf = new RandomAccessFile(f,"rw");
    			String username = null;
    			String password = null;
    			System.out.print("username=");//用户名
    			username = sc.next();
    			System.out.print("password=");//密码
    			password = sc.next();
    			raf.seek(raf.length());
    			raf.write((username+"="+password+"\r").getBytes());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}finally{
    			try {
    				raf.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    			System.out.println("注册成功！");
    			menu(f);
    		}
    	}
    }
