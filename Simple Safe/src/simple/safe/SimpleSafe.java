
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
    
    public void setorTunai (double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Uang yang anda setorkan kurang dari Rp 0");
        }
        else {
            this.saldo += jumlah;
            System.out.println("Berhasil menyetorkan uang ke rekening sebesar Rp " + jumlah + ".");
        }
    }
    
    public void tarikTunai (double nominalTarikan, String pinInput) {
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
            
            System.out.println(">> ");
            int opsi = scanner.nextInt();
            
            if (opsi == 1) {
                System.out.println("Masukkan pin atm : ");
                int pinATM = scanner.nextInt();
            }
            else if (opsi == 2) {
                System.out.println("Masukkan pin baru : ");
                int pinAtmBaru = scanner.nextInt();
                
                System.out.println("Masukkan nama baru : ");
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
