/*
 * 2015 Next Generation Mobile Service JSC., (NMS).
 * All rights reserved.
 */
package com.nms.tm.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cuong
 */
@XmlRootElement(name = "TMConnection")
public class Connection implements Serializable {

    private static final long serialVersionUID = 5685546321813959049L;
    
    /**
     * <strong>Enum for protocals</strong><br />
     * <i>DDTP</i> :  Dynamic Data Transfer Protocal (FPT -FSS) <br />
     * <i>SNMP</i> : <a href = "http://vi.wikipedia.org/wiki/SNMP">Simple Netword Manager Protocal</a> <br />
     * <i>WebSocket</i> : WebSocket protocal.<br />
     * <i>REST</i> : Restfull webservice via HTTP, ...
     */
    public enum Protocal {
        DDTP, SMNP, WebSocket, REST
    }
    
    /**
     *  Status of connection
     */
    public enum Status {
        Open, Disconnect;
    }
    
    protected String name; // name of connectin
    protected String host; // hostname or ip address
    protected Protocal protocal; // protocal to connect 
    protected String username;
    protected String password;
    protected Status status;
    protected List<ThreadEntry> threads;

    public Connection() {
    }

    public Connection(String name, String host, Protocal protocal, String username, String password, Status status) {
        this.name = name;
        this.host = host;
        this.protocal = protocal;
        this.username = username;
        this.password = password;
        this.status = status;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Protocal getProtocal() {
        return protocal;
    }

    public void setProtocal(Protocal protocal) {
        this.protocal = protocal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ThreadEntry> getThreads() {
        return threads;
    }

    public void setThreads(List<ThreadEntry> threads) {
        this.threads = threads;
    }
    
}
