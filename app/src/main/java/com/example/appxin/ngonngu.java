package com.example.appxin;

public class ngonngu {

    private String ten;
    private  String mota;
    private  int hinhanh;

    public ngonngu(String ten, String mota, int hinhanh) {
        this.ten = ten;
        this.mota = mota;
        this.hinhanh = hinhanh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }



    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public int getHinhanh() {
        return hinhanh;
    }


}
