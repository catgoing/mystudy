package movieDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import movieDAO.MemberVO;
import movie_frame.Admin_movieManage;
import view.signin1;

public class moviedao {
	
	final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "MEMTEST";
	final String PASSWORD = "memtest";
	static public String id;
	public String VNAME, RTIME, RSIT;
	public Date RDATE;
	public int RNUM;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	signin1 sg;
	public MemberVO member;
	
	public moviedao() {
	
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		
	}
	
	
	// SeatFrame에서 moviename, movietime, seats를 받아와,
	// DB의 RESERV테이블에 id, 영화제목, 상영일자, 좌석번호, 상영시간, 예매번호 등록
	public void reservmovie(String moviename, String movietime, String seats, int price) {
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
				
			System.out.println("reservthis:" + this.id);
			
			String id = "";
			id = this.id;
			
			if("admin".equals(signin1.ids)) {
				id = this.id;
			} else	id = sg.ids;
			
			if(id != null) {
			
			System.out.println("reserv:" + id);
			
			String date = "20/12/31";
			int rnum = 0;
			rnum = (int)(Math.random() * 1000000) + 1;
			
			String sql = ""
					+ "INSERT INTO RESERV(RID, RNAME, RDATE, RSIT, RTIME, RNUM, RPRICE) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?) "
					;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, moviename);
			pstmt.setString(3, date);
			pstmt.setString(4, seats);
			pstmt.setString(5, movietime);
			pstmt.setInt(6, rnum);
			pstmt.setInt(7, price);
			
			
			
			pstmt.executeUpdate()
			;
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		
	}
	
	
	// SeatFrame2에서 moviename, movietime, seats를 받아와,
	// DB의 RESERV테이블에서 id, 영화제목, 상영시간이 일치하는 정보 좌석 번호만 수정
	public void updatemovie(String moviename, String movietime, String seats, int rnum) {
		String id = "";
		id = this.id;
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			if("admin".equals(signin1.ids)) {
				id = this.id;
			} else	id = sg.ids;
//			System.out.println("update: " + id);

			
			String sql = ""
					+ "UPDATE RESERV "
					+ "   SET RNAME = ?"
					+ "		, RTIME = ? "
					+ "     , RSIT = ? "
					+ "WHERE RNUM = ? "
					;
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, moviename);
			pstmt.setString(2, movietime);
			pstmt.setString(3, seats);
			pstmt.setInt(4, rnum);
			
			
			pstmt.executeUpdate()
			;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
	}
	
	
	
	// 예매한 영화 조회
	public void reservedmovie(String id) {
		
		this.id = id;
		
		System.out.println("reserved: " + this.id);
		
		
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			
			String sql = ""
					+ "SELECT R.RNUM, V.VNAME, R.RDATE, R.RTIME, R.RSIT "
					+ "FROM MEMBER M, MOVIE V, RESERV R "
					+ "WHERE R.RID = M.ID "
					+ "AND R.RNAME = V.VNAME "
					+ "AND M.ID = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				RNUM = rs.getInt("RNUM");
				VNAME = rs.getString("VNAME");
				RDATE = rs.getDate("RDATE");
				RTIME = rs.getString("RTIME");
				RSIT = rs.getString("RSIT");
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
	}
	
	public int reservedmovieRNUM(String id) {
		
		this.id = id;
		
		System.out.println("reserved: " + this.id);
		
		
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			
			String sql = ""
					+ "SELECT R.RNUM, V.VNAME, R.RDATE, R.RTIME, R.RSIT "
					+ "FROM MEMBER M, MOVIE V, RESERV R "
					+ "WHERE R.RID = M.ID "
					+ "AND R.RNAME = V.VNAME "
					+ "AND M.ID = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				RNUM = rs.getInt("RNUM");
				VNAME = rs.getString("VNAME");
				RDATE = rs.getDate("RDATE");
				RTIME = rs.getString("RTIME");
				RSIT = rs.getString("RSIT");
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		} 
		System.out.println(RNUM);
		return RNUM;
		
	}
	
	
	// 내가 예매한 영화 취소
	public void cancelmovie(String id) {
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
		
			String sql = ""
					+ "DELETE RESERV "
					+ "WHERE RNUM = ? "
					;
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, RNUM);
			
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
	}
	
	
	
	// SeatFrame, SeatFrame2에서 moviename, movietime를 받고, 
	// 같은 영화, 같은 시간대 예매된 좌석을 DB의 RESETV 테이블에서  하나의 ROW로 얻어내어,
	// 좌석번호를 String RSIT으로 얻어내서 리턴
	public String reservedSeat(String moviename, String movietime) {
		
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			
			String sql = ""
					+ "SELECT LISTAGG(RSIT,',') WITHIN GROUP (ORDER BY RNAME) RSIT "
					+ "FROM RESERV  "
					+ "WHERE RNAME = ? "
					+ "AND RTIME = ?"
					;
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, moviename);
			pstmt.setString(2, movietime);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				RSIT = rs.getString("RSIT");
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		} return RSIT;
		
	}
	
	public String reservedSeatId(String id) {
		
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			
			String sql = ""
					+ "SELECT LISTAGG(RSIT,',') WITHIN GROUP (ORDER BY RID) RSIT "
					+ "FROM RESERV  "
					+ "WHERE RID = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				RSIT = rs.getString("RSIT");
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		} return RSIT;
		
	}
	
	public String moviestatisAud(String moviename) {
		
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			
			String sql = ""
					+ "SELECT LISTAGG(RSIT,',') WITHIN GROUP (ORDER BY RNAME) RSIT "
					+ "FROM RESERV  "
					+ "WHERE RNAME = ? "
					;
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, moviename);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				RSIT = rs.getString("RSIT");
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		} return RSIT;
		
	}
	
	public String moviestatisSales(String moviename) {
		String sales = "";
		
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			
			String sql = ""
					+ "SELECT NVL(TO_CHAR(SUM(RPRICE), '999,999,999,999'), 0) AS SALES "
					+ "FROM RESERV  "
					+ "WHERE RNAME = ? "
					;
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, moviename);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sales = rs.getString("SALES");
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		} return sales;
		
	}
	
	
	
	// SeatFrame2에서 moviename, movietime 받고, 
	// 내가 예매한 좌석을 DB에서 String RSIT으로 얻어내서 리턴
	public String reservedSeat2(String moviename, String movietime, String id) {
		
		this.id = id;
		try {
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			if("admin".equals(signin1.ids)) {
				id = this.id;
			} else id = sg.ids;	
			
			System.out.println("reservedSeat2: " + id);
			
			String sql = ""
					+ "SELECT LISTAGG(RSIT,',') WITHIN GROUP (ORDER BY RNAME) RSIT "
					+ "FROM RESERV  "
					+ "WHERE RNAME = ? "
					+ "AND RTIME = ?"
					+ "AND RID = ?"
					;
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, moviename);
			pstmt.setString(2, movietime);
			pstmt.setString(3, id);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				RSIT = rs.getString("RSIT");
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		} return RSIT;
		
	}
	
	   public MemberVO select(String id) {
	      	      
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         

	         String sql = ""
	               + "SELECT ID, NAME, PASSWORD, PHONE "
	               + "  FROM MEMBER"
	               + " WHERE ID = ? ";
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, id);  
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {  
	            member = new MemberVO();  
	            member.setId(rs.getString("ID"));
	            member.setName(rs.getString("NAME"));
	            member.setPassword(rs.getString("PASSWORD"));
	            member.setPhone(rs.getString("PHONE"));
	            
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt, rs);
	      }
