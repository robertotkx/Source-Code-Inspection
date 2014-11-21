package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import br.calebe.ticketmachine.core.Troco;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

//Commit
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

   /* public boolean getTroco() {
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
    }*/
    
        
    //Caminho onde função da apenas 1 troco por causa do valor do ticket
    
    @Test
    public void getTrocoTestCaminho3() throws PapelMoedaInvalidaException {
        
        TicketMachine machineTroco3 = new TicketMachine(2);
        
        int quantia = 2;
        
        machineTroco3.inserir(2);
        assertEquals(quantia,machineTroco3.getTroco());
        
    }
        
    //Caminho onde não tem saldo e por isso não da troco para cliente
    
    @Test
    public void getTrocoTesteCaminho2() throws PapelMoedaInvalidaException {
        
        TicketMachine machineTroco2 = new TicketMachine(2);
        
        int saldo = 0;
        
        assertEquals(saldo, machineTroco2.getTroco());
    }
    
    //Caminho em que a função tenta dar todo troco possivel ao cliente dependendo do saldo
    
    @Test
    public void getTrocoTesteCaminho1() throws PapelMoedaInvalidaException {
        
        TicketMachine machineTroco = new TicketMachine(2);
        
        int quantia = 100;
        
        machineTroco.inserir(quantia);
        
        assertEquals(quantia, machineTroco.getTroco());

    }

    /*public String solicitaBilhete(Integer qtdBilhete){
        
        if((qtdBilhete*this.valor) <= this.saldo){
            for(int i = 1; i <= qtdBilhete; i++){
                this.saldo -= this.valor;
                System.out.println("Imprimindo Bilhete " + i);
            }
            return "Bilhete adiquirido com sucesso!";
        }else{
            return "Sem Saldo";
        }
    }*/
    
    @Test
    public void testSolicitaBilheteValido() throws PapelMoedaInvalidaException {
        Integer qtdBilhete = 1;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String expResult = "Bilhetes comprados com sucesso!";
        String result = instance.solicitaBilhete(qtdBilhete);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testSolicitaBilheteInvalido() throws PapelMoedaInvalidaException {
        Integer qtdBilhete = -1;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String result = instance.solicitaBilhete(qtdBilhete);
    }
    
    /*public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }else{
            String result = "*****************\n";
            result += "*** R$ " + saldo + ",00 ****\n";
            result += "*****************\n";
            return result;
        }
    }*/
    
    //Caminho errado, onde imprimi mas não tem saldo o suficiente
    
    public void imprimirTesteCaminho1 () throws SaldoInsuficienteException{
        
        TicketMachine machineImprimir1 = new TicketMachine(2);
        
        int saldo1 = 0;
     
        saldo1 = machineImprimir1.getSaldo();
        String resutaldoSaldo1 = "Saldo: "+saldo1;
        String resultadoTeste1 = machineImprimir1.imprimir();
        assertEquals(resutaldoSaldo1,resultadoTeste1);

    }
    
    //Caminho certo, onde imprimi corretamente
    
    public void imprimirTesteCaminho2 () throws SaldoInsuficienteException, PapelMoedaInvalidaException{
        
        TicketMachine machineImprimir2 = new TicketMachine(2);
        
        int quantia = 100;
        int saldo2 = 0;
     
        machineImprimir2.inserir(quantia);
        saldo2 = machineImprimir2.getSaldo();
        String resultadoTeste = machineImprimir2.imprimir();
        String resutaldoSaldo2 = "Saldo: "+saldo2;
        assertEquals(resutaldoSaldo2,resultadoTeste);
 
    }

    @Test
    public void testImprimirCerto() throws Exception {
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String expResult = "*****************\n";
               expResult += "*** R$ " + instance.getSaldo() + ",00 ****\n";
               expResult += "*****************\n";
        
        String result = instance.imprimir();
        assertEquals(expResult, result);
    }
    
    @Test (expected = Exception.class)
    public void imprimeTestIncorreto() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine tm = new TicketMachine(2);
        System.out.println("Starting Imprime Test Incorreto");
        tm.inserir(-30);
        String result = tm.imprimir();
        String exResult = "Bilhetes comprados com sucesso";
        //assertEquals(exResult, result);
        System.out.println(result);
    }
    
    public String imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getTroco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String solicitaBilhete(Integer qtdBilhete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
