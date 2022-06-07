/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Aluno
 */
public class FXMLDocumentController implements Initializable {
    
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
    
    
    @FXML
    private Button botao;
    
    @FXML
    private ImageView fundo;

    @FXML
    private ImageView Pessoa;
    
    @FXML
    private ImageView chave;
    
    @FXML 
    private ImageView icone;
    @FXML
    private AnchorPane ap;
    @FXML
    private ImageView fundoAzul;
    
    @FXML
    private TextField login;
    
    @FXML 
    private PasswordField senha;
    
    @FXML
    private BorderPane bp;
    
    @FXML
    private Pane pn;
    
    @FXML
    private Button entrar;
    
    public Bolsista B = new Bolsista();
    private Nutricionista N = new Nutricionista();
    private AcessosAPPDAO acess = new AcessosAPPDAO();
    
    

    @FXML
    private void confere() throws IOException{
        String login;
        String senha;
        senha = String.valueOf(this.senha.getText());
        login = String.valueOf(this.login.getText());
        
        
        ArrayList<Bolsista> bolsista = new ArrayList<>();
        ArrayList<Nutricionista> nutri = new ArrayList<>();
        
        chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
        bolsista = chefeDAO.visualizarBolsistas();
        nutri = chefeDAO.visualizarNutricionistas();
        System.out.println(login);
        System.out.println("OPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        
        System.out.println(senha);
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("MENSAGEM DE ERRO");
        alert.setHeaderText("LOGIN INCORRETO");
        alert.setContentText("Por favor, digite novamente o seu login, o mesmo não está cadastrado em nosso banco de dados");
        
        if(chefeDAO.logins(login) == true && chefeDAO.senhas(senha) == true){
            //conferir se é chefe, nutricionista ou bolsista
            
            for(int i = 0; i < bolsista.size(); i++){
                if(bolsista.get(i).getLogin().equals(login)){
                    //É BOLSISTAA
                    System.out.println("É BOLSISTA");
                    B = bolsista.get(i); 
                    B.setNomeacao("Bolsista");
                    acess.acessoBolsista(B);
                    
                    abrirTelaHomeB();
                }
            }
            for(int i= 0; i < nutri.size(); i++){
                if(nutri.get(i).getLogin().equals(login) ){
                    //É NUTRICIONISTA
                    System.out.println("É NUTRICIONISTA");
                    N = nutri.get(i);
                    N.setNomeacao("Nutricionista");
                    acess.acessoNutricionista(N);
                    abrirTelaHomeN();
                }
            }
                     
            chefeNutricionista lista;
            lista = chefeDAO.visualizarChefe();
            
            if(chefeDAO.visualizarLoginChefe().equals(login) ){
                    //É CHEFE
                    System.out.println("É CHEFE");
                    abrirTelaHomeCN();
            }
            
            
      }else if(chefeDAO.logins(login) == false && chefeDAO.senhas(senha) == true){
            alert.showAndWait();
            System.out.println("LOGIN FALSE");
        }else if(chefeDAO.logins(login) == true && chefeDAO.senhas(senha) == false){
            alert.showAndWait();
            System.out.println("SENHA FALSE");
        }else if(chefeDAO.logins(login) == false && chefeDAO.senhas(senha) == false){
           alert.showAndWait();
            System.out.println("SENHA E LOGIN FALSE");
        }

        System.out.println("FINAL");
    }
    
    
    public Bolsista getBolAtual(){
        return B;
    }
    
   
    
    public void abrirTelaHomeCN() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();
            
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeCN.fxml"));
            
            Parent par = root.load();
                    
            Stage stag1 = new Stage();
            stag1.getIcons().add(new Image ("imagens/logo.jpeg"));
            stag1.setResizable(false);
            stag1.setScene(new Scene(par));
           
            stag1.show();     
           // fecharTela.getScene().getWindow(); FECHAR
            
    }
    
    
    public void abrirTelaHomeN() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeN.fxml"));
            
            Parent par = root.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();      
            
            // fecharTela.getScene().getWindow(); FECHAR
    }
    
    public void abrirTelaHomeB() throws IOException{
            
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(chefeDAO.visualizarChefe().getLogin());
        acess.excluirAcessoBolsista(null);
        acess.excluirAcessoNutricionista(null);
    }    
    
}
