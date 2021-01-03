package movie_frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movieDAO.moviedao;
import movieDAO.MemberVO;

public class JoinFrame extends JFrame {
   
   JPanel panel;
   JLabel label1, id1, password1, name1, phone1;
   public TextField idT, passwordT, nameT, phoneT;
   JButton okbtn, checkbtn;
   
   public JoinFrame() {
      
       setSize(500, 400);
       setLocation(750, 200);
       setTitle("회원가입");
       panel = new JPanel(null);
      
       label1 = new JLabel("JOIN");
       id1 = new JLabel("아이디 ");
       password1 = new JLabel("비밀번호 ");
       name1 = new JLabel("이름 ");
       phone1 = new JLabel("연락처 ");
       label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 40));
       label1.setForeground(Color.black);
       
       idT = new TextField();
       passwordT = new TextField();
       nameT = new TextField();
       phoneT = new TextField();
       
       okbtn = new JButton("확인"); 
       okbtn.setBounds(190, 270, 80, 30); 
       
       checkbtn = new JButton("중복확인");
       checkbtn.setBounds(320, 100, 90, 20);
       
       label1.setBounds(190, 10, 200, 80);  
       
       id1.setBounds(130, 100, 55, 18);
       name1.setBounds(130, 130, 55, 18);
       password1.setBounds(130, 160, 55, 18);
       phone1.setBounds(130, 190, 55, 18);
       
       idT.setBounds(190, 100, 120, 20);
       nameT.setBounds(190, 130, 120, 20);
       passwordT.setBounds(190, 160, 120, 20);
       phoneT.setBounds(190, 190, 120, 20);
       
       panel.add(label1);
       panel.add(id1);
       panel.add(password1);
       panel.add(name1);
       panel.add(phone1);
       panel.add(idT);
       panel.add(passwordT);
       panel.add(nameT);
       panel.add(phoneT);
       panel.add(okbtn);
       panel.add(checkbtn);
       
       setDefaultCloseOperation(JoinFrame.DISPOSE_ON_CLOSE);
       add(panel);
       
       
       okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String id = idT.getText();
               String name = nameT.getText();
               String password = passwordT.getText();
               String phone = phoneT.getText();
               
           	moviedao dao = new moviedao();
            String idt = idT.getText();


         
      
               if(id.isEmpty() || name.isEmpty() || password.isEmpty() || phone.isEmpty() ) {
                  JOptionPane.showMessageDialog( null, "정보를 모두 입력하세요", "error", JOptionPane.ERROR_MESSAGE );
               }else {
                   if(dao.loginid(idt) == true) {
                       JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "error", JOptionPane.ERROR_MESSAGE);
                       okbtn.setEnabled(false);}
                  
                   else {
                  JOptionPane.showMessageDialog( null, name + "님 가입을 축하드립니다!", "success", JOptionPane.INFORMATION_MESSAGE );
                  dao = new moviedao();
                  MemberVO vo = new MemberVO(id, name, password, phone);
                  dao.insert(vo);
                  dispose();
                   }
               }
            }
         });
       
         checkbtn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            moviedao dao = new moviedao();
               String id = idT.getText();
               if(dao.loginid(id) == true) {
                 JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "error", JOptionPane.ERROR_MESSAGE);
                 okbtn.setEnabled(false);
               } else {
                  JOptionPane.showMessageDialog( null, "사용 가능한 아이디입니다", "success", JOptionPane.INFORMATION_MESSAGE );
                  okbtn.setEnabled(true);
               }
            }
         });
         
         setVisible(true);
       

   }


}