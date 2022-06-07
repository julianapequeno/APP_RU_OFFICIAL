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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaRegistrarCardapioNController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Cardapio c = new Cardapio();
    
    private CardapioDAO cDAO = new CardapioDAO();
    
    @FXML
    private TextArea lancheM;
    
    @FXML
    private TextArea Almoco;   
    
    @FXML
    private TextArea lancheT;
    
    @FXML
    private TextArea Janta;
    
    @FXML
    private TextArea Ceia;
    
    @FXML
    private Button enviar;
    
    @FXML
    private Button voltar;
    
    @FXML
    private Button botao;
    
    public void enviarCardapio() throws IOException{
        c.setLancheManha(String.valueOf(lancheM.getText()));
        c.setAlmoco(String.valueOf(Almoco.getText()));
        c.setLancheTarde(String.valueOf(lancheT.getText()));
        c.setJanta(String.valueOf(Janta.getText()));
        c.setCeia(String.valueOf(Ceia.getText()));
        cDAO.incluirCardapio(c);
        enviarCardapioJSON(c);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CARDÁPIO ENVIADO");
        alert.setHeaderText("Cardápio enviado com Sucesso!");
        alert.setContentText("Confira o cardápio do dia no aplicativo do APP RU no seu celular!");
        alert.showAndWait();
        this.Voltar();
    }
    
    
    public JSONObject enviarCardapioJSON(Cardapio c){
        JSONObject my_obj = new JSONObject();
        try{
           // my_obj.put("cafe", c.getCafe());
            my_obj.put("lanchemanha",c.getLancheManha());
            my_obj.put("almoco",c.getAlmoco());
            my_obj.put("lanchetarde",c.getLancheTarde());
            my_obj.put("janta",c.getJanta());
            my_obj.put("ceia", c.getCeia());
            
        }catch(Exception e){
            System.out.println("Erro no envio: "+e.getMessage());
        }
            return my_obj;
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
