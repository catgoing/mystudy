package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import panels.loginp2;

public class signin1 extends Frame implements WindowListener {
	
	
	final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "MEMTEST";
	final String PASSWORD = "memtest";
	String id;
	String MNAME, RTIME, RSIT;
	Date RDATE;
	int RNUM;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	TextField IDT;
	JPasswordField PASSWORDT;
	JButton signinbtn;
	JLabel label, idl, psl;
	mainView mv;
	String name;
	public static String ids, pws, names, phones;
	
	JButton loginbt, signupbt;
	JButton modibt, reserv;
	JLabel welcom;
	   
	public signin1() {
	
		
		 setLayout(null);
		   
	      IDT = new TextField();
	      PASSWORDT = new JPasswordField();
	     
	      String id = "아이디";
	      String ps = "비밀번호";
	      idl = new JLabel();
	      idl.setText(id);
	      psl = new JLabel();
	      psl.setText(ps);
	      
	      idl.setBounds(130, 100, 55, 18);
	      psl.setBounds(130, 135, 55, 20);

	      
	      IDT.setBounds(190, 100, 100, 20);
	      PASSWORDT.setBounds(190, 135, 100, 20);
	      
	      signinbtn = new JButton("로그인");
	      signinbtn.setBounds(165, 200, 90, 23);

	      signinbtn.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
      
	            ids = IDT.getText();
	            pws = PASSWORDT.getText();
	            	            		
	            boolean b = false;

	            try {
	    			//2. DB연결하고 Connection 객체 생성
	    			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
	    			
	    			//3. Statement 문 생성 및 실행(SQL문 - 쿼리문실행)
	    				    			
	    			String sql = ""
	    					+ "SELECT ID, NAME, PASSWORD, PHONE "
	    					+ "FROM MEMBER "
	    					+ "WHERE ID = ? "
	    					+ "AND PASSWORD = ?";
	    			
	    			pstmt = conn.prepareStatement(sql);
	    			
	    			// ?에 값을 매칭하기 위한 명령
	    			pstmt.setString(1, ids);
	    			pstmt.setString(2, pws);
	    			
	    			// sql문장 실행
	    			rs = pstmt.executeQuery();
	    			
	    			//4. 결과물에 대한 처리
	    			if(rs.next()) {
	    				b = true;
	    				name = rs.getString("NAME");
	    				names = name;
	    				phones = rs.getString("PHONE");
	    				
	    			} 
	    			else {
	    				ids = null;
	    				JOptionPane.showMessageDialog(null, "일치하는 회원정보가 없습니다.");
		
	    			}

	    			
		} catch (SQLException e2) {
			e2.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
			
		}
	        
            if(null == ids) {
	        	  
	          }
            else  if(!ids.equals("admin") && b == true) {  
	        	loginp2 lg = new loginp2();
		        lg.loginp3();
		        dispose();

	          }
	          else if (ids.equals("admin") && b == true) {
	        	  loginp2 lg = new loginp2();
	        	  lg.loginp5();
	        	  dispose();
	          } 
	            
	       	            
	         }
	      });
	   
	      
	      label = new JLabel("Login");
	      label.setBounds(170,30,130,50);
	      label.setOpaque(true);
		  label.setBackground(Color.white);
		  label.setForeground(Color.black);
		  label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 28));
	  
	   
	      
	      this.add(IDT);
	      this.add(PASSWORDT);

	      this.add(signinbtn);
	      this.add(label);
	      this.add(idl);
	      this.add(psl);
	      
	      
	      setSize(400,300);
	      setLocation(750, 200);
	      addWindowListener(this);
	      setVisible(true);
	     
	      
	      
	   }
	
	

	@Override
	   public void windowOpened(WindowEvent e) {
	      // TODO Auto-generated method stub
	      
	   }

	   @Override
	   public void windowClosing(WindowEvent e) {
	      // TODO Auto-generated method stub
	      dispose();
	   }

	   @Override
	   public void windowClosed(WindowEvent e) {
	      // TODO Auto-generated method stub
	      
	   }

	   @Override
	   public void windowIconified(WindowEvent e) {
	      // TODO Auto-generated method stub
	      
	   }

	   @Override
	   public void windowDeiconified(WindowEvent e) {
	      // TODO Auto-generated method stub
	      
	   }

	   @Override
	   public void windowActivated(WindowEvent e) {
	      // TODO Auto-generated method stub
	      
	   }

	   @Override
	   public void windowDeactivated(WindowEvent e) {
	      // TODO Auto-generated method stub
	      
	   }
	   
	   private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}