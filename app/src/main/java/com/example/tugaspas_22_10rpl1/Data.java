package com.example.tugaspas_22_10rpl1;

import java.io.Serializable;

public class Data implements Serializable {

    private String nama;
    private String noHp;

    public Data (String nama, String noHp){
        this.nama = nama;
        this.noHp = noHp;
    }

    public String getNoHp() {return noHp;}

    public void setNoHp(String noHp) {this.noHp = noHp;}

    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama; }

}
