package entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class SanPham {
	private int sanPhamID, soLuongTon, namSanXuat, soTrang;
	private Date ngayNhap;
	private double giaNhap, thue;
	private String tenSanPham, loaiDoiTra, barcode, imgPath, 
					tinhTrang, loaiSanPham, donViDoLuong, 
					kichThuoc, xuatXu, ngonNgu, loaiBia;
	private TacGia tacGia;
	private TheLoai theLoai;
	private NhaXuatBan nhaXuatBan;
	private ThuongHieu thuongHieu;
	private DanhMuc danhMuc;
	private NhaCungCap nhaCungCap;
	
	
	// contructer cho khuyến mãi
	public SanPham(int sanPhamID, String tenSanPham , int soLuongTon, String imgPath) {
		this.sanPhamID = sanPhamID;
		this.soLuongTon = soLuongTon;
		this.tenSanPham = tenSanPham;
		this.imgPath = imgPath;
	}
	
	public SanPham(int sanPhamID, String tenSanPham) {
		this.sanPhamID = sanPhamID;
		this.tenSanPham = tenSanPham;
	}
	
	public SanPham(int sanPhamID) {
		this.sanPhamID = sanPhamID;
	}
	// Thuộc tính mới trong csdl dưới dạng ID ==>>> Đổi về đối tượng, nhớ kiểm tra xem có tồn tại hay không?

	public int getSanPhamID() {
		return sanPhamID;
	}
	public void setSanPhamID(int sanPhamID) {
		this.sanPhamID = sanPhamID;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon){
		if (soLuongTon < 0)
			this.soLuongTon = 0;
		else
			this.soLuongTon = soLuongTon;
	}
	public int getNamSanXuat() {
		return namSanXuat;
	}
	public void setNamSanXuat(int namSanXuat) throws Exception{
		if (namSanXuat > LocalDate.now().getYear())
			throw new Exception("Năm không được lớn hơn hiện tại");
		this.namSanXuat = namSanXuat;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) throws Exception{
		if (soTrang < 1) 
			throw new Exception("Số trang tối thiểu là 1");
		this.soTrang = soTrang;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	public double getThue() {
		return thue/100;
	}
	public void setThue(double thue) throws Exception{
		if (thue < 0)
			throw new Exception("Thuế không được âm");
		this.thue = thue;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) throws Exception{
		if (tenSanPham.trim().isEmpty() || tenSanPham.trim().isBlank()) {
			throw new Exception("Tên sản phẩm không được để trống");
		}
		this.tenSanPham = tenSanPham;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) throws Exception{
		if (barcode.trim().isEmpty() || barcode.trim().isBlank()) {
			throw new Exception("Barcode không được để trống!");
		}
		this.barcode = barcode;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public String getDonViDoLuong() {
		return donViDoLuong;
	}
	public void setDonViDoLuong(String donViDoLuong) {
		this.donViDoLuong = donViDoLuong;
	}
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public String getLoaiBia() {
		return loaiBia;
	}
	public void setLoaiBia(String loaiBia) {
		this.loaiBia = loaiBia;
	}
	
	

	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	
	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public DanhMuc getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	
	
	public String getLoaiDoiTra() {
		return loaiDoiTra;
	}
	public void setLoaiDoiTra(String loaiDoiTra) {
		this.loaiDoiTra = loaiDoiTra;
	}
	public SanPham(int sanPhamID, int soLuongTon, int namSanXuat,int soTrang, Date ngayNhap, double giaNhap,
			double thue, String tenSanPham, String loaiDoiTra, String barcode, String imgPath, String tinhTrang, String loaiSanPham,
			String donViDoLuong, String kichThuoc, String xuatXu, String ngonNgu, String loaiBia) throws Exception{
		super();
		setSanPhamID(sanPhamID);
		setSoLuongTon(soLuongTon);
		setNamSanXuat(namSanXuat);
		setSoTrang(soTrang);
		setNgayNhap(ngayNhap);
		setGiaNhap(giaNhap);
		setThue(thue);
		setTenSanPham(tenSanPham);
		setLoaiDoiTra(loaiDoiTra);
		setBarcode(barcode);
		setImgPath(imgPath);
		setTinhTrang(tinhTrang);
		setLoaiSanPham(loaiSanPham);
		setDonViDoLuong(donViDoLuong);
		setKichThuoc(kichThuoc);
		setXuatXu(xuatXu);
		setNgonNgu(ngonNgu);
		setLoaiBia(loaiBia);
		
	}

	public SanPham(int sanPhamID, int soLuongTon, int namSanXuat, int soTrang, Date ngayNhap, double giaNhap,
			double thue, String tenSanPham, String loaiDoiTra,String barcode, String imgPath, String tinhTrang, String loaiSanPham,
			String donViDoLuong, String kichThuoc, String xuatXu, String ngonNgu, String loaiBia, TacGia tacGia,
			TheLoai theLoai, NhaXuatBan nhaXuatBan, ThuongHieu thuongHieu, DanhMuc danhMuc, NhaCungCap nhaCungCap) throws Exception {
		super();
		setSanPhamID(sanPhamID);
		setSoLuongTon(soLuongTon);
		setNamSanXuat(namSanXuat);
		setSoTrang(soTrang);
		setNgayNhap(ngayNhap);
		setGiaNhap(giaNhap);
		setThue(thue);
		setTenSanPham(tenSanPham);
		setLoaiDoiTra(loaiDoiTra);
		setBarcode(barcode);
		setImgPath(imgPath);
		setTinhTrang(tinhTrang);
		setLoaiSanPham(loaiSanPham);
		setDonViDoLuong(donViDoLuong);
		setKichThuoc(kichThuoc);
		setXuatXu(xuatXu);
		setNgonNgu(ngonNgu);
		setLoaiBia(loaiBia);
		
		setTacGia(tacGia);
		setTheLoai(theLoai);
		setNhaXuatBan(nhaXuatBan);
		setThuongHieu(thuongHieu);
		setDanhMuc(danhMuc);
		setNhaCungCap(nhaCungCap);
	}
        
        
	public SanPham() {
		super();
		long millis = System.currentTimeMillis();
		this.ngayNhap = new java.sql.Date(millis);
		this.loaiDoiTra = "DUOC_DOI_TRA";
		this.barcode = "";
		this.imgPath = "";
		this.tinhTrang = "CON_HANG";
		this.donViDoLuong = "";
		this.loaiSanPham = "";
		this.donViDoLuong = "";
		this.kichThuoc = "";
		this.xuatXu = "";
		this.ngonNgu = "";
		this.loaiBia = "";
		this.soLuongTon = 0;
		this.namSanXuat = 0;
		this.giaNhap = 0;
		this.soTrang = 1;
	}

	
	/* Tính giá bán */
	public double getGiaBan() {
		// TODO Auto-generated method stub
		return (giaNhap  + giaNhap * 0.2) + (giaNhap  + giaNhap * 0.2) * getThue();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(sanPhamID);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return sanPhamID == other.sanPhamID;
	}
	@Override
	public String toString() {
		return tenSanPham;
	}
	
}
