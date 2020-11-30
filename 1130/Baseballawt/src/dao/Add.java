package dao;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import singleton.singleton;

public class Add extends Frame implements WindowListener, ActionListener, ItemListener {
	
	Label title;
	Label label[];
	Label position;
	TextField txf[];
	String data[];
	Checkbox radiobt1, radiobt2;
	int num;
	
	LinkedList<Human> list;
	
	public Add() {
		
		singleton si = singleton.getInstance();
		dao memd = new dao();
		Pitcher pit = new Pitcher();
		Batter bat = new Batter();
		
		
		
		num = 1;
		
		
		list = memd.list;
		
		setLayout(null);
		
		CheckboxGroup cbg1 = new CheckboxGroup();
		radiobt1 = new Checkbox("투수", cbg1, true);
		radiobt2 = new Checkbox("타자", cbg1, false);
		radiobt1.setBounds(340, 140, 50, 50);
		radiobt2.setBounds(410, 140, 50, 50);
		radiobt1.addItemListener(this);
		radiobt2.addItemListener(this);
		add(radiobt1);
		add(radiobt2);
		
		title = new Label("Add Player Information");
		title.setAlignment(Label.CENTER);
		title.setBounds(250, 70, 300, 70);
		title.setBackground(Color.LIGHT_GRAY);
		add(title);
		txf = new TextField[6];
		label = new Label[6];
		
		
		Panel txp = new Panel();
		for (int i = 0; i < txf.length; i++) {
			label[i] = new Label();
			label[i].setBounds(170, 200+(i*50), 170, 30);
			label[i].setBackground(Color.white);
			label[i].setAlignment(Label.RIGHT);
			add(label[i]);
			txf[i] = new TextField(20);
			txf[i].setBounds(350, 200+(i*50), 200, 30);
			add(txf[i]);
		}
		
//		label[0].setText("포지션(투수/타자");
		label[0].setText("이름");
		label[1].setText("나이");
		label[2].setText("키");
		label[3].setText("승전수");
		label[4].setText("패전수");
		label[5].setText("방어율");
		
		data = new String[6];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = txf[i].getText();
		}
		
		if(position.equals(radiobt1.getName())) {
			num = num + 1000;
			
		}
		
		
		
		setBounds(100, 100, 800, 650);
		setVisible(true);
		
		addWindowListener(this);
		
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();		// Button btn = (Button)e.getsource(); 원래 이렇게 캐스트 해주던 걸 그냥 object로 받음
		position = new Label();
				
		// radio button
		if( obj == radiobt1) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				String wins = "숭전수";
				label[3].setText(wins);
				String loses = "패전수";
				label[4].setText(loses);
				String def = "방어율";
				label[5].setText(def);
				position.setName(radiobt1.getName());
			}
		} else if ( obj == radiobt2) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				String hit = "타수";
				label[3].setText(hit);
				String anta = "안타수";
				label[4].setText(anta);
				String hitrate = "타율";
				label[5].setText(hitrate);
				position.setName(radiobt2.getName());
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
