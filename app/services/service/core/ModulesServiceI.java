package services.service.core;

import application.exceptions.BaseException;
import models.bean.core.ModulesBean;
import models.core.Modules;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface ModulesServiceI {

    /**
     * Add a module.
     * @param modulesBean
     * @return
     * @throws BaseException
     */
    Modules addModule(ModulesBean modulesBean) throws BaseException;

    /**
     * Add a module.
     * @param modules
     * @return
     * @throws BaseException
     */
    Modules addModule(Modules modules) throws BaseException;

    /**
     * De-activate a module
     * @param moduleId
     * @return
     * @throws BaseException
     */
    Modules deactivateModule(Long moduleId) throws BaseException;

    /**
     * Updates the STATUS, ModuleName, Indexing.
     * Need to specify which fields are to be updated.
     * @param modulesBean
     * @return
     * @throws BaseException
     */
    Modules updateModule(ModulesBean modulesBean) throws BaseException;

    /**
     * Find a Module
     * @param moduleId
     * @return
     * @throws BaseException
     */
    Modules findModule(Long moduleId) throws BaseException;

    /**
     * Find all Modules
     * @TODO : Find all modules for a Chapter
     * @return
     * @throws BaseException
     */
    List<Modules> findAllModules() throws BaseException;

    /**
     * Convert to ModulesBean.
     * @param modulesList
     * @return
     * @throws BaseException
     */
    List<ModulesBean> convertToModuleBean(List<Modules> modulesList) throws BaseException;
}