/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PraticaDragDrop.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author OCTI01
 */
public class InformacaoHDController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private TextArea taInformation;
    @FXML
    private Button btMove;
    @FXML
    private Button btHere;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Process process = Runtime.getRuntime().exec("wmic diskdrive get model,interfacetype");
            InputStream inputStream = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String linha = br.readLine();
            String modelo = "";
            do {
                if (linha.contains("IDE")) {
                    taInformation.setText(taInformation.getText() + linha + "\n");
                    String[] parametros = linha.split(" ");
                    for (String parametro : parametros) {
                        if (!parametro.equals("")) {
                            if (!parametro.equals("IDE")) {
                                modelo += parametro + " ";
                            }
                        }
                    }
                    modelo = modelo.substring(0, modelo.length() - 1);
                    System.out.println(String.valueOf(modelo.charAt(0)) + String.valueOf(modelo.charAt(1)) + String.valueOf(modelo.charAt(1)) + String.valueOf(modelo.charAt(0)) + "-" + String.valueOf(modelo.charAt(modelo.length() - 1)) + String.valueOf(modelo.charAt(modelo.length() - 2)) + String.valueOf(modelo.charAt(modelo.length() - 2)) + String.valueOf(modelo.charAt(modelo.length() - 1)));
                }
                linha = br.readLine();
            } while (linha != null);
        } catch (IOException ex) {
            Logger.getLogger(InformacaoHDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Preparar drag
        btMove.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = btMove.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent clipboard = new ClipboardContent();
            clipboard.putImage(btMove.snapshot(new SnapshotParameters(), null));
            db.setContent(clipboard);
            btMove.setVisible(false);
        });
        btMove.setOnDragDone((DragEvent event) -> {
            btMove.setVisible(true);
        });
        btHere.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != btHere) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
        });
        btHere.setOnDragDropped((DragEvent event) -> {
            Dragboard dragboard = event.getDragboard();
            apPrincipal.getChildren().remove((Button)event.getGestureSource());
        });
        btHere.setOnAction((ActionEvent event) -> {
            apPrincipal.getChildren().add(btMove);
        });
    }

}
