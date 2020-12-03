package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import view.ClientFrame;

public class ReadThread extends Thread {
	
	Socket socket;
	ClientFrame cf;
	
	public ReadThread(Socket socket, ClientFrame cf) {
		this.socket = socket;
		this.cf = cf;
	}

	@Override
	public void run() {
		
//		super.run();
		
		 
		try {
			
			while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
			if(str == null) {
				System.out.println("서버와의 연결이 원활하지 않습니다");
			}
			
			cf.textA.append(str + "\n");
			
			Thread.sleep(300);
			}
		} catch (Exception e) {		// exception 하나로 끝내고 싶을 때
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
