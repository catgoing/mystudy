package movie_frame;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import movieDAO.moviedao;
import view.mainView;


///////////////////////////admin
public class Admin_MemManage extends JFrame implements ItemListener{
	
	mainView mv;
	Choice movieName;   // 영화목록
	JPanel panel, modifypanel;
	JScrollPane jscp;
	JLabel label, name, id1, password1, name1, phone1;
	JButton managebt, enter, refresh;
	JTextField searchbar;
	JTextField idT, passwordT, nameT, phoneT;
	public JTextArea statis, statis2;
	Container cont;
	moviedao dao = new moviedao();
	JPanel info;
	public String str = "1";
		
	
	public Admin_MemManage() {
		
		
		setSize(500, 400);
		setLocation(750, 200);
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(200, 20, 200, 50);
	
		label = new JLabel("회원관리");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		label.setForeground(Color.black);
		label.setBounds(205, 50, 200, 20);	
		
		panel.add(label);
		
		JPanel searchpanel = new JPanel();
		searchpanel.setBounds(150, 400, 400, 200);
		JLabel ID = new JLabel("ID:");
		searchbar = new JTextField(12);
		enter = new JButton("Enter");
		searchpanel.add(ID);
		searchpanel.add(searchbar);
		searchpanel.add(enter);

	
		info = new JPanel();
		managebt = new JButton("회원수정");
		refresh = new JButton("새로고침");
		statis = new JTextArea();
		statis2 = new JTextArea();
		statis2.append("ID\t이름\t패스워드\t연락처");
		
		JScrollPane idname = new JScrollPane(statis2, JScrollPane.VERTICAL_SCROLLBAR_NEVER
				, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		idname.setPreferredSize(new Dimension(400, 20));
		statis2.setEditable(false);

		jscp = new JScrollPane(statis);
		jscp.setPreferredSize(new Dimension(400, 200));
		jscp.setLocation(100, 100);

		info.setBounds(100, 100, 400, 200);
		String meminfo = dao.select2().toString();
		statis.append(meminfo);
		statis.setEditable(false);
		info.add(idname, BorderLayout.NORTH);
		info.add(jscp);
		info.add(managebt);
		info.add(refresh);

	
		cont = new Container();
		cont = getContentPane();
		
		

		cont.add(panel, BorderLayout.NORTH);
		cont.add(searchpanel, BorderLayout.SOUTH);
		cont.add(info, BorderLayout.CENTER);

		
		enter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String member = dao.select3(searchbar.getText());
				if(!"".equals(member)) {
				statis.setText("");
				statis.append(member);
				}
				
			}
		});
		

		managebt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Admin_MemUpdate().ModifyFrame3();

				
			}
		});
		
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String member = dao.select2().toString();
				if(!"".equals(member)) {
				statis.setText("");
				statis.append(member);
				}
				
			}
		});

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
