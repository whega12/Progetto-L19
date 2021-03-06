package codice.server.stubs;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.Ufficio;
import codice.sharedInterface.TerminaleUtente;

import java.rmi.RemoteException;

public class ServerUtente extends Server implements TerminaleUtente {

    public ServerUtente(Ufficio ufficio) throws RemoteException {
        super(ufficio);
    }

    @Override
    public int prenota(IdServizio idServizio) throws RemoteException {
        return ufficioPubblico.prenota(idServizio);
    }
}
