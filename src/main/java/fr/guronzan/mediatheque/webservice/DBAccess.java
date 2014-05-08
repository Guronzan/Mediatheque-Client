/**
 * DBAccess.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.guronzan.mediatheque.webservice;

public interface DBAccess extends java.rmi.Remote {
    public fr.guronzan.mediatheque.webservice.DomainObject[] getAll(fr.guronzan.mediatheque.webservice.DataType arg0) throws java.rmi.RemoteException;
    public void updateUserFromUser(fr.guronzan.mediatheque.webservice.User arg0) throws java.rmi.RemoteException;
    public void updateUserFromData(java.lang.String arg0, java.lang.String arg1, fr.guronzan.mediatheque.webservice.DataType arg2) throws java.rmi.RemoteException;
    public fr.guronzan.mediatheque.webservice.User getUserFromNickName(java.lang.String arg0) throws java.rmi.RemoteException;
    public fr.guronzan.mediatheque.webservice.User getUserFromFullName(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean checkPasswordFromID(int arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean checkPasswordFromNickName(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean checkPasswordFromNIck(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public fr.guronzan.mediatheque.webservice.DomainObject[] getAllNotOwned(fr.guronzan.mediatheque.webservice.DataType arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public int addUser(fr.guronzan.mediatheque.webservice.User arg0) throws java.rmi.RemoteException;
    public int addBook(fr.guronzan.mediatheque.webservice.Book arg0) throws java.rmi.RemoteException;
    public int addMovie(fr.guronzan.mediatheque.webservice.Movie arg0) throws java.rmi.RemoteException;
    public int addCD(fr.guronzan.mediatheque.webservice.Cd arg0) throws java.rmi.RemoteException;
    public void deleteUser(fr.guronzan.mediatheque.webservice.User arg0) throws java.rmi.RemoteException;
    public fr.guronzan.mediatheque.webservice.User getUserFromID(int arg0) throws java.rmi.RemoteException;
    public fr.guronzan.mediatheque.webservice.User[] getAllUsers() throws java.rmi.RemoteException;
    public boolean containsUser(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean containsBook(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
    public boolean containsMovie(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
    public boolean containsCD(java.lang.String arg0) throws java.rmi.RemoteException;
    public void cleanDB() throws java.rmi.RemoteException;
}
