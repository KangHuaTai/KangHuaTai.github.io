public class DieThreadDemo {
	public static void main(String[]args) {
		DeadThread dt = new DeadThread();
		for (int i =0;i<100;i++){
			Thread mainThread =Thread.currentThread();//获得当前线程（Main线程）
			System.out.println(mainThread.getName()+ "--" + i);
			System.out.println("------>"+mainThread.isAlive());
			if(i==10){
				dt.start();
			}
		}
		if(!dt.isAlive()){
				dt.start();
		}
	}
}
class DeadThread extends Thread {
	public void run(){
		for (int i = 0; i < 50; i++){
			System.out.println(getName() +"--" + i);
		}
	}
}