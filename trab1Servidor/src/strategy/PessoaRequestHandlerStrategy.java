package strategy;

import dto.RequestDTO;
import model.Aluno;
import model.Pessoa;
import model.Professor;

import java.util.Map;

public class PessoaRequestHandlerStrategy implements RequestHandlerStrategy {

    private final Map<String, Pessoa> pessoas;

    public PessoaRequestHandlerStrategy(Map<String, Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public String handleRequest(RequestDTO request) {
        System.out.println(request.getOperacao());
        switch (request.getOperacao().toLowerCase()) {
            case "insert":
                return inserirPessoa(request);

            case "update":
                return atualizarPessoa(request);

            case "get":
                return obterPessoa(request);

            case "delete":
                return removerPessoa(request);

            case "listpessoa":
                return listarPessoas();

            default:
                return "Operação não reconhecida";
        }
    }

    private String inserirPessoa(RequestDTO request) {
        if (request.getCpf() != null && !request.getCpf().isEmpty()) {
            if (request.getMatricula() != null) {
                Aluno aluno = new Aluno(request.getCpf(), request.getNome(), request.getEndereco(), request.getMatricula());
                pessoas.put(request.getCpf(), aluno);
                return "Aluno inserido com sucesso";
            } else if (request.getSalario() != null) {
                Professor professor = new Professor(request.getCpf(), request.getNome(), request.getEndereco(), request.getSalario());
                pessoas.put(request.getCpf(), professor);
                return "Professor inserido com sucesso";
            } else {
                return "Dados obrigatórios para inserção não localizados(matricula ou salario)";
            }
        }
        return "Dados inválidos para inserção";
    }

    private String atualizarPessoa(RequestDTO request) {
        Pessoa pessoa = pessoas.get(request.getCpf());
        if (pessoa != null) {
            pessoa.setNome(request.getNome());
            pessoa.setEndereco(request.getEndereco());
            if (pessoa instanceof Aluno && request.getMatricula() != null) {
                ((Aluno) pessoa).setMatricula(request.getMatricula());
            } else if (pessoa instanceof Professor && request.getSalario() != null) {
                ((Professor) pessoa).setSalario(request.getSalario());
            }
            return "Pessoa atualizada com sucesso";
        }
        return "Pessoa não encontrada";
    }

    private String obterPessoa(RequestDTO request) {
        Pessoa pessoa = pessoas.get(request.getCpf());
        if (pessoa != null) {
            return pessoa.toString();
        }
        return "Pessoa não encontrada";
    }

    private String removerPessoa(RequestDTO request) {
        Pessoa pessoaRemovida = pessoas.remove(request.getCpf());
        if (pessoaRemovida != null) {
            return "Pessoa removida com sucesso";
        }
        return "Pessoa não encontrada";
    }

    private String listarPessoas() {
        if (pessoas.isEmpty()) {
            return "Não há pessoas";
        } else {
            StringBuilder lista = new StringBuilder();
            lista.append(String.format("%02d\n", pessoas.size()));
            for (Pessoa p : pessoas.values()) {
                lista.append(p.toString()).append("\n");
            }
            return lista.toString();
        }
    }

}
