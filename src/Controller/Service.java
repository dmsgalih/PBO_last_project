package Controller;

import Model.ModelService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    Scanner sc = new Scanner(System.in);
    ModelService service = new ModelService();

    public Service() throws SQLException {
    }

    public void addService() throws SQLException {
        System.out.print("Nama : ");
        String nama = sc.nextLine();
        System.out.print("Keterangan : ");
        String ket = sc.nextLine();
        System.out.print("Tanggal (yyyy-mm-dd) : ");
        Date date = Date.valueOf(sc.nextLine());
        System.out.print("Jumalah : ");
        int jumlah = sc.nextInt();
        System.out.print("ID Customer : ");
        int id_cus = sc.nextInt();

        service.addService(nama,jumlah,date,id_cus,ket);

    }

    public void showService() throws SQLException {
        service.showService();
    }

    public void updateService() throws SQLException {
        System.out.println("PILIH UPDATE");
        System.out.println("1. Nama\n2. Keterangan");
        System.out.print("Pilih : ");
        int pilihan = sc.nextInt();

        if(pilihan==1){
            Scanner sc1 = new Scanner(System.in);
            System.out.print("ID Service : ");
            int id = sc.nextInt();
            System.out.print("Nama : ");
            String nama = sc1.nextLine();
            service.updateNamaService(nama,id);
        } else if (pilihan==2){
            Scanner sc1 = new Scanner(System.in);
            System.out.print("ID Service : ");
            int id = sc.nextInt();
            System.out.print("Keterangan : ");
            String ket = sc1.nextLine();
            service.updateKeteranganService(ket,id);
        }


    }
}
