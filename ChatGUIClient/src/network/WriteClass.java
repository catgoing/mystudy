package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import view.ClientFrame;
import view.Id;

public class WriteClass {
	
	Socket socket;
	ClientFrame cf;
	
	String id;
	String msg;
	
	
	public WriteClass(ClientFrame cf) {
	
		this.cf = cf;
		this.socket = cf.socket;
		
	}
	
	public void sendMessage() {
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			// 첫 번째 전송(대화명 전송)
			if(cf.isFirst == true) {
				InetAddress iaddr = socket.getLocalAddress();	// 메인에서 생성한 소켓을 , 서버 주소 취득
				String ip = iaddr.getHostAddress();	// ip주소 출력
				
				id = Id.textF.getText();		// Id클래스에서 id(대화명) 취득, static으로 잡아놨기 때문에 클래스명.필드로 바로 접근 가능
				
				msg = "[" + id + "]님이 입장하였습니다(" + ip + ")";
				
				cf.setTitle("내 대화명: " + id);
				
			}
			// 두 번째 전송부터(채팅 전송)
			else {
				msg = "[" + id + "]: " + cf.textF.getText();
				
			}
			pw.println( msg );
			pw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
