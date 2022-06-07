/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import projetoaplicativoru.Conexao;
import projetoaplicativoru.Cardapio;
import java.sql.PreparedStatement;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author julia_000
 */
public class CardapioDAO {
    private Conexao con;
    private String incluirCardapioSQL = "insert into \"cardapio\" values (?,?,?,?,?,?)";
    private String excluirCardapioSQL = "Delete * from \"cardapio\" where \"cp\"=?";
    private String alterarCardapioSQL = "update \"cardapio\" set \"cp\"=?,\"lanchemanha\"=?, \"almoco\"=?, \"lanchetarde\"=?,\"janta\"=?,\"ceia\"=? where \"cp\"=?";
    
    public CardapioDAO(){
        con = new Conexao("jdbc:postgresql://localhost:5432/BDAPPRU","postgres","postgres");
    }
    
    public JSONObject enviarCardapio(Cardapio c){
        JSONObject my_obj = new JSONObject();
        try{
           // my_obj.put("cafe", c.getCafe());
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
    
    public void incluirCardapio(Cardapio c){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(incluirCardapioSQL);
            instrucao.setString(1,c.getLancheManha());
            instrucao.setString(2, c.getAlmoco());
            instrucao.setString(3, c.getLancheTarde());
            instrucao.setString(4, c.getJanta());
            instrucao.setString(5, c.getCeia());
            Random r = new Random();
            instrucao.setInt(6, r.nextInt()*10);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
    
    public void excluirCardapio(int cp){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(excluirCardapioSQL);
            instrucao.setInt(1, cp);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }
    
    public void alteraCardapio(Cardapio c, int cp){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(alterarCardapioSQL);
            instrucao.setInt(1,c.getCp());
            instrucao.setString(2,c.getLancheManha());
            instrucao.setString(3, c.getAlmoco());
            instrucao.setString(4, c.getLancheTarde());
            instrucao.setString(5, c.getJanta());
            instrucao.setString(6, c.getCeia());
            instrucao.setInt(7, cp);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }
    
    
    
    
}
