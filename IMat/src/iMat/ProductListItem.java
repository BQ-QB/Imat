package iMat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;

public class ProductListItem extends AnchorPane {
        private iMatController parentController;
        private Product product;
        @FXML private ImageView image;
        @FXML private Text food_name;

        public ProductListItem(Product product, iMatController recipeSearchController){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recipe_listitem.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
            image.setImage(new Image(product.getImageName()));
            food_name.setText(product.getName());
            this.product = product;
            this.parentController = recipeSearchController;
        }
        @FXML
        protected void onClick(Event event){
            parentController.openProductView(product);
        }

}
