/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.exceptions;

/**
 *
 * @author Diogo
 */
public class CustomGenericException extends RuntimeException {

	private String code;
	private String msg;

	

        public CustomGenericException(String errMsg) {
		this.msg = errMsg;
	}
        
	public CustomGenericException(String errCode, String errMsg) {
		this.code = errCode;
		this.msg = errMsg;
	}

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
