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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaVisualizarNutricionistasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button voltar;
    
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO() ;
   
  
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
    

    public void abrirRegistrarN() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close();
            
            FXMLLoader root1 = new FXMLLoader(this.getClass().getResource("TelaRegistro.fxml"));
            
            Parent par = root1.load();

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
    private TextField cpfAPAGAR;
    
    public void apagarNutricionista(){
        String cp;
        cp = String.valueOf(this.cpfAPAGAR.getText());
        ArrayList<Nutricionista> lista;
        lista = chefeDAO.visualizarNutricionistas();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCpf().equals(cp)){
                chefeDAO.excluirNutricionistaSQL(cp);
            }
        }
    }
    
    @FXML
    private TableView<Nutricionista> visuNutri;
    
    @FXML
    private TableColumn<Nutricionista, String> nome ;
    @FXML
    private TableColumn<Nutricionista, String> email;   
    @FXML
    private TableColumn<Nutricionista, String> cpf;
    @FXML
    private TableColumn<Nutricionista, String> login;
    @FXML
    private TableColumn<Nutricionista, String> senha;
   
    private ArrayList<Nutricionista> lista = new ArrayList<>();
    private ObservableList<Nutricionista> observableListCardapio;
    private Nutricionista d = new Nutricionista();
    
    public void carregarTableView(){
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        
        for(int i = 0; i < chefeDAO.visualizarNutricionistas().size(); i++){
            d = chefeDAO.visualizarNutricionistas().get(i);
            Nutricionista c = new Nutricionista(d.getNome(), d.getEmail(), d.getCpf(), d.getLogin(), d.getSenha());
            lista.add(c);
        }
        
        observableListCardapio = FXCollections.observableArrayList(lista);
        visuNutri.setItems(observableListCardapio);
        
    }
    
    public void selecionarTable(Cardapio c){
        
    }
    
    
    
    @FXML
    public void removerItem(){
        Nutricionista c = new Nutricionista();
         c = visuNutri.getSelectionModel().getSelectedItem();
        System.out.println("Nutricionista removido: "+ c.getNome());
        visuNutri.getItems().remove(c);
        chefeDAO.excluirNutricionistaSQL(c.getCpf());
        //appcreator
        //58 dos 67, 97,
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.carregarTableView();
    }    
    
}
