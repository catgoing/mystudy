package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{

	Socket socket;
	
	public ClientThread(Socket socket) {
		this.socket = socket;

	}
	

	@Override
	public void run() {
		
		super.run();
		
		
		try {
			
			while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = br.readLine();
			System.out.println(/*"서버로부터 받은 메시지:" + */msg);
			
			
			Thread.sleep(300);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	

}
