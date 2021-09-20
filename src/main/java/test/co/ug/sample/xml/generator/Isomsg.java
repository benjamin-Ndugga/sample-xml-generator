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
import java.util.List;

/**
 *
 * @author benjie_en
 */
@XmlRootElement(name = "isomsg")
@XmlAccessorType(XmlAccessType.FIELD)
public class Isomsg {

    private List<Field> field;

    @XmlAttribute(name = "direction")
    private String direction;

    public List<Field> getField() {
        return field;
    }

    public void setField(List<Field> field) {
        this.field = field;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Isomsg{" + "field=" + field + ", direction=" + direction + '}';
    }

}
