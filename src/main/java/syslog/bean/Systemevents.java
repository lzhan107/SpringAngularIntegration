package syslog.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lei
 */
@Entity
@Table(name = "systemevents", catalog = "syslog", schema = "")
public class Systemevents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CustomerID")
    private Integer customerID;
    @Column(name = "ReceivedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedAt;
    @Column(name = "DeviceReportedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deviceReportedTime;
    @Column(name = "Facility")
    private Integer facility;
    @Column(name = "Priority")
    private Integer priority;
    @Column(name = "FromHost")
    private String fromHost;
    @Lob
    @Column(name = "Message")
    private String message;
    @Column(name = "NTSeverity")
    private Integer nTSeverity;
    @Column(name = "Importance")
    private Integer importance;
    @Column(name = "EventSource")
    private String eventSource;
    @Column(name = "EventUser")
    private String eventUser;
    @Column(name = "EventCategory")
    private Integer eventCategory;
    @Column(name = "EventID")
    private Integer eventID;
    @Lob
    @Column(name = "EventBinaryData")
    private String eventBinaryData;
    @Column(name = "MaxAvailable")
    private Integer maxAvailable;
    @Column(name = "CurrUsage")
    private Integer currUsage;
    @Column(name = "MinUsage")
    private Integer minUsage;
    @Column(name = "MaxUsage")
    private Integer maxUsage;
    @Column(name = "InfoUnitID")
    private Integer infoUnitID;
    @Column(name = "SysLogTag")
    private String sysLogTag;
    @Column(name = "EventLogType")
    private String eventLogType;
    @Column(name = "GenericFileName")
    private String genericFileName;
    @Column(name = "SystemID")
    private Integer systemID;

    public Systemevents() {
    }

    public Systemevents(Integer id, Integer customerID, Date receivedAt, Date deviceReportedTime, Integer facility, Integer priority, String fromHost, String message, Integer nTSeverity, Integer importance, String eventSource, String eventUser, Integer eventCategory, Integer eventID, String eventBinaryData, Integer maxAvailable, Integer currUsage, Integer minUsage, Integer maxUsage, Integer infoUnitID, String sysLogTag, String eventLogType, String genericFileName, Integer systemID) {
        this.customerID = customerID;
        this.receivedAt = receivedAt;
        this.deviceReportedTime = deviceReportedTime;
        this.facility = facility;
        this.priority = priority;
        this.fromHost = fromHost;
        this.message = message;
        this.nTSeverity = nTSeverity;
        this.importance = importance;
        this.eventSource = eventSource;
        this.eventUser = eventUser;
        this.eventCategory = eventCategory;
        this.eventID = eventID;
        this.eventBinaryData = eventBinaryData;
        this.maxAvailable = maxAvailable;
        this.currUsage = currUsage;
        this.minUsage = minUsage;
        this.maxUsage = maxUsage;
        this.infoUnitID = infoUnitID;
        this.sysLogTag = sysLogTag;
        this.eventLogType = eventLogType;
        this.genericFileName = genericFileName;
        this.systemID = systemID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public Date getDeviceReportedTime() {
        return deviceReportedTime;
    }

    public void setDeviceReportedTime(Date deviceReportedTime) {
        this.deviceReportedTime = deviceReportedTime;
    }

    public Integer getFacility() {
        return facility;
    }

    public void setFacility(Integer facility) {
        this.facility = facility;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getFromHost() {
        return fromHost;
    }

    public void setFromHost(String fromHost) {
        this.fromHost = fromHost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNTSeverity() {
        return nTSeverity;
    }

    public void setNTSeverity(Integer nTSeverity) {
        this.nTSeverity = nTSeverity;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventUser() {
        return eventUser;
    }

    public void setEventUser(String eventUser) {
        this.eventUser = eventUser;
    }

    public Integer getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(Integer eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventBinaryData() {
        return eventBinaryData;
    }

    public void setEventBinaryData(String eventBinaryData) {
        this.eventBinaryData = eventBinaryData;
    }

    public Integer getMaxAvailable() {
        return maxAvailable;
    }

    public void setMaxAvailable(Integer maxAvailable) {
        this.maxAvailable = maxAvailable;
    }

    public Integer getCurrUsage() {
        return currUsage;
    }

    public void setCurrUsage(Integer currUsage) {
        this.currUsage = currUsage;
    }

    public Integer getMinUsage() {
        return minUsage;
    }

    public void setMinUsage(Integer minUsage) {
        this.minUsage = minUsage;
    }

    public Integer getMaxUsage() {
        return maxUsage;
    }

    public void setMaxUsage(Integer maxUsage) {
        this.maxUsage = maxUsage;
    }

    public Integer getInfoUnitID() {
        return infoUnitID;
    }

    public void setInfoUnitID(Integer infoUnitID) {
        this.infoUnitID = infoUnitID;
    }

    public String getSysLogTag() {
        return sysLogTag;
    }

    public void setSysLogTag(String sysLogTag) {
        this.sysLogTag = sysLogTag;
    }

    public String getEventLogType() {
        return eventLogType;
    }

    public void setEventLogType(String eventLogType) {
        this.eventLogType = eventLogType;
    }

    public String getGenericFileName() {
        return genericFileName;
    }

    public void setGenericFileName(String genericFileName) {
        this.genericFileName = genericFileName;
    }

    public Integer getSystemID() {
        return systemID;
    }

    public void setSystemID(Integer systemID) {
        this.systemID = systemID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.customerID != null ? this.customerID.hashCode() : 0);
        hash = 47 * hash + (this.eventID != null ? this.eventID.hashCode() : 0);
        hash = 47 * hash + (this.infoUnitID != null ? this.infoUnitID.hashCode() : 0);
        hash = 47 * hash + (this.systemID != null ? this.systemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Systemevents other = (Systemevents) obj;
        if (this.customerID != other.customerID && (this.customerID == null || !this.customerID.equals(other.customerID))) {
            return false;
        }
        if (this.eventID != other.eventID && (this.eventID == null || !this.eventID.equals(other.eventID))) {
            return false;
        }
        if (this.infoUnitID != other.infoUnitID && (this.infoUnitID == null || !this.infoUnitID.equals(other.infoUnitID))) {
            return false;
        }
        if (this.systemID != other.systemID && (this.systemID == null || !this.systemID.equals(other.systemID))) {
            return false;
        }
        return true;
    }

    
}
