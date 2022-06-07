/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import projetoaplicativoru.Bolsista;
import projetoaplicativoru.Nutricionista;
import projetoaplicativoru.Cardapio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONObject;
import projetoaplicativoru.Conexao;
import projetoaplicativoru.OperacoesCardapio;
import projetoaplicativoru.OperacoesCardapio;

/**
 *
 * @author julia_000
 */
public class chefeNutricionistaDAO implements OperacoesCardapio {

    private Conexao con;
    private String incluirNutricionistaSQL = "insert into \"nutricionista\" values (?,?,?,?,?,?) ";
    private String excluirNutricionistaSQL = "delete from \"nutricionista\" where \"cpf\"=?";
    private String incluirBolsistaSQL = "insert into \"bolsista\" values (?,?,?,?,?,?)";
    private String excluirBolsistaSQL = "delete from \"bolsista\" where \"cpf\"=?";
    private String visualizarNutricionistasSQL = "select * from \"nutricionista\"";
    private String visualizarBolsistasSQL = "select * from \"bolsista\"";
    
    private String alterarDadosChefeSQL = "Update \"chefenutricionista\" set \"nome\"=?, \"email\"=? , \"cpf\"=? , \"login\"=? , \"senha\"=? where \"cpf\"=?";
    private String visualizarDadosChefeSQL = "select * from \"chefenutricionista\" ";
    
    private String incluirCardapioSQL = "insert into \"cardapio\" values (?,?,?,?,?,?)";
    private String excluirCardapioSQL = "delete from \"cardapio\" where \"cp\"=?";
    private String alterarCardapioSQL = "update \"cardapio\" set \"lanchemanha\"=?, \"almoco\"=?, \"lanchetarde\"=?,\"janta\"=?, \"ceia\"=? where \"cp\"=?";
    private String visualizarCardapiosSQL = "select * from \"cardapio\"";
    //enviar cardápio == JSON
    
    //SÓ TÁ RETORNANDO O DO CHEFE E O DO NUTRICIONISTA SÓ
    private String retornarLoginSQL = "SELECT login FROM chefenutricionista UNION SELECT login FROM nutricionista UNION SELECT login FROM bolsista";
    private String retornarSenhaSQL = "SELECT senha FROM chefenutricionista UNION SELECT senha FROM nutricionista UNION SELECT senha FROM bolsista";
    
    public chefeNutricionistaDAO(){
         con = new Conexao("jdbc:postgresql://localhost:5432/BDAPPRU","postgres","postgres"); 
    }
    
