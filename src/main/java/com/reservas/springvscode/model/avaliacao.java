package com.reservas.springvscode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idavaliacao;

    private String avaliacao_Desc;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    private Long idUsuario;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idavaliacao == null) ? 0 : idavaliacao.hashCode());
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
        avaliacao other = (avaliacao) obj;
        if (idavaliacao == null) {
            if (other.idavaliacao != null)
                return false;
        } else if (!idavaliacao.equals(other.idavaliacao))
            return false;
        return true;
    }

    /**
     * @return Long return the idavaliacao
     */
    public Long getIdavaliacao() {
        return idavaliacao;
    }

    /**
     * @param idavaliacao the idavaliacao to set
     */
    public void setIdavaliacao(Long idavaliacao) {
        this.idavaliacao = idavaliacao;
    }

    /**
     * @return String return the avaliacao_Desc
     */
    public String getAvaliacao_Desc() {
        return avaliacao_Desc;
    }

    /**
     * @param avaliacao_Desc the avaliacao_Desc to set
     */
    public void setAvaliacao_Desc(String avaliacao_Desc) {
        this.avaliacao_Desc = avaliacao_Desc;
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

}
