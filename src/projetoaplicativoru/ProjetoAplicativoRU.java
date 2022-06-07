/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import java.awt.Frame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class ProjetoAplicativoRU extends Application {
    
    private AcessosAPPDAO acess = new AcessosAPPDAO();
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.getIcons().add(new Image ("imagens/logo.jpeg"));
        stage.setScene(scene);
        stage.setResizable(false);
        acess.excluirAcessoBolsista(null);
        acess.excluirAcessoNutricionista(null);
        stage.show();
        
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }
    
}
