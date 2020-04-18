package ar.nic.remedy.wsclient.callbacks;

import ar.nic.remedy.wsclient.wsdl.AuthenticationInfo;
import ar.nic.remedy.wsclient.wsdl.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.bind.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import static javax.xml.bind.JAXBContext.newInstance;

public class IncidentsClientCallback implements WebServiceMessageCallback {

    @Autowired
    @Value("${remedy.user}")
    private String remedyUser;

    @Autowired
    @Value("${remedy.password}")
    private String remedyPasswords;

    @Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws TransformerException {

        SoapHeader soapHeader = ((SoapMessage)webServiceMessage).getSoapHeader();
        final ObjectFactory a = new ObjectFactory();
        AuthenticationInfo inf = new AuthenticationInfo();
        inf.setUserName(remedyUser);
        inf.setPassword(remedyPasswords);

        JAXBContext context = null;
        try {
            context = newInstance(AuthenticationInfo.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Marshaller marshaller = null;
        try {
            marshaller = context.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        ObjectFactory objectWsse = new ObjectFactory();

        JAXBElement<AuthenticationInfo> securityObject = a.createAuthenticationInfo(inf);

        try {
            marshaller.marshal(securityObject, soapHeader.getResult());
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
