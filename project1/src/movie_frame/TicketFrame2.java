package movie_frame;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.mainView;

public class TicketFrame2 extends JFrame implements ItemListener, ActionListener{
	mainView mv;
	Choice movieName;   // 영화목록
	Choice selectTime;  // 시간
	Choice adultTicket;  // 성인
	Choice childTicket;  // 청소년
	JPanel panel;
	JLabel label, name, time, adult, child;
	JButton nextbtn;
	public String idt;
	int ticketNum, select; // 예약번호
	
	public TicketFrame2(int mv, String idt) {
		String idt2 = idt;
		this.idt = idt;
		setSize(500, 400);
		setLocation(750, 200);
		setTitle("영화예매");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel(null);
		label = new JLabel("영화예매");
		name = new JLabel("영화제목 ");
		time = new JLabel("영화시간 ");
		adult = new JLabel("어른 ");
		child = new JLabel("청소년 ");
		
		ticketNum = (int)(Math.random() * 99999999);
		nextbtn = new JButton("NEXT");
		
		nextbtn.addActionListener(this);
		
		movieName = new Choice();
		selectTime = new Choice();
		adultTicket = new Choice();
		childTicket = new Choice();
		
		movieName.add("기생충");
		movieName.add("귀멸의 칼날: 무한열차편");
		movieName.add("원더우먼1984");
		movieName.select(mv);
		selectTime2(mv);
					
		movieName.addItemListener(this);
		
		for (int i = 0; i <= 10; i++) {
			adultTicket.add(String.valueOf(i));
			childTicket.add(String.valueOf(i));
		}
		
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		label.setForeground(Color.black);
		
		label.setBounds(180, 40, 200, 20);									
		name.setBounds(130, 87, 55, 50);
		time.setBounds(130, 126, 55, 50);
		adult.setBounds(130, 168, 40, 50);
		child.setBounds(130, 208, 40, 30);
		movieName.setBounds(190, 100, 160, 20);
		selectTime.setBounds(190, 140, 160, 20);
		adultTicket.setBounds(190, 180, 70, 20);
		childTicket.setBounds(190, 210, 70, 30);
		nextbtn.setBounds(340, 300, 80, 30);
		
		
		panel.add(label);
		panel.add(name);
		panel.add(movieName);
		panel.add(time);
		panel.add(selectTime);
		panel.add(adult);
		panel.add(adultTicket);
		panel.add(child);
		panel.add(childTicket);
		panel.add(nextbtn);			
		add(panel);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// item에서 index 추가해주기
		int movie_time = selectTime.getSelectedIndex();		
		String strmovie_time = selectTime.getSelectedItem();
		int adult_ticket = adultTicket.getSelectedIndex();
		int child_ticket = childTicket.getSelectedIndex();


		int adultP = 10000;					
		int childP = 9000;
		int totalP = 0;
		
		

	      if((adult_ticket == 0 && child_ticket == 0) || strmovie_time.equals(null))
	      {
	         JOptionPane.showMessageDialog( null, "정보를 모두 입력하세요", "error", JOptionPane.ERROR_MESSAGE );
	      }
	       else {
	            
	            if(adult_ticket != 0)
	            {
	              totalP += adult_ticket * adultP; 
	            }
	            if(child_ticket != 0)
	            {
	              totalP += child_ticket * childP;
	            }
	          System.out.println("Ticket2: " + this.idt);
	          SeatFrame2 seat = new SeatFrame2(movieName.getItem(select),adult_ticket + child_ticket,
	                                              totalP, ticketNum, strmovie_time, idt);
	            dispose();
	       }
		
	 
					}

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		int index = movieName.getSelectedIndex();
		System.out.println(index);
		selectTime.removeAll();
		if(index == 0)						
		{					
			selectTime.add("8:50 ~ 11:10");
			selectTime.add("10:30 ~ 12:55");
			selectTime.add("13:00 ~ 16:10");
			selectTime.add("17:15 ~ 19:40");
			selectTime.add("19:00 ~ 22:45");
			selectTime.add("22:20 ~ 24:50");
		}
		else if(index == 1)
		{					
			selectTime.add("9:43 ~ 12:05");
			selectTime.add("11:20 ~ 13:55");
			selectTime.add("14:10 ~ 17:15");
			selectTime.add("18:05 ~ 10:35");
			selectTime.add("20:10 ~ 23:40");
			selectTime.add("23:30 ~ 25:55");
		}
		else if(index == 2)
		{					
			selectTime.add("7:50 ~ 10:10");
			selectTime.add("9:30 ~ 11:55");
			selectTime.add("12:00 ~ 15:10");
			selectTime.add("16:15 ~ 18:40");
			selectTime.add("18:00 ~ 21:45");
			selectTime.add("21:20 ~ 23:50");
		}
		select = index;
	}
	
	public void selectTime2(int n) {
		
		if(n == 0)						
		{					
			selectTime.add("8:50 ~ 11:10");
			selectTime.add("10:30 ~ 12:55");
			selectTime.add("13:00 ~ 16:10");
			selectTime.add("17:15 ~ 19:40");
			selectTime.add("19:00 ~ 22:45");
			selectTime.add("22:20 ~ 24:50");
		}
		else if(n == 1)
		{					
			selectTime.add("9:43 ~ 12:05");
			selectTime.add("11:20 ~ 13:55");
			selectTime.add("14:10 ~ 17:15");
			selectTime.add("18:05 ~ 10:35");
			selectTime.add("20:10 ~ 23:40");
			selectTime.add("23:30 ~ 25:55");
		}
		else if(n == 2)
		{					
			selectTime.add("7:50 ~ 10:10");
			selectTime.add("9:30 ~ 11:55");
			selectTime.add("12:00 ~ 15:10");
			selectTime.add("16:15 ~ 18:40");
			selectTime.add("18:00 ~ 21:45");
			selectTime.add("21:20 ~ 23:50");
		}
		
		
		select = n;
	}
	
	
	
}