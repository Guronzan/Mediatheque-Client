/**
 * MediathequeWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webservices.demo;

public interface MediathequeWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getMediathequeWebServicePortAddress();

    public com.webservices.demo.MediathequeWebService getMediathequeWebServicePort()
            throws javax.xml.rpc.ServiceException;

    public com.webservices.demo.MediathequeWebService getMediathequeWebServicePort(
            final java.net.URL portAddress)
            throws javax.xml.rpc.ServiceException;
}
