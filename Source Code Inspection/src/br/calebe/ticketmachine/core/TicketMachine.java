package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import br.calebe.ticketmachine.core.Troco;


public class TicketMachine {

    protected int valor;
    protected int saldo;
    private int qtd_valor;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};
    private Troco troco = null;
    

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int qnta) throws PapelMoedaInvalidaException {
        boolean encontrou = false;
        for (int i = 0; i < papelMoeda.length && !encontrou; i++) {
            if (papelMoeda[i] == qnta) {
                encontrou = true;
            }
        }
        if (!encontrou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += qnta;
        
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean getTroco() {
        if(this.saldo > 0){
            troco = new Troco(this.saldo);
            Iterator iter;
            iter = troco.getIterator();

            System.out.println("Devolvendo Troco: " + this.saldo);
            
            while(iter.hasNext()){
                System.out.println("Processando...");
                iter.next();
            }

            return true;
        }else{
            return false;
        }
    }

    public String solicitaBilhete(Integer qtdBilhete){
        
        if((qtdBilhete*this.valor) <= this.saldo){
            for(int i = 1; i <= qtdBilhete; i++){
                this.saldo -= this.valor;
                System.out.println("Imprimindo Bilhete " + i);
            }
            return "Bilhete adiquirido com sucesso!";
        }else{
            return "Sem Saldo";
        }
    }
    
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }else{
            String result = "*****************\n";
            result += "*** R$ " + saldo + ",00 ****\n";
            result += "*****************\n";
            return result;
        }
    }
}
