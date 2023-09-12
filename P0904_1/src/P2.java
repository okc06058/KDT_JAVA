
public class P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st1 = new Student();
	
		new School(st1).takeExam(null);
	}

}


class School{

	private Student s1;
	//private Student s1 = new Student();
	
	public School(Student s1) {
		this.s1 = s1;
	}
	
	public void takeExam(Student s1) {
		System.out.println("학교가 시험을 치룹니다.");
		//private s1 = new Student;
		
	}
	
}

class Student{
	private String name;
	private int age;
	private int score;
	
	public void study() {
		
	}
}