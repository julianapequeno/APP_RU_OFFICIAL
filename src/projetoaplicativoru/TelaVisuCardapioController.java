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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaVisuCardapioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
    
    
    
    @FXML
    private Button apagar;
    
    @FXML
    private Button voltar;
    
    @FXML
    private Button botao;
    
    private AcessosAPPDAO acessDAO = new AcessosAPPDAO();
    
    @FXML
    private TextField cpApagarCardapio;
    
    
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
            }else{
                    FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeCN.fxml"));               
                    Parent par = root.load();
                    Stage stage = new Stage();
                    stage.getIcons().add(new Image ("imagens/logo.jpeg"));
                    stage.setResizable(false);
                    stage.setScene(new Scene(par));
                    stage.show();
            //}
        }
    }
    
    public void apagarRegistroCardapio() throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CARDÁPIO EXCLUÍDO");
        alert.setHeaderText("Cardápio excluído com Sucesso!");
        alert.setContentText("Esse cardápio não está mais diponível em nosso banco de dados");
        
        Alert alertNoFouded = new Alert(Alert.AlertType.INFORMATION);;
        alertNoFouded.setTitle("CARDÁPIO NÃO ENCONTRADO");
        alertNoFouded.setHeaderText("Esse cardápio não existe em nosso sistema!");
        alertNoFouded.setContentText("Por favor, digite o número de um cardápio exitente para a exclusão");
        
        int cp = Integer.parseInt(cpApagarCardapio.getText());
        ArrayList<Cardapio> lista = new ArrayList<>();
        lista = chefeDAO.visualizarCardapios();
        boolean flag = false;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCp() == cp){ //ele tá entrando mesmo q n ache, pq?
                chefeDAO.excluirCardapio(cp);
                alert.showAndWait();
                this.Voltar(); 
                flag = true;
            }
        }
        if(flag == false){
            alertNoFouded.showAndWait();
        }

    }
    
    
    @FXML
    public TextField atualizarCP;
    
    private AtualizarCpDAO cpDAO = new AtualizarCpDAO();
    private AtualizarCp Hi = new AtualizarCp();
    
    public boolean cpAtualizar(){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Esse CP não existe!");
        alert.setHeaderText("CP NÃO ENCONTRADO!");
        alert.setContentText("Por favor, digite um cp válido correspondente a um cardápio que deseja atualizar e reenviar"); 
        int cp = 0;
        try{
            cp = Integer.parseInt(this.atualizarCP.getText());
        }catch(Exception e){
            alert.showAndWait();
            return false;
        }
        System.out.println("Int: "+ cp);
        ArrayList<Cardapio> lista = new ArrayList<>();
        lista = chefeDAO.visualizarCardapios();
        boolean flag = false;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCp() == cp){ //ele tá entrando mesmo q n ache, pq?        
                Hi.setCp(cp);
                System.out.println("Hi: "+Hi.getCp());
                cpDAO.incluirCp(Hi);
                System.out.println("VISUCPDAOCPATUALIZAR: "+cpDAO.visualizarCp());
                flag = true;
                return true;
            }
        }
        
       
        if(flag == false){
            alert.showAndWait();
            return false;
        }
         return false;
    }
    
    
    public void atualizarCpTela() throws IOException{
        
            if(cpAtualizar() == true){
                System.out.println("ENTROU NO OBJ: "+cpDAO.visualizarCp());

                Stage stage1 = (Stage) botao.getScene().getWindow();
                stage1.close();       

                FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaAlterarCardapio.fxml"));


                Parent par = root.load();

                Stage stage = new Stage();

                stage.getIcons().add(new Image ("imagens/logo.jpeg"));
                stage.setResizable(false);

                stage.setScene(new Scene (par));


                stage.show();
            }
    }
    @FXML
    private TableView<Cardapio> visuCardapio;
    
    @FXML
    TableColumn<Cardapio, Integer> cp ;
    @FXML
    private TableColumn<Cardapio, String> lancheManha;   
    @FXML
    private TableColumn<Cardapio, String> almoco;       
    @FXML
    private TableColumn<Cardapio, String> lancheTarde;
    @FXML
    private TableColumn<Cardapio, String> janta;
    @FXML
    private TableColumn<Cardapio, String> ceia;
    
    private ArrayList<Cardapio> lista = new ArrayList<>();
    private ObservableList<Cardapio> observableListCardapio;
    private Cardapio d = new Cardapio();
    
    public void carregarTableView(){
        cp.setCellValueFactory(new PropertyValueFactory<>("cp"));
        lancheManha.setCellValueFactory(new PropertyValueFactory<>("lancheManha"));
        almoco.setCellValueFactory(new PropertyValueFactory<>("almoco"));
        lancheTarde.setCellValueFactory(new PropertyValueFactory<>("lancheTarde"));
        janta.setCellValueFactory(new PropertyValueFactory<>("janta"));
        ceia.setCellValueFactory(new PropertyValueFactory<>("ceia"));
        
        for(int i = 0; i < chefeDAO.visualizarCardapios().size(); i++){
            d = chefeDAO.visualizarCardapios().get(i);
            Cardapio c = new Cardapio(d.getLancheManha(), d.getAlmoco(), d.getLancheTarde(), d.getJanta(), d.getCeia(), d.getCp());
            lista.add(c);
        }
        
        observableListCardapio = FXCollections.observableArrayList(lista);
        visuCardapio.setItems(observableListCardapio);
        
    }
    
    public void selecionarTable(Cardapio c){
        
    }
    
    
    
    @FXML
    public void removerItem(){
        Cardapio c = new Cardapio();
         c = visuCardapio.getSelectionModel().getSelectedItem();
        System.out.println("Cardapio removido: "+ c.getCp());
        visuCardapio.getItems().remove(c);
        chefeDAO.excluirCardapio(c.getCp());
        //appcreator
        //58 dos 67, 97,
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //TableView visuCardapio;
            carregarTableView();
     //   visuCardapio.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) -> selecionarTable(newValue);
    }    
    

    
}
