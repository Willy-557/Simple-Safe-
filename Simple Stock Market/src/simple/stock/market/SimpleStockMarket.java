/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.stock.market;

import java.util.Random;


class Saham {
    private String kodeSaham;
    private double hargaSaham;
    Random r = new Random();

    public Saham (String kodeSaham, double hargaSaham) {
        this.kodeSaham = kodeSaham;
        this.hargaSaham = hargaSaham;
    } 

    public void updatePasar() {
        int r1 = r.nextInt(1001) - 500;
        this.hargaSaham += r1;

        if (r1 < 50) {
            this.hargaSaham = 50;
        }

        System.out.println("Saham " + this.kodeSaham + " : Rp " + (int)this.hargaSaham + ".");
    }
}  
/**
 *
 * @author William
 */
public class SimpleStockMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
         
    }
}
