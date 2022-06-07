/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import projetoaplicativoru.Pessoa;

/**
 *
 * @author julia_000
 */
public class Nutricionista extends Pessoa {
    
    public Nutricionista(){
        
    }
    
    public Nutricionista(String n, String e, String c, String l, String s){
        this.nome = n;
        this.email =e;
        this.cpf = c;
        this.login = l;
        this.senha = s; 
        
    }
    
    public Nutricionista(String login, String s){ //para o Banco de Acessos
        this.login = login;
        this.senha = s;
        this.nomeacao = "Nutricionista";
    }
    
    public String getEmail(){
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeacao() {
        return nomeacao;
    }

    public void setNomeacao(String nomeacao) {
        this.nomeacao = nomeacao;
    }
    
    
    
    
    
}
