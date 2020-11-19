package dto;

public class batter extends human {
	
	private int batcount;
	private int hit;
	private double hitrate;
	
	public batter() {
	
	}

	public batter(int number, String name, int age, int height, int batcount, int hit, double hitrate) {
		super(number, name, age, height);
		this.batcount = batcount;
		this.hit = hit;
		this.hitrate = hitrate;
	}

	public int getBatcount() {
		return batcount;
	}

	public void setBatcount(int batcount) {
		this.batcount = batcount;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getHitrate() {
		return hitrate;
	}

	public void setHitrate(double hitrate) {
		this.hitrate = hitrate;
	}

	@Override
	public String toString() {
		return super.toString() + "batter [batcount=" + batcount + ", hit=" + hit + ", hitrate=" + hitrate + "]";
	}
	
	
	
}
