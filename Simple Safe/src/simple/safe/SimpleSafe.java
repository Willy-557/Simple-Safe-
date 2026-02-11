
package simple.safe;

import java.util.Scanner;
import java.util.HashMap;


class RekeningBank {
    private String namaPemilik;
    private double saldo;
    
    public RekeningBank (String namaPemilik, double saldo) {
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }
    
    public void cekSaldo() {
        System.out.println("Saldo yang anda miliki di rekening sebesar Rp " + this.saldo + "."); 
    }
    
    public void setorTunai (int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Uang yang anda setorkan kurang dari Rp 0");
        }
        else {
            this.saldo += jumlah;
            System.out.println("Berhasil menyetorkan uang ke rekening sebesar Rp " + jumlah + ".");
        }
    }
    
    public void Transfer1 (int nominalYangAkanDiterima) {
        this.saldo += nominalYangAkanDiterima;
        System.out.println("Berhasil melakukan transfer ke rekening a/n '" + namaPemilik + "' dengan nominal Rp " + nominalYangAkanDiterima +".");
    }
    
    public void Transfer2 (int nominalYangAkanDiTf) {
        this.saldo -= nominalYangAkanDiTf;
    }

    public void tarikTunai (int nominalTarikan) {
        if (nominalTarikan > saldo) {
            System.out.println("Saldo yang anda miliki di rekening tidak cukup!");
        }
        else {
            this.saldo -= nominalTarikan;
            System.out.println("Berhasil melakukan penarikan tunai sebesar Rp " + nominalTarikan + ".");
            }
        }
    }

public class SimpleSafe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        HashMap <Integer, RekeningBank> daftarAkun = new HashMap<>();
        
        while (true) {
            System.out.println("1. Log In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            
            System.out.print(">> ");
            int opsi = scanner.nextInt();
            
            if (opsi == 1) {
                System.out.print("Masukkan pin atm : ");
                int pinATM = scanner.nextInt();
                
                if (!daftarAkun.containsKey(pinATM)) {
                    System.out.println("No pin yang anda masukkan tidak ada di sistem, silahkan buat ulang!");
                }
                else {
                    while (true) {
                        System.out.println("Simple ATM (Hanya bisa Rp 50.000 untuk setor dan tarik tunai!");
                        System.out.println("1. Tarik Tunai");
                        System.out.println("2. Setor tunai");
                        System.out.println("3. Transfer antar rekening");
                        System.out.println("4. Cek saldo");
                        System.out.println("5. Keluar");

                        System.out.print(">> ");
                        int choice = scanner.nextInt();

                        if (choice == 5) {
                            System.out.println("Terimakasih!");
                            break;
                        } 
                        
                        else if (choice > 5 || choice < 1) {
                            System.out.println("Invalid input! Anda hanya bisa meng-input menu 1 - 4!");
                            continue;
                        }
                        else {
                            switch (choice) {
                                case 1:
                                    System.out.print("Masukkan nominal uang yang ingin di-tarik: ");
                                    int nominalTarikTunai = scanner.nextInt();
                                    
                                    if (nominalTarikTunai % 50000 == 0) {
                                        RekeningBank PenarikanTunai = daftarAkun.get(pinATM);
                                        PenarikanTunai.tarikTunai(nominalTarikTunai);
                                    }
                                    else {
                                        System.out.println("ATM Hanya bisa melakukan penarikan tunai dengan kelipatan Rp 50.000");
                                    }
                                    break;
                                
                                case 2:
                                    System.out.println("Masukkan nominal uang yang ingin di-setorkan: ");
                                    int nominalSetorTunai = scanner.nextInt();
                                    
                                    if (nominalSetorTunai % 50000 == 0) {
                                        RekeningBank PenyetoranTunai = daftarAkun.get(pinATM);
                                        PenyetoranTunai.setorTunai(nominalSetorTunai);
                                    }
                                    else {
                                        System.out.println("Maaf, penyetoran tunai hanya bisa kelipatan Rp 50.000");
                                    }
                                    break;
                                
                                case 3:
                                    System.out.println("Masukkan no rekening yang ingin di-transfer: ");
                                    int pinAtmTransfer = scanner.nextInt();
                                    
                                    System.out.println("Masukkan nominal uang yang ingin di-transfer: ");
                                    int uangTransfer = scanner.nextInt();
                                    
                                    for (int nomorPinAtm : daftarAkun.keySet()){
                                        if (nomorPinAtm == pinAtmTransfer){
                                            RekeningBank Transfer = daftarAkun.get(nomorPinAtm);
                                            Transfer.Transfer1(uangTransfer);
                                            Transfer.Transfer2(uangTransfer);   
                                        }
                                        else {
                                            System.out.println("No rekening '" + pinAtmTransfer + "' tidak ter-daftar");
                                        }
                                    }
                                    break;
                                    
                                case 4:
                                    RekeningBank PengecekanSaldo = daftarAkun.get(pinATM);
                                    PengecekanSaldo.cekSaldo();
                                    break;
                            }   
                        }
                    }
                }
            }
            else if (opsi == 2) {
                System.out.print("Masukkan pin baru : ");
                int pinAtmBaru = scanner.nextInt();
                
                scanner.nextLine();
                System.out.print("Masukkan nama baru : ");
                String namaRekeningBaru = scanner.nextLine();
                
                if (daftarAkun.containsKey(pinAtmBaru)) {
                    System.out.println("Pin yang anda input sudah ada di sistem, silahkan login ulang!");
                }
                else {
                    RekeningBank rekeningBaru = new RekeningBank (namaRekeningBaru, pinAtmBaru);
                    
                    if (daftarAkun.containsKey(pinAtmBaru)) {
                        System.out.println("Rekening anda bernama '" + namaRekeningBaru + "' sudah ada!");
                        continue;
                    }
                    else {
                        daftarAkun.put(pinAtmBaru, rekeningBaru);
                        System.out.println("Berhasil membuat rekening a/n '" + namaRekeningBaru + "'.");
                    }
                    
                }
            }
            else if (opsi == 3) {
                System.out.println("Terimakasih!");
                break;
            }
            else {
                System.out.println("Harap masukkan nomor menu 1 - 3!");
                continue;
            }

        }
    }

}
