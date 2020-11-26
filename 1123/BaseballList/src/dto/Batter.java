package dto;

public class Batter extends Human {
	
	private int hit;
	private int anta;
	private double hitrate;
	
	public Batter() {
		// TODO Auto-generated constructor stub
	}

	public Batter(int numb, String name, int age, int height, int hit, int anta, double hitrate) {
		super(numb, name, age, height);
		this.hit = hit;
		this.anta = anta;
		this.hitrate = hitrate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getAnta() {
		return anta;
	}

	public void setAnta(int anta) {
		this.anta = anta;
	}

	public double getHitrate() {
		return hitrate;
	}

	public void setHitrate(double hitrate) {
		this.hitrate = hitrate;
	}

	@Override
	public String toString() {
		return super.toString() + "hit=" + hit + ", anta=" + anta + ", hitrate=" + hitrate;
	}
	
	

}
