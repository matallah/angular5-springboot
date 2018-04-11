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
@Table(name = "operator")
public class Operator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Operator_id")
    private Integer operatorid;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Country")
    private String country;

    public Operator() {
    }

    public Operator(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public Operator(Integer operatorid, String name, String country) {
        this.operatorid = operatorid;
        this.name = name;
        this.country = country;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operatorid != null ? operatorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operator)) {
            return false;
        }
        Operator other = (Operator) object;
        if ((this.operatorid == null && other.operatorid != null) || (this.operatorid != null && !this.operatorid.equals(other.operatorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entites.Operator[ operatorid=" + operatorid + " ]";
    }

}
