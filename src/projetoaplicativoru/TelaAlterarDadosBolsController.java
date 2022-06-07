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
public class TelaAlterarDadosBolsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
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
    //private ArrayList<Bolsista> lista;
    private Bolsista bAnt = new Bolsista();
    private BolsistaDAO bolDAO = new BolsistaDAO();
    private Bolsista b = new Bolsista();
    
    public void EnviarRegistro() throws IOException{
        bAnt = aP.visualizarAcessosBolsista();
        
        String nome = new String();
        nome = String.valueOf(this.Nome.getText());
        b.setNome(nome);
        
        String email = new String();
        email = String.valueOf(this.email.getText());
        b.setEmail(email);  
        
        String CPF = new String();
        CPF = String.valueOf(this.cpf.getText());
        b.setCpf(CPF);
        
        String login = new String();
        login = String.valueOf(this.login.getText());
        b.setLogin(login);
        
        
        String senha = new String();
        senha = String.valueOf(this.senha.getText());
        b.setSenha(senha);
        
       if(conferirLogin() == false && conferirSenhas() == true ){
           b.setNomeacao("Bolsista");
           
           bolDAO.alterarBolsista(b, bAnt.getCpf());
                   System.out.println("Nome novo: "+b.getNome());
                   System.out.println("AntCPF: "+bAnt.getCpf()); //NULL
           aP.excluirAcessoBolsista(bAnt);
           
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("DADOS ALTERADOS COM SUCESSO!");
           alert.setContentText("Seus dados foram atualizados com sucesso! Iremos deslogar a sua conta atual para que possamos validar o novo login e senha");
           alert.showAndWait();
           this.SAIR();
       }
        
        //EU ESTOU AQUII. É A MESMA COISA Q TU FEZ EM NUTRICIONISTA É SÓ COPIAR E COLAR 
       //VDC AMIGA, EU CONFIO EM VOCÊ!
        
        
        //PODE DAR PROBLEMA CASO MAIS DE UMA PESSOA ACESSE AO MESMO TEMPO
        
    }
    
    
    
    public boolean conferirLogin(){
        String Llogin;
        Llogin = String.valueOf(login.getText());
        
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
                
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeB.fxml")); 
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();
    }
    
    
        public void SAIR() throws IOException{
        
            aP.excluirAcessoBolsista(b); //como eu excluo o atual PELAMORDIDEUS JSUS ME AJUDA //BLZ, VAI EXCLUIR O PRIMEIRO
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
