import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Digite sua requisição para o servidor:");
            String request = scanner.nextLine().trim();
            // Aqui você coletaria as informações do usuário e formataria a mensagem
//            String request = "operacao: \"get\", cpf: \"12345678901\", nome: \"João2\", endereco: \"Rua A\", matricula: 1";
            out.println(request);

            String response = in.readLine();
            System.out.println("Resposta do servidor: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
