import java.text.NumberFormat;
import java.util.Locale;

/**
 * Project : Aplikasi Manajemen Perpustakaan
 * Author: Dede Irwanto
 * Email: id.dedeirwanto@yahoo.com
 * Telegram : @dedeirwanto
 * Date: 14/05/2025
 * Time: 11:23 AM
 */
public class Main {
    int countDataBuku = 0;
    Buku[] dataBuku = new Buku[20];

    TransaksiBuku[] dataTransaksiBuku = new TransaksiBuku[20];
    int countDataTransaksiBuku = 0;


    private String scan(String message) {
        System.out.print(message + ": ");
        return new java.util.Scanner(System.in).nextLine();
    }

    // fungsi convert double ke format rupiah
    private String formatRupiah(double harga) {
        Locale indonesia = Locale.forLanguageTag("id-ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(indonesia);
        return formatRupiah.format(harga);
    }

    private void tampilkanMenu() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("1. Input Data Buku");
        System.out.println("2. Peminjaman Buku");
        System.out.println("3. Pengembalian Buku");
        System.out.println("4. Cetak Struk");
        System.out.println("5. Manajemen Data Buku");
        System.out.println("6. Keluar Aplikasi");
        String pilihan = scan("Masukkan pilihan");

        switch (pilihan) {
            case "1":
                menuInputDataBuku();
                break;
            case "2":
                menuPinjamBuku();
                break;
            case "3":
                menuPengembalianBuku();
                break;
            case "4":
                menuCetakStruk();
                break;
            case "5":
                menuManajemenDataBuku();
                break;
            case "6":
                keluarAplikasi();
                break;
            default:
                System.out.println("Pilihan tidak tersedia!");
                kembaliKeMenu();
                break;
        }
    }

