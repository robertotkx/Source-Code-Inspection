/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.ticketmachine.test;

import br.calebe.ticketmachine.core.PapelMoeda;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PapelMoedaTest {
    
    @Test (expected = Exception.class)
    public void getValorTestIncorreto(){
        PapelMoeda pm = new PapelMoeda(-5, 3);
        int exResult = 5;
        int result = pm.getValor();
        
        assertEquals(exResult, result);
    }
    
    @Test
    public void getValorTest(){
        PapelMoeda pm = new PapelMoeda(5, 3);
        int exResult = 5;
        int result = pm.getValor();
        
        assertEquals(exResult, result);
    }
    
    @Test (expected = Exception.class)
    public void getQuantidadeTestIncorreto(){
        PapelMoeda pm = new PapelMoeda(-10, 3);
        int exResult = 3;
        int result = pm.getQuantidade();
        
        assertEquals(exResult, result);
    
    }
    

    @Test
    public void getQuantidadeTest(){
        PapelMoeda pm = new PapelMoeda(5, 3);
        int exResult = 3;
        int result = pm.getQuantidade();
        
        assertEquals(exResult, result);
    
    }
    
}
