/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import projetoaplicativoru.Conexao;
import projetoaplicativoru.Bolsista;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author julia_000
 */
public class BolsistaDAO {
    private Conexao con;
    private String alterarBolsistaSQL = "update \"bolsista\" set \"nome\"=?,\"email\"=?,\"cpf\"=?,\"login\"=?,\"senha\"=? where \"cpf\"=?";
    //ENVIAR CARDAPIO == JSON
    private String incluirCardapioSQL = "insert into \"cardapio\" values (?,?,?,?,?,?)";
    
    
    public BolsistaDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/BDAPPRU","postgres","postgres");
    }
    
    public void incluirCardapio(Cardapio c){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(incluirCardapioSQL);
            instrucao.setString(1, c.getLancheManha());
            instrucao.setString(2,c.getAlmoco());
            instrucao.setString(3,c.getLancheTarde());
            instrucao.setString(4, c.getJanta());
            instrucao.setString(5, c.getCeia());
            instrucao.setInt(6, c.getCp());
            instrucao.execute();
            con.desconectar();
            
            //enviarCardapio(c);
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
    
    public JSONObject enviarCardapio(Cardapio c){
        JSONObject my_obj = new JSONObject();
        try{
            my_obj.put("lanchemanha",c.getLancheManha());
            my_obj.put("almoco",c.getAlmoco());
            my_obj.put("lanchetarde",c.getLancheTarde());
            my_obj.put("janta",c.getJanta());
            my_obj.put("ceia", c.getCeia());
            my_obj.put("cp", c.getCp());
            
        }catch(Exception e){
            System.out.println("Erro no envio: "+e.getMessage());
        }
        return my_obj;
    }
    
    public void alterarBolsista(Bolsista b, String Antcpf){
         try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(alterarBolsistaSQL);
            instrucao.setString(1, b.getNome());
            instrucao.setString(2,b.getEmail());
            instrucao.setString(3, b.getCpf());
            instrucao.setString(4, b.getLogin());
            instrucao.setString(5, b.getSenha());
            instrucao.setString(6, Antcpf);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }
    
}
