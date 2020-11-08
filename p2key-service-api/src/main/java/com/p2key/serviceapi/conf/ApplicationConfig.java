package com.p2key.serviceapi.conf;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.p2key.service.api.services.OwnerApi;
import com.p2key.service.api.services.ServiceApi;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(OwnerApi.class);
        set.add(ServiceApi.class);
        return set;
    }
}