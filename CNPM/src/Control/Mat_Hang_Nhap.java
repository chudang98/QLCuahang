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
public class Mat_Hang_Nhap {
    private String ma_mat_hang;
    private San_Pham ma_san_pham; //id_ma_san_pham
    private Hoa_Don_Nhap_Hang HD_nhap; //id_HD_nhap

    public Mat_Hang_Nhap(String ma_mat_hang, San_Pham ma_san_pham, Hoa_Don_Nhap_Hang HD_nhap) {
        this.ma_mat_hang = ma_mat_hang;
        this.ma_san_pham = ma_san_pham;
        this.HD_nhap = HD_nhap;
    }

    public Mat_Hang_Nhap() {
    }

    public String getMa_mat_hang() {
        return ma_mat_hang;
    }

    public void setMa_mat_hang(String ma_mat_hang) {
        this.ma_mat_hang = ma_mat_hang;
    }

    public San_Pham getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(San_Pham ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public Hoa_Don_Nhap_Hang getHD_nhap() {
        return HD_nhap;
    }

    public void setHD_nhap(Hoa_Don_Nhap_Hang HD_nhap) {
        this.HD_nhap = HD_nhap;
    }
}
