class MyThread implements Runnable {
	public void run(){
		for (int i=0;i<200;i++){
			System.out.println(i);
		}
	}
}
public class MyThreadDemo{
	public static void main(String[] args){
		for (int i = 0; i < 10;i++){
			if(i == 5){
				MyThread t = new MyThread();
				new Thread(t).start();
			}
			System.out.println("main" + i);
		}
	}
}