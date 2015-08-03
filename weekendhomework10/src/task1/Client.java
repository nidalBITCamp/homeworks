package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class present the client which send the path of file to server for
 * checking they are exists
 * 
 * @author Niddal.Salkic
 *
 */
public class Client {

	private static final int PORT = Server.PORT;

	public static void main(String[] args) {

		try {

			@SuppressWarnings("resource")
			Socket client = new Socket("localhost", PORT);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			while (true) {
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);

				System.out
						.println("Please insert the path of checking file...");
				writer.write(input.nextLine());
				writer.newLine();
				writer.flush();

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				System.out.println("1 - file exist, 0 - file dont exist\n" + reader.readLine());

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
