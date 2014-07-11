package syslog.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Lei
 */
@Entity
public class Prioritylookup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private Short priorityLookupCode;
    private String message;

    public Prioritylookup() {
    }

    public Prioritylookup(Short priorityLookupCode) {
        this.priorityLookupCode = priorityLookupCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getPriorityLookupCode() {
        return priorityLookupCode;
    }

    public void setPriorityLookupCode(Short priorityLookupCode) {
        this.priorityLookupCode = priorityLookupCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (priorityLookupCode != null ? priorityLookupCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Prioritylookup)) {
            return false;
        }
        Prioritylookup other = (Prioritylookup) object;
        if ((this.priorityLookupCode == null && other.priorityLookupCode != null)
                || (this.priorityLookupCode != null && !this.priorityLookupCode
                .equals(other.priorityLookupCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Prioritylookup[ priorityLookupCode=" + priorityLookupCode
                + " ]";
    }
}
