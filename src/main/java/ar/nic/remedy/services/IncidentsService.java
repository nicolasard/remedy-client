package ar.nic.remedy.services;

import ar.nic.remedy.dao.Incident;
import ar.nic.remedy.dao.UrgencyType;
import ar.nic.remedy.wsclient.ClientConfiguration;
import ar.nic.remedy.wsclient.clients.IncidentsClient;
import ar.nic.remedy.wsclient.wsdl.GetListOutputMap;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class IncidentsService {

    public List<Incident> getIncidents(ClientConfiguration clientConfiguration){
        List<Incident> incidentList = new ArrayList<>();
        IncidentsClient incidentsClient = new IncidentsClient(clientConfiguration);
        GetListOutputMap incidents = incidentsClient.getIncidents();
        for (GetListOutputMap.GetListValues incidentws: incidents.getGetListValues()) {
            Incident incident = new Incident();
            incident.setIncidentID(incidentws.getIncidentNumber());
            incident.setSummary(incidentws.getSummary());
            incident.setStatus(incidentws.getStatus().value());
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'").parse(incidentws.getReportedDate().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date today = new Date();
            incident.setDate(date);
            incident.setLifeDays((int) TimeUnit.DAYS.convert(Math.abs(today.getTime() - date.getTime()),TimeUnit.MILLISECONDS));
            incident.setUrgency(UrgencyType.getByRemedyString(incidentws.getUrgency()));
            incident.setAssignedTo(incidentws.getAssignee());
            incident.setNotes(incidentws.getNotes());
            incidentList.add(incident);
        }
        return incidentList;
    }
}
