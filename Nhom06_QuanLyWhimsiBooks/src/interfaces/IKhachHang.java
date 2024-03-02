package interfaces;

import java.util.ArrayList;

import entities.KhachHang;
import entities.NhanVien;

public interface IKhachHang {
	public ArrayList<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang);

	public ArrayList<KhachHang> getAllKhachHang();

	public int totalKhachHang();

	public boolean addKhachHang(KhachHang kh);

	public KhachHang getKhachHangByKhachHangID(String ma);

	public boolean editKhachHang(KhachHang kh);

	public boolean deleteKhachHang(KhachHang kh);

	public String getLayTenTuMa(String x);

	public ArrayList<NhanVien> findKhachHang(String x);

	public int phatSinhMaKhachHang();

	String phatSinhMaSoThue(String loaiKhachHang);

	public KhachHang getKhachHangTuMaVaSDT(String x);

	public boolean checkIfKhachHangExists(String maKH);
	public boolean chuyenLoaiKhachHang(String maKhachHang, String loaiKhachHangMoi) ;
}
