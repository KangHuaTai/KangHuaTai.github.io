public class Maipiao{
	public static void main(String[] ager){
		Thread b1=new Mai("����1");
		Thread b2=new Mai("����2");
		Thread b3=new Mai("����3");
		b1.start();
		b2.start();
		b3.start();
	}
}
class Mai extends Thread{
	private int piao=50;
	private String name;
	public Mai(String name){
		this.name=name;
	}

	public void run(){
		 synchronized(name){
			while(piao>0){
				System.out.println(name+"�۳��˵�"+piao+"��Ʊ");
				piao--;
			}
		}
	}

}
