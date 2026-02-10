
package simple.safe;

class RekeningBank {
    private String namaPemilik;
    private double saldo;
    private String pin;
    
    public RekeningBank (String namaPemilik, double saldo, String pin) {
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.pin = pin;
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
        if (this.pin.equals(pinInput)) {
            if (nominalTarikan > saldo) {
            System.out.println("Saldo yang anda miliki di rekening tidak cukup!");
            }
            else {
                this.saldo -= nominalTarikan;
                System.out.println("Berhasil melakukan penarikan tunai sebesar Rp " + nominalTarikan + ".");
            }
        }
        else {
            System.out.println("Pin yang anda inputkan salah! Silahkan dicoba lagi!");
        }
        
    }
    
    
}
public class SimpleSafe {
    public static void main(String[] args) {
        
    }

}
