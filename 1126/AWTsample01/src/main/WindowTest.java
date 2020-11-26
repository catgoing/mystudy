package main;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
												// listener: 버튼이 언제 눌릴지 모르니 리스너를 둠 
public class WindowTest extends Frame implements WindowListener{ // Frame 상속 
	
	public WindowTest() {
		setSize(640, 480);	//	window의 폭, 높이
		setLocation(0, 0);	//	window의 위치
		setVisible(true);	// winddow의 시각화
		
		addWindowListener(this); 	// 현재 클래스에 리스너가 추가되어 있다고 알리는 것
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {	// x버튼 눌렀을 때 작동하는 메서드
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
