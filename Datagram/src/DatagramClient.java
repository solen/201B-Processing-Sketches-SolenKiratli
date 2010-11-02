
import java.io.*;
import java.net.*;
import java.util.*;

public class DatagramClient {

  private int PORT = 49997;
  private String ADDRESS = "192.168.1.110";
  private String MESSAGE = "8";

  private DatagramSocket socket = null;

  
  public DatagramClient(String sent) {

    MESSAGE = sent;
    try {
      sendMessage();
    } catch (IOException ioe) {
      System.err.println("Error! Couldn't send message to " + ADDRESS + " on port " + PORT);
    }
  }

  public void sendMessage() throws IOException
  {
    // create a datagram socket
    socket = new DatagramSocket();

    // send request
    byte[] bufSend = MESSAGE.trim().getBytes();
    InetAddress inetAddress = InetAddress.getByName(ADDRESS);
    DatagramPacket packet = new DatagramPacket(bufSend, bufSend.length, inetAddress, PORT);
    socket.send(packet);
/*
    // get response
    byte[] bufReceive = new byte[1024];
    packet = new DatagramPacket(bufReceive, bufReceive.length);
    socket.receive(packet);

    // display response
    String received = new String(packet.getData(), 0, packet.getLength());
    System.out.println(received);
*/
    socket.close();
  }
}