    private void menuManajemenDataBuku() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Manajemen Data Buku - Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("1. Tambah Data Buku");
        System.out.println("2. Ubah Data Buku");
        System.out.println("3. Hapus Data Buku");
        System.out.println("4. Kembali ke Menu Utama");
        String pilihan = scan("Masukkan pilihan");
        switch (pilihan) {
            case "1":
                menuInputDataBuku();
                break;
            case "2":
                menuUbahDataBuku();
                break;
            case "3":
                menuHapusDataBuku();
                break;
            case "4":
                tampilkanMenu();
                break;
            default:
                System.out.println("Pilihan tidak tersedia!");
                kembaliKeMenu();
                break;
        }
    }

    private void menuHapusDataBuku() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Hapus Buku - Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        tampilkanDataBuku();
        hapusDataBuku();
        tampilkanDataBuku();
        kembaliKeMenuManajemenDataBuku();
    }

    private void hapusDataBuku() {
        String judulBuku = scan("Masukkan judul buku yang akan dihapus");

        for (int i = 0; i < countDataBuku; i++) {
            if (judulBuku.equalsIgnoreCase(dataBuku[i].judul)) {
                String hapus = scan("Apakah anda yakin akang menghapus data buku ini? [y/t]");
                if (hapus.equalsIgnoreCase("y")) {
                    hapusDataBuku(judulBuku);
                } else if (hapus.equalsIgnoreCase("t")) {
                    kembaliKeMenuManajemenDataBuku();
                } else {
                    System.out.println("Input tidak valid! pilih 'y' untuk ya atau 't' untuk tidak");
                    hapusDataBuku();
                }
            }
        }
    }

    private void hapusDataBuku(String judulBuku) {
        Buku[] dataBukuTemp = new Buku[20];
        int j = 0;

        for (int i = 0; i < countDataBuku; i++) {
            if (!judulBuku.equalsIgnoreCase(dataBuku[i].judul)) {
                dataBukuTemp[j] = dataBuku[i];
                j++;
            }
        }

        dataBuku = dataBukuTemp;
        countDataBuku--;
        System.out.println("Buku berhasil dihapus!");
    }

    private void menuUbahDataBuku() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Ubah Informasi Buku - Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        tampilkanDataBuku();
        ubahDataBuku();
        tampilkanDataBuku();
        kembaliKeMenuManajemenDataBuku();
    }

    private void ubahDataBuku() {
        String judulBukuScan = scan("Masukkan judul buku (yang akan diubah)");
        boolean ditemukan = false;
        for (int i = 0; i < countDataBuku; i++) {
            if (judulBukuScan.equalsIgnoreCase(dataBuku[i].judul)) {
                ditemukan = true;
                System.out.println("Judul buku sebelumnya: " + dataBuku[i].judul);
                String judulBuku = scan("Masukkan judul buku baru (kosongkan jika tidak ingin mengubah)");
                if (judulBuku.isEmpty()) {
                    judulBuku = dataBuku[i].judul;
                }
                dataBuku[i].judul = judulBuku.toUpperCase();

                System.out.println("Penulis sebelumnya: " + dataBuku[i].penulis);
                String penulis = scan("Masukkan penulis baru (kosongkan jika tidak ingin mengubah)");
                if (penulis.isEmpty()) {
                    penulis = dataBuku[i].penulis;
                }
                dataBuku[i].penulis = penulis.toUpperCase();

                System.out.println("Kategori sebelumnya: " + dataBuku[i].kategori);
                String kategori = scan("Pilih kategori baru [Fiksi, Non Fiksi, Teknologi, Sejarah] (kosongkan jika tidak ingin mengubah)");

                if (kategori.isEmpty()) {
                    kategori = dataBuku[i].kategori.toString();
                } else if (kategori.equalsIgnoreCase("Fiksi")) {
                    kategori = "FIKSI";
                } else if (kategori.equalsIgnoreCase("Non Fiksi")) {
                    kategori = "NON_FIKSI";
                } else if (kategori.equalsIgnoreCase("Teknologi")) {
                    kategori = "TEKNOLOGI";
                } else if (kategori.equalsIgnoreCase("Sejarah")) {
                    kategori = "SEJARAH";
                } else {
                    System.out.println("Kategori tidak tersedia!");
                    break;
                }
                dataBuku[i].kategori = Buku.kategoriBuku.valueOf(kategori);

                System.out.println("Status sebelumnya: " + ((dataBuku[i].statusKetersediaan) ? "TERSEDIA" : "TIDAK TERSEDIA"));
                String statusKetersediaan = scan("Ubah status ketersediaan? [y/t]");
                if (statusKetersediaan.equalsIgnoreCase("y")) {
                    dataBuku[i].statusKetersediaan = !dataBuku[i].statusKetersediaan;
                    continue;
                } else if (statusKetersediaan.equalsIgnoreCase("t")) {
                    continue;
                } else {
                    System.out.println("Input tidak valid! pilih 'y' untuk ya atau 't' untuk tidak");
                    ubahDataBuku();
                }
                System.out.println("Buku berhasil diubah!");
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Judul buku tidak ditemukan!");
            ubahDataBuku();
        }
    }

    private void menuInputDataBuku() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Input Data Buku - Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        inputDataBuku();
        tampilkanDataBuku();
        inputUlangDataBuku();
    }

    private void inputDataBuku() {

        String judulBuku = scan("Masukkan judul buku");
        String penulisBuku = scan("Masukkan penulis buku");
        String kategoriBuku = scan("Masukkan kategori buku (Fiksi/Non Fiksi/Teknologi/Sejarah)");
        if (kategoriBuku.equalsIgnoreCase("Fiksi")) {
            kategoriBuku = "FIKSI";
        } else if (kategoriBuku.equalsIgnoreCase("Non Fiksi")) {
            kategoriBuku = "NON_FIKSI";
        } else if (kategoriBuku.equalsIgnoreCase("Teknologi")) {
            kategoriBuku = "TEKNOLOGI";
        } else if (kategoriBuku.equalsIgnoreCase("Sejarah")) {
            kategoriBuku = "SEJARAH";
        } else {
            System.out.println("Kategori buku tidak tersedia!");
            inputUlangDataBuku();
        }
        boolean statusKetersediaan = true;

        dataBuku[countDataBuku] = new Buku(judulBuku.toUpperCase(), penulisBuku.toUpperCase(), Buku.kategoriBuku.valueOf(kategoriBuku), statusKetersediaan);
        countDataBuku++;

        System.out.println("Buku berhasil ditambahkan!");
    }

    private void inputUlangDataBuku() {
        String inputUlang = scan("Input ulang data buku? [y/t]");
        if (inputUlang.equalsIgnoreCase("y")) {
            menuInputDataBuku();
        } else if (inputUlang.equalsIgnoreCase("t")) {
            kembaliKeMenu();
        } else {
            System.out.println("Input tidak valid! pilih 'y' untuk ya atau 't' untuk tidak");
            inputUlangDataBuku();
        }
    }

    private void tampilkanDataBuku() {
        System.out.printf("%-3s %-30s %-30s %-10s %-20s%n", "No.", "Judul", "Penulis", "Kategori", "Status");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        if (countDataBuku == 0) {
            System.out.println("Tidak ada data buku!");
        } else {
            for (int i = 0; i < countDataBuku; i++) {
                System.out.printf("%-3s %-30s %-30s %-10s %-20s%n", (i + 1), dataBuku[i].judul, dataBuku[i].penulis, dataBuku[i].kategori, ((dataBuku[i].statusKetersediaan) ? "TERSEDIA" : "TIDAK TERSEDIA"));
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    private void menuPinjamBuku() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Peminjaman Buku - Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        tampilkanDataBuku();
        if (countDataBuku != 0) {
            pinjamBuku();
        } else {
            kembaliKeMenu();
        }
    }

    private void pinjamBuku() {
        String judulBuku = scan("Masukkan judul buku (ketik 'selesai' untuk mengakhiri)");
        if (judulBuku.equalsIgnoreCase("selesai")) {
            tampilkanDataBuku();
            kembaliKeMenu();
        } else {
            for (int i = 0; i < countDataBuku; i++) {
                if (judulBuku.equalsIgnoreCase(dataBuku[i].judul)) {
                    if (dataBuku[i].statusKetersediaan) {

                        TransaksiBuku transaksiBuku = new TransaksiBuku();
                        transaksiBuku.judulBuku = dataBuku[i].judul;
                        transaksiBuku.lamaPinjam = 0;
                        transaksiBuku.dendaKeterlambatan = 0;
                        transaksiBuku.statusPinjam = true;
                        dataTransaksiBuku[countDataTransaksiBuku] = transaksiBuku;
                        countDataTransaksiBuku++;
                        dataBuku[i].statusKetersediaan = false;
                        System.out.println("Judul Buku: " + dataBuku[i].judul);
                        System.out.println("Status: Dipinjam!");
                        break;
                    } else {
                        System.out.println("Buku sudah dipinjam!");
                    }
                }
            }
        }
        pinjamBuku();
    }

    private void tampilkanDataTransaksiBuku() {
        System.out.printf("%-3s %-30s %-20s %-20s %-10s%n", "No.", "Judul Buku", "Lama Pinjam (hari)", "Denda Keterlambatan", "Status");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        if (countDataTransaksiBuku == 0) {
            System.out.println("Tidak ada data transaksi buku!");
        } else {
            for (int i = 0; i < countDataTransaksiBuku; i++) {
                System.out.printf("%-3s %-30s %-20s %-20s %-10s%n", (i + 1), dataTransaksiBuku[i].judulBuku, dataTransaksiBuku[i].lamaPinjam, formatRupiah(dataTransaksiBuku[i].dendaKeterlambatan), (dataTransaksiBuku[i].statusPinjam ? "DIPINJAM" : "DIKEMBALIKAN"));
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    private void menuPengembalianBuku() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Pengembalian Buku - Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        tampilkanDataTransaksiBuku();
        if (countDataTransaksiBuku != 0) {
            kembalikanBuku();
        } else {
            kembaliKeMenu();
        }
    }

    private void kembalikanBuku() {
        int countPengembalian = 0;
        String judulBuku = scan("Masukkan judul buku (yang akan dikembalikan)");
        for (int i = 0; i < countDataBuku; i++) {
            if (judulBuku.equalsIgnoreCase(dataBuku[i].judul)) {
                if (!dataBuku[i].statusKetersediaan) {
                    dataBuku[i].statusKetersediaan = true;
                    System.out.println("Judul Buku: " + dataBuku[i].judul);
                    break;
                }
            }
        }

        for (int i = 0; i < countDataTransaksiBuku; i++) {
            if (judulBuku.equalsIgnoreCase(dataTransaksiBuku[i].judulBuku)) {
                String lamaPinjamStr = scan("Lama pinjam (hari)");
                int lamaPinjam = Integer.parseInt(lamaPinjamStr);
                dataTransaksiBuku[i].lamaPinjam = lamaPinjam;
                double dendaKeterlambatan = 0;

                int terlambat = 0;
                if (lamaPinjam > 7) {
                    terlambat = lamaPinjam - 7;
                    dendaKeterlambatan = terlambat * 5000;
                }

                dataTransaksiBuku[i].dendaKeterlambatan = dendaKeterlambatan;

                dataTransaksiBuku[i].statusPinjam = false;
                System.out.println("Status: Dikembalikan!");
                countPengembalian++;
                break;
            }
        }
        if (countPengembalian == 0) {
            kembalikanBuku();
        }
        kembaliKeMenu();
    }

    private void menuCetakStruk() {
        clearConsole();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Struk Peminjaman - Aplikasi Manajemen Perpustakaan");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        tampilkanDataTransaksiBuku();
        kembaliKeMenu();
    }

    private void kembaliKeMenu() {
        String kembali = scan("Kembali ke menu utama? [y/t]");
        if (kembali.equalsIgnoreCase("y")) {
            tampilkanMenu();
        } else if (kembali.equalsIgnoreCase("t")) {
            keluarAplikasi();
        } else {
            System.out.println("Input tidak valid! pilih 'y' untuk ya atau 't' untuk tidak");
            kembaliKeMenu();
        }
    }

    private void kembaliKeMenuManajemenDataBuku() {
        String kembali = scan("Kembali ke menu sebelumnya? [y/t]");
        if (kembali.equalsIgnoreCase("y")) {
            menuManajemenDataBuku();
        } else if (kembali.equalsIgnoreCase("t")) {
            tampilkanMenu();
        } else {
            System.out.println("Input tidak valid! pilih 'y' untuk ya atau 't' untuk tidak");
            kembaliKeMenu();
        }
    }

    private void keluarAplikasi() {
        clearConsole();
        System.out.println("Anda telah keluar dari aplikasi!");
        System.exit(0);
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        new Main().tampilkanMenu();
    }
}
