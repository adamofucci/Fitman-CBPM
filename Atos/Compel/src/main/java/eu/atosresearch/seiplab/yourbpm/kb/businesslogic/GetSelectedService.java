
package eu.atosresearch.seiplab.yourbpm.kb.businesslogic;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BPMN_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bpmnId"
})
@XmlRootElement(name = "getSelectedService")
public class GetSelectedService {

    @XmlElementRef(name = "BPMN_id", namespace = "http://businesslogic.webn1.atosresearch.eu", type = JAXBElement.class)
    protected JAXBElement<String> bpmnId;

    /**
     * Gets the value of the bpmnId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBPMNId() {
        return bpmnId;
    }

    /**
     * Sets the value of the bpmnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBPMNId(JAXBElement<String> value) {
        this.bpmnId = ((JAXBElement<String> ) value);
    }

}
