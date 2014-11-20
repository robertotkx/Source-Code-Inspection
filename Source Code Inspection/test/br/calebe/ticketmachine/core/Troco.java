package br.calebe.ticketmachine.core;

import java.util.Iterator;

public class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        
        papeisMoeda[5] = new PapelMoeda(100, (int)valor/100);
        valor %= 100;
        
        papeisMoeda[4] = new PapelMoeda(50, (int)valor/50);
        valor %= 50;
        
        papeisMoeda[3] = new PapelMoeda(20, (int)valor/20);
        valor %= 20;
        
        papeisMoeda[2] = new PapelMoeda(10, (int)valor/10);
        valor %= 10;
        
        papeisMoeda[1] = new PapelMoeda(5, (int)valor/5);
        valor %= 5;
        
        papeisMoeda[0] = new PapelMoeda(2, (int)valor/2);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

                @Override
        public boolean hasNext() {
            for (int i = 5; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda retorna = null;
            for (int i = 5; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    retorna = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                    return retorna;
                }
            }
            
            return null;
        }


        @Override
        public void remove() {
            next();
        }
    }
}
