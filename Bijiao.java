import java.util.*;
public class Bijiao{
	public static void main(String[] ages){
		A a = new A();
		Set s = new TreeSet(a);
		s.add(new Student(100,5));
		s.add(new Student(80,7));
		s.add(new Student(80,9));
		s.add(new Student(90,6));
		Iterator iter = s.iterator();
		while(iter.hasNext()){
			Student stu = (Student)iter.next();
			System.out.println(stu.getCj()+"\t"+stu.getAge());
		}
	}
}
class Student{
	int cj,age;
	public Student(int cj,int age){
		this.cj=cj;
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public int getCj(){
		return cj;
	}
}
class A implements Comparator{
	public int compare(Object o1,Object o2){
		Student s1=(Student)o1;
		Student s2=(Student)o2;
		if(s1.getCj()>s2.getCj()){
			return -1;
		}
		if(s1.getCj()==s2.getCj()){
			if(s1.getAge()>s2.getAge()){
				return -1;
			}
			if(s1.getAge()==s2.getAge()){
				return 0;
			}
			return 1;
		}
		return 1;
	}
}
