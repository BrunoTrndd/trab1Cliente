package factory;

import model.Curso;

public class CursoFactory {

    public static Curso create(String nomeCurso, String sala) {
        return new Curso(nomeCurso, sala);
    }

}
