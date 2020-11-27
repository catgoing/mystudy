package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Counter extends JFrame implements ActionListener{
	
	JLabel countLabel;
	JButton pBtn, mBtn, rBtn;
	
	int count;
	
	public Counter() {
		super("counter");		
		setTitle("카운터");
		
		count = 0;
		
		setLayout(null);
		
		JLabel label = new JLabel("Counter");
		label.setBounds(30, 30, 250, 30);
		add(label);
		
		countLabel = new JLabel("0");
		countLabel.setBounds(30, 70, 250, 30);
		add(countLabel);
		
		pBtn = new JButton();
		pBtn.setLabel("+");
		pBtn.setBounds(30, 150, 150, 100);
		pBtn.addActionListener(this);
		add(pBtn);
		
		mBtn = new JButton("-");
		mBtn.setBounds(200, 150, 150, 100);
		mBtn.addActionListener(this);
		add(mBtn);
		
		rBtn = new JButton("reset");
		rBtn.setBounds(30, 300, 250, 50);
		rBtn.addActionListener(this);
		add(rBtn);
		
		setSize(400, 500);
		setLocation(100, 100);
		setVisible(true);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String title = btn.getLabel();
		
		if(title.equals("+")) {
		//	JOptionPane.showMessageDialog(null, "+ 클릭");
			count++;			
		}
		else if(title.equals("-")) {
		//	JOptionPane.showMessageDialog(null, "- 클릭");
			if(count > 0) {
				count--;
			}
		}
		else if(title.equals("reset")) {
		//	JOptionPane.showMessageDialog(null, "reset 클릭");
			count = 0;
		}
		
		countLabel.setText(count + "");
		
	}	

}











