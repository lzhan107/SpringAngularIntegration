package syslog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import syslog.bean.Prioritylookup;
import syslog.dto.PrioritylookupDTO;
import syslog.repository.PrioritylookupRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service("prioritylookupService")
public class PrioritylookupServiceImpl implements PrioritylookupService {

    @Autowired
    PrioritylookupRepository prioritylookupRepository;
    
    public List<PrioritylookupDTO> getAllPriorities() {
        List<Prioritylookup> prioritylookups = prioritylookupRepository.findAll();
        List<PrioritylookupDTO> prioritylookupDTOs = new ArrayList<PrioritylookupDTO>();
        
        for (Prioritylookup prioritylookup: prioritylookups){
            PrioritylookupDTO prioritylookupDTO = new PrioritylookupDTO();
            
            prioritylookupDTO.setId(prioritylookup.getId());
            prioritylookupDTO.setMessage(prioritylookup.getMessage());
            prioritylookupDTO.setPriorityLookupCode(prioritylookup.getPriorityLookupCode());
            
            prioritylookupDTOs.add(prioritylookupDTO);
        }
        return prioritylookupDTOs;
    }

    public void addPriority(Prioritylookup prioritylookup) {
        prioritylookupRepository.save(prioritylookup);
    }

    public void deletePriority(Prioritylookup prioritylookup) {
        prioritylookupRepository.delete(prioritylookup);
    }

    public void deleteAllPriorities() {
        prioritylookupRepository.deleteAll();
    }
}
