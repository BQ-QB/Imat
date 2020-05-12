
package iMat;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
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


public class iMatController implements Initializable {

    IMatDataHandler db = IMatDataHandler.getInstance();
    iMATBackendController controller = new iMATBackendController();
    Head_categories categories = new Head_categories();

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

    @FXML
    private TextField search_field;
    @FXML
    private Pane replace_pane;

    //tillhörande kassan
    @FXML
    private AnchorPane buyBetalningsplattaAnchorpane;
    @FXML
    private AnchorPane buyAndrabetalningsmetodPlatta;
    @FXML
    private AnchorPane buyAndraleveransPlatta;
    @FXML
    private AnchorPane buyAndratelefonnummerPlatta;
    @FXML
    private AnchorPane buyAndraadressPlatta;
    @FXML
    private JFXScrollPane buyKlumpScrollpane;
    @FXML
    private Label buy_idinvarukorg_label;
    @FXML
    private Label buy_sorteraefter_label;
    @FXML
    private Label buyAttbetalaLabel;
    @FXML
    private Label buyCurrentadressLabel;
    @FXML
    private Label buyCurrentbetalningsmetodLabel;
    @FXML
    private Label buyCurrentleveranstidLabel;
    @FXML
    private Label buyCurrenttelefonnummerLabel;
    @FXML
    private GridPane buyRowGridPane;
    @FXML
    private FlowPane buyKlumpFlowpane;
    //behövs nog inte??
    @FXML
    private JFXButton buy_kategori_knapp;
    @FXML
    private JFXButton buy_pris_knapp;
    @FXML
    private JFXButton buy_inkopslista_knapp;
    @FXML
    private JFXButton buy_vidare_knapp;
    @FXML
    private JFXButton buyAndrabetalningsmetodButton;
    @FXML
    private JFXButton buyAndraLeveransmetod;
    @FXML
    private JFXButton buyAndraTelefonnummer;
    @FXML
    private JFXButton buyAndradressButton;





    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCheckOut();
        replace_pane.getChildren().add(new Button("Yes"));


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
    //till checkout
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



    private void populateByRow(ArrayList<ShoppingItem> list, String method){
        buyKlumpScrollpane.getChildren().clear();
        if (method == "kategori"){

        }
        //int rows = list.size()/2;  //avrundar uppåt???
        for( ShoppingItem item : list){
            buyKlumpFlowpane.getChildren().add(new MiniKlump(item, this));

        }
    }


    public void populateCheckoutScrollPane(String method){
        switch(method){
            case "pris":
                populateByRow(sortByPris(), method);
                break;
            case "inkopslista":
                break;
            case "kategori":
                break;
            default:
               // throw Exception
        }
    }
    //knappfunktioner

    @FXML protected void sortPrisButton(){
        populateCheckoutScrollPane("pris");
    }

    @FXML protected void sortInkopslistaButton(){
        populateCheckoutScrollPane("inkopslista");
    }

    @FXML protected void sortKategoriButton(){
        populateCheckoutScrollPane("kategori");
    }

    @FXML protected void VidareButton(){
        initializeBetalning();
    }

    @FXML protected void changeAdressButton(){
        buyAndraadressPlatta.toFront();
    }
    @FXML protected void changeBetalningsmetodButton(){
        buyAndrabetalningsmetodPlatta.toFront();
    }
    @FXML protected void changeTelefonnummerButton(){
        buyAndratelefonnummerPlatta.toFront();
    }
    @FXML protected void changeLeveransmetodButton(){
        buyAndraleveransPlatta.toFront();
    }

    //init för betalning
    public void initializeCheckOut(){
        test.go(this);
        //här: inled med att byta så att denna panen är längst fram alternativ ladda ny fxml
        populateCheckoutScrollPane("kategori");
        ;
        //sätta etiketter:
        Date date = new Date();
        buy_idinvarukorg_label.setText("I din varukorg:");
        buy_sorteraefter_label.setText("Sortera efter: ");
        buyCurrentadressLabel.setText("Du bor på " + db.getCustomer().getAddress());
        buyCurrentbetalningsmetodLabel.setText("");
        buyCurrenttelefonnummerLabel.setText("Ditt telefonnummer är " + db.getCustomer().getMobilePhoneNumber());
        buyCurrentleveranstidLabel.setText("Varorna kommer levereras den" + date.toString());
        buyAttbetalaLabel.setText(String.valueOf(db.getShoppingCart().getTotal()));
        //test



    }

    private void initializeBetalning(){

    }
}


