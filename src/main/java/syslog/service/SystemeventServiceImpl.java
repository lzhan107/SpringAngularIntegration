package syslog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import syslog.bean.Systemevents;
import syslog.dto.SystemeventDTO;
import syslog.repository.SystemeventRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Service("systemeventService")
public class SystemeventServiceImpl implements SystemeventService {

    @Autowired
    SystemeventRepository systemeventRepository;
    @PersistenceUnit(unitName = "SYSLOG_PU")
    EntityManagerFactory entityManagerFactory;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<SystemeventDTO> getAllSystemevents(List<String> queryObjs) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        for (String field : queryObjs) {
            query.append("s.").append(field).append(",");
        }

        query.deleteCharAt(query.lastIndexOf(","));
        query.append(" FROM Systemevents s LIMIT 5");
        List<SystemeventDTO> systemeventDTOs = new ArrayList<SystemeventDTO>();
        List<Map<String, Object>> systemevents = this.jdbcTemplate.queryForList(query.toString());

        
        for (Map<String, Object> map : systemevents) {
            SystemeventDTO systemeventDTO = new SystemeventDTO();
            if (map.get("CustomerID") != null) {
                System.out.println("Customer ID");
                systemeventDTO.setCustomerID((Integer) map.get("CustomerID"));
            }
            if (map.get("ReceivedAt") != null){
                System.out.println("Recived at");
                systemeventDTO.setReceivedAt((Date) map.get("ReceivedAt"));
            }
            if (map.get("DeviceReportedTime") != null){
                System.out.println("Device");
                systemeventDTO.setDeviceReportedTime((Date) map.get("DeviceReportedTime"));
            }
            if (map.get("Facility") != null){
                System.out.println("Facility");
                systemeventDTO.setFacility((Integer) map.get("Facility"));
            }
            if (map.get("Priority") != null){
                System.out.println("Priority");
                systemeventDTO.setPriority((Integer) map.get("Priority"));
            }
            if (map.get("FromHost") != null){
                System.out.println("FromHost");
                systemeventDTO.setFromHost((String) map.get("FromHost"));
            }
            if (map.get("Message") != null){
                System.out.println("Message");
                systemeventDTO.setMessage((String) map.get("Message"));
            }
            if (map.get("NTSeverity") != null){
                systemeventDTO.setnTSeverity((Integer) map.get("NTSeverity"));
            }
            if (map.get("Importance") != null){
                systemeventDTO.setImportance((Integer) map.get("Importance"));
            }
            if (map.get("EventSource") != null){
                systemeventDTO.setEventSource((String) map.get("EventSource"));
            }
            if (map.get("EventUser") != null){
                systemeventDTO.setEventUser((String) map.get("EventUser"));
            }
            if (map.get("EventCategory") != null){
                systemeventDTO.setEventCategory((Integer) map.get("EventCategory"));
            }
            if (map.get("EventID") != null){
                systemeventDTO.setEventID((Integer) map.get("EventID"));
            }
            if (map.get("EventBinaryData") != null){
                systemeventDTO.setEventBinaryData((String) map.get("EventBinaryData"));
            }
            if (map.get("MaxAvailable") != null){
                systemeventDTO.setMaxAvailable((Integer) map.get("MaxAvailable"));
            }
            if (map.get("CurrUsage") != null){
                systemeventDTO.setCurrUsage((Integer) map.get("CurrUsage"));
            }
            if (map.get("MinUsage") != null){
                systemeventDTO.setMinUsage((Integer) map.get("MinUsage"));
            }
            if (map.get("MaxUsage") != null){
                systemeventDTO.setMaxUsage((Integer) map.get("MaxUsage"));
            }
            if (map.get("InfoUnitID") != null){
                systemeventDTO.setInfoUnitID((Integer) map.get("InfoUnitID"));
            }
            if (map.get("SysLogTag") != null){
                systemeventDTO.setSysLogTag((String) map.get("SysLogTag"));
            }
            if (map.get("EventLogType") != null){
                systemeventDTO.setEventLogType((String) map.get("EventLogType"));
            }
            if (map.get("GenericFileName") != null){
                systemeventDTO.setGenericFileName((String) map.get("GenericFileName"));
            }
            if (map.get("SystemID") != null){
                systemeventDTO.setSystemID((Integer) map.get("SystemID"));
            }
            systemeventDTOs.add(systemeventDTO);
        }
        return systemeventDTOs;
    }

    public void deleteAllSystemevent() {
        systemeventRepository.deleteAll();
    }

    public void addSystemevent(Systemevents systemevent) {
        systemeventRepository.save(systemevent);
    }

    public void deleteSystemevent(Systemevents systemevent) {
        systemeventRepository.delete(systemevent);
    }
}
