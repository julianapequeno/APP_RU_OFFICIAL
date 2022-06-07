/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

/**
 *
 * @author Aluno
 */
public class AcessosAPP extends Pessoa {
    
    private Bolsista b;
    private Nutricionista n;

    public String getNomeacao() {
        return nomeacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setNomeacao(String nomeacao) {
        this.nomeacao = nomeacao;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Bolsista getB() {
        return b;
    }

    public void setB(Bolsista b) {
        this.b = b;
    }

    public Nutricionista getN() {
        return n;
    }

    public void setN(Nutricionista n) {
        this.n = n;
    }
           
    
}
