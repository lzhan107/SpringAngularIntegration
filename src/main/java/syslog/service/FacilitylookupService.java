package syslog.service;

import syslog.bean.Facilitylookup;
import syslog.dto.FacilitylookupDTO;
import java.util.List;

public interface FacilitylookupService {

    public List<FacilitylookupDTO> getAllFacilities();

    public void addFacility(Facilitylookup facilitylookup);

    public void deleteFacility(Facilitylookup facilitylookup);

    public void removeAllFacilityLookup();
}