    public ArrayList<Cardapio> visualizarCardapios(){
        ArrayList<Cardapio> lista = new ArrayList<>();
        Cardapio c = new Cardapio();
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visualizarCardapiosSQL);
            ResultSet rs = instrucao.executeQuery();
            while(rs.next()){
                c = new Cardapio(rs.getString("lanchemanha"), rs.getString("almoco"), rs.getString("lanchetarde"), rs.getString("janta"), rs.getString("ceia"), rs.getInt("cp"));
                lista.add(c);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return lista;
    }
    
    
    public void incluirNutricionista(Nutricionista n){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(incluirNutricionistaSQL);
            instrucao.setString(1, n.getNome());
            instrucao.setString(2,n.getEmail());
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

    
    public void excluirNutricionistaSQL(String Antcpf){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(excluirNutricionistaSQL);
            instrucao.setString(1, Antcpf);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }
    
    public ArrayList<Nutricionista> visualizarNutricionistas(){
        ArrayList<Nutricionista> lista = new ArrayList<>();
        Nutricionista n = null;
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visualizarNutricionistasSQL);
            ResultSet rs = instrucao.executeQuery();
            while(rs.next()){
                n = new Nutricionista(rs.getString("nome"),rs.getString("email"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
                lista.add(n);
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no relatório: "+e.getMessage());
        }
        return lista;
    }
    
    public void incluirBolsista (Bolsista p){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(incluirBolsistaSQL);
            instrucao.setString(1, p.getNome());
            instrucao.setString(2, p.getEmail());
            instrucao.setString(3, p.getCpf());
            instrucao.setString(4, p.getLogin());
            instrucao.setString(5, p.getSenha());
            instrucao.setString(6, p.getNomeacao());
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
    
    
    public void excluirBolsista(String Antcpf){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(excluirBolsistaSQL);
            instrucao.setString(1, Antcpf);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }
    
    public ArrayList<Bolsista> visualizarBolsistas(){
        ArrayList<Bolsista> lista = new ArrayList<>();
        Bolsista b = new Bolsista();
         try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visualizarBolsistasSQL);
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
    
    public chefeNutricionista visualizarChefe(){
        chefeNutricionista c = null;
         try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visualizarDadosChefeSQL);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                c = new chefeNutricionista(rs.getString("nome"),rs.getString("email"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no visualizarChefe: "+e.getMessage());
        }
        return c;
    }
    
    public String visualizarLoginChefe(){
         chefeNutricionista c = new chefeNutricionista();
         String login = "";
         try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(visualizarDadosChefeSQL);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                c = new chefeNutricionista(rs.getString("nome"),rs.getString("email"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
                //login = rs.getString("login");
            }
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no visualizarChefe: "+e.getMessage());
        }
         login = String.valueOf(c.getLogin());
        return login;
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
            instrucao.setString(1, c.getLancheManha());
            instrucao.setString(2,c.getAlmoco());
            instrucao.setString(3,c.getLancheTarde());
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
            instrucao.executeQuery();
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
            instrucao.setString(5,c.getCeia());
            instrucao.setInt(6, cp);
            instrucao.executeQuery();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }
    
    public void alterarDadosChefe(chefeNutricionista n, String Antcpf){
        try{
            con.conectar();
            PreparedStatement instrucao = con.getConexao().prepareStatement(alterarDadosChefeSQL);
            instrucao.setString(1, n.getNome());
            instrucao.setString(2,n.getEmail());
            instrucao.setString(3, n.getCpf());
            instrucao.setString(4, n.getLogin());
            instrucao.setString(5, n.getSenha());
            instrucao.setString(6, Antcpf);
            instrucao.executeQuery();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração dos Dados do Chefe: "+e.getMessage());
        }
    }
    
   
    public boolean logins(String login){
        ArrayList<String> logins = new ArrayList<>();
        String l = new String();
        
        System.out.println("Teste logins");
        try{
            con.conectar();
            System.out.println("conectou");
            Statement instrucao = con.getConexao().createStatement();
            //instrucao.setString(1,login);
            ResultSet rs = instrucao.executeQuery(retornarLoginSQL);
            System.out.println("string");
            while(rs.next()){
                l = rs.getString("login"); 
                //System.out.println(l+" logins");
               // System.out.println("adicionou");
                logins.add(l);
                //ESTÁ ADD AO ARRAY
               // System.out.println(logins.get(i));
               // i++;
            }
            
            for(int i = 0; i < logins.size(); i++){
                if(logins.get(i).equals(login)){
                    System.out.println("TRUE");
                    return true;
                }
            }   
            System.out.println("desconectou");
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro no loginsBoolean: "+e.getMessage());
        }
        return false;
    }
    
    public boolean senhas(String Senha){
        ArrayList<String> senhas = new ArrayList<>();
        String s = new String();
        try{
            con.conectar();
             System.out.println("conectou");
            Statement instrucao = con.getConexao().createStatement();
            //instrucao.setString(1,login);
            ResultSet rs = instrucao.executeQuery(retornarSenhaSQL);
            System.out.println("string");
            while(rs.next()){
                s = rs.getString("senha");
               // System.out.println(s);
                senhas.add(s);
            }
            
            for(int i = 0; i < senhas.size(); i++){
                if(senhas.get(i).equalsIgnoreCase(Senha)){
                    return true;
                }
            }
                    
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na senhaBoolean: "+e.getMessage());
        }
        return false;
    }
    
}
