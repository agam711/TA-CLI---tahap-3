/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.AslabEntity07220;
import Entity.PraktikanEntity07220;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Agam
 */
public class PraktikanModel07220 implements ModelInterfaces07220 {

    private ArrayList<PraktikanEntity07220> praktikanEntityArrayList;

    public PraktikanModel07220() {
        praktikanEntityArrayList = new ArrayList<PraktikanEntity07220>();
    }

    public void insert(PraktikanEntity07220 praktikanEntity07220) {
        praktikanEntityArrayList.add(praktikanEntity07220);
    }

    public int size() {
        return praktikanEntityArrayList.size();
    }

    @Override
    public void view() {
        for (PraktikanEntity07220 praktikanEntity07220 : praktikanEntityArrayList) {
            System.out.println("========================================");
            System.out.println("NPM : " + praktikanEntity07220.getNpm() + "\nNama : " + praktikanEntity07220.getNama()
                    + "\nPassowrd : " + praktikanEntity07220.getPassword() + "\nNo.Telp : " + praktikanEntity07220.getNo_telp()
                    + "\nTanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(praktikanEntity07220.getTglLahir()));
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String npm, String password) {
        int loop = 0;
        while (!praktikanEntityArrayList.get(loop).getNpm().equals(npm)
                && !praktikanEntityArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }
        return loop;
    }

    public PraktikanEntity07220 getPraktikanEntityArrayList(int index) {
        return praktikanEntityArrayList.get(index);
    }
}
