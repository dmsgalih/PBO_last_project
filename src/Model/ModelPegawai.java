package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelPegawai extends TemplateModel{
    final String lihatPegawai = "select * from pegawai";

    public ModelPegawai() throws SQLException {
        super();
    }

    public void showPegawai () throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(lihatPegawai);
        ResultSet rs = preparedStatement.executeQuery();

        System.out.println("==============================================================================================");
        System.out.printf("|%-5s | %-30s | %-50s |%n","No","ID Pegawai","Nama Pegawai");
        System.out.println("==============================================================================================");
        int num = 1;
        while(rs.next()){
            System.out.printf("|%-5d | %-30s | %-50s |%n",num,String.valueOf(rs.getInt("id_pegawai")),rs.getString("nama_pegawai"));
            num++;

        }
    }
}
