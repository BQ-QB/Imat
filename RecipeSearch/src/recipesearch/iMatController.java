
package recipesearch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.Text;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;


public class iMatController implements Initializable {

    IMatDataHandler db = IMatDataHandler.getInstance();
    iMATBackendController controller = new iMATBackendController();

    @FXML private Label food_label;
    @FXML private ImageView food_image;
    @FXML private AnchorPane product_pane;
    @FXML private AnchorPane product_description_pane;
    @FXML private AnchorPane cart_pane;
    @FXML private AnchorPane shoppingcart_page_pane;
    @FXML private AnchorPane register_pane1;
    @FXML private AnchorPane register_pane2;
    @FXML private AnchorPane register_pane3;
    @FXML private AnchorPane front_pane;
    @FXML private ListView product_category_list;
    @FXML private ListView products;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    private void populateProductDetailView(Product product) {
        food_label.setText(product.getName());
        food_image.setImage(new Image(product.getImageName()));
    }
    @FXML
    public void closeProductView(){
        product_pane.toFront();
    }
    public void openProductView(Product product){
        populateProductDetailView(product);
        product_description_pane.toFront();
    }
    public void openCartView(){
        cart_pane.toFront();
    }
}