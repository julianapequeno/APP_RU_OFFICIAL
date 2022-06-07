/*}
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import projetoaplicativoru.OperacoesCardapio;
import projetoaplicativoru.Conexao;
import projetoaplicativoru.Nutricionista;
import projetoaplicativoru.Cardapio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.JSONObject;
import projetoaplicativoru.OperacoesCardapio;

/**
 *
 * @author julia_000
 */
public class NutricionistaDAO implements OperacoesCardapio{
    private Conexao con;
    private String alterarNutricionistaSQL = "update \"nutricionista\" set \"nome\"=?,\"email\"=?,\"cpf\"=?,\"login\"=?,\"senha\"=? where \"cpf\"=?";
    private String incluirCardapioSQL = "insert into \"cardapio\" values (?,?,?,?,?,?)";
    private String excluirCardapioSQL = "Delete * from \"cardapio\" where \"cp\"=?";
    private String alterarCardapioSQL = "update \"cardapio\" set \"lanchemanha\"=?, \"almoco\"=?, \"lanchetarde\"=?,\"janta\"=?,\"ceia\"=? where \"cp\"=?";
    private String visualizarCardapiosSQL = "select * from \"cardapio\"";
    private String visualizarBolsistaSQL = "select * from \"bolsista\"";
    //enviar CARDÁPIO == JSON
     
    public NutricionistaDAO(){
         con = new Conexao("jdbc:postgresql://localhost:5432/BDAPPRU","postgres","postgres"); 
    }
    
    public ArrayList<Cardapio> visualizarCardapios(){
        ArrayList<Cardapio> lista = new ArrayList<>();
        Cardapio n = null;
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visualizarCardapiosSQL);
            ResultSet rs = instrucao.executeQuery();
            while(rs.next()){
                n = new Cardapio(rs.getString("lanchemanha"), rs.getString("almoco"), rs.getString("lanchetarde"), rs.getString("janta"), rs.getString("lanchenoite"), rs.getInt("cp"));
                lista.add(n);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Bolsista> visualizarBolsistas(){
        ArrayList<Bolsista> lista = new ArrayList<>();
        Bolsista b = null;
         try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visualizarBolsistaSQL);
            ResultSet rs = instrucao.executeQuery();
            while(rs.next()){
                b = new Bolsista(rs.getString("nome"),rs.getString("email"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
                lista.add(b);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return lista;
    }
    
    
    public void alterarDados(Nutricionista n, String cpf){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(alterarNutricionistaSQL);
            instrucao.setString(1, n.getNome());
            instrucao.setString(2,n.getEmail());
            instrucao.setString(3, n.getCpf());
            instrucao.setString(4, n.getLogin());
            instrucao.setString(5, n.getSenha());
            instrucao.setString(6, cpf);
            instrucao.executeQuery();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração de dados do Nutricionista: "+e.getMessage());
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
    
    public void incluirCardapio(Cardapio c){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(incluirCardapioSQL);
            instrucao.setString(1,c.getLancheManha());
            instrucao.setString(2, c.getAlmoco());
            instrucao.setString(3, c.getLancheTarde());
            instrucao.setString(4, c.getJanta());
            instrucao.setString(5, c.getCeia());
            instrucao.setInt(6, c.getCp());
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
            instrucao.setString(1,c.getLancheManha());
            instrucao.setString(2, c.getAlmoco());
            instrucao.setString(3, c.getLancheTarde());
            instrucao.setString(4, c.getJanta());
            instrucao.setString(5, c.getCeia());
            instrucao.setInt(6, cp);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }
    
    
}
