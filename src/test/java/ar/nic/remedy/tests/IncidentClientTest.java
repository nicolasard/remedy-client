package ar.nic.remedy.tests;

import ar.nic.remedy.wsclient.service.IncidentsClient;
import org.junit.Test;

public class IncidentClientTest {
    @Test
    public void GetListOutputMapTest() {
        IncidentsClient incidentClient = new IncidentsClient();
        incidentClient.getIncidents();
    }
}