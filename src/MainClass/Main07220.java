package MainClass;

import Entity.PraktikumEntity07220;
import Controller.AdminController07220;
import Controller.AllObjectModel07220;
import Controller.PraktikanController07220;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main07220 {

    private static AdminController07220 admin = new AdminController07220();
    private static Scanner input = new Scanner(System.in);
    private static PraktikanController07220 praktikan = new PraktikanController07220();

    public static void main(String[] args) {
        int loop = 0;
        int pilih = 0;
        int pilLogin = 0;
        admin.dataAslab();
        do {
            System.out.println("Selamat Datang di Laboratorium Informatika ITATS !!"
                    + "\n1. Login"
                    + "\n2. Daftar Praktikan"
                    + "\n0. Stop"
                    + "\nMasukkan Pilihan Anda : ");
            pilih = input.nextInt();
            if (pilih == 1) {
                System.out.println("1. Login Aslab" + "\n2. Login Praktikan" + "\nPilih : ");
                pilLogin = input.nextInt();
                if (pilLogin == 1) {
                    loginAslab();
                } else {
                    loginPraktikan();
                }
            } else if (pilih == 2) {
                registerPraktikan();
            } else if (pilih == 3) {
                admin.viewAslab();
            } else {
                break;
            }
        } while (pilih != 0);
    }

    static void loginAslab() {
        System.out.println("NPM : ");
        String npm = input.next();
        System.out.println("Passwrod : ");
        String password = input.next();
        try {
            admin.login(npm, password);
            System.out.println("Selamat Datang " + admin.aslabEntity07220().getNama() + " dari Lab "
                    + admin.aslabEntity07220().getLaboratorium());
            if (admin.cekDaftarprakModel().size() == 0) {
                System.out.println("Data Masih Kosong !!!");
            } else {
                viewDaftarPrak();
                updateIsVerified();
            }
        } catch (Exception e) {
            System.out.println("NPM atau Password Anda Salah !!!");
        }
    }

    static void loginPraktikan() {
        System.out.println("NPM : ");
        String npm = input.next();
        System.out.println("Password : ");
        String password = input.next();
        praktikan.login(npm, password);
        System.out.println("Selamat Datang " + praktikan.praktikanEntity().getNama());
        int cek = praktikan.cekDaftarPrak(praktikan.praktikanEntity().getNpm());
        if (cek == -1) {
            System.out.println("Anda Belum Tedaftar Praktikum !!");
            registerPraktikum();
        } else if (cek == -2) {
            System.out.println("Anda Belum Tedaftar Praktikum !!");
            registerPraktikum();
        } else {
            System.out.println("====================================");
            System.out.print(" NPM : " + praktikan.showDaftarPrak(cek).getPraktikan().getNpm()
                    + "\n Nama : " + praktikan.showDaftarPrak(cek).getPraktikan().getNama()
                    + "\n No Telp : " + praktikan.showDaftarPrak(cek).getPraktikan().getNo_telp()
                    + "\n Tanggal Lahir : " + new SimpleDateFormat("dd-MM--yyyy").format(praktikan.showDaftarPrak(cek).getPraktikan().getTglLahir())
                    + "\n Praktikum : " + PraktikumEntity07220.nama[praktikan.showDaftarPrak(cek).getIndexPrak()]
                    + "\n isVerified : ");
            if (praktikan.showDaftarPrak(cek).isIsVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi Admin");
            }
            System.out.println(" Kelas : " + praktikan.showDaftarPrak(cek).getPraktikan().getKelas());
            System.out.println("====================================");
        }
    }

    static void registerPraktikan() {
        try {
            System.out.println("Input NPM : ");
            String npm = input.next();
            System.out.println("Input Nama : ");
            String nama = input.next();
            System.out.println("Input Password : ");
            String password = input.next();
            System.out.println("Input No. Telp : ");
            String notelp = input.next();
            System.out.println("Input Tgl Lahir dd/mm/yyyy : ");
            Date tglLahir = new Date(input.next());
            System.out.println("Kelas : ");
            String kelas = input.next();
            praktikan.insert(npm, password, nama, notelp, tglLahir, kelas);
            System.out.println("Daftar Sukses !!");
        } catch (Exception e) {
            System.out.println("Format Pengisian Salah");
        }
    }
    
    static void registerPraktikum() {
        System.out.println("Pilih Praktikum : ");
        for (int i = 0; i < PraktikumEntity07220.nama.length; i++) {
            System.out.println((i) + " " + PraktikumEntity07220.nama[i]);
        }
        int pilPrak = input.nextInt();
        praktikan.daftarPraktikum(pilPrak, praktikan.getData(), false);
        admin.listPendaftarPraktikum();
    }

    static void viewDaftarPrak() {
        admin.listPendaftarPraktikum();
    }

    static void updateIsVerified() {
        System.out.println("NPM Praktikum : ");
        String npm = input.next();
        int index = AllObjectModel07220.daftarPrakModel.cekData(npm, null);
        admin.updateIsVerified(index, praktikan.showDaftarPrak(index).getIndexPrak(), praktikan.showDaftarPrak(index).getPraktikan());
    }
}
