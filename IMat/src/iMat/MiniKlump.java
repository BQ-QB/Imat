package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class MiniKlump extends AnchorPane {
    @FXML
    private ImageView imgBild;
    @FXML private Label lblNamn;
    @FXML private Label lblGram;
    @FXML private Label lblDes;
    @FXML private Label lblKrPer;
    @FXML private Label lblNum;
    @FXML private Label lblPrice;


    private iMatController controller;
    private ShoppingItem item;
    MiniKlump(ShoppingItem item, iMatController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("card.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.controller = controller;
        this.item = item;
        this.lblNamn.setText(item.getProduct().getName());
        this.lblGram.setText(item.getProduct().getUnitSuffix());
        this.lblDes.setText(item.getProduct().getUnit());
        this.lblKrPer.setText(String.valueOf(item.getProduct().getPrice()));
        this.lblPrice.setText(String.valueOf(Double.parseDouble(lblKrPer.getText()) * Double.parseDouble(lblNum.getText())));
        this.imgBild.setImage(new Image("File:///c:/users/william/.dat215/images/product_1.jpg"));

    }
}
