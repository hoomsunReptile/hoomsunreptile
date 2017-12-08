package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.GrabDomainProcedureInfoDao;
import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GrabDomainProcedureService {

    @Resource
    private GrabDomainProcedureInfoDao procedureInfoDao;

    public void postNewProcedure(GrabDomainProcedureInfo procedureInfo){
        procedureInfoDao.postNewProcedure(procedureInfo);
    }
}
