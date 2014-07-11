package syslog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import syslog.bean.Systemevents;
import syslog.dto.SystemeventDTO;
import syslog.service.SystemeventService;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/systemevent")
public class SystemeventController {

    @Autowired
    SystemeventService systemeventService;
    private List<String> queryStringList;
    
    @RequestMapping("/systemevents.json")
    public @ResponseBody
    ResponseEntity<String> getSystemeventsList() {
        //return systemeventService.getAllSystemevents();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<SystemeventDTO> systemeventDTOs = systemeventService.getAllSystemevents(this.queryStringList);
        if (this.queryStringList.isEmpty()){
            return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(SystemeventDTO.toJsonArray(systemeventDTOs), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/appendQueryString/{queryString}", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody void appendQeuryString(@PathVariable("queryString") String query){
        System.out.println("Query string passed: " + query);
        queryStringList = new ArrayList<String>();
        if (query.contains(",")){
            String [] fields = query.split(",");
            queryStringList.addAll(Arrays.asList(fields));
        }else{
            queryStringList.add(query);
        }
        System.out.println("Query stinrg now is: " + queryStringList);
    }
    
    @RequestMapping(value = "/addSystemevent/{systemevent}", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    void addSystemevent(@PathVariable("systemevent") Systemevents systemevent) {
        systemeventService.addSystemevent(systemevent);
    }

    @RequestMapping(value = "/removeSystemevent/{systemevent}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody
    void removeSystemevent(@PathVariable("systemevent") Systemevents systemevent) {
        systemeventService.deleteSystemevent(systemevent);
    }

    @RequestMapping(value = "/removeAllSystemevents", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody
    void removeAllSystemevents() {
        systemeventService.deleteAllSystemevent();
    }

    @RequestMapping("/template")
    public String getSystemEventPage() {
        return "systemevent/template";
    }
}
