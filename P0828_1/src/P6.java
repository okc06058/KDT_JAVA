
public class P6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[3];
		{
			int[] arr2= new int[4];
			arr1=arr2;
			int[] arr3 = new int[5];
			arr3 = null;
		} 
		// arr2 : 메모리 값이 바뀌어 버렸기에 메모리 소멸이 된다. 
		// arr3 : 새로 메모리를 받았기에 값이 들어간다.
		// -> 연쇄적으로 소멸될 가능성을 염두해 둬야 함.
	}

}
