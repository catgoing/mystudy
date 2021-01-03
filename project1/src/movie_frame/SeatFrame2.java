package movie_frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movieDAO.moviedao;

public class SeatFrame2 extends JFrame {
	int people;  // 성인 2하면 하나씩 좌석선택하면서 감소하게끔
	JPanel panel, seat;
	JLabel screen, seats[], peopleL, priceL, movienameL, movietimeL;
	JButton next;
	String date;
	String movienamee, movietimee;
	ArrayList<String> seatnum = new ArrayList<String>();
	moviedao dao = new moviedao();
	String[] str1, str5;
	
	public SeatFrame2(String moviename, int totalP, int totalT, int ticketNum, String movieT, String idt) {
		
		
		people = totalP;
		date = "20/12/31";
		movienamee = moviename;
		movietimee = movieT;
		String str = dao.reservedSeat(moviename, movieT); // 영화제목, 영화시간 파라미터 넣어서
		System.out.println("Seatf2: " + idt);
		String str3 = dao.reservedSeat2(moviename, movieT, idt); // 영화제목, 영화시간 파라미터 넣어서
		// 예매된 좌석번호 얻는 메서드

		
	   setSize(500, 400);
	   setLocation(750, 200);
	   setTitle("영화예매");
	   screen = new JLabel("SCREEN");
	   screen.setForeground(Color.black);
	   screen.setBackground(Color.blue);
	   screen.setFont(new Font(screen.getFont().getName(), Font.PLAIN, 20));
	   screen.setBounds(130, 20, 100, 30);
	   
	   movienameL = new JLabel("영화 : " + moviename);
	   movietimeL = new JLabel("시간 : " + movieT);
	   peopleL = new JLabel("인원 : " + totalP +"명 ");
	   priceL = new JLabel("가격 : " + totalT +"원 ");
	   movienameL.setBounds(360, 80, 140, 30);
	   movietimeL.setBounds(360, 130, 140, 30);
	   peopleL.setBounds(360, 180, 140, 30);
	   priceL.setBounds(360, 230, 140, 30);
	   next = new JButton("예매하기");
	   next.setBounds(340,316,100,30);

	   panel = new JPanel(null);
	   seat = new JPanel(new GridLayout(7, 7)); // (줄, 칸) 7 * 7 좌석으로
	   seat.setBackground(Color.white); // 처음 선택할 때 다 흰색
	   seat.setBounds(30, 60, 300, 230);
	   
	   seats = new JLabel[50];  // 자리수   // for문 돌릴때 0부터 시작해서 -1

	   boolean[] select = new boolean[49]; // 내가 선택한 자릿수  4번자리 선택하면 select[4] = true;
	   
	   
	   
	   for (int i = 0; i < 7; i++) {    // 별찍기 
		   for (int j = 0; j < 7; j++) {
			int z = i * 7 + j;
			 seats[z] = new JLabel(Integer.toString(z+1)); // 라벨 하나에 좌석번호 부여

			 seats[z].addMouseListener(new MouseListener(){ // 라벨 클릭하면 동작하는거

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(seats[z].getBackground() == Color.red) { // 내가 선택한 좌석
							seats[z].setBackground(Color.WHITE); // 다시 선택하면 흰색으로
							seatnum.remove(seats[z].getText());
							System.out.println(seatnum.toString());
							select[z] = false; // 선택된 좌석 false로
						    people++; // people 하나씩 증가
						}
						else if(seats[z].getBackground()!= Color.gray && people > 0) { // gray는 이미 예매된 좌석
							seats[z].setBackground(Color.red);
							System.out.println(seats[z].getText());
							seatnum.add(seats[z].getText());
							select[z] = true; // 선택할 수 있게 true로 해준다
							people--;  // 한자리 선택했으니까 인원 감소시켜준다
				   
						}
						seats[z].setOpaque(true); // 바뀐 색 적용
					}
				});
			 seat.add(seats[z]);
 
			 }

	}
	   
		if(str != null) {
		str1 = str.split(","); // 얻은 좌석번호 ',' 기준으로 나누기
		int[] str2 = new int[str1.length];
		for (int i = 0; i < str2.length; i++) {
			str2[i] = Integer.parseInt(str1[i]);
		}
		for (int q = 0; q < str2.length; q++) { //예매된 좌석 색 회색으로 바꾸기
			seats[str2[q]-1].setBackground(Color.gray);
			seats[str2[q]-1].setOpaque(true);
		}
		}
		
		if(str3 != null) {
			str5 = str3.split(","); // 얻은 좌석번호 ',' 기준으로 나누기
			int[] str4 = new int[str5.length];
			for (int i = 0; i < str4.length; i++) {
				str4[i] = Integer.parseInt(str5[i]);
			}
			for (int q = 0; q < str4.length; q++) { //내가 전에 예매한 좌석 색 오렌지으로 바꾸기
				seats[str4[q]-1].setBackground(Color.orange);
				seats[str4[q]-1].setOpaque(true);
			}
			}
		
	   
	   
	   
	    // seats라벨을 gridlayout seat패널에 추가
	   
	        // db연동하기
	   
	         
	   
	    // next버튼 누르면 예매확인 창 보이게
	     next.addActionListener(new ActionListener() {							
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예매 확인 나오게 창 연결
				if(people > 0) { // 좌석 선택안했는데 next 누른경우
				  JOptionPane.showMessageDialog( null, "좌석을 모두 선택해주세요!", "error", JOptionPane.ERROR_MESSAGE );
				} else {
				  
				  
				  StringBuilder sb = new StringBuilder();
				  for (int i = 0; i < seatnum.size(); i++) {
					sb.append(seatnum.get(i));
					sb.append(",");
				}
				  sb.deleteCharAt(sb.length()-1);
				  
				  int rnum = dao.reservedmovieRNUM(idt);
				  dao.updatemovie(movienamee, movietimee, sb.toString(), rnum);
				  JOptionPane.showMessageDialog(null, "예매되었습니다.");
				  dispose();
					
				}
				
			}
	   });
			 
	    panel.add(seat);
		panel.add(screen);
		panel.add(next);
		panel.add(movienameL);
		panel.add(movietimeL);
		panel.add(peopleL);
		panel.add(priceL);
		
		
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
			 }
	   
	}