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
public class Cua_Hang {
    private String ten_cua_hang;
    private String dia_chi;
    private String sdt;
    private String mo_ta;

    public Cua_Hang() {
        
    }
    
    
    public Cua_Hang(String ten_cua_hang, String dia_chi, String sdt, String mo_ta) {
        this.ten_cua_hang = ten_cua_hang;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.mo_ta = mo_ta;
    }

    public String getTen_cua_hang() {
        return ten_cua_hang;
    }

    public void setTen_cua_hang(String ten_cua_hang) {
        this.ten_cua_hang = ten_cua_hang;
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

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
    
}
