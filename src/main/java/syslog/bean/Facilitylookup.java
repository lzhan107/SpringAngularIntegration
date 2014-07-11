package syslog.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Lei
 */
@Entity
public class Facilitylookup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private Short facilityLookupCode;
    private String message;

    public Facilitylookup() {
    }

    public Facilitylookup(Short facilityLookupCode) {
        this.facilityLookupCode = facilityLookupCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getFacilityLookupCode() {
        return facilityLookupCode;
    }

    public void setFacilityLookupCode(Short facilityLookupCode) {
        this.facilityLookupCode = facilityLookupCode;
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
        hash += (facilityLookupCode != null ? facilityLookupCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Facilitylookup)) {
            return false;
        }
        Facilitylookup other = (Facilitylookup) object;
        if ((this.facilityLookupCode == null && other.facilityLookupCode != null)
                || (this.facilityLookupCode != null && !this.facilityLookupCode
                .equals(other.facilityLookupCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Facilitylookup[ facilityLookupCode=" + facilityLookupCode
                + " ]";
    }
}
