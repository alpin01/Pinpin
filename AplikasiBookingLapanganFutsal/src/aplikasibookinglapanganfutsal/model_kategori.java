package aplikasibookinglapanganfutsal;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class model_kategori  {


    public void Simpan(FrmKategori ktg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "insert kategori values (?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, ktg.txtid_kategori.getText());
            prepare.setString(2, ktg.txtnama_kategori.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(ktg);
            ktg.setLebarKolom();
            Bersih(ktg);
        }
    }


    public void Ubah(FrmKategori ktg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "update kategori set nama = ? where id_kategori = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, ktg.txtnama_kategori.getText());
            prepare.setString(2, ktg.txtid_kategori.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(ktg);
            ktg.setLebarKolom();
            Bersih(ktg);
            AutoNomor(ktg);
        }
    }


    public void Hapus(FrmKategori ktg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "delete from kategori where id_kategori = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, ktg.txtid_kategori.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(ktg);
            ktg.setLebarKolom();
            Bersih(ktg);
            AutoNomor(ktg);
        }
    }


    public void Tampil(FrmKategori ktg) throws SQLException {
        ktg.tbl.getDataVector().removeAllElements();
        ktg.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from kategori order by id_kategori asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ktg.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void Bersih(FrmKategori ktg) throws SQLException {
        ktg.txtid_kategori.setText(null);
        ktg.txtnama_kategori.setText(null);
        ktg.txtnama_kategori.requestFocus();
    }


    public void KlikTabel(FrmKategori ktg) throws SQLException {
        try {
            int pilih = ktg.tblKategori.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            ktg.txtid_kategori.setText(ktg.tbl.getValueAt(pilih, 0).toString());
            ktg.txtnama_kategori.setText(ktg.tbl.getValueAt(pilih, 1).toString());
        } catch (Exception e) {
        } finally {
            ktg.txtnama_kategori.requestFocus();
        }
    }


    public void AutoNomor(FrmKategori ktg) throws SQLException {
         try{
            Connection con = koneksi.getKoneksi();
            
            Statement st = con.createStatement();
            String sql = "select max(id_kategori) from kategori";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                ktg.txtid_kategori.setText(""+ Integer.toString(a+1));
            }
        }catch (Exception e){
            System.out.println(""+ e.getMessage());
        }
    }
        
}
