package p13;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] arr = new Person[10];
		arr[0] = new Student();
		
		arr[1] = new Police();
		arr[2] = new Student();
		arr[3] = new FireMan();
		
		for (Person e : arr) {
			
		}
	}

}

class Person{}

class Student extends Person{}
class Police extends Person{}
class FireMan extends Person{}