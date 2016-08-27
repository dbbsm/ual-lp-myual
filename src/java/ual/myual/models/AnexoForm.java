/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.models;

import java.util.ArrayList;

/**
 *
 * @author Diogo
 */
public class AnexoForm {
    
    
    private int id;
    private User professor;
    
    private String cadeira;
    private int ano;
    
    private ArrayList<Pergunta> anexo;
    private Pergunta10 pergunta10;

    public AnexoForm() {
    }

    public AnexoForm(ArrayList<Pergunta> anexo) {
        this.anexo = anexo;
    }
    
    public AnexoForm(ArrayList<Pergunta> anexo, Pergunta10 p) {
        this.anexo = anexo;
        this.pergunta10=p;
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
    public String getCadeira() {
        return cadeira;
    }

    /**
     * @param cadeira the cadeira to set
     */
    public void setCadeira(String cadeira) {
        this.cadeira = cadeira;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
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
