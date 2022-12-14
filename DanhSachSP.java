import java.io.*;
import java.util.*;

public class DanhSachSP implements ChucNangDS, Serializable {
    private int n;
    SanPham dssp[];
    Scanner sc = new Scanner(System.in);

    public DanhSachSP() {
        n = 0;
        dssp = null;
    }

    public SanPham[] getDssp() {
        return dssp;
    }

    public void setDssp(SanPham[] dssp) {
        this.dssp = dssp;
    }

    // nhập vào danh sách sản phẩm ban đầu
    void nhapds() {
        System.out.println("Nhap vao so luong san pham ban muon nhap vao danh sach: ");
        n = Integer.parseInt(sc.nextLine());
        System.out.println();
        for (int i = 0; i < n; i++) {
            them();
        }
    }

    public void danhSachHienTai() {
        n = 0;
        dssp = new SanPham[n];
    }

    // hàm thêm sản phẩm
    public void them() {
        int n = demDuLieu();
        System.out.println("------------------------ADD------------------------");
        System.out.println("Nhap vao thong tin san pham can them: ");
        SanPham addsp = new SanPham();
        addsp.Nhap();
        dssp = Arrays.copyOf(dssp, dssp.length + 1);
        dssp[n] = addsp;
        System.out.println();
        ghiDuLieu();
    }

    // hàm tìm kiếm sản phẩm
    public void timKiemTheo_MaSP() {
        System.out.println("Nhap vao ma SP ban muon tim: ");
        int masp = Integer.parseInt(sc.nextLine());
        System.out.printf("  %-30s%-30s%-30s%-30s%-30s\n", "[MaSP]", "[TenSP]", "[SoluongSP]", "[GiaSP]",
                "[ThongtinSP]");
        for (int i = 0; i < dssp.length; i++) {
            if (dssp[i].getMasp() == masp) {
                dssp[i].Xuat();
            }
        }
    }

    public void timKiemTheo_TenSP() {
        System.out.println("Nhap vao ten SP ma ban muon tim: ");
        String tensp = sc.nextLine();
        System.out.printf("  %-30s%-30s%-30s%-30s%-30s\n", "[MaSP]", "[TenSP]", "[SoluongSP]", "[GiaSP]",
                "[ThongtinSP]");
        for (int i = 0; i < dssp.length; i++) {
            if (dssp[i].getTensp().equalsIgnoreCase(tensp)) {
                dssp[i].Xuat();
            }
        }
    }

    public void timKiemTheo_GiaSP() {
        System.out.println("Nhap vao gia SP ban muon tim: ");
        double giasp = Double.parseDouble(sc.nextLine());
        System.out.printf("  %-30s%-30s%-30s%-30s%-30s\n", "[MaSP]", "[TenSP]", "[SoluongSP]", "[GiaSP]",
                "[ThongtinSP]");
        for (int i = 0; i < dssp.length; i++) {
            if (dssp[i].getGiasp() == giasp) {
                dssp[i].Xuat();
            }
        }
    }

    // hàm sửa đổi sản phẩm
    public void suaTheo_GiaSP() {
        System.out.println("nhap vao ma san pham ban muon thay doi gia: ");
        int ma = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao gia ban muon thay the: ");
        Double giasp = Double.parseDouble(sc.nextLine());
        for (int i = 0; i < dssp.length; i++) {
            if (dssp[i].getMasp() == ma) {
                dssp[i].setGiasp(giasp);
                // dssp[i].Xuat();
            }
        }
        hienThi();
    }

    public void suaTheo_ThongTinSP() {
        System.out.println("nhap vao ma san pham ban muon thay doi thong tin: ");
        int ma = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao thong tin ban muon thay the: ");
        String thongtinsp = sc.nextLine();
        for (int i = 0; i < dssp.length; i++) {
            if (dssp[i].getMasp() == ma) {
                dssp[i].setThongtinsp(thongtinsp);
                // dssp[i].Xuat();
            }
        }
        hienThi();
    }

