package syslog.controller;

import syslog.bean.Facilitylookup;
import syslog.dto.FacilitylookupDTO;
import syslog.service.FacilitylookupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/facilitylookup")
public class FacilitylookupController {

    @Autowired
    FacilitylookupService facilitylookupService;

    @RequestMapping(value = "/facilitylookup.json", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> getFacilitylookupList() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<FacilitylookupDTO> facilitylookupDTOs = facilitylookupService.getAllFacilities();
        if (facilitylookupDTOs.isEmpty()){
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(FacilitylookupDTO.toJsonArray(facilitylookupDTOs), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/addFacilitylookup/{facilitylookup}", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public void addFacilitylookup(@PathVariable("facilitylookup") Facilitylookup facilitylookup) {
        facilitylookupService.addFacility(facilitylookup);
    }

    @RequestMapping(value = "/deleteFacilitylookup/{facilitylookup}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @ResponseBody
    public void deleteFacilitylookup(@PathVariable("facilitylookup") Facilitylookup facilitylookup) {
        facilitylookupService.deleteFacility(facilitylookup);
    }

    @RequestMapping(value = "/removeAllFacilitylookup", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @ResponseBody
    public void removeAllFacilitylookup() {
        facilitylookupService.removeAllFacilityLookup();
    }

    @RequestMapping(value = "/template")
    public String getFacilitylookupPage() {
        return "facilitylookup/template";
    }
}
