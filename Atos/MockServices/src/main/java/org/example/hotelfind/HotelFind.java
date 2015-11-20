package org.example.hotelfind;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2012-05-09T12:00:15.291+01:00
 * Generated source version: 2.4.2
 * 
 */
@WebService(targetNamespace = "http://www.example.org/HotelFind/", name = "HotelFind")
@XmlSeeAlso({ObjectFactory.class})
public interface HotelFind {

    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "BookRoom", targetNamespace = "http://www.example.org/HotelFind/", className = "org.example.hotelfind.BookRoom")
    @WebMethod(operationName = "BookRoom", action = "http://www.example.org/HotelFind/BookRoom")
    @ResponseWrapper(localName = "BookRoomResponse", targetNamespace = "http://www.example.org/HotelFind/", className = "org.example.hotelfind.BookRoomResponse")
    public java.lang.String bookRoom(
        @WebParam(name = "client", targetNamespace = "")
        java.lang.String client,
        @WebParam(name = "hotelId", targetNamespace = "")
        java.lang.String hotelId,
        @WebParam(name = "nights", targetNamespace = "")
        java.lang.String nights,
        @WebParam(name = "roomId", targetNamespace = "")
        java.lang.String roomId
    );
}