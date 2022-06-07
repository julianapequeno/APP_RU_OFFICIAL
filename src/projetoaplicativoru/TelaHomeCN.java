/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author julia_000
 */
public class TelaHomeCN extends ProjetoAplicativoRU {

    public void start(Stage stage) throws Exception {
        //stage.getIcons().add(new Image ("imagens/logo.jpeg"));
        Parent root = FXMLLoader.load(getClass().getResource("TelaHomeCN.fxml"));
        
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image ("imagens/logo.jpeg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    

}
