package tv2;

public class MyTv2 {
	
	private boolean isPowerOn;
	private int channel;
	private int volume;
	int temp, temp1;
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	
	
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		temp = this.channel;
		this.channel = channel;
		
	}
	
	public int gotoPrevChannel(){
		
//		temp1 = this.channel;
//		this.channel = temp;
//		temp = temp1;
		setChannel(temp);
		
		return this.channel;
	}
	
	public boolean isPowerOn() {
		return isPowerOn;
	}

	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}

	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	

}