package com.reservas.springvscode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocal;

    private String Local_Name;

    private Long Local_Cap;

    private String Local_End;

    private String Local_disp;


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
     * @return String return the Local_Name
     */
    public String getLocal_Name() {
        return Local_Name;
    }

    /**
     * @param Local_Name the Local_Name to set
     */
    public void setLocal_Name(String Local_Name) {
        this.Local_Name = Local_Name;
    }

    /**
     * @return Long return the Local_Cap
     */
    public Long getLocal_Cap() {
        return Local_Cap;
    }

    /**
     * @param Local_Cap the Local_Cap to set
     */
    public void setLocal_Cap(Long Local_Cap) {
        this.Local_Cap = Local_Cap;
    }

    /**
     * @return String return the Local_End
     */
    public String getLocal_End() {
        return Local_End;
    }

    /**
     * @param Local_End the Local_End to set
     */
    public void setLocal_End(String Local_End) {
        this.Local_End = Local_End;
    }

    /**
     * @return String return the Local_disp
     */
    public String getLocal_disp() {
        return Local_disp;
    }

    /**
     * @param Local_disp the Local_disp to set
     */
    public void setLocal_disp(String Local_disp) {
        this.Local_disp = Local_disp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idLocal == null) ? 0 : idLocal.hashCode());
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
        Local other = (Local) obj;
        if (idLocal == null) {
            if (other.idLocal != null)
                return false;
        } else if (!idLocal.equals(other.idLocal))
            return false;
        return true;
    }

        
}
