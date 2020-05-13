package iMat;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kategorisida extends AnchorPane {

    @FXML private FlowPane productview;
    @FXML private Label productCategory;

    private iMatController controller;
    private Category_head category;
    private Map<String, MiniKlump> productListItemMap = new HashMap<String, MiniKlump>();
    Kategorisida(Category_head category, iMatController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Kategorisida.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.controller = controller;
        this.productCategory.setText(category.name());
        for (Product product : controller.controller.getProducts()) {
            productListItemMap.put(product.getName(), new MiniKlump(new ShoppingItem(product), controller));
        }
        update();
    }
    public void update()
    {
        productview.getChildren().clear();
        for(Product product : controller.controller.getProducts())
        {
            productview.getChildren().add(productListItemMap.get(product.getName()));
        }

    }
    public void update(String search)
    {
        productview.getChildren().clear();
        for(Product product : controller.controller.getProducts())
        {
            if(product.getName().contains(search)) {
                productview.getChildren().add(productListItemMap.get(product.getName()));
            }
        }

    }
    @FXML
    protected void onClick(Event event){
        System.out.println("Funkar");
    }
}
