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
public class CV {
    
    private int id;
    private User professor;
    
    private ArrayList<Pergunta> questionario;

    public CV() {
        
        questionario = new ArrayList<Pergunta>();
    }

    public CV(int id, User professor, ArrayList<Pergunta> questionario) {
        this.id = id;
        this.professor = professor;
        this.questionario = questionario;
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
     * @return the questionario
     */
    public ArrayList<Pergunta> getQuestionario() {
        return questionario;
    }

    /**
     * @param questionario the questionario to set
     */
    public void setQuestionario(ArrayList<Pergunta> questionario) {
        this.questionario = questionario;
    }
    
}
