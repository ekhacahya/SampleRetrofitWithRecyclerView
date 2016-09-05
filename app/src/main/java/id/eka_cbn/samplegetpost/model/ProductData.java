package id.eka_cbn.samplegetpost.model;

public class ProductData implements java.io.Serializable {
    private static final long serialVersionUID = -862913977433648592L;
    private String updated_at;
    private String price;
    private String name;
    private String description;
    private String created_at;
    private String pid;

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
