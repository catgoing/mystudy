package dto;

public class Pitcher extends Human {
	
	String wins;
	String loses;
	String def;
	
	public Pitcher() {
		// TODO Auto-generated constructor stub
	}

	public Pitcher(int num, String age, String name, String height, String wins, String loses, String def) {
		super(num, age, name, height);
		this.wins = wins;
		this.loses = loses;
		this.def = def;
	}

	@Override
	public String toString() {
		return super.toString() + wins + "-" + loses + "-" + def;
	}
	

}
