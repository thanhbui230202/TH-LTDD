package caidat.dmt.gk;

public class NuocUong {
    private String tenNuoc;
    private String moTa;
    private int img;
    private String hangSX;

    public NuocUong(String tenNuoc, String moTa, int img, String hangSX) {
        this.tenNuoc = tenNuoc;
        this.moTa = moTa;
        this.img = img;
        this.hangSX = hangSX;
    }

    public NuocUong() {
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }
}
