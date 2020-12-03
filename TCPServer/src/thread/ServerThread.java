package thread;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.IIOException;

public class ServerThread extends Thread{

	Socket clientSocket;
	List<Socket> list = new ArrayList<Socket>();

	public ServerThread(Socket clientSocket, List<Socket> list) {
		this.clientSocket = clientSocket;
		this.list = list;

	}

	@Override
	public void run() {
		super.run();

		try {
			while(true) {
				// receive
				BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String msg = br.readLine();  // 받는 부분
				System.out.println("클라이언트로부터 받은 메세지: " + msg);



				// send
				for (int i = 0; i < list.size(); i++) {
					Socket s = list.get(i);
					if(s != clientSocket) {
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					pw.println(msg);	// <- 전송되는 부분
					pw.flush();			// 절대 빠뜨리면 안 되는 부분
					}
				}
				
				Thread.sleep(500);
				
			}
		}catch (Exception e) {
			System.out.println("연결이 끊긴 IP: " + clientSocket.getInetAddress());
			list.remove(clientSocket);
			
			// 남은 클라이언트 확인
			for (Socket soc : list) {
				System.out.println("접속 중인 IP: " + soc.getInetAddress());
				
			}
			try {
				clientSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	}



}
