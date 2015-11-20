//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.09.22 at 12:43:24 PM GMT+01:00 
//


package eu.atosresearch.seiplab.yourbpm.bpmn.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}sourceRef"/>
 *         &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}targetRef"/>
 *         &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}assignment"/>
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
    "sourceRef",
    "targetRef",
    "assignment"
})
@XmlRootElement(name = "dataInputAssociation")
public class DataInputAssociation {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String sourceRef;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String targetRef;
    @XmlElement(required = false)
    protected Assignment assignment;

    /**
     * Gets the value of the sourceRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceRef() {
        return sourceRef;
    }

    /**
     * Sets the value of the sourceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceRef(String value) {
        this.sourceRef = value;
    }

    /**
     * Gets the value of the targetRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetRef() {
        return targetRef;
    }

    /**
     * Sets the value of the targetRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetRef(String value) {
        this.targetRef = value;
    }

    /**
     * Gets the value of the assignment property.
     * 
     * @return
     *     possible object is
     *     {@link Assignment }
     *     
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * Sets the value of the assignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Assignment }
     *     
     */
    public void setAssignment(Assignment value) {
        this.assignment = value;
    }

}
