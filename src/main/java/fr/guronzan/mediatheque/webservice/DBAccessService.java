/**
 * DBAccessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.guronzan.mediatheque.webservice;

public interface DBAccessService extends javax.xml.rpc.Service {
    public java.lang.String getDBAccessPortAddress();

    public fr.guronzan.mediatheque.webservice.DBAccess getDBAccessPort() throws javax.xml.rpc.ServiceException;

    public fr.guronzan.mediatheque.webservice.DBAccess getDBAccessPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
