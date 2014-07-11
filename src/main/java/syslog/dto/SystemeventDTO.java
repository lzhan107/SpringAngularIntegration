/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syslog.dto;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lei
 */
public class SystemeventDTO {
    private Integer id;
    private Integer customerID;
    private Date receivedAt;
    private Date deviceReportedTime;
    private Integer facility;
    private Integer priority;
    private String fromHost;
    private String message;
    private Integer nTSeverity;
    private Integer importance;
    private String eventSource;
    private String eventUser;
    private Integer eventCategory;
    private Integer eventID;
    private String eventBinaryData;
    private Integer maxAvailable;
    private Integer currUsage;
    private Integer minUsage;
    private Integer maxUsage;
    private Integer infoUnitID;
    private String sysLogTag;
    private String eventLogType;
    private String genericFileName;
    private Integer systemID;

    public SystemeventDTO() {
    }

    public SystemeventDTO(Integer id, Integer customerID, Date receivedAt, Date deviceReportedTime, Integer facility, Integer priority, String fromHost, String message, Integer nTSeverity, Integer importance, String eventSource, String eventUser, Integer eventCategory, Integer eventID, String eventBinaryData, Integer maxAvailable, Integer currUsage, Integer minUsage, Integer maxUsage, Integer infoUnitID, String sysLogTag, String eventLogType, String genericFileName, Integer systemID) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getnTSeverity() {
        return nTSeverity;
    }

    public void setnTSeverity(Integer nTSeverity) {
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
    
    public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

    public String toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }

    public static SystemeventDTO fromJsonToSystemevent(String json) {
        return new JSONDeserializer<SystemeventDTO>().use(null, SystemeventDTO.class).deserialize(json);
    }

    public static String toJsonArray(Collection<SystemeventDTO> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

    public static String toJsonArray(Collection<SystemeventDTO> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }

    public static Collection<SystemeventDTO> fromJsonArrayToSystemevents(String json) {
        return new JSONDeserializer<List<SystemeventDTO>>().use(null, ArrayList.class).use("values", SystemeventDTO.class).deserialize(json);
    }

    @Override
    public String toString() {
        return "SystemeventDTO{" + "id=" + id + ", customerID=" + customerID + ", receivedAt=" + receivedAt + ", deviceReportedTime=" + deviceReportedTime + ", facility=" + facility + ", priority=" + priority + ", fromHost=" + fromHost + ", message=" + message + ", nTSeverity=" + nTSeverity + ", importance=" + importance + ", eventSource=" + eventSource + ", eventUser=" + eventUser + ", eventCategory=" + eventCategory + ", eventID=" + eventID + ", eventBinaryData=" + eventBinaryData + ", maxAvailable=" + maxAvailable + ", currUsage=" + currUsage + ", minUsage=" + minUsage + ", maxUsage=" + maxUsage + ", infoUnitID=" + infoUnitID + ", sysLogTag=" + sysLogTag + ", eventLogType=" + eventLogType + ", genericFileName=" + genericFileName + ", systemID=" + systemID + '}';
    }
    
}
