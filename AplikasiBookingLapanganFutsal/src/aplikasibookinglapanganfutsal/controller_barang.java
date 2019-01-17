package aplikasibookinglapanganfutsal;

import java.sql.SQLException;

public interface controller_barang {
    public void Simpan(Frame_booking_lapangan brg) throws SQLException;
    public void Ubah (Frame_booking_lapangan brg) throws SQLException;
    public void Hapus(Frame_booking_lapangan brg) throws SQLException;
    public void Tampil (Frame_booking_lapangan brg) throws SQLException;
    public void Bersih(Frame_booking_lapangan brg) throws SQLException;
    public void KlikTabel (Frame_booking_lapangan brg) throws SQLException;
    public void Combo (Frame_booking_lapangan brg) throws SQLException;
    public void Combo2 (Frame_booking_lapangan brg) throws SQLException;
}
