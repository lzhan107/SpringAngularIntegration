/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syslog.dto;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Lei
 */
public class PrioritylookupDTO {
    private Integer id;
    private Short priorityLookupCode;
    private String message;

    public PrioritylookupDTO() {
    }

    public PrioritylookupDTO(Integer id, Short priorityLookupCode, String message) {
        this.id = id;
        this.priorityLookupCode = priorityLookupCode;
        this.message = message;
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
    
    public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

    public String toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }

    public static PrioritylookupDTO fromJsonToPrioritylookup(String json) {
        return new JSONDeserializer<PrioritylookupDTO>().use(null, PrioritylookupDTO.class).deserialize(json);
    }

    public static String toJsonArray(Collection<PrioritylookupDTO> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

    public static String toJsonArray(Collection<PrioritylookupDTO> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }

    public static Collection<PrioritylookupDTO> fromJsonArrayToPrioritylookups(String json) {
        return new JSONDeserializer<List<PrioritylookupDTO>>().use(null, ArrayList.class).use("values", PrioritylookupDTO.class).deserialize(json);
    }
}
