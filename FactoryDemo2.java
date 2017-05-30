
public class FactoryDemo2 {
	public static void main(String[] args) {
		//ICellPhone p = new HTC();
		ICellPhone htcp = Factory.getInstance("htc");
		System.out.print(htcp.a);
	}
}

/* 返字垢皆 */
class Factory {
	public static ICellPhone getInstance(String type){
		ICellPhone phone = null;
		if("htc".equals(type)){
			phone = new HTC();
		}else if("iphone".equals(type)){
			phone = new IPhone();
		}
		return phone;
	}
}

//返字炎彈
interface ICellPhone {
	void sendMsg();
}

/* HTC返字 */
class HTC implements ICellPhone {
	public void sendMsg() {
		System.out.println("htc返字");
	}
	static int a=1;
}

/* IPhone返字 */
class IPhone implements ICellPhone {
	public void sendMsg() {
		System.out.println("iphone返字");
	}
	static int a=3;
}





