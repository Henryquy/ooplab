package ProjectOOP.Thanhvien;

public abstract class ThanhVien {
    private String id;
    private String ten;
    private String sdt;

    public ThanhVien(String id, String ten, String sdt) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Bắt buộc các lớp con phải tự định nghĩa cách tính lương và hiển thị
    public abstract double tinhLuong();

    public abstract void hienThiThongTin();

    public abstract String toFileString();
}
