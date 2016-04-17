package services.service.impl.core;

import application.enums.STATUS;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import application.utilities.Util;
import models.bean.core.ModulesBean;
import models.core.Chapters;
import models.core.Modules;
import org.springframework.transaction.annotation.Transactional;
import repository.core.ChaptersRepository;
import repository.core.ModulesRepository;
import services.service.core.ModulesServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */

@Named
@Singleton
@Transactional
public class ModulesServiceImpl implements ModulesServiceI {

    @Inject
    ModulesRepository modulesRepository;

    @Inject
    ChaptersRepository chaptersRepository;

    @Override
    public Modules addModule(ModulesBean modulesBean) throws BaseException {
        try {
            Chapters chapter = chaptersRepository.findOne(modulesBean.getChapterId());
            Modules modules = new Modules(chapter, modulesBean.getModuleName(), modulesBean.getIndexing(), modulesBean.getStatus());
            return modulesRepository.save(modules);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Modules deactivateModule(Long moduleId) throws BaseException {
        try {
            Modules module = modulesRepository.findOne(moduleId);
            module.setStatus(STATUS.INACTIVE);
            return modulesRepository.save(module);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Modules updateModule(ModulesBean modulesBean) throws BaseException {
        try {
            Modules module = modulesRepository.findOne(modulesBean.getModuleId());

            if (Util.notNull(modulesBean.getModuleName())) {
                module.setModuleName(modulesBean.getModuleName());
            }
            if (modulesBean.getIndexing() != null) {
                module.setIndexing(modulesBean.getIndexing());
            }
            if (modulesBean.getStatus() != null) {
                module.setStatus(modulesBean.getStatus());
            }
            return modulesRepository.save(module);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Modules findModule(Long moduleId) throws BaseException {
        try {
            return modulesRepository.findOne(moduleId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<Modules> findAllModules() throws BaseException {
        try {
            return modulesRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}
