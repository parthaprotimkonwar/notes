package services.service.core;

import application.exceptions.BaseException;
import models.bean.core.ModulesBean;
import models.core.Modules;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface ModulesServiceI {

    Modules addModule(ModulesBean modulesBean) throws BaseException;

    Modules deactivateModule(Long moduleId) throws BaseException;

    Modules updateModule(ModulesBean modulesBean) throws BaseException;

    Modules findModule(Long moduleId) throws BaseException;

    List<Modules> findAllModules() throws BaseException;

}