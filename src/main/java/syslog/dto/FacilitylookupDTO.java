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
public class FacilitylookupDTO {

    private Integer id;
    private Short facilityLookupCode;
    private String message;

    public FacilitylookupDTO() {
    }

    public FacilitylookupDTO(Integer id, Short facilityLookupCode, String message) {
        this.id = id;
        this.facilityLookupCode = facilityLookupCode;
        this.message = message;
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

    public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

    public String toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }

    public static FacilitylookupDTO fromJsonToFacilitylookup(String json) {
        return new JSONDeserializer<FacilitylookupDTO>().use(null, FacilitylookupDTO.class).deserialize(json);
    }

    public static String toJsonArray(Collection<FacilitylookupDTO> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

    public static String toJsonArray(Collection<FacilitylookupDTO> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }

    public static Collection<FacilitylookupDTO> fromJsonArrayToUserinfoes(String json) {
        return new JSONDeserializer<List<FacilitylookupDTO>>().use(null, ArrayList.class).use("values", FacilitylookupDTO.class).deserialize(json);
    }
}
