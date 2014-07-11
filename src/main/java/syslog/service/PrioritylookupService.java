package syslog.service;

import java.util.List;

import syslog.bean.Prioritylookup;
import syslog.dto.PrioritylookupDTO;

public interface PrioritylookupService {
	public List<PrioritylookupDTO> getAllPriorities();

	public void addPriority(Prioritylookup prioritylookup);
	
	public void deletePriority(Prioritylookup prioritylookup);
        
        public void deleteAllPriorities();
}
