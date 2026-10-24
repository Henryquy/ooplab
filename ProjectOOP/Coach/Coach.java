package ProjectOOP.Coach;

import ProjectOOP.Thanhvien.ThanhVien;

public class Coach extends ThanhVien {
    private String vaiTro; // VD: HLV Chiến thuật, HLV Phân tích
    private double luongCoBan;
    private double phuCap;

    public Coach(String id, String ten, String sdt, String vaiTro, double luongCoBan, double phuCap) {
        super(id, ten, sdt);
        this.vaiTro = vaiTro;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + phuCap;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("[COACH] ID: " + getId() + " | Tên: " + getTen() + " | Vai trò: " + vaiTro +
                " | SĐT: " + getSdt() + " | Tổng lương: " + tinhLuong());
    }

    @Override
    public String toFileString() {
        return "Coach," + getId() + "," + getTen() + "," + getSdt() + "," + vaiTro + "," + luongCoBan + "," + phuCap;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
}
