package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kategorisida extends AnchorPane {

    @FXML private ListView productview;

    private iMatController controller;
    private Category_head productCategory;
    private Map<String, MiniKlump> productListItemMap = new HashMap<String, MiniKlump>();
    Kategorisida(Category_head category, iMatController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Kategorisida.fxml"));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.controller = controller;
        this.productCategory = category;
        for (Product product : controller.controller.getProducts()) {
            productListItemMap.put(product.getImageName(), new MiniKlump(new ShoppingItem(product), controller));
        }
        update();
    }
    public void update()
    {
        for(Product product : controller.controller.getProducts())
        {
            productview.getItems().add(productListItemMap.get(product.getName()));
        }
    }
}
