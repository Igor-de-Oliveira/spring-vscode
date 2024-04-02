package com.reservas.springvscode.model;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    private Time Evento_D_H;

    private int Evento_Dur;

    private int Evento_Num_Conv;

    @OneToOne
    @JoinColumn(name = "local", referencedColumnName = "idLocal")
    private Long idLocal;

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEvento == null) ? 0 : idEvento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Evento other = (Evento) obj;
        if (idEvento == null) {
            if (other.idEvento != null)
                return false;
        } else if (!idEvento.equals(other.idEvento))
            return false;
        return true;
    }

    /**
     * @return Long return the idEvento
     */
    public Long getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return Time return the Evento_D_H
     */
    public Time getEvento_D_H() {
        return Evento_D_H;
    }

    /**
     * @param Evento_D_H the Evento_D_H to set
     */
    public void setEvento_D_H(Time Evento_D_H) {
        this.Evento_D_H = Evento_D_H;
    }

    /**
     * @return int return the Evento_Dur
     */
    public int getEvento_Dur() {
        return Evento_Dur;
    }

    /**
     * @param Evento_Dur the Evento_Dur to set
     */
    public void setEvento_Dur(int Evento_Dur) {
        this.Evento_Dur = Evento_Dur;
    }

    /**
     * @return int return the Evento_Num_Conv
     */
    public int getEvento_Num_Conv() {
        return Evento_Num_Conv;
    }

    /**
     * @param Evento_Num_Conv the Evento_Num_Conv to set
     */
    public void setEvento_Num_Conv(int Evento_Num_Conv) {
        this.Evento_Num_Conv = Evento_Num_Conv;
    }

    /**
     * @return Long return the idLocal
     */
    public Long getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

}
