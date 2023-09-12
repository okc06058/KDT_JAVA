import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) {
		// 기능 : 1. 학생 정보 입력, 2. 리스트 출력, 3. 이름 검색, 4. 학생정보 삭제, 5. 점수 통계
		// 학생 정보 : 이름, 나이, 점수
		String[] nameList = new String[5];
		int[] ageList = new int[5];
		int[] scoreList = new int[5];
		int count =0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*********************************");
		System.out.println("*		학생 정보 관리 프로그램 v1		*");
		System.out.println("*********************************");	

		while (true) {
			System.out.println("**** 메뉴 (현재 학생 수 : "+ count +") ****");
			System.out.println("1. 정보 입력");
			System.out.println("2. 리스트 출력");
			System.out.println("3. 정보 검색");
			System.out.println("4. 정보 삭제");
			System.out.println("5. 점수 통계");
			System.out.println("Q. 프로그램 종료");
			System.out.println("입력 > ");
			String command = sc.nextLine();
			
			if (command.equals("Q") || command.equals("q")) {
				break;
			}
			
			if(command.equals("1")) {
				System.out.println("학생 정보 등록 수행합니다.");
				System.out.print("이름 입력 > ");
				String name = sc.nextLine();
				
				System.out.print("나이 입력 > ");
				String inputAge = sc.nextLine();
				int age = Integer.parseInt(inputAge);
				
				System.out.print("점수 입력 > ");
				String inputScore = sc.nextLine();
				int score = Integer.parseInt(inputScore);
				
				nameList[count] = name;
				ageList[count] = age;
				scoreList[count] = score;
				count++;
				
				// 꽉 찼을때, 배열 메모리 증가
				if(count == nameList.length) {
					String[] tempNameList = new String[nameList.length*2];
					for(int x=0; x<nameList.length; x++) {
						tempNameList[x] = nameList[x];
					}
					nameList = tempNameList;
					
					int[] tempAgeList = new int[ageList.length*2];
					for(int x=0; x<ageList.length; x++) {
						tempAgeList[x] = ageList[x];
					}
					ageList = tempAgeList;
					
					int[] tempScoreList = new int[scoreList.length*2];
					for(int x=0; x<scoreList.length; x++) {
						tempScoreList[x] = scoreList[x];
					}
					scoreList = tempScoreList;
					//System.arraycopy(scoreList, 0, tempScoreList, 0, scoreList.length); 
				}
				System.out.println("입력이 완료되었습니다.");
				
			}else if(command.equals("2")) {
				
				System.out.println("**** 학생 리스트 출력 ****");
				for (int x = 0; x<count; x++) {
					String name = nameList[x];
					int age = ageList[x];
					int score = scoreList[x];
					
					String result = "이름 : " + name + ", 나이 : " + age + ", 점수 : " + score;
					System.out.println(result);
				}
				
			}else if(command.equals("3")) {
				
				System.out.println("**** 학생 검색 ****");
				System.out.print("검색할 학생 이름 입력 > ");
				String inputScerch= sc.nextLine();
				
				int serchCount = 0;
				for (int x = 0; x<count; x++) {
					//nameList[x].contains(inputScerch) - > 해당 문자열이 포함되어 있는 여부 확인(bool) 
					if(nameList[x].equals(inputScerch)) {
						String name = nameList[x];
						int age = ageList[x];
						int score = scoreList[x];
						
						String result = "이름 : " + name + ", 나이 : " + age + ", 점수 : " + score;
						System.out.println(result);
						serchCount++;
					}else {
						System.out.println("해당 학생이 없습니다.");
					}
				}
				System.out.println("총 "+serchCount+" 명의 학생의 결과가 나왔습니다.");
				
			}else if(command.equals("4")) {
				System.out.println("**** 학생 정보 삭제 ****");
				System.out.print("삭제할 학생의 이룸 > ");
				String deletName = sc.nextLine();
				
				int deleteCount = 0;
				for (int x=0; x<count; x++) {
					if(deletName.equals(nameList[x])) {
						for(int y=x; y<count-1; y++) {
							nameList[y]=nameList[y+1];
							ageList[y]=ageList[y+1];
							scoreList[y]=scoreList[y+1];
						}
						x--;
						count--;
						deleteCount++;
					}
				}
				System.out.println(deleteCount + "명이 삭제되었습니다.");
				
			}else if(command.equals("5")) {
				int sum = 0;
				for(int score : scoreList) {
					sum+=score;
				}
				double average = sum/(double)count;
				
				int maxScore = 0;
				for (int x=0; x<count; x++) {
					if(maxScore < scoreList[x]) {
						maxScore = scoreList[x];
					}
				}
				System.out.println();
				int tempVarSum=0;
				for (int x=0; x<count; x++) {
					double deviation = scoreList[x]-average;
					tempVarSum += deviation * deviation;
				}
				//tempVarSum = tempVarSum/(CountDownLatch-1)
				System.out.println();System.out.println();
			
				double std = Math.sqrt(tempVarSum/count);
				
				System.out.println("**** 점수 통계 ****");
				System.out.println("총 인원 : "+count);
				System.out.println("평균 : "+average);
				System.out.println("최고점 : "+maxScore);
				System.out.println("표준편차 : "+std);
				
			}else {
				System.out.println("잘못 입력하였습니다. 다시 입력해 주세요.");
			}
			System.out.println("계속하시려면 Enter를 입력해 주세요.");
			sc.nextLine();
		}

		System.out.println("프로그램을 종료됩니다. 이용해 주셔서 감사합니다.");

		
		sc.close();
	}

}
