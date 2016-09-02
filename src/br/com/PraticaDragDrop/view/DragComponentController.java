/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PraticaDragDrop.view;

import br.com.PraticaDragDrop.control.dao.CidadeDAO;
import br.com.PraticaDragDrop.model.entity.Cidade;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author OCTI01
 */
public class DragComponentController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private GridPane gpCidades;
    @FXML
    private GridPane gpFavoritas;

    private Cidade lastCidade;
    private boolean cor = false;
    private Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCidades();
        carregarFavoritas();
    }

    private void carregarCidades() {
        List<Cidade> cidades = new CidadeDAO().pegarPorFavorito(false);
        gpCidades.getChildren().clear();
        int linha = 0, coluna = 0;
        for (Cidade cidade : cidades) {
            Button button = new Button(cidade.getNome());
            ImageView imageView = new ImageView();
            if (cidade.getFoto() != null) {
                imageView.setImage(new Image(new ByteArrayInputStream(cidade.getFoto())));
            }
            imageView.setFitHeight(75);
            imageView.setFitWidth(75);
            imageView.setPreserveRatio(false);
            button.setGraphic(imageView);
            button.setContentDisplay(ContentDisplay.TOP);
            button.setUserData(cidade);
            button.setOnDragDetected((MouseEvent event) -> {
                Dragboard dragboard = button.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent clipboardContent = new ClipboardContent();
                clipboardContent.putImage(button.snapshot(new SnapshotParameters(), null));
                dragboard.setContent(clipboardContent);
                button.setVisible(false);
            });
            button.setOnDragDone((DragEvent event) -> {
                button.setVisible(true);
            });

            gpCidades.add(button, coluna, linha);
            coluna++;
            if (coluna > 3) {
                coluna = 0;
                linha++;
            }
        }
    }

    private void carregarFavoritas() {
        List<Cidade> cidades = new CidadeDAO().pegarPorFavorito(true);
        gpFavoritas.getChildren().clear();
        int linha = 0, coluna = 0;
        for (Cidade cidade : cidades) {
            Button button = new Button(cidade.getNome());
            ImageView imageView = new ImageView();
            if (cidade.getFoto() != null) {
                imageView.setImage(new Image(new ByteArrayInputStream(cidade.getFoto())));
            }
            imageView.setFitHeight(75);
            imageView.setFitWidth(75);
            imageView.setPreserveRatio(false);
            button.setGraphic(imageView);
            button.setContentDisplay(ContentDisplay.TOP);
            button.setUserData(cidade);
            button.setOnDragDetected((MouseEvent event) -> {
                Dragboard dragboard = button.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent clipboardContent = new ClipboardContent();
                clipboardContent.putImage(button.snapshot(new SnapshotParameters(), null));
                dragboard.setContent(clipboardContent);
                button.setVisible(false);
            });
            button.setOnDragDone((DragEvent event) -> {
                button.setVisible(true);
            });
            if (cidade.equals(lastCidade)) {
                if (timeline != null) {
                    timeline.stop();
                }
                timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent) -> {
                    System.out.println("Cor " + cor);
                    System.out.println(button.getText());
                    if (cor) {
                        button.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    } else {
                        button.setBorder(null);
                    }
                    cor = !cor;
                }));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
            }
            gpFavoritas.add(button, coluna, linha);
            coluna++;
            if (coluna > 11) {
                coluna = 0;
                linha++;
            }
        }
    }

    @FXML
    private void lbAdicionarOnDragOver(DragEvent de) {
        if (de.getDragboard().hasImage()) {
            de.acceptTransferModes(TransferMode.MOVE);
        }
    }

    @FXML
    private void lbAdicionarOnDragDropped(DragEvent de) {
        if (de.getGestureSource() instanceof Button) {
            Button botao = (Button) de.getGestureSource();
            if (botao.getUserData() instanceof Cidade) {
                Cidade cidade = (Cidade) botao.getUserData();
                cidade.setFavorito(true);
                new CidadeDAO().editar(cidade);
                lastCidade = cidade;
                carregarCidades();
                carregarFavoritas();
            }
        }
    }

    @FXML
    private void lbApagarOnDragOver(DragEvent de) {
        de.acceptTransferModes(TransferMode.MOVE);
    }

    @FXML
    private void lbApagarOnDragDropped(DragEvent de) {
        if (de.getGestureSource() instanceof Button) {
            Button button = (Button) de.getGestureSource();
            if (button.getUserData() instanceof Cidade) {
                Cidade cidade = (Cidade) button.getUserData();
                cidade.setFavorito(false);
                new CidadeDAO().editar(cidade);
                carregarCidades();
                carregarFavoritas();
            }
        }
    }
}
