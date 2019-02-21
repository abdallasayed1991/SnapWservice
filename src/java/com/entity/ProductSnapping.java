/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author section
 */
@Entity
@Table(name = "Product_Snapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSnapping.findAll", query = "SELECT p FROM ProductSnapping p"),
    @NamedQuery(name = "ProductSnapping.findByUserid", query = "SELECT p FROM ProductSnapping p WHERE p.productSnappingPK.userid = :userid"),
    @NamedQuery(name = "ProductSnapping.findByProductid", query = "SELECT p FROM ProductSnapping p WHERE p.productSnappingPK.productid = :productid"),
    @NamedQuery(name = "ProductSnapping.findBySnapDate", query = "SELECT p FROM ProductSnapping p WHERE p.snapDate = :snapDate")})
public class ProductSnapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductSnappingPK productSnappingPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Snap_Date")
    @Temporal(TemporalType.DATE)
    private Date snapDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Snap_Image")
    private byte[] snapImage;
    @JoinColumn(name = "Product_id", referencedColumnName = "Product_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "User_id", referencedColumnName = "User_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public ProductSnapping() {
    }

    public ProductSnapping(ProductSnappingPK productSnappingPK) {
        this.productSnappingPK = productSnappingPK;
    }

    public ProductSnapping(ProductSnappingPK productSnappingPK, Date snapDate, byte[] snapImage) {
        this.productSnappingPK = productSnappingPK;
        this.snapDate = snapDate;
        this.snapImage = snapImage;
    }

    public ProductSnapping(int userid, int productid) {
        this.productSnappingPK = new ProductSnappingPK(userid, productid);
    }

    public ProductSnappingPK getProductSnappingPK() {
        return productSnappingPK;
    }

    public void setProductSnappingPK(ProductSnappingPK productSnappingPK) {
        this.productSnappingPK = productSnappingPK;
    }

    public Date getSnapDate() {
        return snapDate;
    }

    public void setSnapDate(Date snapDate) {
        this.snapDate = snapDate;
    }

    public byte[] getSnapImage() {
        return snapImage;
    }

    public void setSnapImage(byte[] snapImage) {
        this.snapImage = snapImage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productSnappingPK != null ? productSnappingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSnapping)) {
            return false;
        }
        ProductSnapping other = (ProductSnapping) object;
        if ((this.productSnappingPK == null && other.productSnappingPK != null) || (this.productSnappingPK != null && !this.productSnappingPK.equals(other.productSnappingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.ProductSnapping[ productSnappingPK=" + productSnappingPK + " ]";
    }
    
}
