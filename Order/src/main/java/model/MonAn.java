// =======================
// FILE: MonAn.java
// PACKAGE: model
// =======================

package model;

public class MonAn {

    private String maMon;
    private String tenMon;
    private int donGia;

    public MonAn() {
    }

    public MonAn(
            String maMon,
            String tenMon,
            int donGia) {

        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donGia = donGia;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}