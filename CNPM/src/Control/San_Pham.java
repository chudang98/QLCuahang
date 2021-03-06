/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author hunglv
 */
public class San_Pham {
    private String ma_san_pham;
    private String ten_san_pham;
    private String loai_san_pham;
    private int gia_nhap;
    private int gia_ban;
    private String mau_sac;
    private String kich_co;
    private Cua_Hang ten_cua_hang; //id cua_hang

    public San_Pham(String ma_san_pham, String ten_san_pham, String loai_san_pham, int gia_nhap, int gia_ban, String mau_sac, String kich_co, Cua_Hang ten_cua_hang) {
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.loai_san_pham = loai_san_pham;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
        this.mau_sac = mau_sac;
        this.kich_co = kich_co;
        this.ten_cua_hang = ten_cua_hang;
    }

    public San_Pham() {
    }

    public String getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(String ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public String getLoai_san_pham() {
        return loai_san_pham;
    }

    public void setLoai_san_pham(String loai_san_pham) {
        this.loai_san_pham = loai_san_pham;
    }

    public int getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(int gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public String getMau_sac() {
        return mau_sac;
    }

    public void setMau_sac(String mau_sac) {
        this.mau_sac = mau_sac;
    }

    public String getKich_co() {
        return kich_co;
    }

    public void setKich_co(String kich_co) {
        this.kich_co = kich_co;
    }

    public Cua_Hang getTen_cua_hang() {
        return ten_cua_hang;
    }

    public void setTen_cua_hang(Cua_Hang ten_cua_hang) {
        this.ten_cua_hang = ten_cua_hang;
    }
}
