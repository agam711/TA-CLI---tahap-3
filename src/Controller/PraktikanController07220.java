/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entity.DaftarprakEntity07220;
import Entity.PraktikanEntity07220;
import java.util.Date;
/**
 *
 * @author Agam
 */
public class PraktikanController07220 implements ControllerInterface07220{
    int indexLogin = 0;
    public PraktikanController07220() {
    }
    
    public PraktikanEntity07220 getData() {
        return AllObjectModel07220.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }
    
    public void daftarPraktikum(int indexPraktikum, PraktikanEntity07220 praktikanEntity, boolean isVerified) {
        AllObjectModel07220.daftarPrakModel.insertDataDaftarprak(new DaftarprakEntity07220(praktikanEntity, isVerified, indexPraktikum));
    }
    
    @Override
    public void login(String npm, String password) {
        indexLogin = AllObjectModel07220.praktikanModel.cekData(npm, password);
    }
    
    public void insert(String npm, String password, String nama, String no_telp, Date tglLahir, String kelas) {
        AllObjectModel07220.praktikanModel.insert(new PraktikanEntity07220(npm, password, nama, no_telp, tglLahir, kelas));
    }
    
    public PraktikanEntity07220 praktikanEntity() {
        return AllObjectModel07220.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }
    
    public int cekDaftarPrak(String npm) {
        int cek = AllObjectModel07220.daftarPrakModel.cekData(npm, null);
        return cek;
    }
    
    public DaftarprakEntity07220 showDaftarPrak(int index) {
        return AllObjectModel07220.daftarPrakModel.showDaftarprak(index);
    }
}
