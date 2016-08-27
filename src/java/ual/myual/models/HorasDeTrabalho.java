/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.models;

/**
 *
 * @author Diogo
 */
public class HorasDeTrabalho {
    
    private int horas_contacto;
    private int horas_consolidacao;
    private int horas_outras_actividades;

    public HorasDeTrabalho() {
    }

    public HorasDeTrabalho(int horas_contacto, int horas_consolidacao, int horas_outras_actividades) {
        this.horas_contacto = horas_contacto;
        this.horas_consolidacao = horas_consolidacao;
        this.horas_outras_actividades = horas_outras_actividades;
    }

    /**
     * @return the horas_contacto
     */
    public int getHoras_contacto() {
        return horas_contacto;
    }

    /**
     * @param horas_contacto the horas_contacto to set
     */
    public void setHoras_contacto(int horas_contacto) {
        this.horas_contacto = horas_contacto;
    }

    /**
     * @return the horas_consolidacao
     */
    public int getHoras_consolidacao() {
        return horas_consolidacao;
    }

    /**
     * @param horas_consolidacao the horas_consolidacao to set
     */
    public void setHoras_consolidacao(int horas_consolidacao) {
        this.horas_consolidacao = horas_consolidacao;
    }

    /**
     * @return the horas_outras_actividades
     */
    public int getHoras_outras_actividades() {
        return horas_outras_actividades;
    }

    /**
     * @param horas_outras_actividades the horas_outras_actividades to set
     */
    public void setHoras_outras_actividades(int horas_outras_actividades) {
        this.horas_outras_actividades = horas_outras_actividades;
    }
    
    
    
}
