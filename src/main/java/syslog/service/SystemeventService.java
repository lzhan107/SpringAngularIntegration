package syslog.service;

import java.util.List;

import syslog.bean.Systemevents;
import syslog.dto.SystemeventDTO;

public interface SystemeventService {
	public List<SystemeventDTO> getAllSystemevents(List<String> queryObjs);
	
	public void addSystemevent(Systemevents systemevent);
	
	public void deleteSystemevent(Systemevents systemevent);
	
	public void deleteAllSystemevent();

}
