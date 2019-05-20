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
public class Khach_Hang {
    private String cmnd;
    private String ten;
    private String dia_chi;
    private String sdt;
    private String email;

    public Khach_Hang() {
    }

    public Khach_Hang(String cmnd, String ten, String dia_chi, String sdt, String email) {
        this.cmnd = cmnd;
        this.ten = ten;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.email = email;
    }
    
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
