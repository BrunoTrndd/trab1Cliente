package dto;
public class RequestDTO {
    private String operacao;
    private String cpf;
    private String nome;
    private String endereco;
    private String matricula;
    private String salario;
    private String nomeCurso;
    private String sala;

    public RequestDTO(String operacao, String cpf, String nome, String endereco, String matricula, String salario, String nomeCurso, String sala) {
        this.operacao = operacao;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.matricula = matricula;
        this.salario = salario;
        this.nomeCurso = nomeCurso;
        this.sala = sala;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public static RequestDTO fromString(String input) {
        String[] parts = input.split(",");
        String operacao = null;
        String cpf = null;
        String nome = null;
        String endereco = null;
        String matricula = null;
        String salario = null;
        String nomeCurso = null;
        String sala = null;

        for (String part : parts) {
            String[] keyValue = part.split(":");
            String key = keyValue[0].trim().toLowerCase();
            String value = keyValue.length > 1 ? keyValue[1].trim() : null;

            switch (key) {
                case "operacao":
                    operacao = value;
                    break;
                case "cpf":
                    cpf = value;
                    break;
                case "nome":
                    nome = value;
                    break;
                case "endereco":
                    endereco = value;
                    break;
                case "matricula":
                    matricula = value;
                    break;
                case "salario":
                    salario = value;
                    break;
                case "nomecurso":
                    nomeCurso = value;
                    break;
                case "sala":
                    sala = value;
                    break;
                default:
                    // Campo desconhecido, ignorar ou lançar exceção dependendo do caso
                    break;
            }
        }

        return new RequestDTO(operacao, cpf, nome, endereco, matricula, salario, nomeCurso, sala);
    }
}
