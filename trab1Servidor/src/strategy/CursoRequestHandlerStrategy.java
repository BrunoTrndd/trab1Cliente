package strategy;

import dto.RequestDTO;
import model.Curso;

import java.util.List;

public class CursoRequestHandlerStrategy implements RequestHandlerStrategy {

    private List<Curso> cursos;


    public CursoRequestHandlerStrategy(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String handleRequest(RequestDTO request) {
        switch (request.getOperacao()) {
            case "INSERT":
                if (request.getNomeCurso() != null && !request.getNomeCurso().isEmpty()) {
                    Curso curso = new Curso(request.getNomeCurso(), request.getSala());
                    cursos.add(curso);
                    return "Curso inserido com sucesso";
                }
                return "Dados inválidos para inserção de curso";

            // Implementar outros casos para Curso (como UPDATE, GET, DELETE, LIST) se necessário

            default:
                return "Operação não reconhecida";
        }
    }

}
