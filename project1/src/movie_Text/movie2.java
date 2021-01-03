package movie_Text;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class movie2 extends JFrame {
	
	JPanel panel;
	JLabel label1, text1, text2, star;
	ImageIcon img1;
	JButton btn1;

	
	public movie2() {
		
		 setSize(600, 400);
		 setTitle("영화정보");
		 panel = new JPanel(null);
		 
		 img1 = new ImageIcon("img/demon_slayer.png");
		 
		 btn1 = new JButton(img1);
		 btn1.setBounds(330, 80, 230, 250);
		 btn1.setContentAreaFilled(false); 
		 
		
		 label1 = new JLabel("극장판 귀멸의 칼날: 무한열차");
		 label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 24));
		 label1.setForeground(Color.black);
		 label1.setBounds(40, 2, 520, 70); 
		 label1.setOpaque(true);
		 label1.setForeground(Color.white);
		 label1.setBackground(Color.black);
		 

		 
		 text1 = new JLabel("<html>장르  :  애니메이션<br>개봉일  :  2020.12.31</html>");
		 text1.setBounds(40, 80, 280, 44); 
		 text1.setFont(new Font(text1.getFont().getName(), Font.PLAIN, 14));
		 text1.setOpaque(true);
		 text1.setBackground(Color.LIGHT_GRAY);
		 
		 text2 = new JLabel("<html>［소개］<br>혈귀로 변해버린 여동생 ‘네즈코’를 인간의 단서를 찾아<br>"
		 		+ "비밀조직 귀살대에 들어간 ‘탄지로.’ ‘젠이츠’, ‘이노스케’와<br>"
		 		+ "새로운 임무 수행을 위해 무한열차에 탑승 후 귀살대 최강 검사 염주 ‘렌고쿠’와 합류한다.<br>"
		 		+ "달리는 무한열차에서 승객들이 하나 둘 흔적 없이 사라지자 숨어있는 식인 혈귀의 존재를 직감하는 ‘렌고쿠’.<br>"
		 		+ "귀살대 ‘탄지로’ 일행과 최강 검사 염주 ‘렌고쿠’는 어둠 속을 달리는 무한열차에서,<br>"
		 		+ "모두의 목숨을 구하기 위해 예측불가능한 능력을 가진 혈귀와 목숨을 건 혈전을 시작하는데…</html>");
		 
		 text2.setBounds(40, 150, 280, 180); 
		 text2.setFont(new Font(text2.getFont().getName(), Font.PLAIN, 11));
		 text2.setOpaque(true);
		 text2.setBackground(Color.white);
		 
		 star = new JLabel("평점 : ★★★☆☆ 7.3");
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
