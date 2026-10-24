package ProjectOOP.MainApp;

import ProjectOOP.Coach.Coach;
import ProjectOOP.Gamer.Gamer;
import ProjectOOP.HoiThao.HoiThao;
import ProjectOOP.QuangLyFile.QuangLyFile;
import ProjectOOP.Thanhvien.ThanhVien;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    static ArrayList<ThanhVien> danhSachNhanSu = new ArrayList<>();
    static ArrayList<HoiThao> danhSachLich = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Nhờ tách class, dòng gọi hàm đọc file trở nên cực kỳ ngắn gọn
        QuangLyFile.docDuLieu(danhSachNhanSu, danhSachLich);

        int luaChon = -1;
        while (luaChon != 0) {
            System.out.println("\n=== HỆ THỐNG ESPORTS ===");
            System.out.println("1. Quản lý Nhân sự (Thêm, Xóa, Hiển thị...)");
            System.out.println("2. Quản lý Lịch đấu/Hội thảo");
            System.out.println("0. Lưu và Thoát");
            System.out.print("Chọn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lỗi: Nhập số đi bạn!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    int luaChonNS = -1;
                    while (luaChonNS != 0) {
                        System.out.println("\n--- QUẢN LÝ NHÂN SỰ ---");
                        System.out.println("1. Thêm nhân sự mới");
                        System.out.println("2. Xóa nhân sự theo ID");
                        System.out.println("3. Hiển thị danh sách");
                        System.out.println("0. Quay lại Menu chính");
                        System.out.print("Chọn: ");

                        try {
                            luaChonNS = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Lỗi: Nhập số đi bạn!");
                            continue;
                        }

                        switch (luaChonNS) {
                            case 1:
                                System.out.print("Bạn muốn thêm ai? (1: Gamer | 2: Coach): ");
                                int loai = Integer.parseInt(scanner.nextLine());
                                if (loai == 1) {
                                    System.out.println("\n--- NHẬP THÔNG TIN GAMER ---");
                                    System.out.print("Nhập ID: ");
                                    String id = scanner.nextLine();
                                    System.out.print("Nhập Tên: ");
                                    String ten = scanner.nextLine();
                                    System.out.print("Nhập SĐT: ");
                                    String sdt = scanner.nextLine();
                                    System.out.print("Nhập Ingame Name: ");
                                    String ingame = scanner.nextLine();
                                    System.out.print("Nhập Lương cơ bản: ");
                                    double luongCB = Double.parseDouble(scanner.nextLine());
                                    System.out.print("Nhập Tiền thưởng: ");
                                    double thuong = Double.parseDouble(scanner.nextLine());

                                    danhSachNhanSu.add(new Gamer(id, ten, sdt, ingame, luongCB, thuong));
                                    System.out.println("✅ Đã thêm Gamer thành công!");
                                } else if (loai == 2) {
                                    System.out.println("\n--- NHẬP THÔNG TIN COACH ---");
                                    System.out.print("Nhập ID: ");
                                    String id = scanner.nextLine();
                                    System.out.print("Nhập Tên: ");
                                    String ten = scanner.nextLine();
                                    System.out.print("Nhập SĐT: ");
                                    String sdt = scanner.nextLine();
                                    System.out.print("Nhập Chuyên môn: ");
                                    String chuyenMon = scanner.nextLine();
                                    System.out.print("Nhập Lương cơ bản: ");
                                    double luongCB = Double.parseDouble(scanner.nextLine());
                                    System.out.print("Nhập Tiền thưởng: ");
                                    double thuong = Double.parseDouble(scanner.nextLine());

                                    danhSachNhanSu.add(new Coach(id, ten, sdt, chuyenMon, luongCB, thuong));
                                    System.out.println("✅ Đã thêm Coach thành công!");
                                }
                                break;
                            case 2:
                                System.out.print("Nhập ID nhân sự cần xóa: ");
                                String idXoa = scanner.nextLine();
                                boolean timThay = false;
                                for (int i = 0; i < danhSachNhanSu.size(); i++) {
                                    if (danhSachNhanSu.get(i).getId().equalsIgnoreCase(idXoa)) {
                                        danhSachNhanSu.remove(i);
                                        System.out.println("✅ Đã tiễn nhân sự có ID '" + idXoa + "' ra chuồng gà!");
                                        timThay = true;
                                        break;
                                    }
                                }
                                if (!timThay) {
                                    System.out.println("❌ Không tìm thấy ai có ID này!");
                                }
                                break;
                            case 3:
                                System.out.println("\n--- DANH SÁCH NHÂN SỰ HIỆN TẠI ---");
                                if (danhSachNhanSu.isEmpty()) {
                                    System.out.println("Chưa có ai trong đội!");
                                } else {
                                    for (ThanhVien tv : danhSachNhanSu) {
                                        tv.hienThiThongTin();
                                    }
                                }
                                break;
                            case 0:
                                System.out.println("Đang quay lại Menu chính...");
                                break;
                            default:
                                System.out.println("❌ Lựa chọn không hợp lệ!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n--- DANH SÁCH LỊCH ĐẤU/HỘI THẢO ---");
                    if (danhSachLich.isEmpty()) {
                        System.out.println("Hiện chưa có lịch nào!");
                    } else {
                        for (HoiThao ht : danhSachLich) {
                            ht.hienThiLich();
                        }
                    }
                    break;
                case 0:
                    QuangLyFile.ghiDuLieu(danhSachNhanSu, danhSachLich);
                    System.out.println("Đã lưu dữ liệu. Bye!");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }
}