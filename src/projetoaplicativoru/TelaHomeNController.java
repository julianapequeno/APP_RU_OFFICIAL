/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.KeyStroke;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaHomeNController implements Initializable {

    /**
     * Initializes the controller class.
     */
        
        private Cardapio c = new Cardapio();
        
        @FXML
        private Button botao;
        
        @FXML
        private MenuItem alterarDados;
        
        private AcessosAPPDAO aP = new AcessosAPPDAO();
        
    
    public void AlterarDados() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaAlterarDadosNutri.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();
    }
    
    private Nutricionista n = new Nutricionista();
    private String login = new String();
    
    public Nutricionista returnoBJETOaTUAL(){
            n = aP.visualizarNutricionista();
            /*
            listaNutris = aP.visualizarNutricionistas();
            for(int index = 0; index < listaNutris.size(); index++){
                System.out.println(listaNutris.get(index));
            }
            n = aP.visualizarNutricionistas().get(0);
                */
            return n;
    }
    
    
    public void SAIR() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            
            aP.excluirAcessoNutricionista(returnoBJETOaTUAL()); // CASO TENHA MAIS DE UMA PESSOA ACESSANDO, ELA IRA EXCLUIR O ACESSO DA OUTRA
            stage1.close();       
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("FXMLDocument.fxml"));
            
            Parent par = root.load();

            Stage stage = new Stage();
           // KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.,0);
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();      
    }
    
    public void QuemSomos() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
            
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaQuemSomosN.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();
            
    }
    
    public void IncluirCardapio() throws IOException{
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaRegistrarCardapioN.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();
    }
    
    public void VisualizarCardapios() throws IOException{
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaVisualizarCardapio.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();       
    }
    
        public void abrirVisualizarBolsistas() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();
            
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaVisualizarBolsN.fxml"));
            
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
