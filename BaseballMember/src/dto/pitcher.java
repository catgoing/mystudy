package dto;

public class pitcher extends human {
	
	private int win;
	private int lose;
	private double defense;
	
	public pitcher() {
		
	}
	
	public pitcher(int number, String name, int age, int height, int win, int lose, double defense) {
		super(number, name, age, height);
		this.win = win;
		this.lose = lose;
		this.defense = defense;
		
	}
	

	public int getWin() {
		return win;
	}




	public void setWin(int win) {
		this.win = win;
	}




	public int getLose() {
		return lose;
	}




	public void setLose(int lose) {
		this.lose = lose;
	}




	public double getDefense() {
		return defense;
	}




	public void setDefense(double defense) {
		this.defense = defense;
	}




	@Override
	public String toString() {
		return super.toString() + "pitcher [win=" + win + ", lose=" + lose + ", defense=" + defense + "]";
	}
	
	

}
