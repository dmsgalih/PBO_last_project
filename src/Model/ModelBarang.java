package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class ModelBarang extends TemplateModel {
    final String lihatBarang = "select * from barang";
    final String tambahBarang = "insert into barang (id_Barang,nama_Barang,harga,keterangan) values (?,?,?,?)";
    final String updateNamaBarang = "update barang set nama_Barang = ? where id_Barang = ?";
    final String updateHargaBarang = "update barang set harga = ? where id_Barang = ?";
    final String deleteBarang = "delete from barang where id_Barang = ?";

    public ModelBarang() throws SQLException {
        super();
    }

    public void showBarang() throws SQLException {
        Locale indo = new Locale("in","ID");
        Currency rupiah = Currency.getInstance(indo);
        NumberFormat format_rupiah = NumberFormat.getCurrencyInstance(indo);


        PreparedStatement preparedStatement = connection.prepareStatement(lihatBarang);
        ResultSet rs = preparedStatement.executeQuery();
        System.out.println("======================================================================================");
        System.out.println(String.format("|%-10s | %-30s | %-25s | %-10s|","ID Barang","Nama Barang","Harga","Keterangan"));
        System.out.println("======================================================================================");

        while(rs.next()){
            System.out.println(String.format("|%-10s | %-30s | %-25s | %-10s|",rs.getString("id_Barang"),rs.getString("nama_Barang"),format_rupiah.format(rs.getInt("harga")),rs.getString("keterangan")));


        }
    }

    public void addBarang(int id_barang,String nama,int harga,String keterangan ) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(tambahBarang);

        preparedStatement.setInt(1,id_barang);
        preparedStatement.setString(2,nama);
        preparedStatement.setInt(3,harga);
        preparedStatement.setString(4,keterangan);

        preparedStatement.executeUpdate();


    }

    public void UpdateHargaBarang(int id_barang,int harga) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updateHargaBarang);

        preparedStatement.setInt(1,harga);
        preparedStatement.setInt(2,id_barang);

        preparedStatement.executeUpdate();

    }

    public void UpdateNamaBarang(int id_barang,String nama) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updateNamaBarang);

        preparedStatement.setString(1,nama);
        preparedStatement.setInt(2,id_barang);

        preparedStatement.executeUpdate();

    }

    public void deleteDataBarang(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(deleteBarang);
        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();

    }

}