    public void timKiem() {
        int luachon;
        do {
            System.out.println("------------------------Search------------------------");
            System.out.println("1.tim kiem theo ma SP.");
            System.out.println("2.tim kiem theo ten SP.");
            System.out.println("3.tim kiem theo gia SP.");
            System.out.println("4.Thoat chuong trinh");
            System.out.println("Nhap vao lua chon cua ban: ");
            luachon = Integer.parseInt(sc.nextLine());
            System.err.println();
            switch (luachon) {
                case 1:
                    timKiemTheo_MaSP();
                    System.out.println();
                    break;
                case 2:
                    timKiemTheo_TenSP();
                    System.out.println();
                    break;
                case 3:
                    timKiemTheo_GiaSP();
                    System.out.println();
                    break;
            }
        } while (luachon != 4);
    }

    public void sua() {
        int luachon;
        do {
            System.out.println("------------------------Revision------------------------");
            System.out.println("1.Thay doi gia SP");
            System.out.println("2.Thay doi thong tin SP");
            System.out.println("3.Thoat chuong trinh");
            System.out.println("Nhap vao lua chon cua ban: ");
            luachon = Integer.parseInt(sc.nextLine());
            System.out.println();
            switch (luachon) {
                case 1:
                    suaTheo_GiaSP();
                    ghiDuLieu();
                    System.out.println();
                    break;
                case 2:
                    suaTheo_ThongTinSP();
                    ghiDuLieu();
                    System.out.println();
                    break;
            }
        } while (luachon != 3);
    }

    public void xoa() {
        System.out.println("------------------------Delete------------------------");
        System.out.println("Nhap vao ma san pham ban muon xoa: ");
        int masp = Integer.parseInt(sc.nextLine());
        System.out.println();
        for (int i = 0; i < dssp.length; i++) {
            if (dssp[i].getMasp() == masp) {
                dssp[i] = dssp[dssp.length - 1];
                dssp = Arrays.copyOf(dssp, dssp.length - 1);
                n--;
            }
        }
        hienThi();
        ghiDuLieu();
    }

    // ghi du lieu vao data
    public void ghiDuLieu() {
        try {
            FileWriter fw = new FileWriter("D:\\danhsachSP.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (SanPham sp : dssp) {
                bw.write(sp.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // dem du lieu tu data
    public int demDuLieu() {
        int dem = 0;
        try {
            FileReader fr = new FileReader("D:\\danhsachSP.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                dem++;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dem;
    }

    // doc du lieu tu data
    public void docDuLieu() {
        File test = new File("D:\\danhsachSP.txt");
        if (test.exists() == true) {
            try {
                FileReader fr = new FileReader("D:\\danhsachSP.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                test.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // truy xuat du lieu tu data vao mang
    public void truyXuatDuLieuTuFile() {
        int dem = 0;
        File test = new File("D:\\danhsachSP.txt");
        if (test.exists() == true) {
            try {
                FileReader fr = new FileReader("D:\\danhsachSP.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split(",");
                    int masp = Integer.parseInt(txt[0]);
                    String tensp = txt[1];
                    int soluong = Integer.parseInt(txt[2]);
                    double giasp = Double.parseDouble(txt[3]);
                    String thongtinsp = txt[4];
                    dssp = Arrays.copyOf(dssp, dssp.length + 1);
                    SanPham sp = new SanPham(masp, tensp, soluong, giasp, thongtinsp);
                    dssp[dem] = sp;
                    dem++;
                }
                br.close();
                fr.close();
                System.out.println("So san pham co trong danh sach: " + dem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                test.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void hienThi() {
        System.out.println();
        System.out.println(
                "[================================================================MENU=================================================================]");
        System.out.println();
        System.out.printf("  %-30s%-30s%-30s%-30s%-30s\n", "[MaSP]", "[TenSP]", "[SoluongSP]", "[GiaSP]",
                "[ThongtinSP]");
        for (int i = 0; i < dssp.length; i++) {
            dssp[i].Xuat();
        }
        System.out.println();
    }
}
