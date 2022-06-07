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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaHomeBController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Cardapio c = new Cardapio();
    private CardapioDAO cDAO = new CardapioDAO();
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
    
    
    @FXML
    private ImageView AzulEscuro;
    
    @FXML
    private ImageView AzulClaro;

    @FXML
    private ImageView AzulClaroDois;
       
    @FXML
    private ImageView BarraEscura;
            
    @FXML
    private ImageView ImageCardapio;
    
    @FXML
    private MenuBar menu;
    
    @FXML
    private Menu Home;
    
    @FXML
    private Menu QuemSomps;
    
    @FXML
    private Menu Sair;
    
    @FXML
    private MenuItem AlterarDados;
    
    @FXML
    private Label Titulo;
    
    @FXML
    private ImageView cardapioImage;
    
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
    private Button enviarCardapio;
    
    @FXML
    private Button botao;
    
    @FXML
    private Label BoasVindas;
    
    @FXML
    private Label NomePessoa;
    
    private AcessosAPPDAO acess = new AcessosAPPDAO();
    
    
    public void AlterarDados() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
        
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaAlterarDadosBols.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();
    }
    
    private Bolsista b = new Bolsista();
    private String login;
   // private ArrayList<Bolsista> listaBolsis = null;
    private AcessosAPPDAO aP = new AcessosAPPDAO();
    
    public Bolsista returnoBJETOaTUAL(){
            b = aP.visualizarAcessosBolsista();
            return b;
    }
    
        
    public void SAIR() throws IOException{
        
            acess.excluirAcessoBolsista(returnoBJETOaTUAL()); //como eu excluo o atual PELAMORDIDEUS JSUS ME AJUDA //BLZ, VAI EXCLUIR O PRIMEIRO
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
    
    public void QuemSomos() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();       
        
            
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaQuemSomosB.fxml"));
            
            Parent par = root.load();
            
            Stage stage = new Stage();
            stage.getIcons().add(new Image ("imagens/logo.jpeg"));
            stage.setResizable(false);
            stage.setScene(new Scene (par));
            
            stage.show();
            
    }
    
    public void enviarCardapio(){
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
        //this.Voltar();
        
    }
    
    public JSONObject enviarCardapioJSON(Cardapio c){
        JSONObject my_obj = new JSONObject();
        try{
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
