package codice.client;

import codice.dominio.sportello.StatoSportello;
import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleSportello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SportelloClient {

    private String host;
    private int numeroSportello;
    private String tipo;

    private StatoSportello stato;
    private IdServizio servizioOfferto;
    private int numeroClienteInServizio;

    public SportelloClient(int numeroSportello) {
        this.numeroSportello = numeroSportello;

        settaTipo(numeroSportello);

    }

    private void settaTipo(int numeroSportello){
        switch (numeroSportello){
            case 0:case 1:this.tipo="FISSO";
                break;
            case 2:case 3:case 4:case 5:this.tipo="VARIABILE";
                break;
        }
    }

    public String collegaAlServer(String hostServer){
        this.host=hostServer;

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            return stubSportello.collegaSportello(numeroSportello,tipo, IdServizio.SRP);

        }catch (Exception e){
            e.printStackTrace();
            return "NON COLLEGATO:RIAVVIARE";
        }
    }


    public void cambiaStato(StatoSportello stato){
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            if(stubSportello.changeStato(numeroSportello, stato));
                riceviDati();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void riceviDati(){
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            stato=stubSportello.getStatoSportelloPerServer(numeroSportello);
            servizioOfferto=stubSportello.getIdServizioOffertoSportelloPerServer(numeroSportello);
            numeroClienteInServizio=stubSportello.getNumeroClienteSportelloPerServer(numeroSportello);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "SportelloClient{" +
                "numeroSportello=" + numeroSportello +
                ", stato=" + stato +
                ", servizioOfferto=" + servizioOfferto +
                ", numeroClienteInServizio=" + numeroClienteInServizio +
                '}';
    }
}
