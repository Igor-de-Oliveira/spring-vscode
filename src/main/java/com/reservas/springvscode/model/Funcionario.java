package com.reservas.springvscode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    private String Funcionario_CPF;

    private String Funcionario_End;

    private int Funcionario_Cel;

    @ManyToOne
    @JoinColumn(name = "Evento", referencedColumnName = "idEvento")
    private int idEvento;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
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
        Funcionario other = (Funcionario) obj;
        if (idFuncionario == null) {
            if (other.idFuncionario != null)
                return false;
        } else if (!idFuncionario.equals(other.idFuncionario))
            return false;
        return true;
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

    /**
     * @return String return the Funcionario_CPF
     */
    public String getFuncionario_CPF() {
        return Funcionario_CPF;
    }

    /**
     * @param Funcionario_CPF the Funcionario_CPF to set
     */
    public void setFuncionario_CPF(String Funcionario_CPF) {
        this.Funcionario_CPF = Funcionario_CPF;
    }

    /**
     * @return String return the Funcionario_End
     */
    public String getFuncionario_End() {
        return Funcionario_End;
    }

    /**
     * @param Funcionario_End the Funcionario_End to set
     */
    public void setFuncionario_End(String Funcionario_End) {
        this.Funcionario_End = Funcionario_End;
    }

    /**
     * @return int return the Funcionario_Cel
     */
    public int getFuncionario_Cel() {
        return Funcionario_Cel;
    }

    /**
     * @param Funcionario_Cel the Funcionario_Cel to set
     */
    public void setFuncionario_Cel(int Funcionario_Cel) {
        this.Funcionario_Cel = Funcionario_Cel;
    }

    /**
     * @return int return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

}
