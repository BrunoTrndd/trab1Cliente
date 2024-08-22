import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String request = "";
        while (!request.equalsIgnoreCase("sair")) {
            try (Socket socket = new Socket("localhost", 5000);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("Digite sua requisição para o servidor ou digite sair para finalizar:");
                request = scanner.nextLine().trim();
                // operacao: get, cpf: 12345678901, nome: João2, endereco: Rua A, matricula: 1;

                if(request.equalsIgnoreCase("sair")) {
                    return;
                }
                out.println(request);
                String response;
                System.out.print("Resposta do servidor: ");
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
