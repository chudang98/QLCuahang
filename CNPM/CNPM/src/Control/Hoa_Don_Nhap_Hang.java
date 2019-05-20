/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Date;

/**
 *
 * @author hunglv
 */
public class Hoa_Don_Nhap_Hang {
    private String ma_HD_nhap;
    private Date thoi_gian;
    private String ghi_chu;
    private String ncc_cmnd; //id_ncc
    private String cmnd_nv_kho; //id_nv_kho

    public Hoa_Don_Nhap_Hang() {
    }

    public Hoa_Don_Nhap_Hang(String ma_HD_nhap, Date thoi_gian, String ghi_chu, String ncc_cmnd, String cmnd_nv_kho) {
        this.ma_HD_nhap = ma_HD_nhap;
        this.thoi_gian = thoi_gian;
        this.ghi_chu = ghi_chu;
        this.ncc_cmnd = ncc_cmnd;
        this.cmnd_nv_kho = cmnd_nv_kho;
    }
    
    public String getMa_HD_nhap() {
        return ma_HD_nhap;
    }

    public void setMa_HD_nhap(String ma_HD_nhap) {
        this.ma_HD_nhap = ma_HD_nhap;
    }

    public Date getThoi_gian() {
        return thoi_gian;
    }

    public void setThoi_gian(Date thoi_gian) {
        this.thoi_gian = thoi_gian;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public String getNcc_cmnd() {
        return ncc_cmnd;
    }

    public void setNcc_cmnd(String ncc_cmnd) {
        this.ncc_cmnd = ncc_cmnd;
    }

    public String getCmnd_nv_kho() {
        return cmnd_nv_kho;
    }

    public void setCmnd_nv_kho(String cmnd_nv_kho) {
        this.cmnd_nv_kho = cmnd_nv_kho;
    }
    
}
