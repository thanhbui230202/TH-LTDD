package com.example.quanlimaytinh2;

public class Computer {
    private int idcp;
    private String tencp,loai;

    public Computer(int idcp, String tencp, String loai) {
        this.idcp = idcp;
        this.tencp = tencp;
        this.loai = loai;
    }
    public Computer(int idcp, String tencp) {
        this.idcp = idcp;
        this.tencp = tencp;
    }

    public int getIdcp() {
        return idcp;
    }

    public void setIdcp(int idcp) {
        this.idcp = idcp;
    }

    public String getTencp() {
        return tencp;
    }

    public void setTencp(String tencp) {
        this.tencp = tencp;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
