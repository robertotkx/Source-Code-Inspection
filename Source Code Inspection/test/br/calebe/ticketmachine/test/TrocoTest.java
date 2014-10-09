/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.ticketmachine.test;
import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.Troco;
import java.util.Iterator;
import org.junit.Test;

/**
 *
 * @author User
 */
public class TrocoTest {
    
    @Test
    public void getIteratorTest(){
        
        PapelMoeda[] papelMoedaList = new PapelMoeda[6];
        papelMoedaList[5] = new PapelMoeda(100, 0);
        papelMoedaList[4] = new PapelMoeda(50, 0);
        papelMoedaList[3] = new PapelMoeda(20, 0);
        papelMoedaList[2] = new PapelMoeda(10, 1);
        papelMoedaList[1] = new PapelMoeda(5, 0);
        papelMoedaList[0] = new PapelMoeda(2, 1);
        
        Troco troco = new Troco(12);
        Iterator result = troco.getIterator();
        while(result.hasNext()){
            Object next = result.next();
            System.out.println("QUANTIDADE - : " + ((PapelMoeda)next).getQuantidade());
            System.out.println("VALOR - : " + ((PapelMoeda)next).getValor());
            
        }
    }
}
