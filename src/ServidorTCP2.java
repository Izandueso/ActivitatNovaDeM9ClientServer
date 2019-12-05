import java.net.*;
import java.io.*;

public class ServidorTCP2 {
	
	public static void main (String[] args) throws Exception {
		
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
		
		Socket clientConnectat = null;
		
		for (int i = 0; i < 3; i++) {
		   	 System.out.println("Esperant connexió... ");
			 clientConnectat = servidor.accept();
			 System.out.println("Client connectat... ");
		}
		
		PrintWriter fsortida = null;
		
		for (int i = 0; i < 3; i++) {
			//FLUX DE SORTIDA AL CLIENT
			 fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);
		}
	
		BufferedReader fentrada = null;
		
		for (int i = 0; i < 3; i++) {
			//FLUX D'ENTRADA DEL CLIENT
			 fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));
		}
		
		while ((cadena = fentrada.readLine()) != null) {
			
			fsortida.println(cadena);
			System.out.println("Rebent: "+cadena);
			if (cadena.equals("*")) break;
			
		}
		
		//TANCAR STREAMS I SOCKETS
		System.out.println("Tancant connexió... ");
		fentrada.close();
		fsortida.close();
		clientConnectat.close();
		servidor.close();
		
	}

}
