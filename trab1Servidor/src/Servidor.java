import dto.RequestDTO;
import model.Curso;
import model.Pessoa;
import strategy.CursoRequestHandlerStrategy;
import strategy.PessoaRequestHandlerStrategy;
import strategy.RequestHandlerStrategy;

import java.net.*;
import java.io.*;
import java.util.*;
public class Servidor {
    private static Map<String, Pessoa> pessoas = new HashMap<>();
    private static List<Curso> cursos = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor iniciado na porta 5000...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("processando");
                    handleClient(clientSocket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) throws Exception {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String input = in.readLine();
            System.out.println(input);
            trataCamposObrigatorios(input);
            RequestDTO request = RequestDTO.fromString(input);

            RequestHandlerStrategy handler;
            if (request.getNomeCurso() != null || request.getOperacao().equalsIgnoreCase("listcurso")) {
                handler = new CursoRequestHandlerStrategy(cursos);
            } else {
                handler = new PessoaRequestHandlerStrategy(pessoas);
            }

            String response = handler.handleRequest(request);
            out.println(response);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private static void trataCamposObrigatorios(String input) throws Exception {
        if(!input.contains("operacao")) {
            throw new Exception("Operação é um campo obrigatório para processamento");
        }
    }
}
