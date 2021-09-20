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
@XmlRootElement(name = "authHeader")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthHeader {

    @XmlAttribute(name = "sourceid")
    private int sourceid;
    @XmlAttribute(name = "password")
    private int password;

    public int getSourceid() {
        return sourceid;
    }

    public void setSourceid(int sourceid) {
        this.sourceid = sourceid;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthHeader{" + "sourceid=" + sourceid + ", password=" + password + '}';
    }
    

}
