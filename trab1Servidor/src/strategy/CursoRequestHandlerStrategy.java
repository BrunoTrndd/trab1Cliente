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
        switch (request.getOperacao().toLowerCase()) {
            case "insert":
                return inserirCurso(request);

            case "update":
                return atualizarCurso(request);

            case "get":
                return obterCurso(request);

            case "delete":
                return removerCurso(request);

            case "listcurso":
                return listarCursos();

            default:
                return "Operação não reconhecida";
        }
    }

    private String inserirCurso(RequestDTO request) {
        if (request.getNomeCurso() != null && !request.getNomeCurso().isEmpty()) {
            Curso curso = new Curso(request.getNomeCurso(), request.getSala());
            cursos.add(curso);
            return "Curso inserido com sucesso";
        }
        return "Dados inválidos para inserção de curso";
    }

    private String atualizarCurso(RequestDTO request) {
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equals(request.getNomeCurso())) {
                curso.setSala(request.getSala());
                return "Curso atualizado com sucesso";
            }
        }
        return "Curso não encontrado";
    }

    private String obterCurso(RequestDTO request) {
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equals(request.getNomeCurso())) {
                return curso.toString();
            }
        }
        return "Curso não encontrado";
    }

    private String removerCurso(RequestDTO request) {
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equals(request.getNomeCurso())) {
                cursos.remove(curso);
                return "Curso removido com sucesso";
            }
        }
        return "Curso não encontrado";
    }

    private String listarCursos() {
        if (cursos.isEmpty()) {
            return "Não há cursos";
        } else {
            StringBuilder lista = new StringBuilder();
            lista.append(String.format("%02d\n", cursos.size()));
            for (Curso c : cursos) {
                lista.append(c.toString()).append("\n");
            }
            return lista.toString();
        }
    }

}
