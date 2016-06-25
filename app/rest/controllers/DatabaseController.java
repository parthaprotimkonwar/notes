package rest.controllers;

import application.exceptions.BaseException;
import rest.base.BaseController;
import play.mvc.Result;
import startup.BootstrapCoreModules;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 4/21/2016.
 */
@Named
@Singleton
public class DatabaseController extends BaseController{

    @Inject
    BootstrapCoreModules bootstrapCoreModules;

    public Result insertDataIntoDatabase() {

        try {
            bootstrapCoreModules.initializeDatabase();
        } catch (BaseException e) {
            e.printStackTrace();
        }

        return ok();
    }
}
