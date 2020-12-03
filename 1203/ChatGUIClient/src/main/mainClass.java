package main;

import java.net.Socket;

import network.ReadThread;
import view.ClientFrame;
import view.Id;

public class mainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		new Id(null, null);
		
//		new ClientFrame(null);
		
		Socket socket = new Socket("192.168.0.131", 9000);
//		Socket socket = new Socket("192.168.0.131", 9000);
		
		System.out.println("Connected");
		
		ClientFrame cf = new ClientFrame(socket);
		
		new ReadThread(socket, cf).start();
				
		
		

	}

}

