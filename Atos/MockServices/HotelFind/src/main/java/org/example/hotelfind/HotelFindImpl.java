
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.example.hotelfind;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2013-07-07T00:29:14.638+02:00
 * Generated source version: 2.4.2
 * 
 */

@javax.jws.WebService(
                      serviceName = "HotelFind",
                      portName = "HotelFindSOAP",
                      targetNamespace = "http://www.example.org/HotelFind/",
                      wsdlLocation = "HotelFind.wsdl",
                      endpointInterface = "org.example.hotelfind.HotelFind")
                      
public class HotelFindImpl implements HotelFind {

    private static final Logger LOG = Logger.getLogger(HotelFindImpl.class.getName());

    /* (non-Javadoc)
     * @see org.example.hotelfind.HotelFind#bookRoom(java.lang.String  client ,)java.lang.String  hotelId ,)java.lang.String  nights ,)java.lang.String  roomId )*
     */
    public java.lang.String bookRoom(java.lang.String client,java.lang.String hotelId,java.lang.String nights,java.lang.String roomId) { 
        LOG.info("Executing operation bookRoom");
        System.out.println(client);
        System.out.println(hotelId);
        System.out.println(nights);
        System.out.println(roomId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}