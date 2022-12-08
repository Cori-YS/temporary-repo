import java.io.Serializable;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ismelio-cori
 */
public class Transacao implements Serializable {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Date getDataDaTransacao() {
        return dataDaTransacao;
    }

    public void setDataDaTransacao(Date dataDaTransacao) {
        this.dataDaTransacao = dataDaTransacao;
    }

    public Transacao(String email, String titulo, Double valor, String receptor) {
        this.email = email;
        this.titulo = titulo;
        this.valor = valor;
        this.receptor = receptor;
        this.dataDaTransacao = new Date();
    }
    
    private String email;
    private String titulo;
    private Double valor;
    private String receptor;
    private Date dataDaTransacao;
}
