package data;

/**
 * Created by ASUS on 31/07/2018.
 */

public class data_card_paket_detail {

    private String nama_paket,harga,fasilitas;

    public data_card_paket_detail(String nama_paket, String harga, String fasilitas) {
        this.nama_paket = nama_paket;
        this.harga = harga;
        this.fasilitas = fasilitas;
    }

    public String getNama_paket() {
        return nama_paket;
    }

    public String getHarga() {
        return harga;
    }

    public String getFasilitas() {
        return fasilitas;
    }
}
