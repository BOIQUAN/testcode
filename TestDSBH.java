import java.util.*;

public class TestDSBH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachBH ds = new DanhSachBH();
        int luachon,phuongan;
        do{
            System.out.println("------------------------------------[PHUONG AN]------------------------------------");
            System.out.println("1.Hien thi danh sach thiet bi dang duoc bao hanh hien co tren file");
            System.out.println("2.Nhap them thiet bi can duoc bao hanh vao danh sach");
            System.out.println("0.Thoat khoi chuong trinh");
            System.out.println("Nhap vao phuong an ban muon: ");
            phuongan = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------------------------------------------------------------------");
            if(phuongan == 1){
                ds.docDuLieu();
            }else if(phuongan == 2){
                ds.nhapDS();
                ds.truyXuatDuLieuTuFile();
                ds.hienThi();
                ds.ghiDuLieu();
                do{
                    System.out.println("------------------------------------[LUA CHON]------------------------------------");
                    System.out.println("1.Them thiet bi can duoc bao hanh vao danh sach");
                    System.out.println("2.Sua doi danh sach cac thiet bi dang duoc bao hanh");
                    System.out.println("3.Tim cac thiet bi dang duoc bao hanh trong danh sach");
                    System.out.println("4.Xoa thiet bi ra khoi danh sach bao hanh ");
                    System.out.println("5.Hien thi du lieu hien co tren file");
                    System.out.println("0.Thoat khoi chuong trinh");
                    System.out.println("Nhap vao lua chon cua ban: ");
                    luachon = Integer.parseInt(sc.nextLine());
                    System.out.println("----------------------------------------------------------------------------------");
                    if (luachon == 1) {
                        ds.them();
                    } else if (luachon == 2) {
                        ds.sua();
                    } else if (luachon == 3) {
                        ds.timKiem();
                    } else if (luachon == 4) {
                        ds.xoa();
                    } else if (luachon == 5) {
                        ds.docDuLieu();
                    }
                }while(luachon != 0);
                ds.hienThi();
            }
        }while(phuongan != 0);
        sc.close();
    }
}