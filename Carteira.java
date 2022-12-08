/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ismelio-cori
 */   
 
import java.io.Serializable;
                                                                                                                                                                                                                                                                                                                                                     
public class Carteira extends Usuario implements Serializable {

    
    private double saldoUnitel;
    private double saldoEmMoeda;
    
    public Carteira() {
        this.saldoUnitel = 0;
        this.saldoEmMoeda = 0;
    }

    public double getSaldoUnitel() {
        return saldoUnitel;
    }

    public void setSaldoUnitel(double saldoUnitel) {
        this.saldoUnitel = saldoUnitel;
    }

    public double getSaldoEmMoeda() {
        return saldoEmMoeda;
    }

    public void setSaldoEmMoeda(double saldoEmMoeda) {
        this.saldoEmMoeda = saldoEmMoeda;
    }
}
