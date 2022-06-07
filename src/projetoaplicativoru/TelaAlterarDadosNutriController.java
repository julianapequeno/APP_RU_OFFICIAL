/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaAlterarDadosNutriController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Nutricionista n = new Nutricionista();
    @FXML
    private Button botao;
        
    @FXML
    private Button voltar;
    
    @FXML
    private TextField Nome;

    @FXML
    private TextField email;
       
    @FXML
    private TextField cpf;
    
    @FXML
    private TextField login;
    
    @FXML
    private TextField senha;
    
    @FXML
    private TextField senhaConferir;
    
    @FXML
    private Button enviar;
    
    
    @FXML
    public boolean conferirSenhas(){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Senhas não conferem!");
        alert.setContentText("As senhas não conferem! Digite novamente!");
        
        String senha = new String(); 
        String conferidoSenha = new String();
        conferidoSenha = String.valueOf(this.senhaConferir.getText());
        senha = String.valueOf(this.senha.getText());
        
        if(conferidoSenha.equals(senha)){
            return true;
        }else if(!conferidoSenha.equals(senha)){
            alert.showAndWait();
            return false;
        }
        return true;
    }
    
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
    private AcessosAPPDAO aP = new AcessosAPPDAO();
    private ArrayList<Nutricionista> lista = new ArrayList<>();
    private Nutricionista nAnt = new Nutricionista();
    private NutricionistaDAO nutriDAO = new NutricionistaDAO();
    
    public void EnviarRegistro() throws IOException{
        //lista = aP.visualizarNutricionista();
        nAnt = aP.visualizarNutricionista();//1 PESSOA POR VEZ NA LISTA
        System.out.println("Nome: "+nAnt.getNome());   
        
        String nome = new String();
        nome = String.valueOf(this.Nome.getText());
        n.setNome(nome);
        
        String email = new String();
        email = String.valueOf(this.email.getText());
        n.setEmail(email);  
        
        String CPF = new String();
        CPF = String.valueOf(this.cpf.getText());
        n.setCpf(CPF);
        
        String login = new String(); 
        login = String.valueOf(this.login.getText());
        n.setLogin(login);
        
        if(conferirLogin() == false){  
            String senha = new String();
            senha = String.valueOf(this.senha.getText());
            n.setSenha(senha);
            if(conferirSenhas() == true){
                n.setNomeacao("Nutricionista");
                nutriDAO.alterarDados(n, nAnt.getCpf());
                aP.excluirAcessoNutricionista(nAnt);
                aP.acessoNutricionista(n);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("DADOS ALTERADOS COM SUCESSO!");
                alert.setContentText("Seus dados foram atualizados com sucesso! Iremos deslogar a sua conta atual para que possamos validar o novo login e senha");
                alert.showAndWait();
                this.SAIR();
            }
        }
        
        //PODE DAR PROBLEMA CASO MAIS DE UMA PESSOA ACESSE AO MESMO TEMPO
        
    }
    
     public void SAIR() throws IOException{
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
            aP.excluirAcessoNutricionista(n);
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("FXMLDocument.fxml"));
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();      
    }
        
    public boolean conferirLogin(){
        String Llogin = new String();
        Llogin = String.valueOf(this.login.getText());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Já existente!");
        alert.setContentText("Escolha outro nome de login!");        
        
        if(chefeDAO.logins(Llogin) == true){
            alert.showAndWait();
            return true;
        }
        return false;
    }
    
    public void Voltar() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close(); 
                
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeN.fxml")); 
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
