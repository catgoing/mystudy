package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import thread.ClientThread;

public class MainclassTCPClient {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		/*
		 	1. 접속을 해야 할 Server 주소를 설정 - Socket
		 	2. 소켓 생성 
		 	3. 접속
		 	4. 데이터 송수신
		 	
		 */
		
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.0.131", 9000); // 1번 과정

		
		Socket socket = new Socket();	// 2번 과정
		
		try {
			socket.connect(sockAddr, 5000);		// 숫자는 대기시간, 1000이 1초, 5000은 5초까지 대기하겠다는 말
			
			InetAddress inetAddr;
			if((inetAddr = socket.getInetAddress()) != null) {
				System.out.println("접속 성공 " + inetAddr);
			} else {
				System.out.println("접속 실패");
			}
			
			// send
			String msg = "";
			
			new ClientThread(socket).start();	// 받는 게 우선이기 때문에 while 밖에 생성, 쓰레드에 자체적으로 while 생성
			
			while(true) {
				
				
				
				
				System.out.print("전송문자열:");
				msg = sc.next();
				
				// send
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println( msg );	// 실질적으로 전송
				pw.flush();
				
				
				
				// recv
//				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				msg = br.readLine();	// 실질적으로 받는 부분			
//				System.out.println("서버로부터 받은 메시지:" + msg);
			
			}
					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
