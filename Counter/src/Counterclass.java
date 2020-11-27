import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class Counterclass extends Frame implements WindowListener, ActionListener {

	Label label1, label2;
	Button bt1, bt2, bt3;
	String count;
	int resu;
	
	public Counterclass() {
		count = "0";
//		resu = Integer.parseInt(count);
		setLayout(null);
		label1 = new Label();
		label1.setText("카운터");
		label1.setBounds(100, 50, 300, 35);
//		label1.setBackground(Color.DARK_GRAY);
		add(label1);
		
		setLayout(null);
		label2 = new Label();
		label2.setText(count);
		label2.setBounds(100, 100, 300, 35);
//		label2.setBackground(Color.DARK_GRAY);
		add(label2);
		
		bt1 = new Button();
		bt1.setLabel("+");
		bt1.setBounds(100, 200, 120, 50);;
		bt1.setBackground(Color.white);
		bt1.addActionListener(this);
		add(bt1);
		
		bt2 = new Button();
		bt2.setLabel("-");
		bt2.setBounds(280, 200, 120, 50);;
		bt2.setBackground(Color.white);
		bt2.addActionListener(this);		// 이것의 개수만큼 버튼 실행, bt3에 bt2.addActionListener(this);를 잘못 붙여넣었더니 bt2가 2번 눌리는 사태 발생
		add(bt2);
		
		bt3 = new Button();
		bt3.setLabel("reset");
		bt3.setBounds(100, 300, 300, 35);;
		bt3.setBackground(Color.white);
		bt3.addActionListener(this);
		add(bt3);
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		addWindowListener(this);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		String btncount = btn.getLabel();
		int n = 0;
				
		if(btncount.equals("-")) {
			n = Integer.parseInt(count);
//			JOptionPane.showMessageDialog(null, n + "");
			n--;
			count = Integer.toString(n);
			label2.setText(count);
		}else if(btncount.equals("+")) {
			n = Integer.parseInt(count);
			n++;
			count = Integer.toString(n);
			label2.setText(count);
		}else if(btncount.equals("reset")) {
			resu=0;
			count = Integer.toString(resu);
			label2.setText(count);
		}
		
	
		
		
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
