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
public class TelaAlterarCardapioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Cardapio c = new Cardapio();
    
    private CardapioDAO cDAO = new CardapioDAO();
    
    @FXML
    private ImageView fundo;
    
    @FXML
    private ImageView fundo2;
    
    @FXML
    private ImageView Cardapio;
    
    @FXML
    private ImageView imageCar;
    
    @FXML
    private Label AlterarCardapio;
    
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
    
    private AtualizarCpDAO cpDAO = new AtualizarCpDAO();
    
    public void receberCP(){
        //int cp;
        //cp = Integer.parseInt(cpDAO.visualizarCp());
        System.out.println("RECEBERCP: "+cpDAO.visualizarCp());
        c.setCp(cpDAO.visualizarCp());
    }
    
    private chefeNutricionistaDAO chefeDAO = new chefeNutricionistaDAO();
    private ArrayList<Cardapio> lista;
    @FXML
    public String getLM(){
        this.receberCP();
        lista = chefeDAO.visualizarCardapios();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCp() == c.getCp()){
                return lista.get(i).getLancheManha();
            }
        }
        return "";
    }
    
    public void enviarCardapio() throws IOException{
        this.receberCP();
        c.setLancheManha(String.valueOf(lancheM.getText()));
        c.setAlmoco(String.valueOf(Almoco.getText()));
        c.setLancheTarde(String.valueOf(lancheT.getText()));
        c.setJanta(String.valueOf(Janta.getText()));
        c.setCeia(String.valueOf(Ceia.getText()));
        cDAO.alteraCardapio(c, c.getCp());
        enviarCardapioJSON(c);
        //cpDAO.excluirCp();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CARDÁPIO ALTERADO");
        alert.setHeaderText("Cardápio enviado com Sucesso!");
        alert.setContentText("Confira o cardápio do dia no aplicativo do APP RU no seu celular!");
        alert.showAndWait();
        this.Voltar();
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
    
    private AcessosAPPDAO acessDAO = new AcessosAPPDAO();
    
    public void Voltar() throws IOException{
        
            Stage stage1 = (Stage) botao.getScene().getWindow();
            stage1.close(); 
            
            if(acessDAO.visualizarNutricionista() != null){
                //if(acessDAO.visualizarNutricionistas().get(0).getNomeacao() == "Nutricionista"){
                    FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeN.fxml"));   
                    Parent par = root.load();
                    cpDAO.excluirCp();
                    Stage stage = new Stage();
                    stage.getIcons().add(new Image ("imagens/logo.jpeg"));
                   // stage.getIcons().add(new Image ("imagens/logo.jpeg"));
                    stage.setResizable(false);
                    stage.setScene(new Scene(par));
                    stage.show();
               // }
            }else{
                    
                FXMLLoader root = new FXMLLoader(this.getClass().getResource("TelaHomeCN.fxml"));               
                Parent par = root.load();
                cpDAO.excluirCp();
                Stage stage = new Stage();
                stage.getIcons().add(new Image ("imagens/logo.jpeg"));
                stage.setResizable(false);
                stage.setScene(new Scene(par));
                stage.show();
         //  }
            
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // c = new ControllerTelaPrincipal();
        //pegarEmail(c.retornaEmail());
       
    }
    
}
