import java.io.*;
import java.util.*;

public class DanhSachBH implements ChucNangDS, Serializable {
    private int n;
    BaoHanh dsbh[];
    Scanner sc = new Scanner(System.in);

    public DanhSachBH() {
        n = 0;
        dsbh = null;
    }

    public BaoHanh[] getDsbh() {
        return dsbh;
    }

    public void setDsbh(BaoHanh[] dsbh) {
        this.dsbh = dsbh;
    }

    // danh sach nhung thiet bi can bao hanh
    public void nhapDS() {
        System.out.println("Nhap vao so luong thiet bi can bao hanh: ");
        n = Integer.parseInt(sc.nextLine());
        System.out.println();
        for (int i = 0; i < n; i++) {
            them();
        }
    }

    public void danhSachHienTai() {
        n = 0;
        dsbh = new BaoHanh[n];
    }

    // add thiet bi can bao hanh
    public void them() {
        int tmp = demDuLieu();
        System.out.println("------------------------ADD------------------------");
        System.out.println("Nhap vao thong tin thiet bi can bao hanh: ");
        BaoHanh bh = new BaoHanh();
        bh.Nhap();
        dsbh = Arrays.copyOf(dsbh, dsbh.length + 1);
        dsbh[tmp] = bh;
        System.out.println();
        ghiDuLieu();
    }

    public void timKiemTheo_MaBH() {
        System.out.println("Nhap vao ma bao hanh ban muon tim kiem: ");
        int mabh = Integer.parseInt(sc.nextLine());
        System.out.println();
        System.out.printf("%-25s%-25s%-25s\n", "[MaBH]", "[ThoiGianBH]", "[ThongTinBH]");
        for (int i = 0; i < dsbh.length; i++) {
            if (dsbh[i].getMabh() == mabh) {
                dsbh[i].Xuat();
            }
        }
    }

    public void timKiemTheo_ThoiGianBH() {
        System.out.println("Nhap vao thoi gian ban muon tim: ");
        String thoigianbh = sc.nextLine();
        System.out.println();
        System.out.printf("%-25s%-25s%-25s\n", "[MaBH]", "[ThoiGianBH]", "[ThongTinBH]");
        for (int i = 0; i < dsbh.length; i++) {
            if (dsbh[i].getThoigianbh().equalsIgnoreCase(thoigianbh)) {
                dsbh[i].Xuat();
            }
        }
    }

    public void timKiemTheo_ThongTinBH() {
        System.out.println("Nhap vao thong tin can tim kiem: ");
        String thongtinbh = sc.nextLine();
        System.out.println();
        System.out.printf("%-25s%-25s%-25s\n", "[MaBH]", "[ThoiGianBH]", "[ThongTinBH]");
        for (int i = 0; i < dsbh.length; i++) {
            if (dsbh[i].getThongtinbh().equalsIgnoreCase(thongtinbh)) {
                dsbh[i].Xuat();
            }
        }
    }

    public void timKiem() {
        int luachon;
        do {
            System.out.println("------------------------Search------------------------");
            System.out.println("1.Tim kiem theo ma bao hanh.");
            System.out.println("2.Tim kiem theo thoi gian bao hanh.");
            System.out.println("3.Tim kiem theo thong tin bao hanh.");
            System.out.println("4.Thoat chuong trinh.");
            System.out.println("Nhap vao lua chon cua ban: ");
            luachon = Integer.parseInt(sc.nextLine());
            System.out.println();
            switch (luachon) {
                case 1:
                    timKiemTheo_MaBH();
                    System.out.println();
                    break;
                case 2:
                    timKiemTheo_ThoiGianBH();
                    System.out.println();
                    break;
                case 3:
                    timKiemTheo_ThongTinBH();
                    System.out.println();
                    break;
            }
        } while (luachon != 4);
    }

