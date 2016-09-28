package edu.ucdenver.cse.GRIDclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import edu.ucdenver.cse.GRID.GRIDroute.*;

public class GRIDclient extends Thread {

	private Socket socket = null;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;
	private boolean isConnected = false;
	
	private GRIDrouteRequest myRequest;
	private GRIDroute myRoute;
	
	public GRIDclient() {
		
	}
	
	public void communicate() {

		myRequest = new GRIDrouteRequest("TEST_ID", "1to2", "24to25");
				
		while (!isConnected) {
			try {
				
				// Make this configurable
				socket = new Socket("localHost", 10007);
				System.out.println("Connected");
				isConnected = true;
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				
				System.out.println("Object to be written = " + myRoute.);
				outputStream.writeObject(student);

			} catch (SocketException se) {
				se.printStackTrace();
				// System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		GRIDclient client = new GRIDclient();
		client.communicate();
	}
}
