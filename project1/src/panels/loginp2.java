package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movieDAO.moviedao;
import movie_frame.Admin_MemManage;
import movie_frame.ModifyFrame;
import movie_frame.Admin_movieManage;
import movie_frame.TicketFrame2;
import movie_frame.Admin_movieStatis;
import view.mainView;
import view.signin1;

public class loginp2 {
    
    JButton loginbt, signupbt, logoutbt;
    JButton modibt, reserv, MemManage, Reservmanage;
    JLabel welcom;
    mainView mv;
    public static JPanel login2;
    
    public loginp2() {
       
    }
    
    public void loginp3() {
        login2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        login2.setBackground(Color.lightGray);
         welcom = new JLabel( signin1.ids + "님 환영합니다");
         login2.add(welcom);
         modibt = new JButton("내정보");
         modibt.addActionListener(new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ModifyFrame();

                }
            });
        
         // 여기서부터
         reserv = new JButton("예매확인");
         reserv.addActionListener(new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
                    moviedao md = new moviedao();
                    md.reservedmovie(signin1.ids);

                    if(md.VNAME == null) {
                        JOptionPane.showMessageDialog(null, "예매내역이 없습니다!");
                    } else {
                   
                        while(true) {
                        String[] answer = {"예매수정", "예매취소", "확인"};
                        int result = JOptionPane.showOptionDialog(null,
                            "예매번호: " + md.RNUM + "\n"
                                    + "영화제목: " + md.VNAME + "\n"
                                    + "상영일자: " + md.RDATE + "\n"
                                    + "상영시간: " + md.RTIME + "\n"
                                    + "좌석번호: " + md.RSIT, "예매확인", JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null, answer, answer[2]);

                       
                        if(result == 0) {
                            int mv = 0;
                            if(md.VNAME.equals("귀멸의 칼날: 무한열차편")) {
                                mv = 1;
                            } else if(md.VNAME.equals("원더우먼1984")) {
                                mv = 2;
                            }
                            new TicketFrame2(mv, signin1.ids);
                            break;
                           
                        } else if(result == 1) {
                            int cancel = JOptionPane.showConfirmDialog(null, "예매를 취소하시겠습니까?", "예매취소확인", JOptionPane.YES_NO_OPTION);
                            if(cancel == JOptionPane.YES_OPTION) {
                                md.cancelmovie(signin1.ids);
                                JOptionPane.showMessageDialog(null, "예매가 취소되었습니다.");   
                                break;
                            } else md.reservedmovie(signin1.ids);
                   
                        } else break;
                        }

                }
                   
                }
            });
        
         logoutbt = new JButton("로그아웃");
         logoutbt.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
         signin1.ids = null;
         loginp4();

         }
         });

         login2.add(modibt);
         login2.add(reserv);
         login2.add(logoutbt);

        
        
         mv.login.setVisible(false);
         mv.cont.remove(mv.login);
         mv.cont.add(login2, BorderLayout.NORTH); // 로그인 이후 상단패널 변경
         
       }
    

    public void loginp4() { // 로그인 이전 상단패널로 복구
        login2.setVisible(false);
        mv.cont.remove(login2);
        mv.cont.add(mv.login);
        mv.login.setVisible(true);
       

    }
    
    
      // Admin Login Panel
    public void loginp5() {
        login2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        login2.setBackground(Color.lightGray);
         welcom = new JLabel( signin1.ids + "님 환영합니다");
         login2.add(welcom);
         modibt = new JButton("내정보");
         modibt.addActionListener(new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ModifyFrame();

                }
            });
        
        
         reserv = new JButton("영화통계");
         reserv.addActionListener(new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Admin_movieStatis();
                }
            });
        
        
         MemManage = new JButton("회원관리");
         MemManage.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                new Admin_MemManage();
            }
        });
        
        Reservmanage = new JButton("예매관리");
        Reservmanage.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                new Admin_movieManage().ModifyFrame4();
            }
        });
       
         logoutbt = new JButton("로그아웃");
         logoutbt.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
         signin1.ids = null;
         loginp4();

         }
         });

         login2.add(modibt);
         login2.add(reserv);
         login2.add(MemManage);
         login2.add(Reservmanage);
         login2.add(logoutbt);
        
        
         mv.login.setVisible(false);
         mv.cont.remove(mv.login);
         mv.cont.add(login2, BorderLayout.NORTH); // 로그인 이후 상단패널 변경
         
       }               
 

    
}