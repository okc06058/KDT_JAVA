package ploymorpism;

public class User {
		private Tv tv = (Tv) new LgTv();
		
		//생성자식 주입
		public User(Tv tv) {
			this.tv = tv;
		}
		
		public void setTv(Tv tv) {
			this.tv = tv;
		}
		
		public void watchTv() {
			System.out.println("사용자가 TV를 시청합니다.");
			
			tv.powerOn();
			tv.soundUp();
			tv.soundDown();
			tv.powerOff();
			
			System.out.println("잡니다.");
			
		}
		

}
