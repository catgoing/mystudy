package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class PiratesBackend extends Frame implements WindowListener, ActionListener{
	
	
	Label result;
	Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	int numset[];
	int ran;
	int randn[];
	boolean rann[];
	String sran;
		
	Button btnar[];
	
	public PiratesBackend() {
		
		
		numset();
		
		btnar = new Button[9];
		
		setLayout(null);
		
		result = new Label();
		result.setText("");
		result.setBounds(520, 400, 170, 100);
		result.setBackground(Color.orange);
		add(result);
		
		btnar[0] = new Button();
		btnar[0].setLabel("1");
		btnar[0].setBounds(70, 250, 100, 100);
		btnar[0].addActionListener(this);
		add(btnar[0]);
		
		btnar[1] = new Button();
		btnar[1].setLabel("2");
		btnar[1].setBounds(220, 250, 100, 100);
		btnar[1].addActionListener(this);
		add(btnar[1]);
		
		btnar[2] = new Button();
		btnar[2].setLabel("3");
		btnar[2].setBounds(370, 250, 100, 100);
		btnar[2].addActionListener(this);
		add(btnar[2]);
		
		btnar[3] = new Button();
		btnar[3].setLabel("4");
		btnar[3].setBounds(70, 400, 100, 100);
		btnar[3].addActionListener(this);
		add(btnar[3]);
		
		btnar[4] = new Button();
		btnar[4].setLabel("5");
		btnar[4].setBounds(220, 400, 100, 100);
		btnar[4].addActionListener(this);
		add(btnar[4]);
		
		btnar[5] = new Button();
		btnar[5].setLabel("6");
		btnar[5].setBounds(370, 400, 100, 100);
		btnar[5].addActionListener(this);
		add(btnar[5]);
		
		btnar[6] = new Button();
		btnar[6].setLabel("7");
		btnar[6].setBounds(70, 550, 100, 100);
		btnar[6].addActionListener(this);
		add(btnar[6]);
		
		btnar[7] = new Button();
		btnar[7].setLabel("8");
		btnar[7].setBounds(220, 550, 100, 100);
		btnar[7].addActionListener(this);
		add(btnar[7]);
		
		btnar[8] = new Button();
		btnar[8].setLabel("9");
		btnar[8].setBounds(370, 550, 100, 100);
		btnar[8].addActionListener(this);
		add(btnar[8]);
		
		bt7 = new Button();
		bt7.setLabel("reset");
		bt7.setBounds(170, 700, 200, 100);
		bt7.addActionListener(this);
		add(bt7);
	
		setBounds(500, 20, 720, 1024);
		setBackground(Color.lightGray);
		setVisible(true);
		
		addWindowListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		String btnn = btn.getLabel();
		
		if(btnn.equals(sran)) {
			result.setText(sran + "      You are" + "\n" + " the PIRATE!!");
			result.setBackground(Color.red);
			for (int i = 0; i < btnar.length; i++) {
				btnar[i].setEnabled(false);
			}
			JOptionPane.showMessageDialog(null, sran + "! 당신이 해적입니다!");
			
		} else if(btnn.equals("reset")){
			numset();
			
			result.setText("");
			result.setBackground(Color.orange);
			
			for (int i = 0; i < 9; i++) {
				btnar[i].setEnabled(true);
			}

			
			
		} else {
			btn.setEnabled(false);
			result.setText("      You are not" + "\n" + " a PIRATE");
			result.setBackground(Color.green);
		}
	}
		


	@Override
	public void windowActivated(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
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
	
	public void numset() {
		
//		btnar = new Button[9];
		ran = (int)((Math.random()*9 + 1));
		sran = Integer.toString(ran);
	}

}
