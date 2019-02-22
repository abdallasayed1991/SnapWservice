/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Smile With Me Blease
 */
@Entity
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByProductPrice", query = "SELECT p FROM Product p WHERE p.productPrice = :productPrice"),
    @NamedQuery(name = "Product.findByProductDetailes", query = "SELECT p FROM Product p WHERE p.productDetailes = :productDetailes"),
    @NamedQuery(name = "Product.findByProductModel", query = "SELECT p FROM Product p WHERE p.productModel = :productModel"),
    @NamedQuery(name = "Product.findByProductColor", query = "SELECT p FROM Product p WHERE p.productColor = :productColor"),
    @NamedQuery(name = "Product.findByProductState", query = "SELECT p FROM Product p WHERE p.productState = :productState"),
    @NamedQuery(name = "Product.findByProductgroup", query = "SELECT p FROM Product p WHERE p.productgroup = :productgroup")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_ID")
    private Integer productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Product_Name")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_Price")
    private double productPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Product_Detailes")
    private String productDetailes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_Model")
    private int productModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Product_Color")
    private String productColor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Product_Image")
    private byte[] productImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_State")
    private int productState;
    @Size(max = 50)
    @Column(name = "Product_group")
    private String productgroup;
    @JoinColumn(name = "Brand_id", referencedColumnName = "Brand_ID")
    @ManyToOne(optional = false)
    private Brand brandid;
    @JoinColumn(name = "Merchant_id", referencedColumnName = "Merchant_ID")
    @ManyToOne(optional = false)
    private Merchant merchantid;
    @JoinColumn(name = "Offer_id", referencedColumnName = "Offer_ID")
    @ManyToOne(optional = false)
    private Offer offerid;

    public Product() {
    }

    public Product(Integer productID) {
        this.productID = productID;
    }

    public Product(Integer productID, String productName, double productPrice, String productDetailes, int productModel, String productColor, byte[] productImage, int productState) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDetailes = productDetailes;
        this.productModel = productModel;
        this.productColor = productColor;
        this.productImage = productImage;
        this.productState = productState;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDetailes() {
        return productDetailes;
    }

    public void setProductDetailes(String productDetailes) {
        this.productDetailes = productDetailes;
    }

    public int getProductModel() {
        return productModel;
    }

    public void setProductModel(int productModel) {
        this.productModel = productModel;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public int getProductState() {
        return productState;
    }

    public void setProductState(int productState) {
        this.productState = productState;
    }

    public String getProductgroup() {
        return productgroup;
    }

    public void setProductgroup(String productgroup) {
        this.productgroup = productgroup;
    }

    public Brand getBrandid() {
        return brandid;
    }

    public void setBrandid(Brand brandid) {
        this.brandid = brandid;
    }

    public Merchant getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Merchant merchantid) {
        this.merchantid = merchantid;
    }

    public Offer getOfferid() {
        return offerid;
    }

    public void setOfferid(Offer offerid) {
        this.offerid = offerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Product[ productID=" + productID + " ]";
    }
    
}
