/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.models.jsp;

import java.util.ArrayList;
import ual.myual.models.Pergunta;

/**
 *
 * @author Diogo
 */
public class CVForm {
    
    private ArrayList<Pergunta> questionario;

    public CVForm() {
    }

    public CVForm(ArrayList<Pergunta> questionario) {
        this.questionario = questionario;
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
