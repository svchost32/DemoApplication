
package com.example.demoapplication.ui.WebService.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jd.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QueryResponse_QNAME = new QName("http://webservice.jd.com/", "queryResponse");
    private final static QName _Query_QNAME = new QName("http://webservice.jd.com/", "query");
    private final static QName _Others_QNAME = new QName("http://webservice.jd.com/", "others");
    private final static QName _OthersResponse_QNAME = new QName("http://webservice.jd.com/", "othersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jd.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link OthersResponse }
     * 
     */
    public OthersResponse createOthersResponse() {
        return new OthersResponse();
    }

    /**
     * Create an instance of {@link Others }
     * 
     */
    public Others createOthers() {
        return new Others();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.jd.com/", name = "queryResponse")
    public JAXBElement<QueryResponse> createQueryResponse(QueryResponse value) {
        return new JAXBElement<QueryResponse>(_QueryResponse_QNAME, QueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Query }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.jd.com/", name = "query")
    public JAXBElement<Query> createQuery(Query value) {
        return new JAXBElement<Query>(_Query_QNAME, Query.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Others }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.jd.com/", name = "others")
    public JAXBElement<Others> createOthers(Others value) {
        return new JAXBElement<Others>(_Others_QNAME, Others.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OthersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.jd.com/", name = "othersResponse")
    public JAXBElement<OthersResponse> createOthersResponse(OthersResponse value) {
        return new JAXBElement<OthersResponse>(_OthersResponse_QNAME, OthersResponse.class, null, value);
    }

}
