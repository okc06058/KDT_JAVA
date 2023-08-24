
public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a1=10;
		double a3 = 1.1;
		int a2=a1; //타입 캐스팅 - 묵시적
		int a4=a2; 
		
		byte a5=(byte)a4; //타입 캐스팅 - 명시적
		//사실상 명시적 타입 캐스팅을 해야 하는 경우 값의 증발이 정상적이라고 판단하는 경우
		
		double b1=a4; //타입 캐스팅 - 묵시적
		double b2=(double)a4; //위에 코드하고 동일 - 명시적 타입 캐스팅
		
		double c1=10.1;
		int c2=(int)c1; //뒤에 소수점 자름
		

		char d1='A'; 
		System.out.println(d1);
		System.out.println((int)d1);


		char d2=100; 
		System.out.println(d2);
		System.out.println((char)d2);
	}

}
