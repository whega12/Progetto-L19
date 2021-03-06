package codice.dominio.sportello;

import codice.dominio.utente.Prenotazione;
import codice.dominio.eccezioni.NessunoDaServireException;

/**
 * Classe che rappresenta un tipo di sportello che non varia il servizioOfferto
 */
public class SportelloFisso extends AbstractSportello {


    public SportelloFisso(int numeroSportello) {
        super(numeroSportello);
    }

    @Override
    public Prenotazione codaVuota() {
        throw new NessunoDaServireException();
    }


}
