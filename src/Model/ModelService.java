package Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelService extends TemplateModel{
    final String lihatService = "select * from dataservice;";
    final String UpdateNamaService = "update dataservice set nama_service = ? where id_service = ?";
    final String UpdateKeteranganService = "update dataservice set keterangan = ? where id_service = ?";
    final String menambahDataService = "insert into dataservice (nama_service,jumlah_service,tanggal,id_customer,keterangan) values (?,?,?,?,?);";
    public ModelService() throws SQLException {
        super();
    }
    public void addService(String nama_service, int jumlah_service, Date tanggal, int id_customer, String keterangan) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(menambahDataService);

        preparedStatement.setString(1,nama_service);
        preparedStatement.setInt(2,jumlah_service);
        preparedStatement.setDate(3,tanggal);
        preparedStatement.setInt(4,id_customer);
        preparedStatement.setString(5,keterangan);

        preparedStatement.executeUpdate();



    }

    public void showService() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(lihatService);
        ResultSet rs = preparedStatement.executeQuery();

        System.out.println("===============================================================================================================================");
        System.out.println(String.format("| %-5s | %-11s |%-26s | %-8s | %-15s | %-10s | %-30s |","No","ID Service","Nama Service","Jumlah","Tanggal","ID Customer","Keterangan"));
        System.out.println("===============================================================================================================================");int num = 1;
        while(rs.next()){
            System.out.println(String.format("| %-5d | %-11d | %-25s | %-8d | %-15s | %-11d | %-30s |",num,rs.getInt("id_service"),rs.getString("nama_service"),rs.getInt("jumlah_service"),rs.getDate("tanggal"),rs.getInt("id_customer"),rs.getString("keterangan")));
            num++;

        }
    }

    public void updateNamaService(String nama,int id_service) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UpdateNamaService);

        preparedStatement.setString(1,nama);
        preparedStatement.setInt(2,id_service);

        preparedStatement.executeUpdate();
    }
    public void updateKeteranganService(String ket,int id_service) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UpdateKeteranganService);

        preparedStatement.setString(1,ket);
        preparedStatement.setInt(2,id_service);

        preparedStatement.executeUpdate();
    }
}
