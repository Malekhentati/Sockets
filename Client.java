package ClientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		int serverPort = 1234;
		// la premiere étape :
		System.out.println("je suis un client pas encore connecté");
		Socket s = new Socket("localhost",serverPort);
		System.out.println("je suis un client connecté");
		
		System.out.println("Génération de l'objet InputStream et OutputStream de la socket");
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		System.out.println("lire un nombre = ");

		try (Scanner scanner = new Scanner(System.in)) {
			int nb = scanner.nextInt();
			System.out.println("envoyer le nombre '"+nb+"' au serveur");

			os.write(nb);
			System.out.println("Attendre la réponse du serveur:");

			int rep = is.read();
			System.out.println("la valeur de "+nb+"*5 = "+rep);
		// la derniere etape : fermer socket
		}catch(IOException e) {}
		s.close();
	}
}
