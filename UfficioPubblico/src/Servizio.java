public class Servizio {
    private IdServizio id;
    private Coda codaServizio;

    public Servizio(IdServizio id) {
        this.id = id;
        this.codaServizio = new Coda();
    }

    public IdServizio getId() {
        return id;
    }

    public Coda getCodaServizio() {
        return codaServizio;
    }

    public int prenota(){
        return codaServizio.prenota();
    }

    public Prenotazione prossimoCliente(){
        return codaServizio.prossimoDaServire();
    }

    @Override
    public String toString() {
        return "------------------------\n"+
               "Servizio id: " +id +"\n"+
                codaServizio;
    }
}
