/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author section
 */
@Entity
@Table(name = "Category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryID", query = "SELECT c FROM Category c WHERE c.categoryID = :categoryID"),
    @NamedQuery(name = "Category.findByCategoryType", query = "SELECT c FROM Category c WHERE c.categoryType = :categoryType")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Category_ID")
    private Integer categoryID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Category_Type")
    private int categoryType;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Category_Logo")
    private byte[] categoryLogo;
    @JoinTable(name = "Category_Interested", joinColumns = {
        @JoinColumn(name = "Category_id", referencedColumnName = "Category_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "User_id", referencedColumnName = "User_ID")})
    @ManyToMany
    private Collection<User> userCollection;
    @ManyToMany(mappedBy = "categoryCollection")
    private Collection<Brand> brandCollection;

    public Category() {
    }

    public Category(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Category(Integer categoryID, int categoryType, byte[] categoryLogo) {
        this.categoryID = categoryID;
        this.categoryType = categoryType;
        this.categoryLogo = categoryLogo;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public byte[] getCategoryLogo() {
        return categoryLogo;
    }

    public void setCategoryLogo(byte[] categoryLogo) {
        this.categoryLogo = categoryLogo;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Brand> getBrandCollection() {
        return brandCollection;
    }

    public void setBrandCollection(Collection<Brand> brandCollection) {
        this.brandCollection = brandCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Category[ categoryID=" + categoryID + " ]";
    }
    
}
