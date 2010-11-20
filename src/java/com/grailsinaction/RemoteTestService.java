package com.grailsinaction;
import javax.jws.WebParam;

public interface RemoteTestService {
	String sayHello(String yourName);
    void addBook(@WebParam(name="name")String pName,
            @WebParam(name="author")String pAuthor);
}
