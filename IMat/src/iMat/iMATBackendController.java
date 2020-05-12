package iMat;

import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;

import java.util.List;

public class iMATBackendController {

    IMatDataHandler db = IMatDataHandler.getInstance();
    private ProductCategory category;
    public List<Product> getProducts(){
        if(category != null)
        {
            return db.getProducts(category);
        }
        else {
            return db.getProducts();
        }

    }
    public void setCategory(ProductCategory category)
    {
        this.category = category;
    }



}
