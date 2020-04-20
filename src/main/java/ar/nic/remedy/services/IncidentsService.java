package ar.nic.remedy.services;

import ar.nic.remedy.dao.Incident;
import ar.nic.remedy.wsclient.ClientConfiguration;
import ar.nic.remedy.wsclient.clients.IncidentsClient;
import ar.nic.remedy.wsclient.wsdl.GetListOutputMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            incident.setDate(incidentws.getReportedDate().toString());
            incident.setUrgency(incidentws.getUrgency());
            incidentList.add(incident);
        }
        return incidentList;
    }
}
