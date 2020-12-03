package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import thread.ServerThread;

public class MainclassTCPServer {

	public static void main(String[] args) {
		/*
			TCP:	Transmission Control Protocol
					전송				제어		통신규약
					
			TCP server
			Web server
			DB server
			
			종단 system:	host(PC, 프린터, 스마트폰, 스캐너 등)
			Router
			
			inter network:	포괄적 통신망
			
			Protocol
			- TCP:	Transmission Control Protocol
					신사적인 프로토콜
					전화와 비슷함. 상대방과 연결이 되어야 통신 시작
					데이터의 경계가 없다 = 크기에 한계가 없다
					1 대 1 연결식
					채팅은 무조건 TCP, 게임 내 채팅도 모두 포함
					
			- UDP:	User Datagram Protocol
					비연결형
					편지, 지상파방송과 비슷한 개념
					데이터의 경계가 있다
					1:1			유니캐스트
					1:n		브로드캐스트
					n:n	멀티캐스트
					
			7 layer
			1 - 물리
			2 - 
			3. 네트워크
			4. 트렌스포트
			5. 세션
			6. 프리젠테이션
			7. 애플리케이션
			
			packet
			제어정보, 데이터 등이 결합된 형태로 전송되는 실제의 데이터
			TCP/UDP, IP, Port, String, Object
			
	 		IP: Internet Protocol
	 		IPv4:	0~255 4개 값
	 		IPv6:  	16진수 6개 값
	 		
	 		127.0.0.1은 무조건 자기자신의 IP로 접속됨
			
			Port Number
			IP 주소는 internet에 존재하는 host를 식별할 수 있으나 최종 주체인
			process를 식별하지 못 하기 때문에 프로세스를 구별하기 위해 지정된 수 (0 ~ 1024:sys)
			
			Socket		유닉스(file(write, read()
			통신을 하기 위한 주체(Object)
			IP, Port, TCP/UDP
			
			통신순서
			
			Server						Client
					1. Socket 버전 확인
					2. Socket 생성
			3. IP, Port 설정(binding)		
			4. listen
			5. accept	<------------	3. connect
							접속
			6. Packet(데이터) 송수신
			receive						send
			send						receive
			
			
		 */
		
		Socket clientSocket = null;
		
		List<Socket> list = new ArrayList<Socket>();
		
		try {
			// 문지기소켓
			ServerSocket servSocket = new ServerSocket(9000);
			// IP, Port, binding, listen
			
			
			while(true) {
			System.out.println("접속 대기 중...");
			clientSocket = servSocket.accept();  //  여기까지가 server 5번까지
			
			list.add(clientSocket);
			/*
			 	clientSocket: 접속된 소켓의 정보를 담는 Socket, (= 담당자 소켓)
			 */
			
			System.out.println("접속된 클라이언트의 정보: IP = " + clientSocket.getInetAddress()
								+ " Port = " + clientSocket.getPort());
			
			new ServerThread(clientSocket, list).start();
			
			
//			// receive
//			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//			String msg = br.readLine();  // 받는 부분
//			System.out.println("클라이언트로부터 받은 메세지: " + msg);
//			
//			
//		
//			// send
//			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
//			pw.println(msg);	// <- 전송되는 부분
//			pw.flush();			// 절대 빠뜨리면 안 되는 부분
			
			
			}
		
			// br.close();  이걸 넣으면 통신이 끊어짐
		
//			clientSocke.close();
//			servSocket.close();
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
