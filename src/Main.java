import Model.ModelBarang;
import View.*;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {
        Barang barang = new Barang();
        Customer cus = new Customer();
        Pegawai pegawai = new Pegawai();
        Service service = new Service();
        Transaksi transaksi = new Transaksi();
        boolean play = true;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        while(play){
            try{
                System.out.println("============================");
                System.out.println("  SELAMAT DATANG DI BENGKEL");
                System.out.println("           MUKIDI");
                System.out.println("============================");
                System.out.println("1. Lihat Barang\n2. Kelola Barang\n3. Lihat Pegawai\n4. Lihat Service\n5. Kelola Service\n6. Riwayat Transaksi\n7. Keluar");
                System.out.print("Pilih menu :");
                int pilih = sc.nextInt();
                if(pilih==1){
                    barang.showBarang();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==2){
                    System.out.println("KELOLA BARANG");
                    System.out.println("1. Tambah Barang\n2. Update Barang\n3. Hapus Barang");
                    System.out.print("Pilihan : ");
                    int kelola = sc.nextInt();
                    if(kelola==1){
                        barang.addBarang();
                    }else if(kelola==2){
                        System.out.println("1. Update Nama\n2. Update harga");
                        System.out.print("Pilihan : ");
                        int update = sc.nextInt();
                        if(update==1){
                            barang.showBarang();
                            barang.updateNamaBarang();
                        }else if(update==2){
                            barang.showBarang();
                            barang.updateHargaBarang();
                        }


                    }else if(kelola==3){
                        barang.showBarang();
                        barang.deleteBarang();
                    }

                }else if(pilih==3){
                    pegawai.showPegawai();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();


                }else if(pilih==4){
                    service.showService();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==5){
                    System.out.println("KELOLA SERVICE");
                    System.out.println("1. Tambah Service\n2. Update Service");
                    System.out.print("Pilihan : ");
                    int kelola = sc.nextInt();
                    if(kelola==1){
                        service.addService();
                    }else if(kelola==2){
                        service.updateService();
                    }

                }else if(pilih==6){
                    transaksi.showTransaksi();
                    System.out.println("Enter untuk lanjut ..");
                    sc1.nextLine();

                }else if(pilih==7){
                    play=false;

                }


            }catch (InputMismatchException e){
                System.out.println("Mohon maaf inputan salah");
                break;

            }
        }

    }

}
