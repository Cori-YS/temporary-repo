/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author ismelio-cori
 */
public interface IRepositorioDasCarteiras {

    public Carteira criarCarteira(String email, String password, String nomeCompleto);

    public Carteira actualizarCarteira(String email, String password, String nomeCompleto);

    public Carteira consultarCarteira(String email);

    public void fecharCarteira(String email);

    public Carteira comprarPlano(String email, Planos plano, int numeroDeConvitesEnviados);

    public Carteira converterEmDinheiro(String email, double valor);

    public Carteira levantarDinheiro(String email, double valor);

    public String consultarTransacoes(String email);

    public Carteira realizarTransferencia(String email, Double valor, String emailReceptor);

}
