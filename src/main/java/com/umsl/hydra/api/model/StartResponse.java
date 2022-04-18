package com.umsl.hydra.api.model;

/**
 * StartResponse.java
 * model for message to be sent after a new game is
 * initiated
 */
public class StartResponse {
    private String _hashCode;

    public String getHashCode(){
        return _hashCode;
    }

    public void setHashCode(String code){
        _hashCode = code;
    }

}
