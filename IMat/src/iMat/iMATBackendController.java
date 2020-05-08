package iMat;

import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;

import java.util.List;

public class iMATBackendController {

    IMatDataHandler db = IMatDataHandler.getInstance();
    public List<Product> getProducts(){
        return db.getProducts();
    }


}
