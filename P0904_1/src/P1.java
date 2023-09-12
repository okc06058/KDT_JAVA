public class P1 {

   public static void main(String[] args) {
      
      TestClass test1 = new TestClass(10, "xyz");
      TestClass test2 = new TestClass(20, "xyz");
      
      // 여기서 값을 넘기고 싶으면 매개변수로 넘겨주면 되는데 
      // 단, 아래 메소드 선언에서 매개변수에 선언이 되어있어야 함.
      int a = 10;
      test1.doProcess(a);
      test2.doProcess(a);
   
   }

}

class TestClass{
   
   // 속성
   // 이 클래스 내에 선언되어있는 변수들은 이 클래스 내에서는 자유롭게 사용 가능.
   private int v1;
   private String v2;
   
   // 생성자
   // 보통 생성자는 모든 필드를 받는 형태로 하나, 아무것도 안받는 형태로 하나 만들어줌
   public TestClass() {}
   
   public TestClass(int v1, String v2) {
      this.v1 = v1;
      this.v2 = v2;
   }
   
   public int doProcess(int x) {
      System.out.println("안녕: " + v1); // ( -> this.v1)
      return x + 1;
   }
   
   
}