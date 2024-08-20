package model;

import java.util.List;
import java.util.ArrayList;

public class Curso {
    private String nomeCurso;
    private String sala;
    private List<Pessoa> integrantes;

    public Curso(String nomeCurso, String sala) {
        this.nomeCurso = nomeCurso;
        this.sala = sala;
        this.integrantes = new ArrayList<>();
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

    public List<Pessoa> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Pessoa> integrantes) {
        this.integrantes = integrantes;
    }
}
