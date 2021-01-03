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

public class Admin_MemUpdate extends JFrame{
	
	   JPanel panel;
	   JLabel label1, id1, password1, name1, phone1;
	   public TextField idT, passwordT, nameT, phoneT;
	   JButton okbtn, withd;
	   mainView mv;
	   String str;
	
	public Admin_MemUpdate() {
		
	}
	
	public String ModifyFrame3() {

				
		setSize(500, 400);
		setLocation(1050, 200);
		setTitle("회원수정");
		panel = new JPanel(null);

		label1 = new JLabel("회원수정");
		id1 = new JLabel("아이디 ");
		password1 = new JLabel("비밀번호 ");
		name1 = new JLabel("이름 ");
		phone1 = new JLabel("연락처 ");
		label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 30));
		label1.setForeground(Color.black);

		moviedao dao = new moviedao();
		MemberVO vo = new MemberVO();
		dao.select(signin1.ids);

		idT = new TextField();

		passwordT = new TextField();

		nameT = new TextField();

		phoneT = new TextField();


		okbtn = new JButton("수정하기"); 
		okbtn.setBounds(130, 270, 100, 30); 

		withd = new JButton("회원탈퇴");
		withd.setBounds(260, 270, 100, 30);


		label1.setBounds(180, 10, 200, 80);  

		id1.setBounds(130, 100, 55, 20);
		name1.setBounds(130, 130, 55, 20);
		password1.setBounds(130, 160, 55, 20);
		phone1.setBounds(130, 190, 55, 20);

		idT.setBounds(190, 100, 120, 20);
		nameT.setBounds(190, 130, 120, 20);
		passwordT.setBounds(190, 160, 120, 20);
		phoneT.setBounds(190, 190, 120, 20);

		panel.add(label1);
		panel.add(id1);
		panel.add(password1);
		panel.add(name1);
		panel.add(phone1);
		panel.add(idT);
		panel.add(passwordT);
		panel.add(nameT);
		panel.add(phoneT);
		panel.add(okbtn);
		panel.add(withd);


		setDefaultCloseOperation(JoinFrame.DISPOSE_ON_CLOSE);
		add(panel);


		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idT.getText();
				String name = nameT.getText();
				String password = passwordT.getText();
				String phone = phoneT.getText();


				if(id.isEmpty() || name.isEmpty() || password.isEmpty() || phone.isEmpty() ) {
					JOptionPane.showMessageDialog( null, "정보를 모두 입력하세요", "error", JOptionPane.ERROR_MESSAGE );
				}else {
					moviedao dao = new moviedao();
					MemberVO vo = new MemberVO(id, name, password, phone);
					dao.update(vo);
					JOptionPane.showMessageDialog( null, "정보가 수정되었습니다", "success", JOptionPane.INFORMATION_MESSAGE );
					
					dispose();
				}
			}
		});

		withd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "정말로 탈퇴시키겠습니까?", "탈퇴확인", JOptionPane.YES_NO_OPTION);

				if(result == JOptionPane.YES_OPTION) {
					moviedao dao = new moviedao();
					String str = dao.reservedSeatId(idT.getText());
					if(str != null) {
						JOptionPane.showMessageDialog(null, "예매내역이 있어 탈퇴시킬 수 없습니다.");
					}
					else {dao.delete(idT.getText());
					JOptionPane.showMessageDialog(null, "정상적으로 탈퇴처리 되었습니다.");
					dispose();
					}

				}


			}
		});
		
		setVisible(true);
		return str;
	}
	
	
}
	
