package main;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class WindowTest extends Frame implements ActionListener, WindowListener, ItemListener {


	Checkbox cb1, cb2, cb3, cb4, cb5;
	Label label1, label2;
	
	Checkbox exitCheck;
	
	JRadioButton radioBtn1, radioBtn2;
	JCheckBox jc1, jc2, jc3;
	
	public WindowTest() {
		
		/*
		 	radio button	선택 1개		AWT X, swing O
		 	check box		다수의 선택
		 */
		
		
		
		radioBtn1 = new JRadioButton("1");
		radioBtn2 = new JRadioButton("2");
		ButtonGroup group = new ButtonGroup();
		group.add(radioBtn1);
		group.add(radioBtn2);
		this.add(radioBtn1);
		this.add(radioBtn2);
		radioBtn1.setSelected(true);
		
		jc1 = new JCheckBox("1");
		jc2 = new JCheckBox("2");
		jc3 = new JCheckBox("3");
		add(jc1);
		add(jc2);
		add(jc3);
		
		
		CheckboxGroup cbg1 = new CheckboxGroup();
		cb1 = new Checkbox("사과", cbg1, true);
		cb2 = new Checkbox("배", cbg1, false);
		cb3 = new Checkbox("바나나", cbg1, false);
		
		CheckboxGroup cbg2 = new CheckboxGroup();
		cb4 = new Checkbox("빨강", cbg2, false);
		cb5 = new Checkbox("파랑", cbg2, true);
		
		exitCheck = new Checkbox("exit");
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(exitCheck);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cb5.addItemListener(this);
		exitCheck.addItemListener(this);
		
		label1 = new Label("label1");
		label2 = new Label("label2");
		
		add(label1);
		add(label2);
		
		setLayout(new FlowLayout());
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		
		
		addWindowListener(this);
	
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		// checkbox
		Object obj = e.getSource();		// Button btn = (Button)e.getsource(); 원래 이렇게 캐스트 해주던 걸 그냥 object로 받음
		
		if(obj == exitCheck) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState() == true) {		// true는 체크가 되어 있을 때 라는 뜻
				System.exit(0);
			}
			else {
				
			}
		}
		
		// radio button
		if( obj == cb1 || obj == cb2 || obj == cb3) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				String name = cb.getLabel();
				label1.setText(name);
			}
		}
		
		if(obj == cb4 || obj == cb5) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				String name = cb.getLabel();
				label2.setText(name);
			}
		}
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	



}
