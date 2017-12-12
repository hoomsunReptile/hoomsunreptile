package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.GrabDomainMethodInfoDao;
import com.hoomsun.reptile.dao.GrabDomainProcedureInfoDao;
import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * GrabDomainProcedureService
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Service
public class GrabDomainProcedureService {

    @Resource
    private GrabDomainProcedureInfoDao procedureInfoDao;
    @Resource
    private GrabDomainMethodInfoDao methodInfoDao;

    public void postNewProcedure(GrabDomainProcedureInfo procedureInfo){
        procedureInfoDao.postNewProcedure(procedureInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProcedureById(String id){
        methodInfoDao.deleteMethodByProcedureId(id);
        procedureInfoDao.deleteProcedureById(id);
    }

    public GrabDomainProcedureInfo getProcedureInfoById(String id){
        return procedureInfoDao.getProcedureInfoById(id);
    }

    public void putProcedureById(GrabDomainProcedureInfo procedureInfo){
        procedureInfoDao.putProcedureById(procedureInfo);
    }

    public List<GrabDomainProcedureInfo> getProcedureById(String grabDomainBasicId){
        return procedureInfoDao.getProcedureById(grabDomainBasicId);
    }
}
