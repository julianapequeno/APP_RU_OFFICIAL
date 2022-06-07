package projetoaplicativoru;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author julia_000
 */
public class TelaHomeCNController implements Initializable {
    
    private chefeNutricionistaDAO chefeDAO;
   
     
    @FXML
    private ImageView wallpaper;
    
    @FXML
    private ImageView fundoAzul;
    
    @FXML
    private ImageView fundoAzul2;
    
    @FXML
    private Label Car;
    
    @FXML
    private MenuBar mB;
    
    @FXML
    private ImageView cardapio;
    
    @FXML
    private Button Incluir;
    
    @FXML
    private AnchorPane aP;
    
    @FXML
    private Text nomeCN;
    
    @FXML
    private MenuItem adicionarNutri;
    
    @FXML
    private MenuItem removeNutri;
    
    @FXML
    private MenuItem visualizarNutris;
    
    @FXML
    private Menu sair;
    
    @FXML
    private Button botao;
    
    @FXML
    private MenuItem VisuBol;
    
    @FXML
    private MenuItem RemoBol;
    
    @FXML
    private MenuItem AdicBol;
    
    @FXML
    private Menu QuemSomos;
    
    @FXML
    private Button incluir;
    
    @FXML
    private Button alterar;
    
    @FXML
    private Button excluir;
    
    @FXML
    private Button visualizar;
        
    @FXML
    private MenuItem AlterarDados;
    
    @FXML
    private BorderPane BP;
    
    @FXML
    private Pane top;
     
    @FXML
    private Pane bottom;
        
    @FXML
    private Pane esq;
        
    @FXML
    private Pane dir;
        
    @FXML
    private Pane centro;
    
    @FXML
    private ImageView BordaAzul;
    
    @FXML
    public void abrirVisualizarNutris() throws IOException{
         Stage stage1 = (Stage) botao.getScene().getWindow();
         stage1.close();       
        
        FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaVisualizarNutris.fxml"));
            
        Parent par = root.load();

        Stage stage = new Stage();
        stage.getIcons().add(new Image ("imagens/logo.jpeg"));
        stage.setResizable(false);
        stage.setScene(new Scene(par));
           
        stage.show();   
    }

    /**
     * Initializes the controller class.
     */
    
    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    public void abrirRegistrarN() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
            FXMLLoader root12    = new FXMLLoader(this.getClass().getResource("TelaRegistro.fxml"));
            
            Parent par = root12.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));
           
            stage.show();      
    }
    
    public void abrirRegistrarB() throws IOException{
        
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
    
    public void abrirVisualizarBolsistas() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close(); 
            
            FXMLLoader rootBol = new FXMLLoader(this.getClass().getResource("TelaVisualizarBols.fxml"));
            
            Parent par = rootBol.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene(par));

            stage.show();   
    }
    
    public void QuemSomos() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
            
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaQuemSomos.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();
            
    }
    
    public void AlterarDados() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaAlterarDadosCN.fxml"));
            
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
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaRegistrarCardapio.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();
    }
   
    
    public void ExcluirCardapio() throws IOException{
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaVisuCardapio.fxml"));
            
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
