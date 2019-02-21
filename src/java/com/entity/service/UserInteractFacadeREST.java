/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.service;

import com.entity.UserInteract;
import com.entity.UserInteractPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author section
 */
@Stateless
@Path("com.entity.userinteract")
public class UserInteractFacadeREST extends AbstractFacade<UserInteract> {
    @PersistenceContext(unitName = "SnapWservicePU")
    private EntityManager em;

    private UserInteractPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;userid=useridValue;productid=productidValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.entity.UserInteractPK key = new com.entity.UserInteractPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> userid = map.get("userid");
        if (userid != null && !userid.isEmpty()) {
            key.setUserid(new java.lang.Integer(userid.get(0)));
        }
        java.util.List<String> productid = map.get("productid");
        if (productid != null && !productid.isEmpty()) {
            key.setProductid(new java.lang.Integer(productid.get(0)));
        }
        return key;
    }

    public UserInteractFacadeREST() {
        super(UserInteract.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(UserInteract entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, UserInteract entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.entity.UserInteractPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public UserInteract find(@PathParam("id") PathSegment id) {
        com.entity.UserInteractPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UserInteract> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UserInteract> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
