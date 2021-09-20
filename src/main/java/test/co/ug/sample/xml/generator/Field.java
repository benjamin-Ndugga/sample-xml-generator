/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.co.ug.sample.xml.generator;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benjie_en
 */
@XmlRootElement(name = "isomsg")
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {

    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "value")
    private String value;

    public Field() {
    }

    public Field(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Field{" + "id=" + id + ", value=" + value + '}';
    }

    
}