//	      System.out.println(member);
	      return member;
	   }
	   
		public StringBuilder select2() {
   	      	StringBuilder sb = new StringBuilder();
		      try {
		         conn = DriverManager.getConnection(URL, USER, PASSWORD);
		         

		         String sql = ""
		               + "SELECT ID, NAME, PASSWORD, PHONE "
		               + "  FROM MEMBER";
		         
		         pstmt = conn.prepareStatement(sql);
		         		         
		         rs = pstmt.executeQuery();
		         
		         while(rs.next()) {  
		            member = new MemberVO();  
		            member.setId(rs.getString("ID"));
		            member.setName(rs.getString("NAME"));
		            member.setPassword(rs.getString("PASSWORD"));
		            member.setPhone(rs.getString("PHONE"));
		            sb.append(member.toString());
//		            
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(conn, pstmt, rs);
		      }
		      
		      return sb;
		   }
		

		public String select3(String id) {
			StringBuilder sb = new StringBuilder();
		    try {
		       conn = DriverManager.getConnection(URL, USER, PASSWORD);
		       
		
		       String sql = ""
		             + "SELECT ID, NAME, PASSWORD, PHONE "
		             + "  FROM MEMBER"
		             + " WHERE ID = ? ";
		       
		       pstmt = conn.prepareStatement(sql);
		       
		       pstmt.setString(1, id);  
		       
		       rs = pstmt.executeQuery();
		       
		       if(rs.next()) {  
		          member = new MemberVO();  
		          member.setId(rs.getString("ID"));
		          member.setName(rs.getString("NAME"));
		          member.setPassword(rs.getString("PASSWORD"));
		          member.setPhone(rs.getString("PHONE"));
		          sb.append(member.toString());
		          
		       }
		       
		    } catch (SQLException e) {
		       e.printStackTrace();
		    } finally {
		       close(conn, pstmt, rs);
		    }
		    return sb.toString();
		 }


	   
	   public ArrayList<MemberVO> selectAll() {
	      ArrayList<MemberVO> list = null;
	      
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	     
	         String sql = ""
	               + "SELECT ID, NAME, PASSWORD, PHONE "
	               + "  FROM MEMBER"
	               + " ORDER BY ID";

	         pstmt = conn.prepareStatement(sql);   
	         rs = pstmt.executeQuery(); 
	         
	         list = new ArrayList<MemberVO>(); 
	         
	         while(rs.next()) { 
	            MemberVO member = new MemberVO( 
	                  rs.getString("ID"),  
	                  rs.getString("NAME"),
	                  rs.getString("PASSWORD"),
	                  rs.getString("PHONE"));

	            list.add(member); 
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt, rs);
	      }
	      
	      return list;
	   }
	   
	  
	   public int insert(MemberVO member) {  
	      int result = 0;
	      
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         String sql = ""
	               + "INSERT INTO MEMBER "
	               + "       (ID, NAME, PASSWORD, PHONE) "
	               + "VALUES (?, ?, ?, ?)";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, member.getId());
	         pstmt.setString(2, member.getName());
	         pstmt.setString(3, member.getPassword());
	         pstmt.setString(4, member.getPhone());
	         
	         result =  pstmt.executeUpdate(); 
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt, rs);
	      }
	      
	      return result;
	   }
	   
	   
	   public boolean login(String id, String password) {
	      boolean result = false;
	      MemberVO vo = new MemberVO();
	      
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         String sql = ""
	               + "SELECT PASSWORD "
	               + "    FROM MEMBER "
	               + " WHERE ID = ?";
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            if(rs.getString(1).equals(password)) {
	               System.out.println("로그인 성공!");
	               vo = select(id);
	               System.out.println(vo.toString());
	               result = true;
	            } else {
	               System.out.println("비밀번호가 일치하지 않습니다.");
	               result = false;
	            }
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt, rs);
	      }
	      return result;
	   }
	   
	  // 중복 아이디 확인 코드
	   public boolean loginid(String id) {
	      boolean result = false;
	      
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         String sql = ""
	               + "SELECT ID "
	               + "    FROM MEMBER "
	               + "WHERE ID = '" + id + "'";
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         rs = pstmt.executeQuery();
	         
	         if(rs.next() == false)
	         {
	            return false;
	         }
	         else
	         {
	            return true;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt, rs);
	      }
	      return result;
	   }
	   
	   
	   
	   public int update(MemberVO member) {
	      int result = 0;
	      
	      try {
	         	         
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         StringBuilder sb = new StringBuilder();
	         sb.append("UPDATE MEMBER ");
	         sb.append("   SET NAME = ? ");
	         sb.append("     , PASSWORD = ? ");
	         sb.append("     , PHONE = ? ");
	         sb.append(" WHERE ID = ? ");
	         

	         pstmt = conn.prepareStatement(sb.toString());
	         pstmt.setString(1, member.getName());
	         pstmt.setString(2, member.getPassword());
	         pstmt.setString(3, member.getPhone());
	         pstmt.setString(4, member.getId());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt);
	      }
	      
	      return result;
	   }
	   

	   public int delete(String id) {
	      int result = 0;
	      
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         String sql = "DELETE FROM MEMBER WHERE ID = ? ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt);
	      }
	      
	      return result;
	   }
	   
		private void close(Connection conn, PreparedStatement pstmt) {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
