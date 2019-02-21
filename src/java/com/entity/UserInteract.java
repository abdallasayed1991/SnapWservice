/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author section
 */
@Entity
@Table(name = "User_Interact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInteract.findAll", query = "SELECT u FROM UserInteract u"),
    @NamedQuery(name = "UserInteract.findByUserid", query = "SELECT u FROM UserInteract u WHERE u.userInteractPK.userid = :userid"),
    @NamedQuery(name = "UserInteract.findByProductid", query = "SELECT u FROM UserInteract u WHERE u.userInteractPK.productid = :productid"),
    @NamedQuery(name = "UserInteract.findByEmotionType", query = "SELECT u FROM UserInteract u WHERE u.emotionType = :emotionType")})
public class UserInteract implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserInteractPK userInteractPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Emotion_Type")
    private int emotionType;
    @JoinColumn(name = "Product_id", referencedColumnName = "Product_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "User_id", referencedColumnName = "User_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserInteract() {
    }

    public UserInteract(UserInteractPK userInteractPK) {
        this.userInteractPK = userInteractPK;
    }

    public UserInteract(UserInteractPK userInteractPK, int emotionType) {
        this.userInteractPK = userInteractPK;
        this.emotionType = emotionType;
    }

    public UserInteract(int userid, int productid) {
        this.userInteractPK = new UserInteractPK(userid, productid);
    }

    public UserInteractPK getUserInteractPK() {
        return userInteractPK;
    }

    public void setUserInteractPK(UserInteractPK userInteractPK) {
        this.userInteractPK = userInteractPK;
    }

    public int getEmotionType() {
        return emotionType;
    }

    public void setEmotionType(int emotionType) {
        this.emotionType = emotionType;
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
        hash += (userInteractPK != null ? userInteractPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInteract)) {
            return false;
        }
        UserInteract other = (UserInteract) object;
        if ((this.userInteractPK == null && other.userInteractPK != null) || (this.userInteractPK != null && !this.userInteractPK.equals(other.userInteractPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.UserInteract[ userInteractPK=" + userInteractPK + " ]";
    }
    
}
