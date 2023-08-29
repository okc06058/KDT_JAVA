import java.util.Scanner;

public class B_UniqueNicknames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] s = new String[n];
		String[] t = new String[n];

		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
			t[i] = sc.next();
		}
		//sc.close();
		//ai는 사람i의 성 또는 이름과 일치한다. 즉, ai = si 그리고/또는 ai = ti를 만족시킨다.
		//ai는 다른 사람의 성 및 이름과 일치하지 않는다. 즉, 1≤j≤N 및i=j를 만족시키는 모든 정수 j에 대해 ai=sj 그리고/또는 ai=tj을 만족시킨다
		//3
		//tanaka taro
		//tanaka jiro
		//suzuki hanako


		for (int i = 0; i < n; i++) {
			boolean ck_S = false;
			boolean ck_T = false;

			for (int j = 0; j < n; j++) {
				if (j == i) continue; // 자신 건너 뜀
				if (s[j].equals(s[i]) || t[j].equals(s[i])) { //성과 이름이이 겹치거나 성에서 겹치는 경우 
					ck_S = true;
					
				}
					
				if (s[j].equals(t[i]) || t[j].equals(t[i])) //성과 이름이이 겹치거나 이름에서 겹치는 경우
					ck_T = true;
			}

			if (ck_S && ck_T) {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");

	}

}
