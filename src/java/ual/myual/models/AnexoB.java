/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Diogo
 */
public class AnexoB {
    
    private int id;
    private User professor;
    
    private UnidadeCurricular cadeira;
    private String ano;
    private String estado; //nao sei se vai ser preciso
    
    private ArrayList<Pergunta> anexo;
    private Pergunta10 pergunta10;
    
    public AnexoB() {
        
        anexo = new ArrayList<Pergunta>();
    }

    public AnexoB(int id, User professor, String ano, String estado, ArrayList<Pergunta> anexo) {
        this.id = id;
        this.professor = professor;
        this.ano = ano;
        this.estado = estado;
        this.anexo = anexo;
    }

   

    /**
     * @return the anexo
     */
    public ArrayList<Pergunta> getAnexo() {
        return anexo;
    }

    /**
     * @param anexo the anexo to set
     */
    public void setAnexo(ArrayList<Pergunta> anexo) {
        this.anexo = anexo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the professor
     */
    public User getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(User professor) {
        this.professor = professor;
    }

    /**
     * @return the cadeira
     */
    public UnidadeCurricular getCadeira() {
        return cadeira;
    }

    /**
     * @param cadeira the cadeira to set
     */
    public void setCadeira(UnidadeCurricular cadeira) {
        this.cadeira = cadeira;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the pergunta10
     */
    public Pergunta10 getPergunta10() {
        return pergunta10;
    }

    /**
     * @param pergunta10 the pergunta10 to set
     */
    public void setPergunta10(Pergunta10 pergunta10) {
        this.pergunta10 = pergunta10;
    }
    
    
}
