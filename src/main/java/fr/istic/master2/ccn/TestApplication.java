package fr.istic.master2.ccn;


import fr.istic.master2.ccn.controller.App;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(App.class);

        return clazzes;
    }

}