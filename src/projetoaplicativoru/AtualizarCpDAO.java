/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author julia_000
 */
public class AtualizarCpDAO {
    private Conexao con;
    private String inserir = "insert into \"atualizarcp\" values (?)";
    private String excluir = "delete from \"atualizarcp\"";
    private String retorna = "select * from \"atualizarcp\"";
    
    public AtualizarCpDAO(){
         con = new Conexao("jdbc:postgresql://localhost:5432/BDAPPRU","postgres","postgres"); 
    }
    
     public void incluirCp(AtualizarCp cp){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(inserir);
            instrucao.setInt(1,cp.getCp());
            instrucao.executeQuery();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
     
     public void excluirCp(){
        try{
            con.conectar();
            Statement instrucao = con.getConexao().createStatement();
            //instrucao.setInt(1, cp.getCp());
            instrucao.executeQuery(excluir);
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }
     
     public int visualizarCp(){
        AtualizarCp c = new AtualizarCp();
         try{
            con.conectar();
            Statement instrucao = con.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(retorna);
            if(rs.next()){
                c = new AtualizarCp(rs.getInt("cp"));
            }
            con.desconectar();
        }catch(Exception e){
                System.out.println("Erro no visualizarCp: "+e.getMessage());
        }
         
         System.out.println("VisualizarCPDAO: "+c.getCp());
        return c.getCp();
    }
}
//Morro Branco
//Siri Resort
//Mussulo
//Summervile