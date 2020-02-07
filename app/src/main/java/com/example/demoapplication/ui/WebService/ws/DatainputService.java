
package com.example.demoapplication.ui.WebService.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import java.util.Collection;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.0_02-b08-fcs
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "datainputService", targetNamespace = "http://webservice.jd.com/", wsdlLocation = "http://70.106.253.97:8989/webservice?wsdl")
public class DatainputService
    extends Service
{

    private final static URL DATAINPUTSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://70.106.253.97:8989/webservice?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DATAINPUTSERVICE_WSDL_LOCATION = url;
    }

    public DatainputService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DatainputService() {
        super(DATAINPUTSERVICE_WSDL_LOCATION, new QName("http://webservice.jd.com/", "datainputService"));
    }

    /**
     * 
     * @return
     *     returns Datainput
     */
    @WebEndpoint(name = "datainputPort")
    public Datainput getDatainputPort() {
        return (Datainput)super.getPort(new QName("http://webservice.jd.com/", "datainputPort"), Datainput.class);
    }

}
