import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ismelio-cori
 */
public class RepositorioDasCarteiras implements IRepositorioDasCarteiras {

    private ArrayList<Carteira> carteiras;
    private ArrayList<Transacao> transacoes;

    private static RepositorioDasCarteiras instancia;

    private RepositorioDasCarteiras() {
        // construtor privado
        this.carteiras = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    public static RepositorioDasCarteiras pegarInstancia() {
        if (instancia == null) {
            instancia = new RepositorioDasCarteiras();
        }

        return instancia;
    }
    
    private void leitura() {
    	try {
    	   FileInputStream ficheiro = new FileInputStream("carteiras.dat");
      	   ObjectInputStream ler = new ObjectInputStream(ficheiro);

      	   this.carteiras = (ArrayList<Carteira>) ler.readObject();
      	   
      	   ler.close();
      	   
      	   ficheiro = new FileInputStream("transacoes.dat");
      	   ler = new ObjectInputStream(ficheiro);

      	   this.transacoes = (ArrayList<Transacao>) ler.readObject();
      	   
      	   ler.close();
      		
    	}catch(Exception e){
      	   System.out.println("Erro: "+e);
    	}
    	
    	
    }
    
    private void escrita() {
       try {
          FileOutputStream ficheiro = new FileOutputStream("carteiras.dat");
          ObjectOutputStream escrever = new ObjectOutputStream(ficheiro);

          escrever.writeObject(carteiras);
          
          escrever.close();
          
          ficheiro = new FileOutputStream("transacoes.dat");
          escrever = new ObjectOutputStream(ficheiro);

          escrever.writeObject(transacoes);
          
          escrever.close();
       }catch(Exception e){
          System.out.println("Erro: "+e);
       }
    }

    @Override
    public Carteira criarCarteira(String email, String password, String nomeCompleto) {
        leitura();
    
        Carteira carteiraNova = new Carteira();

        try {
            for (Carteira carteira : carteiras) {
                if (!carteira.isActivo() && carteira.getEmail().equals(email)) {
                    throw new Error("Email invalido!");
                }
            }

            carteiraNova.setEmail(email);
            carteiraNova.setPassword(password);
            carteiraNova.setNomeCompleto(nomeCompleto);
            carteiraNova.setActivo(true);

            carteiras.add(carteiraNova);

            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Problema de Cadastro", JOptionPane.ERROR_MESSAGE);
        }
        
        escrita();

        return carteiraNova;
    }

    @Override
    public Carteira actualizarCarteira(String email, String password, String nomeCompleto) {
        leitura();
        
        Carteira carteiraActualizada = new Carteira();

        try {
            for (int i = 0; i < carteiras.size(); i++) {

                if (carteiras.get(i).getEmail().equals(email)) {

                    if (!carteiras.get(i).isActivo()) {
                        throw new Error("Email invalido!");
                    }

                    carteiraActualizada = carteiras.get(i);

                    carteiras.remove(i);

                    carteiraActualizada.setEmail(email);
                    carteiraActualizada.setPassword(password);
                    carteiraActualizada.setNomeCompleto(nomeCompleto);

                    carteiras.add(carteiraActualizada);

                    break;
                }
            }

            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Problema de Cadastro", JOptionPane.ERROR_MESSAGE);
        }
        
        escrita();

        return carteiraActualizada;
    }

    @Override
    public Carteira consultarCarteira(String email) {
        leitura();
        
        Carteira carteira = new Carteira();

        try {
            for (int i = 0; i < carteiras.size(); i++) {
                if (carteiras.get(i).getEmail().equals(email)) {
                    if (!carteiras.get(i).isActivo()) {
                        throw new Error("Email invalido!");
                    }
                    carteira = carteiras.get(i);

                    break;
                }
            }

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return carteira;
    }

    @Override
    public void fecharCarteira(String email) {
        leitura();
        
        try {
            for (int i = 0; i < carteiras.size(); i++) {

                if (carteiras.get(i).getEmail().equals(email)) {

                    if (!carteiras.get(i).isActivo()) {
                        throw new Error("Email invalido!");
                    }

                    carteiras.get(i).setActivo(false);

                    break;
                }
            }

            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, "Conta encerrada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        escrita();
    }

    @Override
    public Carteira comprarPlano(String email, Planos plano, int numeroDeConvitesEnviados) {
        leitura();

        Carteira carteira = new Carteira();

        try {
            for (int i = 0; i < carteiras.size(); i++) {

                if (carteiras.get(i).getEmail().equals(email)) {

                    if (!carteiras.get(i).isActivo()) {
                        throw new Error("Email invalido!");
                    }

                    if (plano == Planos.PLANO_500) {

                        int bonus = (numeroDeConvitesEnviados >= 3) ? (plano.getValor() * 15) / 100 : 0;

                        carteiras.get(i).setSaldoUnitel(carteiras.get(i).getSaldoUnitel() + plano.getValor() + bonus);

                        carteira = carteiras.get(i);

                        Transacao transacao = new Transacao(carteira.getEmail(), "Compra de Plano 500", Double.valueOf(plano.getValor() + bonus), carteira.getEmail());

                        this.transacoes.add(transacao);

                        break;
                    } else if (plano == Planos.PLANO_1000) {

                        int bonus = (numeroDeConvitesEnviados >= 3) ? (plano.getValor() * 25) / 100 : 0;

                        carteiras.get(i).setSaldoUnitel(carteiras.get(i).getSaldoUnitel() + plano.getValor() + bonus);

                        carteira = carteiras.get(i);

                        Transacao transacao = new Transacao(carteira.getEmail(), "Compra de Plano 1000", Double.valueOf(plano.getValor() + bonus), carteira.getEmail());

                        this.transacoes.add(transacao);

                        break;
                    } else if (plano == Planos.PLANO_2000) {

                        int bonus = (numeroDeConvitesEnviados >= 3) ? (plano.getValor() * 50) / 100 : 0;

                        carteiras.get(i).setSaldoUnitel(plano.getValor() + carteiras.get(i).getSaldoUnitel() + bonus);

                        carteira = carteiras.get(i);

                        Transacao transacao = new Transacao(carteira.getEmail(), "Compra de Plano 2000", Double.valueOf(plano.getValor() + bonus), carteira.getEmail());

                        this.transacoes.add(transacao);

                        break;
                    }
                }
            }

            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, "Plano comprado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        escrita();

        return carteira;
    }

    @Override
    public Carteira converterEmDinheiro(String email, double valor) {
        leitura();

        Carteira carteira = new Carteira();

        try {
            for (int i = 0; i < carteiras.size(); i++) {

                if (carteiras.get(i).getEmail().equals(email)) {

                    if (!carteiras.get(i).isActivo()) {
                        throw new Error("Email invalido!");
                    }

                    if (carteiras.get(i).getSaldoUnitel() <= 0 || carteiras.get(i).getSaldoUnitel() < valor || valor <= 0) {
                        throw new Error("Valor invalido!");
                    }
                    carteiras.get(i).setSaldoEmMoeda(valor + carteiras.get(i).getSaldoEmMoeda());

                    carteiras.get(i).setSaldoUnitel(carteiras.get(i).getSaldoUnitel() - valor);

                    carteira = carteiras.get(i);

                    Transacao transacao = new Transacao(carteira.getEmail(), "Conversão para Moeda", valor, carteira.getEmail());

                    this.transacoes.add(transacao);

                    break;
                }
            }

            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, "Conversão efetuada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        escrita();

        return carteira;
    }

    @Override
    public Carteira levantarDinheiro(String email, double valor) {
        leitura();
        
        Carteira carteira = new Carteira();

        try {
            for (int i = 0; i < carteiras.size(); i++) {

                if (carteiras.get(i).getEmail().equals(email)) {

                    if (!carteiras.get(i).isActivo()) {
                        throw new Error("Email invalido!");
                    }

                    if (valor <= 0 || carteiras.get(i).getSaldoEmMoeda() < valor) {
                        throw new Error("Valor invalido!");
                    }

                    carteiras.get(i).setSaldoEmMoeda(carteiras.get(i).getSaldoEmMoeda() - valor);

                    carteira = carteiras.get(i);

                    Transacao transacao = new Transacao(carteira.getEmail(), "Levantamento", valor, carteira.getEmail());

                    this.transacoes.add(transacao);

                    break;
                }
            }

            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, "Levantamento efetuado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        escrita();

        return carteira;
    }

    @Override
    public String consultarTransacoes(String email) {
        leitura();
    
        String consulta = "";

        for (int i = 0; i < transacoes.size(); i++) {
            consulta += "\n|===================================|\n";
            consulta += "Email: " + transacoes.get(i).getEmail() + "\nTitulo: " + transacoes.get(i).getTitulo() + "\nValor: " + transacoes.get(i).getValor() + "\nReceptor: " + transacoes.get(i).getReceptor() + "\nData: " + transacoes.get(i).getDataDaTransacao();
            consulta += "\n|===================================|\n";
        }

        return consulta;
    }

    @Override
    public Carteira realizarTransferencia(String email, Double valor, String emailReceptor) {
        leitura();
        
        Carteira carteira = new Carteira();

        try {
            for (int i = 0; i < carteiras.size(); i++) {

                if (carteiras.get(i).getEmail().equals(email)) {

                    if (!carteiras.get(i).isActivo()) {
                        throw new Error("Email invalido!");
                    }

                    if (valor <= 0 || carteiras.get(i).getSaldoEmMoeda() < valor) {
                        throw new Error("Valor invalido!");
                    }

                    carteira = carteiras.get(i);
                    carteiras.get(i).setSaldoEmMoeda(carteiras.get(i).getSaldoEmMoeda() - valor);

                    for (int k = 0; k < carteiras.size(); k++) {
                        if (carteiras.get(k).getEmail().equals(emailReceptor)) {

                            if (!carteiras.get(i).isActivo()) {
                                throw new Error("Email invalido!");
                            }

                            carteiras.get(k).setSaldoEmMoeda(carteiras.get(k).getSaldoEmMoeda() + valor);

                            Transacao transacao = new Transacao(carteira.getEmail(), "Tranferência", valor, emailReceptor);

                            this.transacoes.add(transacao);

                            break;
                        }
                    }

                    break;
                }
            }

            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, "Transferência efetuada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Error e) {
            // create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog");

            // show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        escrita();

        return carteira;
    }
}
