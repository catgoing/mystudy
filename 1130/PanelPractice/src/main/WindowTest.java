package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener, ActionListener {
	
	Button btn1;
	
	public WindowTest() {
		
		Panel panel = new Panel();
		
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setBackground(Color.black);
		add(panel);
		
		Panel panel2 = new Panel();
		
		panel2.setPreferredSize(new Dimension(800, 600));
		panel2.setBackground(Color.green);
		add(panel2);
		
		btn1 = new Button();
		
		
		
		btn1.setBounds(100,100,100,50);
		btn1.setBackground(Color.gray);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
//				panel2();
				
			}
		});
		
		
		
		
		setBounds(100, 100, 1024, 728);
		setVisible(true);
		
		addWindowListener(this);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
