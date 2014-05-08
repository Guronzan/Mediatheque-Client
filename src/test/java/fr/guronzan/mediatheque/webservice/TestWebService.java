package fr.guronzan.mediatheque.webservice;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.xml.rpc.ServiceException;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Slf4j
public class TestWebService {

    @Test
    public void testAddUser() throws ServiceException, RemoteException {
        final DBAccessServiceLocator serviceLocator = new DBAccessServiceLocator();
        final DBAccess dbAccess = serviceLocator.getDBAccessPort();
        // final User user = dbAccess.getUserFromID(1);
        // log.info(user.toString());
        final User user = new User();
        user.setName("name");
        user.setForName("forName");
        user.setNickName("nick 1");
        user.setPassword("strongPassword");
        user.setRegistrationDate(Calendar.getInstance());
        final int userID = dbAccess.addUser(user);
        System.out.println(userID);
        log.info("breakPoint");
    }

    @Test
    public void testGetUser() throws ServiceException, RemoteException {
        final DBAccessServiceLocator serviceLocator = new DBAccessServiceLocator();
        final DBAccess dbAccess = serviceLocator.getDBAccessPort();
        final User user = dbAccess.getUserFromID(49);
        log.info(user.toString());
        assertThat(user, is(notNullValue()));
        assertThat(user.getUserId(), is(49));
    }

    @Test
    public void testGetAllUsers() throws ServiceException, RemoteException {
        final DBAccessServiceLocator serviceLocator = new DBAccessServiceLocator();
        final DBAccess dbAccess = serviceLocator.getDBAccessPort();
        final User[] user = dbAccess.getAllUsers();
        log.info(user.toString());
        assertThat(user, is(notNullValue()));
    }

    @Test
    public void testGetAllBooks() throws ServiceException, RemoteException {
        final DBAccessServiceLocator serviceLocator = new DBAccessServiceLocator();
        final DBAccess dbAccess = serviceLocator.getDBAccessPort();
        final DataType type = new DataType(DataType._BOOK);
        final DomainObject[] books = dbAccess.getAll(type);
        log.info("length : {}", books.length);
        log.info(books.toString());
        assertThat(books, is(notNullValue()));
    }
}
