package ploymorpism;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TvFactory factory = new TvFactory();
		Tv tv = factory.create("lg");
	
		
		User user = new User(tv);
		user.setTv(tv);
		user.watchTv();
	}

}
