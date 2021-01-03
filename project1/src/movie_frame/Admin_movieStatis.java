package movie_frame;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import movieDAO.moviedao;
import view.mainView;

public class Admin_movieStatis extends JFrame implements ItemListener{
	
	mainView mv;
	Choice movieName;   // 영화목록
	JPanel panel;
	JLabel label, name, time, adult, child;
	JButton nextbtn;
	JTextArea statis;
	moviedao dao = new moviedao();
	
	
	public Admin_movieStatis() {
		
		
		setSize(500, 400);
		setLocation(750, 200);
		setTitle("영화통계");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel(null);
		label = new JLabel("영화통계");
		name = new JLabel("영화제목 ");
		statis = new JTextArea();
				
		movieName = new Choice();
				
		movieName.add("기생충");
		movieName.add("귀멸의 칼날: 무한열차편");
		movieName.add("원더우먼1984");
		movieName.select(0);
		String rsit = dao.moviestatisAud("기생충");
		int aud = (rsit.length() / 3 + 1);
		String sales = dao.moviestatisSales("기생충");
		statis.append("총 관객수: " + aud + "명" + "\n") ;
		statis.append("\n");
		statis.append("총 매출액: " + sales.trim() + "원") ;
		
		
		
		movieName.addItemListener(this);
		
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		label.setForeground(Color.black);
		
		label.setBounds(205, 50, 200, 20);									
		name.setBounds(130, 87, 55, 50);
		movieName.setBounds(190, 100, 160, 20);
		statis.setBounds(125, 140, 250, 100);
		
		
		panel.add(label);
		panel.add(name);
		panel.add(movieName);
		panel.add(statis);
		add(panel);
		setVisible(true);
		
	}
	
	
	
	public void itemStateChanged(ItemEvent e) {
		int index = movieName.getSelectedIndex();
		String movieN = "";		
		String rsit = "";
		int aud = 0;
		String sales;
		
		if(index == 0)	
					
		{	movieN = "기생충";
		statis.setText("");
		rsit = dao.moviestatisAud(movieN);
		sales = dao.moviestatisSales(movieN).trim();
		aud = (rsit.length() / 3 + 1);
		
		
		statis.append("총 관객수: " + aud + "명" + "\n") ;
		statis.append("\n");
		statis.append("총 매출액: " + sales + "원") ;
			
			
		}
		else if(index == 1)
		{	movieN = "귀멸의 칼날: 무한열차편";	
		statis.setText("");
		rsit = dao.moviestatisAud(movieN);
		sales = dao.moviestatisSales(movieN).trim();
		aud = (rsit.length() / 3 + 1);
		
		statis.append("총 관객수: " + aud + "명" + "\n") ;
		statis.append("\n");
		statis.append("총 매출액: " + sales + "원") ;
		}
		else if(index == 2)
		{	movieN = "원더우먼1984";	
		statis.setText("");
		rsit = dao.moviestatisAud(movieN);
		sales = dao.moviestatisSales(movieN).trim();
		aud = (rsit.length() / 3 + 1);
		
		statis.append("총 관객수: " + aud + "명" + "\n") ;
		statis.append("\n");
		statis.append("총 매출액: " + sales + "원") ;
		
		}
		
	}
	


}
