import java.io.*;

public class Product implements Externalizable {
    private int id;
    private String title;
    private int price;
    private float rating;

    public static final long serialVersionUID = 90909;

    public Product(){
        System.out.println("Product()");
    }

    public Product(int id, String title, int price, float rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal Called..");
        out.writeInt(id);
        out.writeUTF(title);
        out.writeInt(price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal Called..");
        this.id = in.readInt();
        this.title = in.readUTF();
        this.price = in.readInt();
        this.rating = 0f;
    }
}
