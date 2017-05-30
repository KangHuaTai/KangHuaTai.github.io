
public class FactoryDemo2 {
	public static void main(String[] args) {
		//ICellPhone p = new HTC();
		ICellPhone htcp = Factory.getInstance("htc");
		System.out.print(htcp.a);
	}
}

/* �ֻ����� */
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

//�ֻ���׼
interface ICellPhone {
	void sendMsg();
}

/* HTC�ֻ� */
class HTC implements ICellPhone {
	public void sendMsg() {
		System.out.println("htc�ֻ�");
	}
	static int a=1;
}

/* IPhone�ֻ� */
class IPhone implements ICellPhone {
	public void sendMsg() {
		System.out.println("iphone�ֻ�");
	}
	static int a=3;
}





