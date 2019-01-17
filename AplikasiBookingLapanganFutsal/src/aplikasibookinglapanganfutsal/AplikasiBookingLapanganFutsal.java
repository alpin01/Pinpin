package aplikasibookinglapanganfutsal;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class AplikasiBookingLapanganFutsal implements controller_barang 
{
 public void Tanggal(Frame_booking_lapangan brg) throws SQLException {
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd");
        brg.tanggal.setText(kal.format(sekarang));
    }    
    public void Simpan(Frame_booking_lapangan brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "insert barang values(?,?,?,?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, brg.txtKode_booking.getText());
            prepare.setString(2, brg.txtid_kategori.getText());
            prepare.setString(3, brg.tanggal.getText());
            prepare.setString(4, brg.waktu.getText());
            prepare.setString(5, brg.txtNama.getText());
            prepare.setString(6, brg.txtTeam.getText());
            prepare.setString(7, brg.txtNo.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
            
        } 
    }

   
    public void Ubah(Frame_booking_lapangan brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "update barang set nama = ?, "
                    + "id_kategori = ?, "
                    + "harga = ?, "
                    + "where kode_barang = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, brg.txtKode_booking.getText());
            prepare.setString(2, brg.txtid_kategori.getText());
            prepare.setString(3, brg.tanggal.getText());
            prepare.setString(4, brg.waktu.getText());
            prepare.setString(5, brg.txtNama.getText());
            prepare.setString(6, brg.txtTeam.getText());
            prepare.setString(7, brg.txtNo.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        }
    }


    
    public void Hapus(Frame_booking_lapangan brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "delete from barang where kode_barang = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, brg.txtKode_booking.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasi Dihapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        }
    }

   
    public void Tampil(Frame_booking_lapangan brg) throws SQLException {
        brg.tbl.getDataVector().removeAllElements();
        brg.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from barang order by kode_booking asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);
                ob[4] = rs.getString(5);
                ob[5] = rs.getString(6);
                ob[6] = rs.getString(7);
                brg.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   
    public void Bersih(Frame_booking_lapangan brg) {
        brg.txtKode_booking.setText(null);
        brg.cmblpng.setSelectedItem("Katagori");
        brg.txtid_kategori.setText(null);
        brg.waktu.setText(null);
        brg.txtNama.setText(null);
        brg.txtTeam.setText(null);
        brg.txtNo.setText(null);
        brg.txtKode_booking.requestFocus();
    }

   
    public void KlikTabel(Frame_booking_lapangan brg) throws SQLException {
        try {
            int pilih = brg.tblBarang.getSelectedRow();
            String s = (String)brg.tblBarang.getModel().getValueAt(pilih, 4);
            SimpleDateFormat f = new SimpleDateFormat("yyyy-M-dd");
            Date d = f.parse(s);
            if (pilih == -1) {
                return; 
            }
            brg.txtKode_booking.setText(brg.tbl.getValueAt(pilih, 0).toString());
            brg.txtid_kategori.setText(brg.tbl.getValueAt(pilih, 1).toString());
            brg.tanggal.setText(brg.tbl.getValueAt(pilih, 2).toString());
            brg.waktu.setText(brg.tbl.getValueAt(pilih, 3).toString());
            brg.txtNama.setText(brg.tbl.getValueAt(pilih, 4).toString());
            brg.txtTeam.setText(brg.tbl.getValueAt(pilih, 5).toString());
            brg.txtNo.setText(brg.tbl.getValueAt(pilih, 6).toString());
        } catch (Exception e) {
        }
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select nama from kategori where id_kategori = '"+brg.txtid_kategori.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                Object[] ob = new Object[3];
                
                ob[1] = rs.getString(1);

                brg.cmblpng.setSelectedItem(rs.getString("nama"));
            }
            rs.close(); st.close();
        } catch (Exception e) {
        }
    }    

   
    public void Combo(Frame_booking_lapangan brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select nama from kategori";
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.cmblpng.addItem((String) ob[1]);                                    
            }
            rs.close(); st.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

   
    

   
    public void Combo2(Frame_booking_lapangan brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select id_kategori from kategori where nama = '"+brg.cmblpng.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.txtid_kategori.setText(rs.getString("id_kategori"));
            }
            rs.close(); st.close();
        } catch (Exception e) {
        }
    }
}
