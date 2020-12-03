package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import network.WriteClass;

public class Id extends JFrame implements ActionListener {
	
	public static JTextField textF = new JTextField(10);
	JButton btn;
	
	ClientFrame cf;
	WriteClass wc;
	
	public Id(ClientFrame cf, WriteClass wc) {
		this.cf = cf;
		this.wc = wc;
		
		setTitle("대화명 설정");
		setLayout(null);
		
		JLabel label = new JLabel("Name");
		label.setBounds(130, 60, 90, 30);
		add(label);
		
		textF.setBounds(75, 90, 150, 30);
		add(textF);
		
		btn = new JButton("Enter");
		btn.setBounds(105, 140, 90, 30);
		btn.addActionListener(this);
		add(btn);
		
		setBounds(100, 100, 300, 250);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		wc.sendMessage();
		
		cf.isFirst = false;
		
		//  clientframe 시각화
		cf.setVisible(true);
		
		// 	id 창은 비시각화
		this.dispose();
	}

}
