package movie_Text;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class movie1 extends JFrame {
	
	JPanel panel;
	JLabel label1, text1, text2, star;
	ImageIcon img1;
	JButton btn1;

	
	public movie1() {
		
		 setSize(600, 400);
		 setTitle("영화정보");
		 panel = new JPanel(null);
		 
		 img1 = new ImageIcon("img/parasite.jpg");
		 
		 btn1 = new JButton(img1);
		 btn1.setBounds(330, 80, 230, 250);
		 btn1.setContentAreaFilled(false); 
		 
		
		 label1 = new JLabel(" 기생충");
		 label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 30));
		 label1.setForeground(Color.black);
		 label1.setBounds(40, 2, 520, 70); 
		 label1.setOpaque(true);
		 label1.setForeground(Color.white);
		 label1.setBackground(Color.black);
		 

		 
		 text1 = new JLabel("<html>장르  :  드라마<br>개봉일  :  2019.05.30</html>");
		 text1.setBounds(40, 80, 280, 44); 
		 text1.setFont(new Font(text1.getFont().getName(), Font.PLAIN, 14));
		 text1.setOpaque(true);
		 text1.setBackground(Color.LIGHT_GRAY);
		 
		 text2 = new JLabel("<html>［소개］<br>전원백수로 살 길 막막하지만 사이는 좋은 기택(송강호) 가족.<br>"
		 		+ " 장남 기우(최우식)에게 명문대생 친구가 연결해준<br>"
		 		+ " 고액 과외 자리는 모처럼 싹튼 고정수입의 희망이다.<br>"
		 		+ " 온 가족의 도움과 기대 속에 박사장(선균) 집으로 향하는 기우.<br>"
		 		+ "글로벌 IT기업 CEO인 박사장의 저택에 도착하자 젊고 아름다운 사모님 연교(조여정)가 기우를 맞이한다.<br>"
		 		+ " 그러나 이렇게 시작된 두 가족의 만남 뒤로는, 걷잡을 수 없는 사건이 기다리고 있었으니…</html>");
		 
		 text2.setBounds(40, 150, 280, 180); 
		 text2.setFont(new Font(text2.getFont().getName(), Font.PLAIN, 11));
		 text2.setOpaque(true);
		 text2.setBackground(Color.white);
		 
		 star = new JLabel("평점 : ★★★★☆ 9.07");
		 star.setBounds(40, 110, 280, 50); 
		 star.setFont(new Font(text1.getFont().getName(), Font.PLAIN, 13));
		 star.setOpaque(true);
		 star.setBackground(Color.LIGHT_GRAY);
		 star.setForeground(Color.red);
		 
		 panel.add(label1);
		 panel.add(text1);
		 panel.add(text2);
		 panel.add(btn1);
		 panel.add(star);
		 
		 add(panel);
		 setVisible(true);
		 
		
		
	}


}
