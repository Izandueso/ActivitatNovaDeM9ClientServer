import java.net.*;
import java.io.*;

public class ServidorTCP2 {
	
	public static void main (String[] args) throws Exception {
		
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
		String cadena2 = "";
		String cadena3 = "";
		
		System.out.println("Esperant connexió al client 1... ");
		Socket clientConnectat = servidor.accept();
		System.out.println("Client 1 connectat... ");
		
		System.out.println("Esperant connexió al client 2... ");
		Socket clientConnectat2 = servidor.accept();
		System.out.println("Client 2 connectat... ");
		
		System.out.println("Esperant connexió al client 3... ");
		Socket clientConnectat3 = servidor.accept();
		System.out.println("Client 3 connectat... ");
		
		//FLUX DE SORTIDA AL CLIENT
		PrintWriter fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);
		PrintWriter fsortida2 = new PrintWriter(clientConnectat2.getOutputStream(), true);
		PrintWriter fsortida3 = new PrintWriter(clientConnectat3.getOutputStream(), true);
		
		//FLUX D'ENTRADA DEL CLIENT
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));
		BufferedReader fentrada2 = new BufferedReader(new InputStreamReader(clientConnectat2.getInputStream()));
		BufferedReader fentrada3 = new BufferedReader(new InputStreamReader(clientConnectat3.getInputStream()));
		
		while ((cadena = fentrada.readLine()) != null) {
			
			fsortida.println(cadena);
			System.out.println("Rebent: "+cadena);
			if (cadena.equals("*")) break;
			
		}
		
		while ((cadena2 = fentrada2.readLine()) != null) {
			
			fsortida2.println(cadena2);
			System.out.println("Rebent: "+cadena2);
			if (cadena2.equals("*")) break;
			
		}

		while ((cadena3 = fentrada3.readLine()) != null) {
	
				fsortida3.println(cadena3);
				System.out.println("Rebent: "+cadena3);
				if (cadena3.equals("*")) break;
	
		}
		
		//TANCAR STREAMS I SOCKETS
		System.out.println("Tancant connexió... ");
		fentrada.close();
		fentrada2.close();
		fentrada3.close();
		fsortida.close();
		fsortida2.close();
		fsortida3.close();
		clientConnectat.close();
		clientConnectat2.close();
		clientConnectat3.close();
		servidor.close();
		
	}

}

