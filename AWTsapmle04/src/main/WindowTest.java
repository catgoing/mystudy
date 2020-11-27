package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class WindowTest extends JFrame /* implements ActionListener */{
	
	JTextField textField;
	JTextArea textArea;
	
	JButton btn1, btn2;
	
	
	public WindowTest() {
		super("타이틀바");
		
		/*
			panel:	window 위의 window
					
					Textfield, Teatarea
			
		 */
		JPanel panel = new JPanel();	// 새 area 준비
		textArea = new JTextArea();		// 새 area 생성
		textArea.setLineWrap(true);		// area의 경계선을 표시하는 부분
		
		JScrollPane scrPane = new JScrollPane(textArea);	// 스크롤바 생성
		scrPane.setPreferredSize(new Dimension(400, 300));	// 스크롤바를 포함한 area의 크기를 정하는 부분
		panel.add(scrPane);
		
		
		
		JPanel botpan = new JPanel();
		textField = new JTextField(30);		// JTextField();의 ()안에 숫자를 넣으면 그만큼으로 입력 개수 제한
		
		btn1 = new JButton("next insert"); // 버튼 크기 안 잡아줘도 되는데... 왜?
//		btn1.addActionListener(this);		
		btn1.addActionListener(new ActionListener() {		// actionlistner에 바로 접근하는 방법(implements, 조건문 필요없음)
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("next insert");
				
				String msg = textField.getText() + "\n";
				textArea.append(msg);
				
				
			}
		});
		
		btn2 = new JButton("prev insert");
//		btn2.addActionListener(this);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("prev insert");
				
				String msg = textField.getText() + "\n";
//				textArea.insert(msg, textArea.getLineStartOffset(0)); exception 걸려서 아래처럼 생성
				try {
					textArea.insert(msg, textArea.getLineStartOffset(0));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		Container contentPane = getContentPane();	// jfram에 있는 contentpane을 모아주는 부분
		contentPane.add(panel, BorderLayout.CENTER);		// 패널의 위치 설정하는 부분, 중앙
		contentPane.add(botpan, BorderLayout.SOUTH);		// 패널의 위치 설정하는 부분, 아래쪽
		
		setBounds(100, 100, 640, 480);
		setVisible(true);
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

/*
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnlabel = btn.getLabel();
		
		if(btnlabel.equals("next insert")) {
			System.out.println("next insert");
		}else if(btnlabel.equals("prev insert")) {
			System.out.println("prev insert");
		}
		
	}
	*/

}
