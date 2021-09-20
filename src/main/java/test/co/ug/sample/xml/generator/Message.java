/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.co.ug.sample.xml.generator;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benjie_en
 */
@XmlRootElement(name = "message")
public class Message {

    private AuthHeader authHeader;
    private  Isomsg isomsg;


    public AuthHeader getAuthHeader() {
        return authHeader;
    }

    public void setAuthHeader(AuthHeader authHeader) {
        this.authHeader = authHeader;
    }

    public Isomsg getIsomsg() {
        return isomsg;
    }

    public void setIsomsg(Isomsg isomsg) {
        this.isomsg = isomsg;
}

    @Override
    public String toString() {
        return "Message{" + "authHeader=" + authHeader + ", isomsg=" + isomsg + '}';
    }
    
    

}
