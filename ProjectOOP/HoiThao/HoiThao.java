package ProjectOOP.HoiThao;

public class HoiThao {
    private String maLich;
    private String noiDung;
    private String thoiGian;

    public HoiThao(String maLich, String noiDung, String thoiGian) {
        this.maLich = maLich;
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
    }

    public void hienThiLich() {
        System.out.println("Mã Lịch: " + maLich + " | Nội dung: " + noiDung + " | Thời gian: " + thoiGian);
    }

    public String toFileString() {
        return maLich + "," + noiDung + "," + thoiGian;
    }
}
