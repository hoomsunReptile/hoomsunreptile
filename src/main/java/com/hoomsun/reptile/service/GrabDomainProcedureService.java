package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.GrabDomainProcedureInfoDao;
import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;
import org.springframework.stereotype.Service;

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

    public void postNewProcedure(GrabDomainProcedureInfo procedureInfo){
        procedureInfoDao.postNewProcedure(procedureInfo);
    }

    public void deleteProcedureById(String id){
        procedureInfoDao.deleteProcedureById(id);
    }

    public void putProcedureById(GrabDomainProcedureInfo procedureInfo){
        procedureInfoDao.putProcedureById(procedureInfo);
    }

    public List<GrabDomainProcedureInfo> getProcedureById(int grabDomainBasicId){
        return procedureInfoDao.getProcedureById(grabDomainBasicId);
    }
}
