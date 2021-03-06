import java.util.ArrayList;

/**
 * Classe che rappresenta il monitoraggio e la gestione degli sportelli dell'ufficio pubblico
 */

public class MonitorSportellii {
    //private ListaServizi listaServizi;
    private ArrayList<AbstractSportello> sportelli;
    //private int NUMERO_SPORTELLI_FISSI,NUMERO_SPORTELLI_VARIABILI;

    public MonitorSportellii() {
        inizializzaSportelli(1,1);
    }

    /**
     * inizializza gli sportelli, prima quelli che hanno comportamento fisso, poi quelli che hanno comportamento variabile
     * tramite i parametri
     * @param numSportellifissi
     * @param numSportelliVariabili
     */
    private void inizializzaSportelli(int numSportellifissi,int numSportelliVariabili){
        //this.NUMERO_SPORTELLI_FISSI=numSportellifissi;
        //this.NUMERO_SPORTELLI_VARIABILI=numSportelliVariabili;
        this.sportelli=new ArrayList<>();

        for (int i=0;i<numSportellifissi;i++){
            sportelli.add(new SportelloFisso(sportelli.size()));
        }

        for (int i=0;i<numSportelliVariabili;i++){
            sportelli.add(new SportelloVariabile(sportelli.size()));
        }
    }

    /*public void setServizi(ListaServizi listaServizi) {
        this.listaServizi=listaServizi;
    }*/

    public void setServizioOffertoSportello(int numSportello,IdServizio idServizio){
        sportelli.get(numSportello).setServizioOfferto(ListaServizi.getInstance().getServizio(idServizio));
    }

    public void changeStato(int numeroSportello,StatoSportello statoSportello){
        sportelli.get(numeroSportello).changeStato(statoSportello);
    }


    @Override
    public String toString() {
        return "MonitorSportellii{" +
                "sportelli=" + sportelli +
                '}';
    }
}
