/**
 * Project : Aplikasi Manajemen Perpustakaan
 * Author: Dede Irwanto
 * Email: id.dedeirwanto@yahoo.com
 * Telegram : @dedeirwanto
 * Date: 14/05/2025
 * Time: 11:23 AM
 */
public class Buku {
    String judul;
    String penulis;
    kategoriBuku kategori;
    boolean statusKetersediaan;

    enum kategoriBuku {
        FIKSI,
        NON_FIKSI,
        TEKNOLOGI,
        SEJARAH,
    }

    public Buku(String judul, String penulis, kategoriBuku kategori, boolean statusKetersediaan) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.statusKetersediaan = statusKetersediaan;
    }

    public Buku() {
    }
}
