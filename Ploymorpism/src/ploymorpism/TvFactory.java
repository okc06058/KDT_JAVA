package ploymorpism;

public class TvFactory {

	public Tv create(String name) {
		switch (name) {
			case "samsung" : return new SamsungTv();
			case "lg" : return (Tv) new LgTv();
			default : return null; 
		}
	}

}
