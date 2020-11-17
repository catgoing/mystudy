package tv2;
import tv2.MyTv2;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyTv2 t = new MyTv2();
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());

	}

}
