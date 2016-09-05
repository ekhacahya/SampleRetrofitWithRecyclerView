package id.eka_cbn.samplegetpost.model;

import java.util.List;

public class Product implements java.io.Serializable {
    private static final long serialVersionUID = -4578474164514838434L;
    private int success;
    private String message;
    private List<ProductData> products;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return this.success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<ProductData> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }
}
