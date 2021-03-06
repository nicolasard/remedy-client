package ar.nic.remedy.controllers.rest;

import ar.nic.remedy.dao.Incident;
import ar.nic.remedy.dao.UrgencyType;
import ar.nic.remedy.services.IncidentsService;
import ar.nic.remedy.wsclient.ClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/incidents")
public class GetIncidents {

    @Autowired
    ClientConfiguration clientConfiguration; //TODO: This autowiring should be inside the wsclient package in the
                                             // IncidentClient. It will be clear to reduce dependency from Controller.

    @RequestMapping(method= RequestMethod.GET, path = "/test")
    public @ResponseBody List<Incident> ListTest() {
        List<Incident> incidentList = new ArrayList<>();
        incidentList.add(new Incident(){{setIncidentID("INC0000001");setUrgency(UrgencyType.HIGH);setSummary("This is a test INC number 1");setNotes("This are the notes");}});
        incidentList.add(new Incident(){{setIncidentID("INC0000002");setUrgency(UrgencyType.HIGH);setSummary("This is a test INC number 2");setNotes("This are the notes");}});
        incidentList.add(new Incident(){{setIncidentID("INC0000003");setUrgency(UrgencyType.LOW);setSummary("This is a test INC number 3");setNotes("This are the notes");}});
        incidentList.add(new Incident(){{setIncidentID("INC0000004");setUrgency(UrgencyType.MEDIUM);setSummary("This is a test INC number 4");setNotes("This are the notes");}});
        return incidentList;
    }
    @RequestMapping(method= RequestMethod.GET, path = "/")
    public @ResponseBody List<Incident> List() {
        final IncidentsService incidentsService = new IncidentsService();
        return incidentsService.getIncidents(clientConfiguration);
    }
}