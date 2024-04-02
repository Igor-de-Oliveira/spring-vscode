package com.reservas.springvscode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    private String Pagamento_status;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    private Long idUsuario;

    @OneToOne
    @JoinColumn(name = "local", referencedColumnName = "idLocal")
    private Long idLocal;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPagamento == null) ? 0 : idPagamento.hashCode());
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
        Pagamento other = (Pagamento) obj;
        if (idPagamento == null) {
            if (other.idPagamento != null)
                return false;
        } else if (!idPagamento.equals(other.idPagamento))
            return false;
        return true;
    }

    /**
     * @return Long return the idPagamento
     */
    public Long getIdPagamento() {
        return idPagamento;
    }

    /**
     * @param idPagamento the idPagamento to set
     */
    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    /**
     * @return String return the Pagamento_status
     */
    public String getPagamento_status() {
        return Pagamento_status;
    }

    /**
     * @param Pagamento_status the Pagamento_status to set
     */
    public void setPagamento_status(String Pagamento_status) {
        this.Pagamento_status = Pagamento_status;
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
