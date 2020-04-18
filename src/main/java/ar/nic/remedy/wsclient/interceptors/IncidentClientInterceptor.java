package ar.nic.remedy.wsclient.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class IncidentClientInterceptor  implements ClientInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(IncidentClientInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            messageContext.getRequest().writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info(out.toString());
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            messageContext.getRequest().writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info(out.toString());
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            messageContext.getRequest().writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.error(out.toString());
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {

    }
}
