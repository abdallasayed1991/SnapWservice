/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author section
 */
@Entity
@Table(name = "\"User\"")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "User.Login", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail AND u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserAddress", query = "SELECT u FROM User u WHERE u.userAddress = :userAddress"),
    @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByUserAge", query = "SELECT u FROM User u WHERE u.userAge = :userAge"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByUserState", query = "SELECT u FROM User u WHERE u.userState = :userState"),
    @NamedQuery(name = "User.findByUserlastLog", query = "SELECT u FROM User u WHERE u.userlastLog = :userlastLog"),
    @NamedQuery(name = "User.findByUserPhone", query = "SELECT u FROM User u WHERE u.userPhone = :userPhone")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_ID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "User_Name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "User_Address")
    private String userAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "User_Email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "User_Password")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_Age")
    private int userAge;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "User_Image")
    private byte[] userImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_Type")
    private int userType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_State")
    private int userState;
    @Column(name = "User_lastLog")
    @Temporal(TemporalType.DATE)
    private Date userlastLog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_Phone")
    private long userPhone;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Category> categoryCollection;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Brand> brandCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Complain> complainCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<UserInteract> userInteractCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<ProductSnapping> productSnappingCollection;

    public User() {
    }

    public User(Integer userID) {
        this.userID = userID;
    }

    public User(Integer userID, String userName, String userAddress, String userEmail, String userPassword, int userAge, byte[] userImage, int userType, int userState, long userPhone) {
        this.userID = userID;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAge = userAge;
        this.userImage = userImage;
        this.userType = userType;
        this.userState = userState;
        this.userPhone = userPhone;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public Date getUserlastLog() {
        return userlastLog;
    }

    public void setUserlastLog(Date userlastLog) {
        this.userlastLog = userlastLog;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    @XmlTransient
    public Collection<Brand> getBrandCollection() {
        return brandCollection;
    }

    public void setBrandCollection(Collection<Brand> brandCollection) {
        this.brandCollection = brandCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Complain> getComplainCollection() {
        return complainCollection;
    }

    public void setComplainCollection(Collection<Complain> complainCollection) {
        this.complainCollection = complainCollection;
    }

    @XmlTransient
    public Collection<UserInteract> getUserInteractCollection() {
        return userInteractCollection;
    }

    public void setUserInteractCollection(Collection<UserInteract> userInteractCollection) {
        this.userInteractCollection = userInteractCollection;
    }

    @XmlTransient
    public Collection<ProductSnapping> getProductSnappingCollection() {
        return productSnappingCollection;
    }

    public void setProductSnappingCollection(Collection<ProductSnapping> productSnappingCollection) {
        this.productSnappingCollection = productSnappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.User[ userID=" + userID + " ]";
    }
    
}
