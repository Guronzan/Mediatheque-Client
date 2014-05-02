package com.webservices.demo;

public class MediathequeWebServiceProxy implements
        com.webservices.demo.MediathequeWebService {
    private String _endpoint = null;
    private com.webservices.demo.MediathequeWebService mediathequeWebService = null;

    public MediathequeWebServiceProxy() {
        _initMediathequeWebServiceProxy();
    }

    public MediathequeWebServiceProxy(final String endpoint) {
        this._endpoint = endpoint;
        _initMediathequeWebServiceProxy();
    }

    private void _initMediathequeWebServiceProxy() {
        try {
            this.mediathequeWebService = new com.webservices.demo.MediathequeWebServiceServiceLocator()
                    .getMediathequeWebServicePort();
            if (this.mediathequeWebService != null) {
                if (this._endpoint != null) {
                    ((javax.xml.rpc.Stub) this.mediathequeWebService)
                            ._setProperty(
                                    "javax.xml.rpc.service.endpoint.address",
                                    this._endpoint);
                } else {
                    this._endpoint = (String) ((javax.xml.rpc.Stub) this.mediathequeWebService)
                            ._getProperty("javax.xml.rpc.service.endpoint.address");
                }
            }

        } catch (final javax.xml.rpc.ServiceException serviceException) {
        }
    }

    public String getEndpoint() {
        return this._endpoint;
    }

    public void setEndpoint(final String endpoint) {
        this._endpoint = endpoint;
        if (this.mediathequeWebService != null) {
            ((javax.xml.rpc.Stub) this.mediathequeWebService)._setProperty(
                    "javax.xml.rpc.service.endpoint.address", this._endpoint);
        }

    }

    public com.webservices.demo.MediathequeWebService getMediathequeWebService() {
        if (this.mediathequeWebService == null) {
            _initMediathequeWebServiceProxy();
        }
        return this.mediathequeWebService;
    }

    @Override
    public java.lang.String sayHello(final java.lang.String guestname)
            throws java.rmi.RemoteException {
        if (this.mediathequeWebService == null) {
            _initMediathequeWebServiceProxy();
        }
        return this.mediathequeWebService.sayHello(guestname);
    }

}