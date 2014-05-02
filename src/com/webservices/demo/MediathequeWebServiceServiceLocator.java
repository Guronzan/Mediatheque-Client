/**
 * MediathequeWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webservices.demo;

public class MediathequeWebServiceServiceLocator extends
        org.apache.axis.client.Service implements
        com.webservices.demo.MediathequeWebServiceService {

    public MediathequeWebServiceServiceLocator() {
    }

    public MediathequeWebServiceServiceLocator(
            final org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MediathequeWebServiceServiceLocator(final java.lang.String wsdlLoc,
            final javax.xml.namespace.QName sName)
            throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MediathequeWebServicePort
    private java.lang.String MediathequeWebServicePort_address = "http://localhost:8080/Mediatheque-WebService/services/MediathequeWebServiceService/";

    @Override
    public java.lang.String getMediathequeWebServicePortAddress() {
        return this.MediathequeWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MediathequeWebServicePortWSDDServiceName = "MediathequeWebServicePort";

    public java.lang.String getMediathequeWebServicePortWSDDServiceName() {
        return this.MediathequeWebServicePortWSDDServiceName;
    }

    public void setMediathequeWebServicePortWSDDServiceName(
            final java.lang.String name) {
        this.MediathequeWebServicePortWSDDServiceName = name;
    }

    @Override
    public com.webservices.demo.MediathequeWebService getMediathequeWebServicePort()
            throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(this.MediathequeWebServicePort_address);
        } catch (final java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMediathequeWebServicePort(endpoint);
    }

    @Override
    public com.webservices.demo.MediathequeWebService getMediathequeWebServicePort(
            final java.net.URL portAddress)
            throws javax.xml.rpc.ServiceException {
        try {
            final com.webservices.demo.MediathequeWebServicePortBindingStub _stub = new com.webservices.demo.MediathequeWebServicePortBindingStub(
                    portAddress, this);
            _stub.setPortName(getMediathequeWebServicePortWSDDServiceName());
            return _stub;
        } catch (final org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMediathequeWebServicePortEndpointAddress(
            final java.lang.String address) {
        this.MediathequeWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation. If this service has
     * no port for the given interface, then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(final Class serviceEndpointInterface)
            throws javax.xml.rpc.ServiceException {
        try {
            if (com.webservices.demo.MediathequeWebService.class
                    .isAssignableFrom(serviceEndpointInterface)) {
                final com.webservices.demo.MediathequeWebServicePortBindingStub _stub = new com.webservices.demo.MediathequeWebServicePortBindingStub(
                        new java.net.URL(this.MediathequeWebServicePort_address),
                        this);
                _stub.setPortName(getMediathequeWebServicePortWSDDServiceName());
                return _stub;
            }
        } catch (final java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException(
                "There is no stub implementation for the interface:  "
                        + (serviceEndpointInterface == null ? "null"
                                : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation. If this service has
     * no port for the given interface, then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(final javax.xml.namespace.QName portName,
            final Class serviceEndpointInterface)
            throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        final java.lang.String inputPortName = portName.getLocalPart();
        if ("MediathequeWebServicePort".equals(inputPortName)) {
            return getMediathequeWebServicePort();
        } else {
            final java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://demo.webservices.com/",
                "MediathequeWebServiceService");
    }

    private java.util.HashSet ports = null;

    @Override
    public java.util.Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new java.util.HashSet();
            this.ports
                    .add(new javax.xml.namespace.QName(
                            "http://demo.webservices.com/",
                            "MediathequeWebServicePort"));
        }
        return this.ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(final java.lang.String portName,
            final java.lang.String address)
            throws javax.xml.rpc.ServiceException {

        if ("MediathequeWebServicePort".equals(portName)) {
            setMediathequeWebServicePortEndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(
                    " Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(final javax.xml.namespace.QName portName,
            final java.lang.String address)
            throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
