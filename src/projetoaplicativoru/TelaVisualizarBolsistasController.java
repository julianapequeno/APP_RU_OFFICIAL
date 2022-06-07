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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaVisualizarBolsistasController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @FXML
    private Button voltar;
    
    @FXML
    private Label titulo;
    
    
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
   
    @FXML
    private Label nomeCN;
    
    @FXML
    private MenuItem adicionarNutri;
    
    @FXML
    private MenuItem removeNutri;
    
    @FXML
    private MenuItem visualizarNutris;
    
    @FXML
    private Menu sair;
    
    @FXML
    private MenuItem VisuBol;
    
    @FXML
    private MenuItem RemoBol;
    
    @FXML
    private MenuItem AdicBol;
    
    @FXML
    private Menu QuemSomos;
    
    @FXML
    private MenuItem AlterarDados;
    
    @FXML
    private Button botao;
    
    @FXML
    private TableView tabela;
    
    private AcessosAPPDAO acessDAO = new AcessosAPPDAO();
    
    @FXML
    private TextField cpfAPAGAR;
    
    public void Voltar() throws IOException{
            
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();
            
            
            if(acessDAO.visualizarNutricionista() != null){
                    FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeN.fxml"));   
                    Parent par = root.load();
                    Stage stage = new Stage();
                    stage.getIcons().add(new Image ("imagens/logo.jpeg"));
                    stage.setResizable(false);
                    stage.setScene(new Scene(par));
                    stage.show();
            }else {
                    FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeCN.fxml"));               
                    Parent par = root.load();
                    Stage stage = new Stage();
                    stage.getIcons().add(new Image ("imagens/logo.jpeg"));
                    stage.setResizable(false);
                    stage.setScene(new Scene(par));
                    stage.show();
            }
    }
    
    
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
    
    
    public void abrirRegistrarN() throws IOException{
        
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
            
            FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaVisualizarBols.fxml"));
            
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
    
     @FXML
    private TableView<Bolsista> visuBolsista;
    
    @FXML
    private TableColumn<Bolsista, String> nome ;
    @FXML
    private TableColumn<Bolsista, String> email;   
    @FXML
    private TableColumn<Bolsista, String> cpf;
    @FXML
    private TableColumn<Bolsista, String> login;
    @FXML
    private TableColumn<Bolsista, String> senha;
   
    private ArrayList<Bolsista> lista = new ArrayList<>();
    private ObservableList<Bolsista> observableListCardapio;
    private Bolsista d = new Bolsista();
    
    public void carregarTableView(){
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        
        for(int i = 0; i < chefeDAO.visualizarBolsistas().size(); i++){
            d = chefeDAO.visualizarBolsistas().get(i);
            Bolsista c = new Bolsista(d.getNome(), d.getEmail(), d.getCpf(), d.getLogin(), d.getSenha());
            lista.add(c);
        }
        
        observableListCardapio = FXCollections.observableArrayList(lista);
        visuBolsista.setItems(observableListCardapio);
        
    }
    
    public void selecionarTable(Cardapio c){
        
    }
    
    
    
    @FXML
    public void removerItem(){
        Bolsista c = new Bolsista();
         c = visuBolsista.getSelectionModel().getSelectedItem();
        System.out.println("Bolsista removido: "+ c.getNome());
        visuBolsista.getItems().remove(c);
        chefeDAO.excluirBolsista(c.getCpf());
        //appcreator
        //58 dos 67, 97,
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.carregarTableView();
    }    
    
      
    
}
