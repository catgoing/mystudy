package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {
	
	public WindowTest() {
		
//		setLayout(new FlowLayout());
//		setLayout(new GridLayout(3, 1));
		setLayout(null);
		
		// Label
		Label label = new Label();
		label.setText("Label");
		label.setBounds(150, 30, 50, 30);
		add(label);
		
		Label label1 = new Label("레이블입니다");		// 프로젝트 우클릭 > properties > Run/Debug Setting > mainclass 선택 > edit > Arguments > 
													// VM Arguments 에 [ -Dfile.encoding=MS949 ] 붙여넣기 
		label1.setBackground(Color.cyan);
		label1.setBounds(150, 80, 70, 30);
		add(label1);
		
		Button button = new Button();
		button.setLabel("버튼");
		button.setBounds(150, 150, 100, 30);
		add(button);
		
		
//		setSize(640, 480);
//		setLocation(0, 0);
		setBounds(100, 100, 800, 600);
		
		setVisible(true);
		
		addWindowListener(this);

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
	public void windowClosing(WindowEvent e) {
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
