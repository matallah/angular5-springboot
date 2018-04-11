/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfwg.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author mohamed.attalah
 */
@Entity
@Table(name = "services")
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Services_id")
    private Integer servicesid;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Type")
    private Character type;
    @JoinColumn(name = "Operator_Service_ID", referencedColumnName = "Operator_id", insertable = true, updatable = true)
    @ManyToOne
    private Operator operator;

    public Services() {
    }

    public Services(Integer servicesid) {
        this.servicesid = servicesid;
    }

    public Services(Integer servicesid, String name, Character type) {
        this.servicesid = servicesid;
        this.name = name;
        this.type = type;
    }

    public Integer getServicesid() {
        return servicesid;
    }

    public void setServicesid(Integer servicesid) {
        this.servicesid = servicesid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicesid != null ? servicesid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.servicesid == null && other.servicesid != null) || (this.servicesid != null && !this.servicesid.equals(other.servicesid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entites.Services[ servicesid=" + servicesid + " ]";
    }

}
