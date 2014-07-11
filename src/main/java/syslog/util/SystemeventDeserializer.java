package syslog.util;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.iit.itm.syslog.util;
//
//import edu.iit.itm.syslog.bean.Systemevent;
//import java.io.IOException;
//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.JsonParser;
//import org.codehaus.jackson.JsonProcessingException;
//import org.codehaus.jackson.ObjectCodec;
//import org.codehaus.jackson.map.DeserializationContext;
//import org.codehaus.jackson.map.JsonDeserializer;
//
///**
// *
// * @author Lei
// */
//public class SystemeventDeserializer extends JsonDeserializer<Systemevent>{
//
//    @Override
//    public Systemevent deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
//        ObjectCodec oc = jp.getCodec();
//        JsonNode jn = oc.readTree(jp);
//        return new Systemevent(jn.get("id").getTextValue(), jn.get);
//    }
//    
//}
