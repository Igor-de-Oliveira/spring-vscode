package com.reservas.springvscode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private String Reserva_status;

    private String Reserva_Data;

    @OneToOne
    @JoinColumn(name = "local", referencedColumnName = "idLocal")
    private Long idLocal;

    @OneToMany
    @JoinColumn(name = "funcionario", referencedColumnName = "idFuncionario")
    private Long idFuncionario;

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idReserva == null) ? 0 : idReserva.hashCode());
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
        Reserva other = (Reserva) obj;
        if (idReserva == null) {
            if (other.idReserva != null)
                return false;
        } else if (!idReserva.equals(other.idReserva))
            return false;
        return true;
    }

    /**
     * @return Long return the idReserva
     */
    public Long getIdReserva() {
        return idReserva;
    }

    /**
     * @param idReserva the idReserva to set
     */
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * @return String return the Reserva_status
     */
    public String getReserva_status() {
        return Reserva_status;
    }

    /**
     * @param Reserva_status the Reserva_status to set
     */
    public void setReserva_status(String Reserva_status) {
        this.Reserva_status = Reserva_status;
    }

    /**
     * @return String return the Reserva_Data
     */
    public String getReserva_Data() {
        return Reserva_Data;
    }

    /**
     * @param Reserva_Data the Reserva_Data to set
     */
    public void setReserva_Data(String Reserva_Data) {
        this.Reserva_Data = Reserva_Data;
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

    /**
     * @return Long return the idFuncionario
     */
    public Long getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

}
