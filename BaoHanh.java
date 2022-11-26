import java.util.Scanner;

public class BaoHanh extends SanPham {
    private int mabh;
    private String thoigianbh;
    private String thongtinbh;

    Scanner sc = new Scanner(System.in);

    public BaoHanh() {
        super();
        this.mabh = 0;
        this.thoigianbh = null;
        this.thongtinbh = null;
    }

    public BaoHanh(int mabh, String thoigianbh, String thongtinbh) {
        this.mabh = mabh;
        this.thoigianbh = thoigianbh;
        this.thongtinbh = thongtinbh;
    }

    public BaoHanh(int masp, String tensp, int soluong, double giasp, String thongtinsp, int mabh, String thoigianbh,
            String thongtinbh) {
        super(masp, tensp, soluong, giasp, thongtinsp);
        this.mabh = mabh;
        this.thoigianbh = thoigianbh;
        this.thongtinbh = thongtinbh;
    }

    public int getMabh() {
        return mabh;
    }

    public void setMabh(int mabh) {
        this.mabh = mabh;
    }

    public String getThoigianbh() {
        return thoigianbh;
    }

    public void setThoigianbh(String thoigianbh) {
        this.thoigianbh = thoigianbh;
    }

    public String getThongtinbh() {
        return thongtinbh;
    }

    public void setThongtinbh(String thongtinbh) {
        this.thongtinbh = thongtinbh;
    }

    public void Nhap() {
        System.out.println("Nhap vao ma bao hanh: ");
        mabh = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao thoi gian bao hanh: ");
        thoigianbh = sc.nextLine();
        System.out.println("Nhap vao thong tin bao hanh: ");
        thongtinbh = sc.nextLine();
    }

    public void Xuat() {
        System.out.printf("  %-25d%-25s%-25s\n", mabh, thoigianbh, thongtinbh);
    }

    @Override
    public String toString() {
        return mabh + "," + thoigianbh + "," + thongtinbh;
    }
}