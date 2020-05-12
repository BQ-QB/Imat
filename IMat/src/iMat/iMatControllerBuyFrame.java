package iMat;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.stage.Stage;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class iMatControllerBuyFrame {

    iMatController controller;
    //tillhörande kassan
    @FXML private AnchorPane buyBetalningsplattaAnchorpane;
    @FXML private AnchorPane buyAndrabetalningsmetodPlatta;
    @FXML private AnchorPane buyAndraleveransPlatta;
    @FXML private AnchorPane buyAndratelefonnummerPlatta;
    @FXML private AnchorPane buyAndraadressPlatta;
    @FXML private JFXScrollPane buyKlumpScrollpane;
    @FXML private Label buy_idinvarukorg_label;
    @FXML private Label buy_sorteraefter_label;
    @FXML private Label buyAttbetalaLabel;
    @FXML private Label buyCurrentadressLabel;
    @FXML private Label buyCurrentbetalningsmetodLabel;
    @FXML private Label buyCurrentleveranstidLabel;
    @FXML private Label buyCurrenttelefonnummerLabel;
    @FXML private GridPane buyRowGridPane;
    @FXML private FlowPane buyKlumpFlowpane;
    @FXML private ImageView buyIMatImageview;
    //behövs nog inte??
    @FXML private JFXButton buy_kategori_knapp;
    @FXML public JFXButton buy_pris_knapp;
    @FXML private JFXButton buy_inkopslista_knapp;
    @FXML public JFXButton buy_vidare_knapp;
    @FXML private JFXButton buyAndrabetalningsmetodButton;
    @FXML private JFXButton buyAndraLeveransmetod;
    @FXML private JFXButton buyAndraTelefonnummer;
    @FXML private JFXButton buyAndradressButton;

    //constructor
    public iMatControllerBuyFrame (iMatController controller){
        this.controller = controller;
    }
//knappar
    //med lyssnare är nog dessa överflödiga
    @FXML
    protected void sortPrisButton(){
      //  populateCheckoutScrollPane("pris");
    }

    @FXML protected void sortInkopslistaButton(){
       // populateCheckoutScrollPane("inkopslista");
    }

    @FXML protected void sortKategoriButton(){
      //  populateCheckoutScrollPane("kategori");
    }

    @FXML protected void VidareButton(ActionEvent event) throws IOException {
        Stage betalningStage = (Stage) buy_vidare_knapp.getScene().getWindow();
        betalningStage.hide();

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

    //sorterar lägsta pris med lägst index


    /*public void populateByRow(List<ShoppingItem> list, String method){
        buyKlumpScrollpane.getChildren().clear();
        if (method == "kategori"){
            ProductCategory nowCat = ProductCategory.POD;
            int count = -1;
            while (nowCat != ProductCategory.HERB){
                nowCat = ProductCategory.values()[count++];
                buyKlumpFlowpane.getChildren().add(new Label(controller.skalProductCategory.toString(nowCat) +": "));
                for(ShoppingItem item : list){
                    if(item.getProduct().getCategory() == nowCat)
                    buyKlumpFlowpane.getChildren().add(new MiniKlump(item, controller));
                }
            }
            return;
        }
        for(ShoppingItem item : list){
            buyKlumpFlowpane.getChildren().add(new MiniKlump(item, controller));
        }
    }*/

//eventuellt överflödigt
/***
    public void populateCheckoutScrollPane(String method){
        switch(method){
            case "pris":
                populateByRow(sortByPris(), method);
                break;
            case "inkopslista":
                populateByRow();
                break;
            case "kategori":
                break;
            default:
                // throw Exception
        }
    }
***/
    //init för betalning
    public void initializeCheckOut(){
        test.go(controller);
        //här: inled med att byta så att denna panen är längst fram alternativ ladda ny fxml
        //populateByRow(controller.db.getShoppingCart().getItems(), "kategori");
        ;
        //sätta etiketter:
        Date date = new Date();
        buy_idinvarukorg_label.setText("I din varukorg:");
        buy_sorteraefter_label.setText("Sortera efter: ");
        buyCurrentadressLabel.setText("Du bor på " + controller.db.getCustomer().getAddress());
        buyCurrentbetalningsmetodLabel.setText("");
        buyCurrenttelefonnummerLabel.setText("Ditt telefonnummer är " + controller.db.getCustomer().getMobilePhoneNumber());
        buyCurrentleveranstidLabel.setText("Varorna kommer levereras den" + date.toString());
        buyAttbetalaLabel.setText(String.valueOf(controller.db.getShoppingCart().getTotal()));
        //test




    }
}