    public void suaTheo_MaBH() {
        System.out.println("Nhap vao ma bao hanh ban muon thay doi: ");
        int mabh = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao ma bao hanh ban muon thay the: ");
        int ma = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < dsbh.length; i++) {
            if (dsbh[i].getMabh() == mabh) {
                dsbh[i].setMabh(ma);
                // dsbh[i].Xuat();
            }
        }
        hienThi();
    }

    public void suaTheo_ThoiGianBH() {
        System.out.println("Nhap vao ma bao hanh ban muon thay doi: ");
        int mabh = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao thoi gian ban muon thay the: ");
        String thoigianbh = sc.nextLine();
        for (int i = 0; i < dsbh.length; i++) {
            if (dsbh[i].getMabh() == mabh) {
                dsbh[i].setThongtinbh(thoigianbh);
                // dsbh[i].Xuat();
            }
        }
        hienThi();
    }

    public void suaTheo_ThongTinBH() {
        System.out.println("Nhap vao ma bao hanh ban muon thay doi: ");
        int mabh = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao thong tin ban muon thay the: ");
        String thongtinbh = sc.nextLine();
        for (int i = 0; i < dsbh.length; i++) {
            if (dsbh[i].getMabh() == mabh) {
                dsbh[i].setThongtinbh(thongtinbh);
                // dsbh[i].Xuat();
            }
        }
        hienThi();
    }

    public void sua() {
        int luachon;
        do {
            System.out.println("------------------------Revision------------------------");
            System.out.println("1.Thay doi ma bao hanh.");
            System.out.println("2.Thay doi thoi gian bao hanh.");
            System.out.println("3.Thay doi thong tin bao hanh.");
            System.out.println("4.Thoat chuong trinh.");
            System.out.println("Nhap vao lua chon cua ban: ");
            luachon = Integer.parseInt(sc.nextLine());
            System.out.println();
            switch (luachon) {
                case 1:
                    suaTheo_MaBH();
                    ghiDuLieu();
                    System.out.println();
                    break;
                case 2:
                    suaTheo_ThoiGianBH();
                    ghiDuLieu();
                    System.out.println();
                    break;
                case 3:
                    suaTheo_ThongTinBH();
                    ghiDuLieu();
                    System.out.println();
                    break;
            }
        } while (luachon != 4);
    }

    public void xoa() {
        System.out.println("------------------------Delete------------------------");
        System.out.println("Nhap vao ma bao hanh ban muon xoa: ");
        int mabh = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < dsbh.length; i++) {
            if (dsbh[i].getMabh() == mabh) {
                dsbh[i] = dsbh[dsbh.length - 1];
                dsbh = Arrays.copyOf(dsbh, dsbh.length - 1);
                n--;
            }
        }
        hienThi();
        ghiDuLieu();
    }

    // ghi du lieu vao data
    public void ghiDuLieu() {
        try {
            FileWriter fw = new FileWriter("D:\\danhsachBH.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (BaoHanh bh : dsbh) {
                bw.write(bh.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // dem du lieu tu data
    public int demDuLieu() {
        int dem = 0;
        try {
            FileReader fr = new FileReader("D:\\danhsachBH.txt");
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

    // doc du lieu ra man hinh console
    public void docDuLieu() {
        File test = new File("D:\\danhsachBH.txt");
        if (test.exists() == true) {
            try {
                FileReader fr = new FileReader("D:\\danhsachBH.txt");
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

    // truy xuat data tu file vao mang
    public void truyXuatDuLieuTuFile() {
        int dem = 0;
        File test = new File("D:\\danhsachBH.txt");
        if (test.exists() == true) {
            try {
                FileReader fr = new FileReader("D:\\danhsachBH.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split(",");
                    int mabh = Integer.parseInt(txt[0]);
                    String thoigianbh = txt[1];
                    String thongtinbh = txt[2];
                    dsbh = Arrays.copyOf(dsbh, dsbh.length + 1);
                    BaoHanh bh = new BaoHanh(mabh, thoigianbh, thongtinbh);
                    dsbh[dem] = bh;
                    dem++;
                }
                br.close();
                fr.close();
                System.out.println("So thiet bi dang duoc bao hanh : " + dem);
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
                "[==============================MENU==============================]");
        System.out.println();
        System.out.printf("  %-25s%-25s%-25s\n", "[MaBH]", "[ThoiGianBH]", "[ThongTinBH]");
        for (int i = 0; i < dsbh.length; i++) {
            dsbh[i].Xuat();
        }
        System.out.println();
    }

}
