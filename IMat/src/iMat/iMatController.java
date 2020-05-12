
package iMat;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import se.chalmers.cse.dat216.project.*;

import javax.swing.plaf.basic.BasicOptionPaneUI;


public class iMatController implements Initializable {

    IMatDataHandler db = IMatDataHandler.getInstance();
    iMATBackendController controller = new iMATBackendController();
    Head_categories categories = new Head_categories();
    iMatControllerBuyFrame buyFrameController = new iMatControllerBuyFrame(this);
    //static SkalProductCategory skalProductCategory = new SkalProductCategory();

    @FXML
    private AnchorPane product_description_pane;
    @FXML
    private AnchorPane cart_pane;
    @FXML
    private AnchorPane shoppingcart_page_pane;
    @FXML
    private AnchorPane register_pane1;
    @FXML
    private AnchorPane register_pane2;
    @FXML
    private AnchorPane register_pane3;
    @FXML
    private AnchorPane front_pane;
    @FXML
    private AnchorPane root_pane;
    @FXML
    private ListView product_category_list;

    @FXML private Label food_label;
    @FXML private ImageView food_image;
    @FXML private AnchorPane product_pane;
    @FXML private ListView products;

    private Map<String, MiniKlump> productListItemMap = new HashMap<String, MiniKlump>();



    @FXML
    private TextField search_field;
    @FXML
    private Pane replace_pane;




    private void loadBetalning(){

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        replace_pane.getChildren().add(new Kategorisida(Category_head.DRINKS,this));
        replace_pane.getChildren().add(new Button("YES"));




        /*
        //lyssnare till iMatControllerBuyFrame
        buyFrameController.buy_vidare_knapp.onActionProperty().addListener(new ChangeListener<EventHandler<ActionEvent>>() {
            @Override
            public void changed(ObservableValue<? extends EventHandler<ActionEvent>> observableValue, EventHandler<ActionEvent> actionEventEventHandler, EventHandler<ActionEvent> t1) {
                loadBetalning();
            }
        });
        buyFrameController.buy_pris_knapp.onActionProperty().addListener(new ChangeListener<EventHandler<ActionEvent>>() {
            @Override
            public void changed(ObservableValue<? extends EventHandler<ActionEvent>> observableValue, EventHandler<ActionEvent> actionEventEventHandler, EventHandler<ActionEvent> t1) {
                //buyFrameController.populateByRow(sortByPris(), "pris");

            }
        });
*/

    }


    @FXML
    public void handleEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && search_field.getLength() > 0) {


        }
    }
    @FXML
    public void AddButton(ActionEvent event)
    {
        replace_pane.getChildren().add(new Button("Yes"));
    }


    @FXML
    public void closeProductView() {

    }

    public void openProductView(Product product) {
        product_description_pane.toFront();
    }

    public void openCartView() {
        cart_pane.toFront();
    }



    //sorterar lägsta pris med lägst index
    private ArrayList<ShoppingItem> sortByPris() {
        ArrayList<ShoppingItem> sortedList = new ArrayList<>();
        while (true) {
            boolean bool = true;
            double lastAmount = 0.0;
            for (int i = 0; i < db.getShoppingCart().getItems().size(); i++) {
                if (db.getShoppingCart().getItems().get(i).getAmount() < lastAmount) {
                    ShoppingItem temp = sortedList.get(i - 1);
                    sortedList.set(i - 1, db.getShoppingCart().getItems().get(i));
                    sortedList.set(i, temp);
                    bool = false;
                }

            }
            if (bool) {
                break;
            }
        }
        return sortedList;
    }














    private void initializeBetalning(){

    }
}


