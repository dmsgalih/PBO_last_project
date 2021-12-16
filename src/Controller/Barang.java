package Controller;

import Model.ModelBarang;

import java.sql.SQLException;
import java.util.Scanner;

public class Barang {
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    ModelBarang barang = new ModelBarang();

    public Barang() throws SQLException {
    }
    public void showBarang() throws SQLException {
        barang.showBarang();
    }
    public void addBarang() throws SQLException {
        System.out.println("MASUKKAN DETAIL PRODUK");
        System.out.print("ID Barang : ");
        int id = sc1.nextInt();
        System.out.print("Nama Barang : ");
        String nama = sc.nextLine();
        System.out.print("Keterangan : ");
        String keterangan = sc.nextLine();
        System.out.print("Harga : ");
        int harga = sc.nextInt();

        barang.addBarang(id,nama,harga,keterangan);


    }

    public void updateNamaBarang() throws SQLException {
        System.out.println("EDIT NAMA BARANG");
        System.out.print("ID Produk : ");
        int id = sc.nextInt();
        System.out.print("Nama : ");
        String nama = sc.next();

        barang.UpdateNamaBarang(id,nama);
    }

    public void updateHargaBarang() throws SQLException {
        System.out.println("EDIT NAMA BARANG");
        System.out.print("ID Produk : ");
        int id = sc.nextInt();
        System.out.print("Harga : ");
        int harga = sc.nextInt();

        barang.UpdateHargaBarang(id,harga);
    }
    public void deleteBarang() throws SQLException {
        System.out.println("HAPUS BARANG");
        System.out.print("ID Produk : ");
        int id = sc.nextInt();
        barang.deleteDataBarang(id);
    }
}
