/**
 * DBAccessServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.guronzan.mediatheque.webservice;

public class DBAccessServiceLocator extends org.apache.axis.client.Service implements fr.guronzan.mediatheque.webservice.DBAccessService {

    public DBAccessServiceLocator() {
    }


    public DBAccessServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DBAccessServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DBAccessPort
    private java.lang.String DBAccessPort_address = "http://localhost:8080/Mediatheque-WebService/services/DBAccessService/";

    public java.lang.String getDBAccessPortAddress() {
        return DBAccessPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DBAccessPortWSDDServiceName = "DBAccessPort";

    public java.lang.String getDBAccessPortWSDDServiceName() {
        return DBAccessPortWSDDServiceName;
    }

    public void setDBAccessPortWSDDServiceName(java.lang.String name) {
        DBAccessPortWSDDServiceName = name;
    }

    public fr.guronzan.mediatheque.webservice.DBAccess getDBAccessPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DBAccessPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDBAccessPort(endpoint);
    }

    public fr.guronzan.mediatheque.webservice.DBAccess getDBAccessPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.guronzan.mediatheque.webservice.DBAccessPortBindingStub _stub = new fr.guronzan.mediatheque.webservice.DBAccessPortBindingStub(portAddress, this);
            _stub.setPortName(getDBAccessPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDBAccessPortEndpointAddress(java.lang.String address) {
        DBAccessPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.guronzan.mediatheque.webservice.DBAccess.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.guronzan.mediatheque.webservice.DBAccessPortBindingStub _stub = new fr.guronzan.mediatheque.webservice.DBAccessPortBindingStub(new java.net.URL(DBAccessPort_address), this);
                _stub.setPortName(getDBAccessPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DBAccessPort".equals(inputPortName)) {
            return getDBAccessPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "DBAccessService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.mediatheque.guronzan.fr/", "DBAccessPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DBAccessPort".equals(portName)) {
            setDBAccessPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
