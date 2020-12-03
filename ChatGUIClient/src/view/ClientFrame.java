package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import network.WriteClass;


// 채팅창
public class ClientFrame extends JFrame implements ActionListener {
	
	public Socket socket;
	
	public JTextField textF = new JTextField(25);
	public JTextArea textA = new JTextArea();
	
	JButton btnTransfer = new JButton("Send");
	JButton btnExit = new JButton("Exit");
	
	JPanel panel = new JPanel();
	
	public boolean isFirst = true;
	
	WriteClass wc;
	
	public ClientFrame(Socket socket) {
		super("chatting");
		
		this.socket = socket;
		
		wc = new WriteClass(this);
		
		new Id(this, wc);
		
		JScrollPane scrPane = new JScrollPane(textA);
		scrPane.setPreferredSize(new Dimension(200, 100));
		add("Center", scrPane);
		panel.add(textF);
		panel.add(btnTransfer);
		panel.add(btnExit);
		
		add("South", panel);
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		
		setBounds(200, 200, 450, 600);
		setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnTransfer) {
			if(textF.getText().trim().equals("")) return;
			String id = Id.textF.getText();
			// textArea에 추가
			textA.append("[" + id + "]: " + textF.getText() + "\n");
			
			// server send
			wc.sendMessage();
			textF.setText("");
			
			
			
		} else if(obj == btnExit) {
			System.exit(0);
		}

	}

}
