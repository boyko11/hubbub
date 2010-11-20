package com.grailsinaction

import javax.jws.WebParam;

class TestService implements RemoteTestService{

    static expose=['axis2']

    String sayHello(String yourName) {
        return "Hello ${yourName}!"
    }

    def availableBooks() {
      return Book.list()
    }

    Book getBookById(int id) {
        return Book.get(id)
    }

    void addBook(String pName, String pAuthor) {
        new Book(name:pName, author:pAuthor).save();
    }
}