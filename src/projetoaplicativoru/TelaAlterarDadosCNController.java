/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author julia_000
 */
public class TelaAlterarDadosCNController implements Initializable {

    /**
     * Initializes the controller class
     */
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
    private chefeNutricionista cN = new chefeNutricionista();
    
    public void dadosChefe(){
        cN = chefeDAO.visualizarChefe();
    }
    
    
    @FXML
    private Button voltar;
    
    @FXML
    private ImageView fundo;
    
    @FXML
    private ImageView fundoClaro;
    
    @FXML
    private ImageView iconeAdd;
    
    @FXML
    private Button enviarDados;
    
    @FXML
    private Label confirmaSenha;
    
    @FXML
    private ImageView fundoNome;
    
    @FXML
    private ImageView fundoMsg;
    
    @FXML
    private ImageView fundoCpf;
    
    @FXML
    private ImageView fundoLogin;
    
    @FXML
    private ImageView fundoSenha;
    
    @FXML
    private ImageView fundoConfirmar;
    
    @FXML
    private Label Titulo;
    
    @FXML
    private Button botao;
    
    @FXML
    public void EnviarRegistro() throws IOException{ //tá dando problema
        String antCPF;
        String s = new String();
        s = chefeDAO.visualizarChefe().getCpf();
        antCPF = s;
        //PROBLEMA NA ALTERÇÃO POR CAUSA DO ANTCPF
        String nome;
        nome = String.valueOf(this.Nome.getText());
        cN.setNome(nome);
        
        String email;
        email = String.valueOf(this.email.getText());
        cN.setEmail(email);  
        
        String CPF;
        CPF = String.valueOf(this.cpf.getText());
        cN.setCpf(CPF);
        
        String login;
        login = String.valueOf(this.login.getText());
        cN.setLogin(login);
        
        String senha;
        senha = String.valueOf(this.senha.getText());
        cN.setSenha(senha);

        if(conferirSenhas() == true){  
            chefeDAO.alterarDadosChefe(cN, antCPF); 

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DADOS ALTERADOS COM SUCESSO!");
            alert.setContentText("Seus dados foram atualizados com sucesso! Iremos deslogar a sua conta atual para que possamos validar o novo login e senha");
            alert.showAndWait();
            this.SAIR();
            //cN = null;
        }
        
        
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
             
    @FXML
    public boolean conferirSenhas(){
        String senha, conferidoSenha;
        conferidoSenha = String.valueOf(senhaConferir.getText());
        senha = String.valueOf(this.senha.getText());
        
        if(conferidoSenha.equals(senha)){
            return true;
        }else if(conferidoSenha.equals(senha) == false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Senhas não conferem!");
            alert.setContentText("As senhas não conferem! Digite novamente!");  
            alert.showAndWait();
            return false;
        }
        return true;
    }
    
    public void SAIR() throws IOException{
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("FXMLDocument.fxml"));
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();      
    }
    
    public void Voltar() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close(); 
                
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeCN.fxml")); 
            
            Parent par = root.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setScene(new Scene(par));
           
            stage.show();
    }
    
    @FXML
    private Label labelNome;
    
    @FXML
    private Label labelEmail;
        
    @FXML
    private Label labelCPF;
            
    @FXML
    private Label labelLogin;
                
    @FXML
    private Label labelSenha;
                    
    @FXML
    private Label labelConfirmaSenha;
    
    @FXML
    private ImageView fundoAzul2;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
