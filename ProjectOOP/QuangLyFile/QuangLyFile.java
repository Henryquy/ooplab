package ProjectOOP.QuangLyFile;

import ProjectOOP.Coach.Coach;
import ProjectOOP.Gamer.Gamer;
import ProjectOOP.HoiThao.HoiThao;
import ProjectOOP.Thanhvien.ThanhVien;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuangLyFile {

    // Hàm ghi dữ liệu
    public static void ghiDuLieu(ArrayList<ThanhVien> danhSachNhanSu, ArrayList<HoiThao> danhSachLich) {
        try {
            PrintWriter pwNS = new PrintWriter(new FileWriter("nhansu.txt"));
            for (ThanhVien tv : danhSachNhanSu) {
                pwNS.println(tv.toFileString());
            }
            pwNS.close();

            PrintWriter pwLich = new PrintWriter(new File("ProjectOOP/hoithao.txt"));
            for (HoiThao ht : danhSachLich) {
                pwLich.println(ht.toFileString());
            }
            pwLich.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file!");
        }
    }

    // Hàm đọc dữ liệu
    public static void docDuLieu(ArrayList<ThanhVien> danhSachNhanSu, ArrayList<HoiThao> danhSachLich) {
        try {
            File fileNS = new File("nhansu.txt");
            if (fileNS.exists()) {
                Scanner sc = new Scanner(fileNS);
                while (sc.hasNextLine()) {
                    String[] data = sc.nextLine().split(",");
                    if (data[0].equals("Gamer")) {
                        danhSachNhanSu.add(new Gamer(data[1], data[2], data[3], data[4], Double.parseDouble(data[5]),
                                Double.parseDouble(data[6])));
                    } else if (data[0].equals("Coach")) {
                        danhSachNhanSu.add(new Coach(data[1], data[2], data[3], data[4], Double.parseDouble(data[5]),
                                Double.parseDouble(data[6])));
                    }
                }
                sc.close();
            }

            File fileLich = new File("ProjectOOP/hoithao.txt");
            if (fileLich.exists()) {
                Scanner sc2 = new Scanner(fileLich);
                int soDongDaDoc = 0;

                System.out.println("\n--- ĐANG KIỂM TRA DỮ LIỆU FILE HỘI THẢO ---");

                while (sc2.hasNextLine()) {
                    String line = sc2.nextLine();
                    if (line.trim().isEmpty())
                        continue; // Bỏ qua dòng trống

                    String[] data = line.split(",");

                    // KIỂM TRA 1: Có đủ 3 thành phần không? (Mã, Nội dung, Thời gian)
                    if (data.length != 3) {
                        System.out.println("❌ LỖI THIẾU DỮ LIỆU: Không đủ 3 thành phần. Dòng lỗi: [" + line + "]");
                    } else {
                        // Bóc tách dữ liệu ra các biến cho dễ kiểm tra tiếp
                        // Lệnh .trim() để cắt bỏ các dấu cách (space) dư thừa ở 2 đầu chữ
                        String maLich = data[0].trim();
                        String noiDung = data[1].trim();
                        String thoiGian = data[2].trim();

                        // KIỂM TRA 2: Mã lịch có bị để trống không?
                        if (maLich.isEmpty()) {
                            System.out.println("❌ LỖI TRỐNG MÃ LỊCH: Không được để trống ID. Dòng lỗi: [" + line + "]");
                        }
                        // KIỂM TRA 3: Thời gian có đúng định dạng chứa dấu '/' không?
                        else if (!thoiGian.contains("/")) {
                            System.out.println(
                                    "❌ LỖI SAI ĐỊNH DẠNG NGÀY: Thời gian phải có dấu '/' (VD: 25/06). Dòng lỗi: ["
                                            + line + "]");
                        }
                        // NẾU VƯỢT QUA HẾT CÁC BÀI KIỂM TRA TRÊN -> DỮ LIỆU CHUẨN!
                        else {
                            danhSachLich.add(new HoiThao(maLich, noiDung, thoiGian));
                            soDongDaDoc++;
                        }
                    }
                }
                sc2.close();
                System.out.println("✅ Đã nạp thành công " + soDongDaDoc + " lịch đấu hợp lệ vào hệ thống!\n");
            }
        } catch (Exception e) {
            System.out.println("Không tìm thấy file để đọc.");
        }
    }
}
