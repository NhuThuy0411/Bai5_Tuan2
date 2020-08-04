package com.example.student.myapplication;

public class KhachHang {
    private String tenKH;
    private int slMua;
    private boolean khachVIP;
    public static  final int GIA = 20000;

    public KhachHang() {
    }

    public KhachHang(String tenKH, int slMua, boolean khachVIP) {
        this.tenKH = tenKH;
        this.slMua = slMua;
        this.khachVIP = khachVIP;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getSlMua() {
        return slMua;
    }

    public void setSlMua(int slMua) {
        this.slMua = slMua;
    }

    public boolean isKhachVIP() {
        return khachVIP;
    }

    public void setKhachVIP(boolean khachVIP) {
        this.khachVIP = khachVIP;
    }

    public double tinhThanhTien()
    {
        return (!khachVIP? slMua*GIA:slMua*GIA*0.9);
    }
}
