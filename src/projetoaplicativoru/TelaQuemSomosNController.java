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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaQuemSomosNController implements Initializable {


    @FXML
    private ImageView ftPedro;
    
    @FXML
    private ImageView ftAndrelyne;
    
    @FXML
    private ImageView ftSuellen;
    
    @FXML
    private ImageView ftJuliana;
    
    @FXML
    private ImageView ftAdelino;
    
    @FXML
    private Text nomeJu;
    
    @FXML
    private Text nomePe;
    
    @FXML
    private Text nomeAn;
    
    @FXML
    private Text nomeSu;
    
    @FXML
    private Text nomeAde;
    
    @FXML
    private Text instaPe;
    
    @FXML
    private Text instaJu;
        
    @FXML
    private Text instaSu;
            
    @FXML
    private Text instaAde;
                
    @FXML
    private Text instaAndre;
    
    @FXML
    private Button voltar;
    
    @FXML
    private Button botao;
    
    
    @FXML
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
