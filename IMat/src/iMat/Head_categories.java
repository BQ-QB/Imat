package iMat;

import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;

import java.util.*;

public class Head_categories {

    private iMatController controller;
    Category_head category_head;
    Map<String, ProductCategory> category_list = new HashMap<>();
    public Map<String, ProductCategory> underCategories(){
        switch (category_head)
        {
            case HERBS:
                return null;
            case MEAT:
                category_list.put("Kött", ProductCategory.MEAT);
                category_list.put("Fisk", ProductCategory.FISH);
                return category_list;
            case FRUIT:
                category_list.put("Exotiska frukter", ProductCategory.EXOTIC_FRUIT);
                category_list.put("Grönsaks frukter", ProductCategory.VEGETABLE_FRUIT);
                category_list.put("Citrus frukter", ProductCategory.CITRUS_FRUIT);
                category_list.put("Bär", ProductCategory.BERRY);
                category_list.put("Vanliga frukter", ProductCategory.FRUIT);
                return category_list;
            case PANTRY:
                category_list.put("Pasta", ProductCategory.PASTA);
                category_list.put("Mjöl, salt och socker", ProductCategory.FLOUR_SUGAR_SALT);
                category_list.put("Bröd", ProductCategory.BREAD);
                category_list.put("Potatis och ris", ProductCategory.POTATO_RICE);
                category_list.put("Nötter och frön", ProductCategory.NUTS_AND_SEEDS);
                return category_list;
            case VEGETABLE:
                category_list.put("Rotfrukter", ProductCategory.ROOT_VEGETABLE);
                category_list.put("Grönsaksfrukt", ProductCategory.VEGETABLE_FRUIT);
                category_list.put("Sallad", ProductCategory.CABBAGE);
                category_list.put("Ärtor", ProductCategory.POD);
                return category_list;
            case DRINKS:
                category_list.put("Kalla drycker", ProductCategory.COLD_DRINKS);
                category_list.put("Varma drycker", ProductCategory.HOT_DRINKS);
                return category_list;
            case DAIRIES:
                return null;
        }
        return null;
    }
    public List<Product> getProducts()
    {
        return controller.controller.getProducts();
    }
    public List<Product> getProducts(Category_head category)
    {
        category_head = category;
        List<Product> products = new ArrayList<>();
        switch (category)
        {
            case MEAT:
                controller.controller.setCategory(ProductCategory.MEAT);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.FISH);
                products.addAll(controller.controller.getProducts());
                return products;
            case FRUIT:
                controller.controller.setCategory(ProductCategory.FRUIT);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.CITRUS_FRUIT);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.VEGETABLE_FRUIT);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.EXOTIC_FRUIT);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.BERRY);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.MELONS);
                products.addAll(controller.controller.getProducts());
                return products;

            case HERBS:
                controller.controller.setCategory(ProductCategory.HERB);
                products.addAll(controller.controller.getProducts());
                return products;

            case DRINKS:
                controller.controller.setCategory(ProductCategory.COLD_DRINKS);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.HOT_DRINKS);
                products.addAll(controller.controller.getProducts());
                return products;

            case DAIRIES:
                controller.controller.setCategory(ProductCategory.DAIRIES);
                products.addAll(controller.controller.getProducts());
                return products;

            case VEGETABLE:
                controller.controller.setCategory(ProductCategory.ROOT_VEGETABLE);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.VEGETABLE_FRUIT);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.CABBAGE);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.POD);
                products.addAll(controller.controller.getProducts());

                return products;

            case PANTRY:
                controller.controller.setCategory(ProductCategory.PASTA);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.BREAD);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.FLOUR_SUGAR_SALT);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.NUTS_AND_SEEDS);
                products.addAll(controller.controller.getProducts());
                controller.controller.setCategory(ProductCategory.POTATO_RICE);
                products.addAll(controller.controller.getProducts());
                return products;

        }
        return null;
    }
}
