package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entities.HangNhap;
import entities.KhuyenMai;
import entities.NhaCungCap;
import interfaces.INhaCungCap;

public class NhaCungCap_DAO implements INhaCungCap{
	private Connection conn;
	private HangNhap_DAO hangNhap_DAO;
	
	@Override
	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		
		try {
			Statement stm =  conn.createStatement();
			String query = "SELECT * FROM NhaCungCap";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("NhaCungCapID"), rs.getString("TenNhaCungCap"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("DiaChi"));
					list.add(nhaCungCap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<NhaCungCap> getNCCByID(String maNCC) {
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM NhaCungCap WHERE NhaCungCapID LIKE '%"+maNCC+"%'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("NhaCungCapID"), rs.getString("TenNhaCungCap"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("DiaChi"));
					list.add(nhaCungCap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<NhaCungCap> getNCCByPhone(String sdt) {
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM NhaCungCap WHERE SoDIenThoai = '%"+sdt+"%'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("NhaCungCapID"), rs.getString("TenNhaCungCap"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("DiaChi"));
					list.add(nhaCungCap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<NhaCungCap> getNCCByEmail(String email) {
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM NhaCungCap WHERE Email LIKE '%"+email+"%'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("NhaCungCapID"), rs.getString("TenNhaCungCap"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("DiaChi"));
					list.add(nhaCungCap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<NhaCungCap> getNCCByName(String name) {
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM NhaCungCap WHERE TenNhaCungCap LIKE '%"+name+"%'";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				try {
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("NhaCungCapID"), rs.getString("TenNhaCungCap"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("DiaChi"));
					list.add(nhaCungCap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public boolean addNhaCungCap(NhaCungCap ncc) {
		
		String insert = "INSERT INTO NhaCungCap (NhaCungCapID,TenNhaCungCap,SoDIenThoai,Email,DiaChi) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setString(1, ncc.getNhaCungCapID());
			preparedStatement.setString(2, ncc.getTenNhaCungCap());
			preparedStatement.setString(3, ncc.getSoDienThoai());
			preparedStatement.setString(4, ncc.getEmail());
			preparedStatement.setString(5, ncc.getDiaChi());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Trùng mã nhà cung cấp");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap ncc) {
//		String maNCC = ncc.getNhaCungCapID();
//		String tenNCC = ncc.getTenNhaCungCap();
//		String SDT = ncc.getSoDienThoai();
//		String email = ncc.getEmail();
//		String diaChi = ncc.getDiaChi();
//		
		String update = "UPDATE NhaCungCap SET TenNhaCungCap = ?, SoDIenThoai = ?, Email = ?, DiaChi = ? Where NhaCungCapID =  ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(update);
			preparedStatement.setString(1, ncc.getTenNhaCungCap());
			preparedStatement.setString(2, ncc.getSoDienThoai());
			preparedStatement.setString(3, ncc.getEmail());
			preparedStatement.setString(4, ncc.getDiaChi());
			preparedStatement.setString(5, ncc.getNhaCungCapID());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int layMaNCCCuoiCung() {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM NhaCungCap");
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			return 0;
		}
	}

	public NhaCungCap_DAO() {
		this.conn = ConnectDB.getConnection();
		this.hangNhap_DAO = new HangNhap_DAO();
	}
}
