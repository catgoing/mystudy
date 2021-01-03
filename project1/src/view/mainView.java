package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movie_Text.movie1;
import movie_Text.movie2;
import movie_Text.movie3;
import movie_frame.Admin_movieReserve;
import movie_frame.JoinFrame;
import movie_frame.Admin_movieManage;
import movie_frame.TicketFrame;


public class mainView extends JFrame {
	
	JLabel lb1, lb2, lb3, lb11, lb22, lb33, title, under;
	public JLabel name1, name2, name3;
	ImageIcon img1, img2, img3;
	JButton bt1[];
	JButton loginbt, signupbt, name11, name22, name33;
	public static Container cont;
	public static JPanel login;
	
	public mainView() {
//		
		setTitle("★ ★ ★ 영화 그 이상의 감동. BITMOVIE ★ ★ ★");
		img1 = new ImageIcon("img/parasite.jpg");
		img2 = new ImageIcon("img/wonder.jpg");
		img3 = new ImageIcon("img/demon_slayer.png");

		loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new signin1();
				
			}
		});

		
		signupbt = new JButton("회원가입");
		
		
		
		bt1 = new JButton[3];
		bt1[0] = new JButton(img1);
		bt1[1] = new JButton(img3);
		bt1[2] = new JButton(img2);
		for (int i = 0; i < bt1.length; i++) {
			
//			bt1[i].setBorderPainted(false);
			bt1[i].setBounds(25 + (i*320), 100, 320, 400);
			bt1[i].setContentAreaFilled(false); // 버튼 배경색 없애기
		}
		
		under = new JLabel();
		under.setSize(1024, 100);
		under.setLocation(0, 610);
		under.setOpaque(true);
		under.setBackground(Color.lightGray);

		title = new JLabel("<     BIT MOVIE     >");
		title.setSize(318,50);
		title.setLocation(390, 00);
		title.setOpaque(true);
		title.setBackground(Color.white);
		title.setForeground(Color.black);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 25));
		
		lb11 = new JLabel();
		lb11.setSize(318,50);
		lb11.setLocation(25, 50);
		lb11.setHorizontalAlignment(JLabel.CENTER);
		lb11.setOpaque(true);
		lb11.setBackground(Color.black);
		
		
		lb1 = new JLabel("No.1");
		lb1.setSize(299,35);
		lb1.setLocation(35, 58);
		lb1.setHorizontalAlignment(JLabel.CENTER);
		lb1.setOpaque(true);
		lb1.setBackground(Color.red);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font(lb1.getFont().getName(), Font.PLAIN, 28));
		
		
		lb2 = new JLabel("No.2");
		lb2.setSize(299,35);
		lb2.setLocation(356, 58);
		lb2.setHorizontalAlignment(JLabel.CENTER);
		lb2.setOpaque(true);
		lb2.setBackground(Color.red);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font(lb1.getFont().getName(), Font.PLAIN, 28));
		
	
		lb22 = new JLabel();
		lb22.setSize(316,50);
		lb22.setLocation(347, 50);
		lb22.setHorizontalAlignment(JLabel.CENTER);
		lb22.setOpaque(true);
		lb22.setBackground(Color.black);
		lb22.setFont(new Font(lb22.getFont().getName(), Font.PLAIN, 28));
		
		
		
		lb3 = new JLabel("No.3");
		lb3.setSize(300,35);
		lb3.setLocation(675, 58);
		lb3.setHorizontalAlignment(JLabel.CENTER);
		lb3.setOpaque(true);
		lb3.setBackground(Color.red);
		lb3.setForeground(Color.white);
		lb3.setFont(new Font(lb3.getFont().getName(), Font.PLAIN, 28));
		
		lb33 = new JLabel("");
		lb33.setSize(318,50);
		lb33.setLocation(667, 50);
		lb33.setHorizontalAlignment(JLabel.CENTER);
		lb33.setOpaque(true);
		lb33.setBackground(Color.black);
		
		name1 = new JLabel("기생충");
		name1.setSize(325,50);
		name1.setLocation(25, 500);
		name1.setHorizontalAlignment(JLabel.CENTER);
		
		
	
		
		bt1[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 0;
				if(signin1.ids != null && !"admin".equals(signin1.ids)) {
					new TicketFrame(n);
					} else if("admin".equals(signin1.ids)) {
						new Admin_movieReserve().ModifyFrame(n);
					}
				else JOptionPane.showMessageDialog(null, "로그인 후 예매가가능합니다."); 
				
			}
		});
		
		
		name2 = new JLabel("극장판 귀멸의 칼날: 무한열차");
		name2.setSize(325,50);
		name2.setLocation(340, 500);
		name2.setHorizontalAlignment(JLabel.CENTER);
		bt1[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 1;
				if(signin1.ids != null && !"admin".equals(signin1.ids)) {
					new TicketFrame(n);
					} else if("admin".equals(signin1.ids)) {
						new Admin_movieReserve().ModifyFrame(n);
					
					} else JOptionPane.showMessageDialog(null, "로그인 후 예매가가능합니다."); 
			}
		});
		
		name3 = new JLabel("원더우먼1984");
		name3.setSize(325,50);
		name3.setLocation(665, 500);
		name3.setHorizontalAlignment(JLabel.CENTER);
		bt1[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 2;
				if(signin1.ids != null && !"admin".equals(signin1.ids)) {
					new TicketFrame(n);
					} else if("admin".equals(signin1.ids)) {
						new Admin_movieReserve().ModifyFrame(n);
					
					} else JOptionPane.showMessageDialog(null, "로그인 후 예매가가능합니다."); 
			}
		});
		
		name11 = new JButton("영화정보");
		name11.setBounds(145, 560, 90, 30); 
		
		name22 = new JButton("영화정보");
		name22.setBounds(465, 560, 90, 30); 
		
		
		name33 = new JButton("영화정보");
		name33.setBounds(785, 560, 90, 30); 
		
		
		
		name11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new movie1();
			}	
		});
		
		
		name22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new movie2();
	
			}	
		});
		
		name33.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new movie3();
			
			}	
		});
		
		
		JPanel mainp = new JPanel();

		login = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		login.add(loginbt);
		login.add(signupbt);
		signupbt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new JoinFrame();	
				
			}
		});
		login.setBackground(Color.lightGray);
		login.setVisible(true);
	
		mainp.setBackground(Color.white);
		mainp.setLayout(null);
		
		for (int i = 0; i < bt1.length; i++) {
			mainp.add(bt1[i]);
		}
		
		
		
	
		mainp.add(name1);
		mainp.add(name2);
		mainp.add(name3);
		mainp.add(lb1);
		mainp.add(title);
		mainp.add(lb11);
		mainp.add(lb2);
		mainp.add(lb22);
		mainp.add(lb3);
		mainp.add(lb33);
		mainp.add(name11);
		mainp.add(name22);
		mainp.add(name33);
		mainp.add(under);

		
		cont = new Container();
		cont = getContentPane();
		cont.add(mainp, BorderLayout.CENTER);
		cont.add(login, BorderLayout.NORTH);
		
		setBounds(450, 120, 1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}

}
