import java.net.*;
import java.io.*;

public class Cliente {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Aqui você coletaria as informações do usuário e formataria a mensagem
            String request = "{ operacao: \"INSERT\", cpf: \"12345678901\", nome: \"João\", endereco: \"Rua A\" }";
            out.println(request);

            String response = in.readLine();
            System.out.println("Resposta do servidor: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
