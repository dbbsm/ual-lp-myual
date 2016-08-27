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
public class Pergunta 
{
    private int id;
    private String nr_pergunta;
    private String pergunta;
    private int id_resposta;
    private String resposta;
    private String documento;

    public Pergunta() {
    }

    public Pergunta(String nr_pergunta, String pergunta) {
        this.nr_pergunta = nr_pergunta;
        this.pergunta = pergunta;
    }
    
     public Pergunta(int id, String nr_pergunta, String pergunta) {
        this.id=id;
        this.nr_pergunta = nr_pergunta;
        this.pergunta = pergunta;
    }
    
    public Pergunta(int id, String nr_pergunta, String pergunta,String resposta) {
        this.id=id;
        this.nr_pergunta = nr_pergunta;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }
    
    public Pergunta(int id, String nr_pergunta, String pergunta,int respostaid,String resposta) {
        this.id=id;
        this.nr_pergunta = nr_pergunta;
        this.pergunta = pergunta;
        this.id_resposta=respostaid;
        this.resposta = resposta;
    }
    
    public Pergunta(String nr_pergunta, String pergunta,String resposta) {
        this.nr_pergunta = nr_pergunta;
        this.pergunta = pergunta;
        this.resposta = resposta;
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
     * @return the pergunta
     */
    public String getPergunta() {
        return pergunta;
    }

    /**
     * @param pergunta the pergunta to set
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
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

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the id_resposta
     */
    public int getId_resposta() {
        return id_resposta;
    }

    /**
     * @param id_resposta the id_resposta to set
     */
    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

    
    
    
    
    
    
}
