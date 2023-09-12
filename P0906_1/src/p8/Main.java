package p8;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다형성 예제
		FFF f1 = new FFF();
		
	}

}

class AAA{}
class BBB{}
class CCC extends AAA{}
class DDD extends BBB{}
class EEE extends CCC{}
class FFF extends CCC{}
class GGG extends FFF{}