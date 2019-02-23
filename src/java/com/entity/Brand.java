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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "Brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findByBrandID", query = "SELECT b FROM Brand b WHERE b.brandID = :brandID"),
    @NamedQuery(name = "Brand.findByBrandName", query = "SELECT b FROM Brand b WHERE b.brandName = :brandName"),
    @NamedQuery(name = "Brand.findByMerchantid", query = "SELECT b FROM Brand b WHERE b.merchantid = :merchantid")})
public class Brand implements Serializable {
    @Lob()
    @Column(name = "Brand_Logo")
    private byte[] brandLogo;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Brand_ID")
    private Integer brandID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Brand_Name")
    private String brandName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Merchant_id")
    private int merchantid;
    @JoinTable(name = "Brand_Interested", joinColumns = {
        @JoinColumn(name = "Brand_id", referencedColumnName = "Brand_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "User_id", referencedColumnName = "User_ID")})
    @ManyToMany
    private Collection<User> userCollection;
    @JoinTable(name = "Brand_Category", joinColumns = {
        @JoinColumn(name = "Brand_id", referencedColumnName = "Brand_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Category_id", referencedColumnName = "Category_ID")})
    @ManyToMany
    private Collection<Category> categoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandid")
    private Collection<Product> productCollection;

    public Brand() {
    }

    public Brand(Integer brandID) {
        this.brandID = brandID;
    }

    public Brand(Integer brandID, String brandName, byte[] brandLogo, int merchantid) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.brandLogo = brandLogo;
        this.merchantid = merchantid;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public byte[] getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(byte[] brandLogo) {
        this.brandLogo = brandLogo;
    }

    public int getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
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
        hash += (brandID != null ? brandID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.brandID == null && other.brandID != null) || (this.brandID != null && !this.brandID.equals(other.brandID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Brand[ brandID=" + brandID + " ]";
    }

   


    
    
}
