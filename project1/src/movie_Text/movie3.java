package movie_Text;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class movie3 extends JFrame {
	
	JPanel panel;
	JLabel label1, text1, text2, star;
	ImageIcon img1;
	JButton btn1;

	
	public movie3() {
		
		 setSize(600, 400);
		 setTitle("영화정보");
		 panel = new JPanel(null);
		 
		 img1 = new ImageIcon("img/wonder.jpg");
		 
		 btn1 = new JButton(img1);
		 btn1.setBounds(330, 80, 230, 250);
		 btn1.setContentAreaFilled(false); 
		 
		
		 label1 = new JLabel(" 원더우먼 1984");
		 label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 30));
		 label1.setForeground(Color.black);
		 label1.setBounds(40, 2, 520, 70); 
		 label1.setOpaque(true);
		 label1.setForeground(Color.white);
		 label1.setBackground(Color.black);
		 

		 
		 text1 = new JLabel("<html>장르  :  액션<br>개봉일  :  2020.12.20 </html>");
		 text1.setBounds(40, 80, 280, 44); 
		 text1.setFont(new Font(text1.getFont().getName(), Font.PLAIN, 14));
		 text1.setOpaque(true);
		 text1.setBackground(Color.LIGHT_GRAY);
		 
		 text2 = new JLabel("<html>［소개］1984년 모든 것이 활기찬 시대, 다이애나 프린스는 고고학자로서<br>"
		 		+ " 인간들 사이에서 조용히 살고 있다. 단지 원더 우먼으로서<br>"
		 		+ " 위기에 처한 사람을 구할 때만 빼고는. 그런 다이애나 앞에 거짓말처럼 죽었던 <br>"
		 		+ " 스티브 트레버가 나타나고, 거부할 수 없는 적마저 함께 찾아오는데… <br>"
		 		+ " 지나친 풍요로움이 과잉이 되어 또 다시 위협받는 인류,<br>"
		 		+ " 위태로운 세상에 오직 원더 우먼만이 희망이다! 그 어떤 적도 피하지 않는다!</html>");
		 
		 text2.setBounds(40, 150, 280, 180); 
		 text2.setFont(new Font(text2.getFont().getName(), Font.PLAIN, 11));
		 text2.setOpaque(true);
		 text2.setBackground(Color.white);
		 
		 star = new JLabel("평점 : ★★★★☆ 8.14");
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
