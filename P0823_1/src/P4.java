
public class P4 {
	
	int aaa=10;

	public static void main(String[] args) {
		
		
		// 모든 지역 변수는 stack에 생성된다
		
		
		int bbb = 20;
		System.out.println(bbb);
		{
			int aaa=10;
			bbb=10;
			aaa=20;
		}
		int aaa=30;
		
		
		System.out.println(bbb);
		System.out.println(aaa);
		
		

	}

}
