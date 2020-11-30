package dto;

public class Batter extends Human {
	
	String hit;
	String anta;
	String hitrate;
	
	public Batter() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Batter(int num, String age, String name, String height, String hit, String anta, String hitrate) {
		super(num, age, name, height);
		this.hit = hit;
		this.anta = anta;
		this.hitrate = hitrate;
	}


	@Override
	public String toString() {
		return super.toString() + "-" + hit + "-" + anta + "-" + hitrate ;
	}
	
	
	
	

}
