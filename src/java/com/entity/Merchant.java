/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author section
 */
@Entity
@Table(name = "Merchant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merchant.findAll", query = "SELECT m FROM Merchant m"),
    @NamedQuery(name = "Merchant.findByMerchantID", query = "SELECT m FROM Merchant m WHERE m.merchantID = :merchantID"),
    @NamedQuery(name = "Merchant.findByCompanyName", query = "SELECT m FROM Merchant m WHERE m.companyName = :companyName"),
    @NamedQuery(name = "Merchant.findByCompanyAddress", query = "SELECT m FROM Merchant m WHERE m.companyAddress = :companyAddress"),
    @NamedQuery(name = "Merchant.findByUserid", query = "SELECT m FROM Merchant m WHERE m.userid = :userid")})
public class Merchant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Merchant_ID")
    private Integer merchantID;
    @Size(max = 50)
    @Column(name = "Company_Name")
    private String companyName;
    @Size(max = 100)
    @Column(name = "Company_Address")
    private String companyAddress;
    @Column(name = "User_id")
    private Integer userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchantid")
    private Collection<Product> productCollection;

    public Merchant() {
    }

    public Merchant(Integer merchantID) {
        this.merchantID = merchantID;
    }

    public Integer getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(Integer merchantID) {
        this.merchantID = merchantID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchantID != null ? merchantID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Merchant)) {
            return false;
        }
        Merchant other = (Merchant) object;
        if ((this.merchantID == null && other.merchantID != null) || (this.merchantID != null && !this.merchantID.equals(other.merchantID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Merchant[ merchantID=" + merchantID + " ]";
    }
    
}
