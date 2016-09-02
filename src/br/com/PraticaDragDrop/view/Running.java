/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PraticaDragDrop.view;

import br.com.PraticaDragDrop.control.FxMananger;
import br.com.PraticaDragDrop.control.FxMananger.Tipo;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author OCTI01
 */
public class Running extends Application {

    @Override
    public void start(Stage primaryStage) {
        FxMananger.showWindow(FxMananger.carregarComponente("DragComponent"), "Informações do HD", Tipo.EXIT_ON_CLOSE,Tipo.MAXIMIZADO).show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
