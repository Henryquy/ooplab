package ProjectOOP.Gamer;

import ProjectOOP.Thanhvien.ThanhVien;

public class Gamer extends ThanhVien {
    private String ingameName;
    private double luongCoBan;
    private double thuongGiai;

    public Gamer(String id, String ten, String sdt, String ingameName, double luongCoBan, double thuongGiai) {
        super(id, ten, sdt);
        this.ingameName = ingameName;
        this.luongCoBan = luongCoBan;
        this.thuongGiai = thuongGiai;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + thuongGiai;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("[GAMER] ID: " + getId() + " | Tên: " + getTen() + " | Ingame: " + ingameName +
                " | SĐT: " + getSdt() + " | Tổng lương: " + tinhLuong());
    }

    @Override
    public String toFileString() {
        return "Gamer," + getId() + "," + getTen() + "," + getSdt() + "," + ingameName + "," + luongCoBan + ","
                + thuongGiai;
    }
}
