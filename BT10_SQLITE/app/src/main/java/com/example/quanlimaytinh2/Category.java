package com.example.quanlimaytinh2;

public class Category {
    private int idct;
    private String loaict;

    public Category(int idct, String loaict) {
        this.idct = idct;
        this.loaict = loaict;
    }

    public int getIdct() {
        return idct;
    }

    public void setIdct(int idct) {
        this.idct = idct;
    }

    public String getLoaict() {
        return loaict;
    }

    public void setLoaict(String loaict) {
        this.loaict = loaict;
    }

}
