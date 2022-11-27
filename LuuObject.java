import java.util.*;

public class LuuObject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSP ds = new DanhSachSP();
        int luachon, phuongan;
        do {
            System.out.println("-----------------------------------[PHUONG AN]------------------------------------");
            System.out.println("1.Hien thi danh sach san pham hien co tren file");
            System.out.println("2.Chinh sua danh sach");
            System.out.println("3.Nhap them san pham vao danh sach");
            System.out.println("0.Thoat khoi chuong trinh");
            System.out.println("Nhap vao phuong an ban muon: ");
            phuongan = Integer.parseInt(sc.nextLine());
            System.out.println("----------------------------------------------------------------------------------");
            if (phuongan == 1) {
                ds.docDuLieu();
            } else if (phuongan == 2) {
                ds.danhSachHienTai();
                ds.truyXuatDuLieuTuFile();
                ds.hienThi();
                do {
                    System.out.println("--------------------------------[LUA CHON]--------------------------------");
                    System.out.println("1.Them san pham vao danh sach");
                    System.out.println("2.Sua doi danh sach san pham");
                    System.out.println("3.Tim san pham trong danh sach");
                    System.out.println("4.Xoa san pham ");
                    System.out.println("5.Hien thi du lieu hien co tren file");
                    System.out.println("0.Thoat khoi chuong trinh");
                    System.out.println("Nhap vao lua chon cua ban: ");
                    luachon = Integer.parseInt(sc.nextLine());
                    System.out.println("--------------------------------------------------------------------------");
                    if (luachon == 1) {
                        ds.them();
                        ds.hienThi();
                    } else if (luachon == 2) {
                        ds.sua();
                    } else if (luachon == 3) {
                        ds.timKiem();
                    } else if (luachon == 4) {
                        ds.xoa();
                    } else if (luachon == 5) {
                        ds.docDuLieu();
                    }
                } while (luachon != 0);
            }else if(phuongan == 3){
                ds.danhSachHienTai();
                ds.truyXuatDuLieuTuFile();
                ds.nhapds();
                ds.hienThi();
            }
        } while (phuongan != 0);
        sc.close();
    }
}