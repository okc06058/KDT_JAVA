import java.util.*;

public class Q2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 평생 공부 해야 될 원칙: SOLID -> Design pattern
		// S -> SRP - 단일 책임 원칙
		// 권고: 하나의 메소드에는 5줄이 넘어가면 안된다
		// 연습 방법: 우선은 쭉 짠다(논리) -> 리팩토링
		
		// 타카하시? 아오키? 달리던 문제...
		new Q2Solver().solve();
	}
}

class Q2Solver{

	private Runner takahashi;
	private Runner aoki;
	private int runTime;		
	
	public void solve() {
		// A - 조깅
		// 알고리즘 문제 스타트 - 입력 받기 API
		init();
		
		// 위에까지 - 세팅
		// 여기부터 알고리즘 구현.... 
		for(int x = 0 ; x < runTime ; x++) {
			takahashi.run();
			aoki.run();
		}
		
		if(takahashi.getDistance() > aoki.getDistance()) {
			System.out.println(takahashi.getName());
		}else if(aoki.getDistance() > takahashi.getDistance()) {
			System.out.println(aoki.getName());
		}else {
			System.out.println("draw");
		}
		
		
		
	}
	
	private void init() {
		Scanner scn = new Scanner(System.in);
		System.out.print("값 입력 > ");
		String inputValue = scn.nextLine();
		// System.out.println("입력 받은 값 : " + inputValue);
		String [] inputs = inputValue.split(" "); 
		
		int tMaxRun = Integer.parseInt(inputs[0]);
		int tSpeed = Integer.parseInt(inputs[1]);
		int tMaxRest = Integer.parseInt(inputs[2]);
		int aMaxRun = Integer.parseInt(inputs[3]);
		int aSpeed = Integer.parseInt(inputs[4]);
		int aMaxRest = Integer.parseInt(inputs[5]);
		runTime = Integer.parseInt(inputs[6]);
		
		takahashi = new Runner("takahashi", tSpeed, tMaxRun, tMaxRest);
		aoki = new Runner("aoki", aSpeed, aMaxRun, aMaxRest);
		
		
		scn.close();
	}
}

class Runner{
	private String name;
	
	private int speed;
	private int maximumStrength;
	private int maximumBreakTime;
	
	private int remainingHealth;
	private int remainingBreakTime;
	
	private int distance;
	
	public Runner(String name, int speed, int maximumStrength, int maximumBreakTime) {
		this.name = name;
		this.speed = speed;
		this.maximumStrength = maximumStrength;
		this.maximumBreakTime = maximumBreakTime;
		
		this.remainingHealth = maximumStrength;
		
	}
	
	public void run() {
		if(existsHealth()) {
			distance += speed;
			decreaseHealth();
		}else {
			decreaseBreakTime();
		}
	}

	private boolean existsHealth() {
		return remainingHealth > 0; 
	}
	
	private void decreaseHealth() {
		remainingHealth--;
		if(!existsHealth()) {
			chargeBreakTime();
		}
	}
	
	private void chargeBreakTime() {
		remainingBreakTime = maximumBreakTime;
	}
	
	private void decreaseBreakTime() {
		remainingBreakTime--;
		if(remainingBreakTime <= 0) {
			remainingHealth = maximumStrength;
		}
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String getName() {
		return name;
	}
}

