package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class MiniKlump extends AnchorPane {
    @FXML
    private ImageView imgBild;

    private iMatController controller;
    private ShoppingItem item;
    MiniKlump(ShoppingItem item, iMatController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("card_köp.fxml"));

        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.controller = controller;
        this.item = item;
        this.imgBild.setImage(new Image(getClass().getResourceAsStream(item.getProduct().getImageName())));

    }
}
