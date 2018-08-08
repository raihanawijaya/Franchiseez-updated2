package data;

public class data_card_transaksi {
    public String urlImage;
    public String title, by, price, status;

    public data_card_transaksi(String urlImage, String title, String by, String price, String status) {
        this.urlImage = urlImage;
        this.title = title;
        this.by = by;
        this.price = price;
        this.status = status;
    }
}
