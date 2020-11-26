package dto;

public class Pitcher extends Human {
	
	private int wins;
	private int loses;
	private double def;
	
	public Pitcher() {
		// TODO Auto-generated constructor stub
	}

	public Pitcher(int numb, String name, int age, int height, int wins, int loses, double def) {
		super(numb, name, age, height);
		this.wins = wins;
		this.loses = loses;
		this.def = def;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {
		this.loses = loses;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	@Override
	public String toString() {
		return super.toString() + "wins=" + wins + ", loses=" + loses + ", def=" + def;
	}
	
	

}
