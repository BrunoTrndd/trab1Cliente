package model;

public class Professor extends Pessoa {

    private String salario;

    public Professor(String cpf, String nome, String endereco, String salario) {
        super(cpf, nome, endereco);
        this.salario = salario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "cpf='" + getCpf() + "', " +
                "nome='" + getNome() + "', " +
                "endereco='" + getEndereco() + "', " +
                "salario='" + salario + "'}";
    }

}
