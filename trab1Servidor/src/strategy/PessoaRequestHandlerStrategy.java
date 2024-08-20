package strategy;

import dto.RequestDTO;
import model.Aluno;
import model.Pessoa;
import model.Professor;

import java.util.Map;

public class PessoaRequestHandlerStrategy implements RequestHandlerStrategy {

    private Map<String, Pessoa> pessoas;

    public PessoaRequestHandlerStrategy(Map<String, Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public String handleRequest(RequestDTO request) {
        switch (request.getOperacao()) {
            case "INSERT":
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
                        return "Não foram encontrados nenhum dos parâmetros obrigatórios (matricula ou salario)";
                    }
                }
                return "Dados inválidos para inserção";

            case "UPDATE":
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

            // Implementar os outros casos: GET, DELETE, LIST...
            default:
                return "Operação não reconhecida";
        }
    }

}
