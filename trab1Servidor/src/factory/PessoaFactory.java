package factory;

import dto.RequestDTO;
import model.Aluno;
import model.Pessoa;
import model.Professor;

public class PessoaFactory {

    public static Pessoa createAluno(String cpf, String nome, String endereco, String matricula) {
        return new Aluno(cpf, nome, endereco, matricula);
    }

    public static Pessoa createProfessor(String cpf, String nome, String endereco, String salario) {
        return new Professor(cpf, nome, endereco, salario);
    }

}
