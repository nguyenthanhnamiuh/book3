package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChiTietHoaDon;
import entities.DanhMuc;
import entities.NhaCungCap;
import entities.NhaXuatBan;
import entities.SanPham;
import entities.TacGia;
import entities.TheLoai;
import entities.ThuongHieu;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietTraHang;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietHoaDon_DAO implements IChiTietHoaDon {
	private Connection conn;
	@Override
	public boolean addMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstm = conn.prepareStatement(
				"INSERT INTO ChiTietHoaDon(hoaDonID,sanPhamID,soLuong,donGia)VALUES(?,?,?,?)"
			);

			pstm.setString(1, x.getHoaDon().getHoaDonID());
			pstm.setInt(2, x.getSanPham().getSanPhamID());
			pstm.setInt(3, x.getSoLuong());
			pstm.setDouble(4, x.getSanPham().getGiaBan());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(ArrayList<ChiTietHoaDon> x) {
            
            // Xoá chi tiết hoá đơn cũ để cập nhật lại
            if (x.size() < 1)
                return true;
            try {
                // TODO Auto-generated method stub
                PreparedStatement pstm = conn.prepareStatement(
                        "DELETE FROM ChiTietHoaDon WHERE HoaDonID = ?"
                );
                
                pstm.setString(1, x.get(0).getHoaDon().getHoaDonID());
                
                pstm.executeUpdate();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            // Cập nhật chi tiết hoá đơn mới
		for (ChiTietHoaDon y : x) {
			if (!addMotChiTietCuaHoaDon(y))
				return false;
		}
		return true;
	}
	@Override
	public ArrayList<ChiTietHoaDon> getAllChiTietCuaMotHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
		ArrayList<ChiTietHoaDon> listCT = new ArrayList<ChiTietHoaDon>();

		try {
			PreparedStatement pstm = conn.prepareStatement(
				"SELECT * FROM ChiTietHoaDon cthd JOIN SanPham sp ON cthd.SanPhamID = sp.SanPhamID WHERE HoaDonID = ?"
			);

			pstm.setString(1, maHoaDon);
			
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				TacGia tg = new TacGia();
				NhaCungCap ncc = new NhaCungCap();
				TheLoai tl = new TheLoai();
				NhaXuatBan nxb = new NhaXuatBan();
				DanhMuc dm = new DanhMuc();
				ThuongHieu th = new ThuongHieu();
				int sanphamid = rs.getInt("sanphamid");
				int soLuongTon = rs.getInt("soluongton");
				int namsx = rs.getInt("namsanxuat"); 
				int sotrang = rs.getInt("sotrang"); 
				Date ngaynhap =  rs.getDate("ngaynhap"); 
				double gianhap = rs.getDouble("gianhap"); 
				double thue = rs.getDouble("thue"); 
				String tensanpham = rs.getString("tensanpham"); 
				String loaidoitra = rs.getString("loaidoitra");
				String barcode = rs.getString("barcode"); 
				String img = rs.getString("imgpath"); 
				String tinhtrang = rs.getString("tinhtrang"); 
				String loaisanpham = rs.getString("loaisanpham"); 
				String donvidoluong = rs.getString("donvidoluong"); 
				String kichthuoc = rs.getString("kichthuoc"); 
				String xuatxu = rs.getString("xuatxu"); 
				String ngongu = rs.getString("ngonngu"); 
				String loaibia = rs.getString("loaibia"); 
				
				int tacgiaid = rs.getInt("tacgiaid"); 
				int theloaiid = rs.getInt("theloaiid"); 
				int nhaxuatbanid = rs.getInt("nhaxuatbanid"); 
				int thuonghieuid = rs.getInt("thuonghieuid"); 
				int danhmucid = rs.getInt("danhmucid"); 
				String nhacungcapid = rs.getString("nhacungcapid");
				
				tg.setTacGiaID(tacgiaid);
				tl.setTheLoaiID(theloaiid);
				nxb.setNhaXuatBanID(nhaxuatbanid);
				th.setThuongHieuID(thuonghieuid);
				dm.setDanhMucID(danhmucid);
				ncc.setNhaCungCapID(nhacungcapid);
				
				SanPham sanPham = new SanPham(sanphamid, soLuongTon, namsx, 
						 sotrang, ngaynhap, gianhap, thue, tensanpham, 
						loaidoitra, barcode, img, tinhtrang, loaisanpham, donvidoluong, 
						kichthuoc, xuatxu, ngongu, loaibia,
						tg, tl, nxb, th, dm, ncc);
				ChiTietHoaDon cthd = new ChiTietHoaDon(sanPham,
						rs.getInt("soLuong"));
				cthd.setDonGia(rs.getDouble("donGia"));
				listCT.add(cthd);
			}
			
			return listCT;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listCT;
		}
	}
	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietHoaDon x) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ChiTietHoaDon_DAO() {
		// TODO Auto-generated constructor stub
		conn = ConnectDB.getConnection();
	}

}
