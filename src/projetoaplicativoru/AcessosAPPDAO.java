/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class AcessosAPPDAO {
    private Conexao con;
    private String AcessoNutri = "insert into \"acessosapp\" values (?,?,?,?,?,?)";
    private String AcessoBolsista = "insert into \"acessosapp\" values (?,?,?,?,?,?)";
    private String visuAcessosBolsistas = "select * from \"acessosapp\" where \"nomecao\"=?";
    private String visuAcessosNutricionistas = "select * from \"acessosapp\" where \"nomecao\"=?";
    private String excluirBolsista = "delete from \"acessosapp\""; //Só pode acessar um de cada vez
    private String excluirNutricionista = "delete from \"acessosapp\" "; //Só pode acessar um de cada vez
    private String retornaTabela = "select * from \"acessosapp\" ";
    
    public AcessosAPPDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/BDAPPRU","postgres","postgres");
    }
    
    public void acessoNutricionista(Nutricionista n){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(AcessoNutri);
            instrucao.setString(1, n.getNome());
            instrucao.setString(2, n.getEmail());
            instrucao.setString(3, n.getCpf());
            instrucao.setString(4, n.getLogin());
            instrucao.setString(5, n.getSenha());
            instrucao.setString(6, n.getNomeacao());
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
    
    public void acessoBolsista(Bolsista b){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(AcessoBolsista);
            instrucao.setString(1, b.getNome());
            instrucao.setString(2, b.getEmail());
            instrucao.setString(3, b.getCpf());
            instrucao.setString(4, b.getLogin());
            instrucao.setString(5, b.getSenha());
            instrucao.setString(6, b.getNomeacao());
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
    
    public void excluirAcessoBolsista(Bolsista b){
         try{
            con.conectar();
            Statement instrucao = con.getConexao().createStatement();
            //instrucao.setString(1, b.getCpf());
            instrucao.executeQuery(excluirBolsista);
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão do bolsista: "+e.getMessage());
        }       
    }
    
    public void excluirAcessoNutricionista(Nutricionista n){
         try{
            con.conectar();
            Statement instrucao = con.getConexao().createStatement();
            //instrucao.setString(1, n.getCpf());
            //Qualquer coisa, por segurança, exclui tudo:
            //delete from nutricionista;
            instrucao.executeQuery(excluirNutricionista);
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão do nutricionista: "+e.getMessage());
        }       
    }
    
    
    
    public Bolsista visualizarAcessosBolsista(){
        //ArrayList<Bolsista> lista = new ArrayList<>();
        Bolsista b = new Bolsista();
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visuAcessosBolsistas);
            instrucao.setString(1, "Bolsista");
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                b = new Bolsista(rs.getString("nome"),rs.getString("email"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
                //lista.add(b);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return b;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    //EM PRODUÇÃO

    //////////////////////////////////////////////////////////////////////////////
    
    public Nutricionista visualizarNutricionista(){
       //ArrayList<Nutricionista> lista = new ArrayList<>();
        Nutricionista n = null;
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visuAcessosNutricionistas);
            instrucao.setString(1, "Nutricionista");
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                n = new Nutricionista(rs.getString("nome"),rs.getString("email"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
                //lista.add(n);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return n;       
    }
    
}
