import java.io.*;
import java.net.*;
import java.util.*;


public class DatagramServer extends Thread {

  private int PORT = 49999;
  private DatagramSocket socket = null;

  public void run() {

      System.out.println("Server is running!");

    try {
      socket = new DatagramSocket(PORT);
    } catch (SocketException se) {
      System.err.println("Couldn't open socket on port " + PORT);
    }

    System.out.println("Datagram server listening on port " + PORT);

    boolean isRunning = true;

    while (isRunning) {
      try {
	// receive request
	byte[] bufReceive = new byte[1024];
	DatagramPacket packet = new DatagramPacket(bufReceive, bufReceive.length);
	socket.receive(packet);
	String receiveMessage = new String(packet.getData(), 0, packet.getLength());
	System.out.println("Server received: " + receiveMessage);

	// send the response to the client
        Scanner myScanner = new Scanner(receiveMessage);
        myScanner.next();
        MyEvent.incoming = receiveMessage;
        MyEvent.incomingIntx = myScanner.nextInt();
        myScanner.close();
        MyEvent.received();

        try{
            Thread.sleep(10000);
        } catch (Exception e) {
        }

        //MyEvent.stopIt();

        ///send to someone else

	int port = packet.getPort();
	InetAddress address = packet.getAddress();
	String respondMessage = "Hello " + receiveMessage + " at " + address + ", I received your message on port " + port;
	byte[] bufSend = respondMessage.getBytes();

	packet = new DatagramPacket(bufSend, bufSend.length, address, port);
	socket.send(packet);
      } catch (IOException ioe) {
	System.err.println("Error! There was a problem in the server!");
	ioe.printStackTrace();
	isRunning = false;
      }
    }
    socket.close();
  }

  public static void main(String[] args) {
        new DatagramServer().start();
  }

}

