package entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
    private Date data_evento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo_evento;
    private int numero_massimo_partecipanti;

    public Evento(){};
    public Evento(String titolo, Date dataEvento, String descrizione, TipoEvento tipoevento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.data_evento = dataEvento;
        this.descrizione = descrizione;
        this.tipo_evento = tipoevento;
        this.numero_massimo_partecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoevento=" + tipo_evento +
                ", numeroMassimoPartecipanti=" + numero_massimo_partecipanti +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public Date getDataEvento() {
        return data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoevento() {
        return tipo_evento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numero_massimo_partecipanti;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(Date dataEvento) {
        this.data_evento = dataEvento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoevento(TipoEvento tipoevento) {
        this.tipo_evento = tipoevento;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numero_massimo_partecipanti = numeroMassimoPartecipanti;
    }
}
