//Buğra ÖZTÜRK 1621012032(SERVER)-FARUK PINAR 1621012064(CLIENT)
package example;

import java.net.*;
import java.io.*;
 
public class server {
	public static void main(String[] args) throws IOException {
 
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.err.println("I/O exception: " + e.getMessage());
			System.exit(1);
		}
		System.out.println("Sunucu baslatildi. Baglanti bekleniyor...");
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept(); 
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
 
		System.out.println(clientSocket.getLocalAddress() + " baglandi.");
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
 
		String inputLine, outputLine;
		System.out.println("İstemciden girdi bekleniyor...");
		while ((inputLine = in.readLine()) != null) { 
			System.out.println("istemciden gelen :" + inputLine);
			outputLine = inputLine.toUpperCase(); 
			out.println(outputLine); 
			if (outputLine.equals("DENEME")) 
				break;
		}
		System.out.println(clientSocket.getLocalSocketAddress()
				+ " baglantisi kesildi.");
		
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
