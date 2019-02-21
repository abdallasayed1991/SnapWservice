/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author section
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.entity.service.BrandFacadeREST.class);
        resources.add(com.entity.service.CategoryFacadeREST.class);
        resources.add(com.entity.service.CommentFacadeREST.class);
        resources.add(com.entity.service.ComplainFacadeREST.class);
        resources.add(com.entity.service.MerchantFacadeREST.class);
        resources.add(com.entity.service.OfferFacadeREST.class);
        resources.add(com.entity.service.ProductFacadeREST.class);
        resources.add(com.entity.service.ProductSnappingFacadeREST.class);
        resources.add(com.entity.service.UserFacadeREST.class);
        resources.add(com.entity.service.UserInteractFacadeREST.class);
    }
    
}
