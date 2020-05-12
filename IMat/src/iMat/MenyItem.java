package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class MenyItem extends AnchorPane {
    @FXML private Label product_category;

    private iMatController controller;
    private ProductCategory productCategory;
    MenyItem(ProductCategory category, iMatController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("front.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.controller = controller;
        this.product_category.setText(category.name());


    }
}
