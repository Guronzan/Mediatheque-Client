package fr.guronzan.mediatheque.webservice;

public class DBAccessProxy implements fr.guronzan.mediatheque.webservice.DBAccess {
  private String _endpoint = null;
  private fr.guronzan.mediatheque.webservice.DBAccess dBAccess = null;
  
  public DBAccessProxy() {
    _initDBAccessProxy();
  }
  
  public DBAccessProxy(String endpoint) {
    _endpoint = endpoint;
    _initDBAccessProxy();
  }
  
  private void _initDBAccessProxy() {
    try {
      dBAccess = (new fr.guronzan.mediatheque.webservice.DBAccessServiceLocator()).getDBAccessPort();
      if (dBAccess != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dBAccess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dBAccess)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dBAccess != null)
      ((javax.xml.rpc.Stub)dBAccess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.guronzan.mediatheque.webservice.DBAccess getDBAccess() {
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess;
  }
  
  public fr.guronzan.mediatheque.webservice.DomainObject[] getAll(fr.guronzan.mediatheque.webservice.DataType arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.getAll(arg0);
  }
  
  public void updateUserFromUser(fr.guronzan.mediatheque.webservice.User arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    dBAccess.updateUserFromUser(arg0);
  }
  
  public void updateUserFromData(java.lang.String arg0, java.lang.String arg1, fr.guronzan.mediatheque.webservice.DataType arg2) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    dBAccess.updateUserFromData(arg0, arg1, arg2);
  }
  
  public fr.guronzan.mediatheque.webservice.User getUserFromNickName(java.lang.String arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.getUserFromNickName(arg0);
  }
  
  public fr.guronzan.mediatheque.webservice.User getUserFromFullName(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.getUserFromFullName(arg0, arg1);
  }
  
  public boolean checkPasswordFromID(int arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.checkPasswordFromID(arg0, arg1);
  }
  
  public boolean checkPasswordFromNickName(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.checkPasswordFromNickName(arg0, arg1);
  }
  
  public boolean checkPasswordFromNIck(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.checkPasswordFromNIck(arg0, arg1, arg2);
  }
  
  public fr.guronzan.mediatheque.webservice.DomainObject[] getAllNotOwned(fr.guronzan.mediatheque.webservice.DataType arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.getAllNotOwned(arg0, arg1);
  }
  
  public int addUser(fr.guronzan.mediatheque.webservice.User arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.addUser(arg0);
  }
  
  public int addBook(fr.guronzan.mediatheque.webservice.Book arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.addBook(arg0);
  }
  
  public int addMovie(fr.guronzan.mediatheque.webservice.Movie arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.addMovie(arg0);
  }
  
  public int addCD(fr.guronzan.mediatheque.webservice.Cd arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.addCD(arg0);
  }
  
  public void deleteUser(fr.guronzan.mediatheque.webservice.User arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    dBAccess.deleteUser(arg0);
  }
  
  public fr.guronzan.mediatheque.webservice.User getUserFromID(int arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.getUserFromID(arg0);
  }
  
  public fr.guronzan.mediatheque.webservice.User[] getAllUsers() throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.getAllUsers();
  }
  
  public boolean containsUser(java.lang.String arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.containsUser(arg0);
  }
  
  public boolean containsBook(java.lang.String arg0, int arg1) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.containsBook(arg0, arg1);
  }
  
  public boolean containsMovie(java.lang.String arg0, int arg1) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.containsMovie(arg0, arg1);
  }
  
  public boolean containsCD(java.lang.String arg0) throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    return dBAccess.containsCD(arg0);
  }
  
  public void cleanDB() throws java.rmi.RemoteException{
    if (dBAccess == null)
      _initDBAccessProxy();
    dBAccess.cleanDB();
  }
  
  
}