public class RandomAccessFileDemo{
	public static void main(String[] agre) throws Exception{
		write();
		read();
	}
	public static void write() throws Exception{
		Person p1=new Person("zhangsan",15);
		Person p2=new Person("lisi",16);
		Person p3=new Person("wangwu",17);

		RandomAccessFile raf=new RandomAccessFile("person.txt","rw");
		raf.write(p1.getName().getBytes());
		raf.writelnt(p1.getAge());

		raf.write(p2.getName().getBytes());
		raf.writelnt(p2.getAge());
		
		raf.write(p3.getName().getBytes());
		raf.writelnt(p3.getAge());

		if(raf!=null){
			raf.close();
		}
		System.out.println("=================");
	}
	public static void read() throws Exception{
		RandomAccessFile raf=new RandomAccessFile("person.txt","rw");

		System.out.println("第二人");
		//跳过第一人
		raf.skipBytes(12);

		String name="";
		for(int i=0;i<4;i++){
			name=name+(char)raf.readByte();
		}
		System.out.println("name="+name);
		System.out.println("age="+raf.readInt());

		System.out.println("第一人");
		raf.seek(0);
		name="";

		for(int i=0;i<8;i++){
			name=name+(char)raf.readByte();
		}
		System.out.println("name="+name);
		System.out.println("age="+raf.readInt());


		System.out.println("第三人");
		raf.skipBytes(8);
		name="";
		for(int i=0;i<6;i++){
			name=name+(char)raf.readByte();
		}
		System.out.println("name="+name);
		System.out.println("age="+raf.readInt());
	}
}
class Person{
	private String name;
	private int age;

	public Person(String name,int age){
		if(name.length()>8){
			name=name.subString(0,8);
		}else{
			wihle(name.length()<8){
				name=name+"\u0000";
			}
		}
		this.name=name;
		this.age=age;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
}