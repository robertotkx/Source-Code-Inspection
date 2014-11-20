/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.ticketmachine.test;


import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author User
 */
public class TicketMachineTest {
    
    @Test (expected = Exception.class)
    public void inserirPapelMoedaTestIncorretp() throws PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(0);
        tm.inserir(-100);
        assertEquals(tm.getSaldo(), 100);
   }
    
    @Test
    public void inserirPapelMoedaTest() throws PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(0);
        tm.inserir(100);
        assertEquals(tm.getSaldo(), 100);
   }
    
    @Test (expected = Exception.class)
    public void inserirReceberTrocoTestIncorreto() throws PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(2);
        System.out.println("Starting troco");
        tm.inserir(-20);
        boolean exResult = true;
        Object result = tm.getTroco();
        assertEquals(exResult, result);
    }
    
    @Test
    public void inserirReceberTrocoTest() throws PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(2);
        System.out.println("Starting troco");
        tm.inserir(20);
        boolean exResult = true;
        Object result = tm.getTroco();
        assertEquals(exResult, result);
    }
    
    @Test (expected = Exception.class)
    public void solicitaBilheteTestIncorreto() throws PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(2);
        System.out.println("Starting Solicita Bilhete Test");
        tm.inserir(-20);
        String result = tm.solicitaBilhete(2);
        String exResult = "Bilhetes comprados com sucesso!";
        assertEquals(exResult, result);
    }
    
    @Test
    public void solicitaBilheteTest() throws PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(2);
        System.out.println("Starting Solicita Bilhete Test");
        tm.inserir(20);
        String result = tm.solicitaBilhete(2);
        String exResult = "Bilhetes comprados com sucesso!";
        assertEquals(exResult, result);
    }
    
    @Test (expected = Exception.class)
    public void imprimeTestIncorreto() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine tm = new TicketMachine(2);
        System.out.println("Starting Imprime Test");
        tm.inserir(-20);
        String result = tm.imprimir();
        String exResult = "Bilhetes comprados com sucesso!";
        //assertEquals(exResult, result);
        System.out.println(result);
    }
    
    /**
     *
     * @throws PapelMoedaInvalidaException
     * @throws SaldoInsuficienteException
     */
    @Test
    public void imprimeTest() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine tm = new TicketMachine(2);
        System.out.println("Starting Imprime Test");
        tm.inserir(20);
        String result = tm.imprimir();
        String exResult = "Bilhetes comprados com sucesso!";
        //assertEquals(exResult, result);
        System.out.println(result);
    }
    
    
    
    
}
