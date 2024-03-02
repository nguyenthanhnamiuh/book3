package interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import entities.HoaDon;
import entities.SanPham;
import entities.ThuongHieu;

public interface ISanPham {
	public ArrayList<SanPham> laySanPhamChoKM();
	public ArrayList<SanPham> getDanhSachSanPham(String query);
	public ArrayList<SanPham> getDanhSachSanPham();
	public ArrayList<SanPham> searchSanPham(String id);
	public boolean addSanPham(SanPham sp);
        public boolean editTrangThaiSanPham(SanPham sp);
	public boolean editSanPham(SanPham sp);
	public ArrayList<SanPham> getDanhSachSanPhamSapHet();
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x);

	public ArrayList<SanPham> getSPTheoThuongHieu(String maThuongHieu);
	public ArrayList<ThuongHieu> getThuongHieu();

        public int getIdTacGiaByName(String name);
        public int getIdTheloaiByName(String name);
        public int getIdNhaXuatBanByName(String name);
        public String getIdNhaCungCapByName(String name);
        public int getIdThuongHieuByName(String name);
        public int getIdDanhMucByName(String name);
        
        public String getNameTacGiaByID(int ID);
        public String getNameNhaXuatBanByID(int ID);
        public String getNameDanhMucByID(int ID);
        public String getNameTheLoaiByID(int ID);
        public String getNameThuongHieuByID(int ID);
        public String getNameNhaCungCapByID(String ID);
        public void SapXepTangTheoGia(ArrayList<SanPham> list);
        public void SapXepGiamTheoGia(ArrayList<SanPham> list);
        public void SapXepTangTheoSoLuong(ArrayList<SanPham> list);
	
}
