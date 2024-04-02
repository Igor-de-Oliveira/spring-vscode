package com.reservas.springvscode.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String Usuario_name;

    private int Usuario_idade;

    private String Usuario_pass;

    private String Usuario_end;

    private String Usuario_email;

    private Date Usuario_nasc;

    @OneToMany
    @JoinColumn(name = "reserva", referencedColumnName = "idReserva")
    private Long idReserva;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
        Usuario other = (Usuario) obj;
        if (idUsuario == null) {
            if (other.idUsuario != null)
                return false;
        } else if (!idUsuario.equals(other.idUsuario))
            return false;
        return true;
    }

    /**
     * @return Long return the idUsuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return String return the Usuario_name
     */
    public String getUsuario_name() {
        return Usuario_name;
    }

    /**
     * @param Usuario_name the Usuario_name to set
     */
    public void setUsuario_name(String Usuario_name) {
        this.Usuario_name = Usuario_name;
    }

    /**
     * @return int return the Usuario_idade
     */
    public int getUsuario_idade() {
        return Usuario_idade;
    }

    /**
     * @param Usuario_idade the Usuario_idade to set
     */
    public void setUsuario_idade(int Usuario_idade) {
        this.Usuario_idade = Usuario_idade;
    }

    /**
     * @return String return the Usuario_pass
     */
    public String getUsuario_pass() {
        return Usuario_pass;
    }

    /**
     * @param Usuario_pass the Usuario_pass to set
     */
    public void setUsuario_pass(String Usuario_pass) {
        this.Usuario_pass = Usuario_pass;
    }

    /**
     * @return String return the Usuario_end
     */
    public String getUsuario_end() {
        return Usuario_end;
    }

    /**
     * @param Usuario_end the Usuario_end to set
     */
    public void setUsuario_end(String Usuario_end) {
        this.Usuario_end = Usuario_end;
    }

    /**
     * @return String return the Usuario_email
     */
    public String getUsuario_email() {
        return Usuario_email;
    }

    /**
     * @param Usuario_email the Usuario_email to set
     */
    public void setUsuario_email(String Usuario_email) {
        this.Usuario_email = Usuario_email;
    }

    /**
     * @return Date return the Usuario_nasc
     */
    public Date getUsuario_nasc() {
        return Usuario_nasc;
    }

    /**
     * @param Usuario_nasc the Usuario_nasc to set
     */
    public void setUsuario_nasc(Date Usuario_nasc) {
        this.Usuario_nasc = Usuario_nasc;
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

}
