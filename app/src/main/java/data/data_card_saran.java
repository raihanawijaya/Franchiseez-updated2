package data;

/**
 * Created by ASUS on 19/07/2018.
 */

public class data_card_saran {
    private int image;
    private String title;
    private String harga;

    public data_card_saran(int image, String title, String harga) {
        this.image = image;
        this.title = title;
        this.harga = harga;
    }

    public data_card_saran() {
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getHarga() {
        return harga;
    }
}
