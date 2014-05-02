package com.webservices.demo;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Main {

    public static void main(final String[] args) throws ServiceException,
            RemoteException {
        final MediathequeWebServiceServiceLocator locator = new MediathequeWebServiceServiceLocator();
        // final Iterator<QName> ports = locator.getPorts();
        // while (ports.hasNext()) {
        // final QName next = ports.next();
        // System.out.println(next);
        //
        // locator.get
        // }
        final MediathequeWebService mediathequeWebServicePort = locator
                .getMediathequeWebServicePort();
        final String helloString = mediathequeWebServicePort
                .sayHello("guestName qui tue");

        System.out.println("result" + helloString);
    }
}
