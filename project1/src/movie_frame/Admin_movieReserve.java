package movie_frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movieDAO.MemberVO;
import movieDAO.moviedao;
import panels.loginp2;
import view.mainView;
import view.signin1;


///////////////////////////admin
public class Admin_movieReserve extends JFrame implements ActionListener{
	
	   JPanel panel;
	   JLabel label1, id1;
	   public TextField idT;
	   JButton okbtn, withd;
	   mainView mv;
	   String str;
	   moviedao dao;
	   public String idt;
	   int n;
	
	public Admin_movieReserve() {
		
	}
	
	public void ModifyFrame(int n) {

		
		this.n = n;
		String idt;
		setSize(500, 300);
		setLocation(750, 200);
		setTitle("예매관리");
		panel = new JPanel(null);

		label1 = new JLabel("예매관리");
		id1 = new JLabel("아이디 ");
	
		label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 30));
		label1.setForeground(Color.black);

		

		idT = new TextField();
		
		okbtn = new JButton("확인"); 
		okbtn.setBounds(190, 150, 100, 30); 
		okbtn.addActionListener(this);



		label1.setBounds(180, 10, 200, 80);  

		id1.setBounds(130, 100, 55, 20);


		idT.setBounds(190, 100, 120, 20);


		panel.add(label1);
		panel.add(id1);

		panel.add(idT);

		panel.add(okbtn);


		setDefaultCloseOperation(JoinFrame.DISPOSE_ON_CLOSE);
		add(panel);


		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okbtn) {
			this.idt = idT.getText();
			dao = new moviedao();
			if(idt.isEmpty()) {
				JOptionPane.showMessageDialog( null, "ID를 입력하세요", "error", JOptionPane.ERROR_MESSAGE );
			}else {
				
				 String id = idT.getText();
	             if(dao.loginid(id) != true) {
	                 JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "error", JOptionPane.ERROR_MESSAGE);
	               }
				
	             else {
					 moviedao.id = id;
	            	 new TicketFrame(this.n);
	            	 dispose(); // 연속적으로 예매할 거면 동작하게 하고 싶으면 이 부분 주석처리
	             }
			}
			
		} 

		
	}
	
	
}
	
