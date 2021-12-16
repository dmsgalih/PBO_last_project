package Controller;

import Model.ModelPegawai;

import java.sql.SQLException;

public class Pegawai {
    ModelPegawai pegawai = new ModelPegawai();

    public Pegawai() throws SQLException {
    }

    public void showPegawai() throws SQLException {
        pegawai.showPegawai();

    }
}
