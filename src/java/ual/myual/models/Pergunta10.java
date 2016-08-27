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
public class Pergunta10 {
    
    private int id;
    private String nr_pergunta;
    private ArrayList<Integer> nr_semana;
    private ArrayList<Integer> nr_sessao;
    private ArrayList<String> conteudo_programatico;
    
    private ArrayList<HorasDeTrabalho> horas_de_trabalho;
    
    private ArrayList<String> descricao_outras_actividades;

    public Pergunta10() 
    {
        nr_semana = new ArrayList<Integer>();
        nr_sessao = new ArrayList<Integer>();
        conteudo_programatico = new ArrayList<String>();
        horas_de_trabalho = new ArrayList<HorasDeTrabalho>();
        descricao_outras_actividades = new ArrayList<String>();
    }

    /**
     * @return the id_anexo
     */
    public int getId() {
        return id;
    }

    /**
     * @param id_anexo the id_anexo to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nr_semana
     */
    public ArrayList<Integer> getNr_semana() {
        return nr_semana;
    }

    /**
     * @param nr_semana the nr_semana to set
     */
    public void setNr_semana(ArrayList<Integer> nr_semana) {
        this.nr_semana = nr_semana;
    }

    /**
     * @return the nr_sessao
     */
    public ArrayList<Integer> getNr_sessao() {
        return nr_sessao;
    }

    /**
     * @param nr_sessao the nr_sessao to set
     */
    public void setNr_sessao(ArrayList<Integer> nr_sessao) {
        this.nr_sessao = nr_sessao;
    }

    /**
     * @return the conteudo_programatico
     */
    public ArrayList<String> getConteudo_programatico() {
        return conteudo_programatico;
    }

    /**
     * @param conteudo_programatico the conteudo_programatico to set
     */
    public void setConteudo_programatico(ArrayList<String> conteudo_programatico) {
        this.conteudo_programatico = conteudo_programatico;
    }

    /**
     * @return the horas_de_trabalho
     */
    public ArrayList<HorasDeTrabalho> getHoras_de_trabalho() {
        return horas_de_trabalho;
    }

    /**
     * @param horas_de_trabalho the horas_de_trabalho to set
     */
    public void setHoras_de_trabalho(ArrayList<HorasDeTrabalho> horas_de_trabalho) {
        this.horas_de_trabalho = horas_de_trabalho;
    }

    /**
     * @return the descricao_outras_actividades
     */
    public ArrayList<String> getDescricao_outras_actividades() {
        return descricao_outras_actividades;
    }

    /**
     * @param descricao_outras_actividades the descricao_outras_actividades to set
     */
    public void setDescricao_outras_actividades(ArrayList<String> descricao_outras_actividades) {
        this.descricao_outras_actividades = descricao_outras_actividades;
    }

    /**
     * @return the nr_pergunta
     */
    public String getNr_pergunta() {
        return nr_pergunta;
    }

    /**
     * @param nr_pergunta the nr_pergunta to set
     */
    public void setNr_pergunta(String nr_pergunta) {
        this.nr_pergunta = nr_pergunta;
    }
    
    
    
    
}
