package utilities;

import java.time.LocalDate;

/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 * @description: 
 * 				1. Các pattern để ràng buộc dữ liệu
 *
 */


public class RegexPattern {
	public static final String HOTEN = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$";

	public static final String SDTVN = "^[0][\\d]{9}$";
	
	public static final String EMAIL = "^(([A-Za-z0-9]+)(([\\.]?)([A-Za-z0-9]+))+)(@)(([A-Za-z0-9]+\\.)([A-Za-z0-9]+))+$";
	
	public static final String KHONG_TRONG_TIENG_VIET = "^([A-Za-zÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ ]+)$";
	
	public static final String MAHANGNHAP = "^(HN)[\\d]+$";
	
	public static String getRegexCCCD(LocalDate dob, boolean gioiTinh) {
		String regex = "";
		int maTheKiVaGioiTinh = (((dob.getYear() / 100) + 1) % 20) * 2 + (gioiTinh ? 0 : 1);
		String maNamSinh = ((dob.getYear() / 10) % 10 )+ "" + (dob.getYear() % 10) ;
		regex = "^(([\\d]{3}(" + maTheKiVaGioiTinh +")(" + maNamSinh +")(\\d{6}))|([\\d]{9}))$";
		return regex;
	}
}