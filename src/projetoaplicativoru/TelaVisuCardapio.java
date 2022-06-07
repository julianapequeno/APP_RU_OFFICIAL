/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

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
public class TelaVisuCardapio extends Application{
        
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TelaVisualizarCardapio.fxml"));
        
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image ("imagens/logo.jpeg"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
