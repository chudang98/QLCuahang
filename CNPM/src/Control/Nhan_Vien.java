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
public class Nhan_Vien {
    private String cmnd;
    private String ten_san_pham;
    private String mat_khau;
    private String vi_tri;
    private String ho_ten;
    private String dia_chi;
    private String sdt;

    public Nhan_Vien() {
    }

    public Nhan_Vien(String cmnd, String ten_san_pham, String mat_khau, String vi_tri, String ho_ten, String dia_chi, String sdt) {
        this.cmnd = cmnd;
        this.ten_san_pham = ten_san_pham;
        this.mat_khau = mat_khau;
        this.vi_tri = vi_tri;
        this.ho_ten = ho_ten;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
    }
    
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public String getVi_tri() {
        return vi_tri;
    }

    public void setVi_tri(String vi_tri) {
        this.vi_tri = vi_tri;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
