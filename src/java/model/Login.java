/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author ellias
 */
public class Login {
    
    private final String email;
    private final String senha;
    private Integer key;
    private String nmUsuario;
    

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
        
    }
    
     public Login(String email, String senha, Integer key) {
        this.email = email;
        this.senha = senha;
        this.key=key;
        
    }

    public Login(String email, String senha, Integer key, String nmUsuario) {
        this.email = email;
        this.senha = senha;
        this.key = key;
        this.nmUsuario = nmUsuario;
    }
     
     

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
    
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }
    
    

    
    
    
    
}
