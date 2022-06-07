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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author julia_000
 */
public class TelaRegistroBController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO() ;
    //private Nutricionista n = new Nutricionista();
    private Bolsista b = new Bolsista();
    
    @FXML
    private ImageView walpaper;
    
    @FXML
    private ImageView plane;
    
    @FXML
    private ImageView plane1;
    
    @FXML
    private Button voltar;
    
    @FXML
    private Label Titulo;
    
    @FXML
    private ImageView fundo;
    
    @FXML 
    private ImageView fundo2;
    
    @FXML
    private ImageView wallpaper;
    
    @FXML
    private Button botao;
    
    @FXML
    public void Voltar() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close(); 
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeCN.fxml"));
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();
    }
   
    
    @FXML
    private MenuItem Nutricionista;
    
    @FXML
    private MenuItem Bolsista;
    
    public void mudaRegistroN() throws IOException{
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close(); 
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaRegistro.fxml"));
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();
    }
    
    
    public void mudaRegistroB() throws IOException{
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close(); 
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaRegistroB.fxml"));
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();
    }
    
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
    
    /**
     *
     * @return
     * @throws IOException
     */
    
    public void EnviarRegistroB() throws IOException{      
        this.setNomeB();
        this.setEmailB();
        this.setCPFB();
        this.setLoginB();
        this.setSenhaB();
        if(conferirLogin() == false && conferirSenhas() == true){
            b.setNomeacao("Bolsista");
            chefeDAO.incluirBolsista(b);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bolsista Adicionado com Sucesso!");
            alert.setContentText("Agora "+b.getNome()+" tem acesso ao menu do bolsista!"); 
            alert.showAndWait();
            this.Voltar();
        }
            
    }
    
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
    
    
    public boolean conferirLogin(){
        String Llogin = new String();
        Llogin = String.valueOf(this.login.getText());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Já existente!");
        alert.setContentText("Escolha outro nome de login!");        
        
        if(chefeDAO.logins(Llogin)){
            alert.showAndWait();
            return true;
        }
        
        return false;
        
    }
    
  
    @FXML
    public void setNomeB(){
       String nome = new String();
       nome = String.valueOf(this.Nome.getText());
       b.setNome(nome);
    }
    
    @FXML
    public void setEmailB(){
        String email = new String();
        email = String.valueOf(this.email.getText());
        b.setEmail(email);
    }
    
    @FXML
    public void setCPFB(){
        String CPF = new String();
        CPF = String.valueOf(this.cpf.getText());
        b.setCpf(CPF);
    }
    
    @FXML
    public void setLoginB(){
        String login = new String();
        login = String.valueOf(this.login.getText());
        b.setLogin(login);
        //conferirLogin();
    }
    
    @FXML
    public void setSenhaB(){
        String senha = new String();
        senha = String.valueOf(this.senha.getText());
        b.setSenha(senha);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
