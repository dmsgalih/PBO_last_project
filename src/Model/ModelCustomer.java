package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelCustomer extends TemplateModel{
    final String lihatCustomer = "select * from customer ";
    public ModelCustomer() throws SQLException {
        super();
    }

    public void showCustomer () throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(lihatCustomer);
        ResultSet rs = preparedStatement.executeQuery();

        System.out.println("==============================================================================================");
        System.out.printf("|%-5s | %-30s | %-50s |%n","No","ID Customer","Nama Customer");
        System.out.println("==============================================================================================");
        int num = 1;
        while(rs.next()){
            System.out.printf("|%-5d | %-30s | %-50s |%n",num,String.valueOf(rs.getInt("id_customer")),rs.getString("nama_customer"));
            num++;

        }
    }

}
