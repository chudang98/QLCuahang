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
public class Hoa_Don_Ban_Hang {
    private String ma_hoa_don;
    private Date thoi_gian;
    private String ghi_chu;
    private Nhan_Vien cmnd_nv_ban;
    private Khach_Hang KH_cmnd;

    public Hoa_Don_Ban_Hang(String ma_hoa_don, Date thoi_gian, String ghi_chu, Nhan_Vien cmnd_nv_ban, Khach_Hang KH_cmnd) {
        this.ma_hoa_don = ma_hoa_don;
        this.thoi_gian = thoi_gian;
        this.ghi_chu = ghi_chu;
        this.cmnd_nv_ban = cmnd_nv_ban;
        this.KH_cmnd = KH_cmnd;
    }

    public Hoa_Don_Ban_Hang() {
    }
    
    public String getMa_hoa_don() {
        return ma_hoa_don;
    }

    public void setMa_hoa_don(String ma_hoa_don) {
        this.ma_hoa_don = ma_hoa_don;
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

    public Nhan_Vien getCmnd_nv_ban() {
        return cmnd_nv_ban;
    }

    public void setCmnd_nv_ban(Nhan_Vien cmnd_nv_ban) {
        this.cmnd_nv_ban = cmnd_nv_ban;
    }

    public Khach_Hang getKH_cmnd() {
        return KH_cmnd;
    }

    public void setKH_cmnd(Khach_Hang KH_cmnd) {
        this.KH_cmnd = KH_cmnd;
    }
}
