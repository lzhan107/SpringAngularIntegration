package syslog.service;

import syslog.bean.Facilitylookup;
import syslog.dto.FacilitylookupDTO;
import syslog.repository.FacilitylookupRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("facilitylookupService")
public class FacilitylookupServiceImpl implements FacilitylookupService {

    @Autowired
    FacilitylookupRepository facilitylookupRepository;
    
    public List<FacilitylookupDTO> getAllFacilities() {
        List<Facilitylookup> facilitylookups = facilitylookupRepository.findAll();
        List<FacilitylookupDTO> facilitylookupDTOs = new ArrayList<FacilitylookupDTO>();
        
        for (Facilitylookup facilitylookup: facilitylookups){
            FacilitylookupDTO facilitylookupDTO = new FacilitylookupDTO();
            
            facilitylookupDTO.setId(facilitylookup.getId());
            facilitylookupDTO.setMessage(facilitylookup.getMessage());
            facilitylookupDTO.setFacilityLookupCode(facilitylookup.getFacilityLookupCode());
            
            facilitylookupDTOs.add(facilitylookupDTO);
        }
        return facilitylookupDTOs;
    }

    public void addFacility(Facilitylookup facilitylookup) {
        facilitylookupRepository.save(facilitylookup);
    }

    public void deleteFacility(Facilitylookup facilitylookup) {
        facilitylookupRepository.delete(facilitylookup);
    }

    public void removeAllFacilityLookup() {
        facilitylookupRepository.deleteAll();
    }
}
