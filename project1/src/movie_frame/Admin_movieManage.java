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
public class Admin_movieManage extends JFrame implements ActionListener{
	
	   JPanel panel;
	   JLabel label1, id1;
	   public TextField idT;
	   JButton okbtn, withd;
	   mainView mv;
	   String str;
	   moviedao dao;
	   public String idt;
	
	public Admin_movieManage() {
		
	}
	
	public void ModifyFrame4() {

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

//		withd = new JButton("예매취소하기");
//		withd.setBounds(260, 270, 100, 30);
//		withd.addActionListener(this);

		label1.setBounds(180, 10, 200, 80);  

		id1.setBounds(130, 100, 55, 20);


		idT.setBounds(190, 100, 120, 20);


		panel.add(label1);
		panel.add(id1);

		panel.add(idT);

		panel.add(okbtn);
//		panel.add(withd);


		setDefaultCloseOperation(JoinFrame.DISPOSE_ON_CLOSE);
		add(panel);

/*
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idt = idT.getText();

				if(idt.isEmpty()) {
					JOptionPane.showMessageDialog( null, "ID를 입력하세요", "error", JOptionPane.ERROR_MESSAGE );
				}else {
					dao = new moviedao();
					dao.reservedmovie(idt);
					while(true) {
						String[] answer = {"예매수정", "예매취소", "확인"};
						int result = JOptionPane.showOptionDialog(null,
							"예매번호: " + dao.RNUM + "\n"
									+ "영화제목: " + dao.VNAME + "\n"
									+ "상영일자: " + dao.RDATE + "\n"
									+ "상영시간: " + dao.RTIME + "\n"
									+ "좌석번호: " + dao.RSIT, "예매확인", JOptionPane.YES_NO_CANCEL_OPTION, 
									JOptionPane.INFORMATION_MESSAGE, 
									null, answer, answer[2]);

						
						if(result == 0) {
							int mv = 0;
							if(dao.VNAME.equals("귀멸의 칼날: 무한열차편")) {
								mv = 1;
							} else if(dao.VNAME.equals("원더우먼1984")) {
								mv = 2;
							}
							new TicketFrame2(mv);
							break;
							
						}
					}
					
					dispose();
				}
			}
		});
		*/
/*
		withd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "예매를 취소하시겠습니까?", "예매취소확인", JOptionPane.YES_NO_OPTION);

				if(result == JOptionPane.YES_OPTION) {
					String idt = idT.getText();
					dao.cancelmovie(idt);
					JOptionPane.showMessageDialog(null, "예매가 취소되었습니다.");
					dispose();

				}


			}
		});
		*/
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		JButton btn = (JButton)e.getSource();
//		String btnlabel = btn.getLabel();
		
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
					dao.reservedmovie(idt);
					while(true) {
						String[] answer = {"예매수정", "예매취소", "확인"};
						String[] answer2 = {"예매하기", "확인"};
						if(dao.RNUM == 0) {
							int result = JOptionPane.showOptionDialog(null,
							"예매내역 없음", idt, JOptionPane.YES_NO_OPTION, 
									JOptionPane.INFORMATION_MESSAGE, 
									null, answer2, answer2[1]);
							
							if(result == 0) {
								int mv = 0;
								
								if(dao.VNAME == null) {
									mv = 0;
								}
								
								else if(dao.VNAME.equals("귀멸의 칼날: 무한열차편")) {
									mv = 1;
								} else if(dao.VNAME.equals("원더우먼1984")) {
									mv = 2;
								}
								new TicketFrame(mv);
								break;
							} else break;
	
						}
						
						else {
							int result = JOptionPane.showOptionDialog(null,
						
							"예매번호: " + dao.RNUM + "\n"
									+ "영화제목: " + dao.VNAME + "\n"
									+ "상영일자: " + dao.RDATE + "\n"
									+ "상영시간: " + dao.RTIME + "\n"
									+ "좌석번호: " + dao.RSIT, "예매확인", JOptionPane.YES_NO_CANCEL_OPTION, 
									JOptionPane.INFORMATION_MESSAGE, 
									null, answer, answer[2]);
	
						
						if(result == 0) {
							int mv = 0;
							
							if(dao.VNAME == null) {
								JOptionPane.showMessageDialog(null, "예매내역 없음");
								mv = 0;
							}
							
							else if(dao.VNAME.equals("귀멸의 칼날: 무한열차편")) {
								mv = 1;
							} else if(dao.VNAME.equals("원더우먼1984")) {
								mv = 2;
							}
							new TicketFrame2(mv, idt);
							break;
							
						} else if(result == 1) {
							int cancel = JOptionPane.showConfirmDialog(null, "예매를 취소하시겠습니까?", "예매취소확인", JOptionPane.YES_NO_OPTION);
							if(cancel == JOptionPane.YES_OPTION) {
								dao.cancelmovie(idt);
								JOptionPane.showMessageDialog(null, "예매가 취소되었습니다.");	
								break;
							} else dao.reservedmovie(idt);
					
						} else break;
					}
						
					}
					
				//dispose();
				
	             }
			}
		} 
//			else if(e.getSource() == withd) {
//			int result = JOptionPane.showConfirmDialog(null, "111예매를 취소하시겠습니까?", "예매취소확인", JOptionPane.YES_NO_OPTION);
//
//			if(result == JOptionPane.YES_OPTION) {
//				String idt = idT.getText();
//				System.out.println(idt);
//				dao.cancelmovie(idt);
//				JOptionPane.showMessageDialog(null, "예매가 취소되었습니다.");
//				dispose();
//
//			}
	
//		}
		
	}
	
	
}
	
