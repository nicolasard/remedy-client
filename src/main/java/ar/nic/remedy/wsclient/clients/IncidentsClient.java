package ar.nic.remedy.wsclient.clients;

import ar.nic.remedy.wsclient.ClientConfiguration;
import ar.nic.remedy.wsclient.callbacks.IncidentsClientCallback;
import ar.nic.remedy.wsclient.interceptors.IncidentClientInterceptor;
import ar.nic.remedy.wsclient.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

@Component
public class IncidentsClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(IncidentsClient.class);

    public ClientConfiguration clientConfiguration;

    @Autowired
    public IncidentsClient(ClientConfiguration clientConfiguration){
        this.clientConfiguration = clientConfiguration;
    }

    public GetListOutputMap getIncidents() {
        LOGGER.info("GetIncidents");
        LOGGER.info("URL : "+clientConfiguration.getUrl());
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();

        GetListInputMap request = new GetListInputMap();
        request.setMaxLimit("100");
        request.setStartRecord("1");
        request.setQualification("'Assigned Group ID' = \"SGP000000007414\" and 'Status'!= \"Closed\" and 'Status' != \"Cancelled\"");

        final ObjectFactory a = new ObjectFactory();
        webServiceTemplate.setInterceptors(new IncidentClientInterceptor[]{new IncidentClientInterceptor()});
        webServiceTemplate.setMarshaller(jaxb2MarshallerCMRETPERMTY());
        webServiceTemplate.setUnmarshaller(jaxb2MarshallerCMRETPERMTY());
        webServiceTemplate.setDefaultUri(clientConfiguration.getUrl()+"/arsys/services/ARService?server=remedyitsm&webService=HPD_IncidentInterface_WS");
        JAXBElement<GetListOutputMap> value =  (JAXBElement) webServiceTemplate.marshalSendAndReceive(a.createHelpDeskQueryListService(request),new IncidentsClientCallback(clientConfiguration));
        return value.getValue();
    }

    @Bean
    Jaxb2Marshaller jaxb2MarshallerCMRETPERMTY() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("ar.nic.remedy.wsclient.wsdl");
        return jaxb2Marshaller;
    }
}