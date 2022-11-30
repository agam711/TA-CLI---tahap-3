/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.DaftarprakEntity07220;
import Entity.PraktikumEntity07220;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Agam
 */
public class DaftarprakModel07220 implements ModelInterfaces07220 {

    private ArrayList<DaftarprakEntity07220> daftarprakArrayList;

    public DaftarprakModel07220() {
        daftarprakArrayList = new ArrayList<DaftarprakEntity07220>();
    }

    public void insertDataDaftarprak(DaftarprakEntity07220 daftarprak) {
        daftarprakArrayList.add(daftarprak);
    }

    public ArrayList<DaftarprakEntity07220> getDaftarprakArrayList() {
        return daftarprakArrayList;
    }

    public int size() {
        return daftarprakArrayList.size();
    }

    @Override
    public void view() {
        for (DaftarprakEntity07220 daftarprak : daftarprakArrayList) {
            System.out.println("========================================");
            System.out.println("NPM : " + daftarprak.getPraktikan().getNpm() + "\nNPM : " + daftarprak.getPraktikan().getNama()
                    + "\nPassword : " + daftarprak.getPraktikan().getPassword() + "\nNo.Telp : " + daftarprak.getPraktikan().getNo_telp()
                    + "\nTanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(daftarprak.getPraktikan().getTglLahir())
                    + "\nPraktikum : " + PraktikumEntity07220.nama[daftarprak.getIndexPrak()] + "\nIsVerified : ");
            if (daftarprak.isIsVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String npm, String password) {
        int loop = 0;
        if (daftarprakArrayList.size() == 0) {
            loop = -1; // data kosong
        } else {
            for (int i = 0; i < daftarprakArrayList.size(); i++) {
                if (daftarprakArrayList.get(i).getPraktikan().getNpm().equals(npm)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public DaftarprakEntity07220 showDaftarprak(int index) {
        return daftarprakArrayList.get(index);
    }

    public void updateIsVerified(int index, DaftarprakEntity07220 daftarprakEntity07220) {
        daftarprakArrayList.set(index, daftarprakEntity07220);
    }
}
