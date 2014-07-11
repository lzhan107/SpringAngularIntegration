package syslog.controller;

import syslog.bean.Prioritylookup;
import syslog.dto.PrioritylookupDTO;
import syslog.service.PrioritylookupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/prioritylookup")
public class PrioritylookupController {

    @Autowired
    PrioritylookupService prioritylookupService;
    
    @RequestMapping(value = "/prioritylookup.json", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> getPrioritylookupList(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<PrioritylookupDTO> prioritylookupDTOs = prioritylookupService.getAllPriorities();
        if (prioritylookupDTOs.isEmpty()){
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(PrioritylookupDTO.toJsonArray(prioritylookupDTOs), headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/addPrioritylookup/{prioritylookup}", headers = "Accept=application/json")
    @ResponseBody
    public  void addPrioritylookup(@PathVariable("prioritylookup") Prioritylookup prioritylookup){
        prioritylookupService.addPriority(prioritylookup);
    }
    
    @RequestMapping(value = "/deletePrioritylookup{prioritylookup}", headers = "Accept=application/json")
    @ResponseBody
    public  void deletePrioritylookup(@PathVariable("prioritylookup") Prioritylookup prioritylookup){
        prioritylookupService.deletePriority(prioritylookup);
    }
    
    @RequestMapping(value = "/removeAllPrioritylookup", headers = "Accept=application/json")
    @ResponseBody
    public  void removeAllPrioritylookp(){
        prioritylookupService.deleteAllPriorities();
    }
    
    @RequestMapping(value = "/template")
    public String getPrioritylookupPage(){
        System.out.println("Pririority look up page returned !!!");
        return "/prioritylookup/template";
    }
}
