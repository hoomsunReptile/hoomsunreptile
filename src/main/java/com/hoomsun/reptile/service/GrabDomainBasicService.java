package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.GrabDomainBasicInfoDao;
import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

/**
 * GrabDomainBasicService
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Service
public class GrabDomainBasicService {
    @Resource
    private GrabDomainBasicInfoDao basicInfoDao;

    @Resource
    private GrabDomainProcedureService procedureService;

    @Resource
    private GrabDomainMethodService methodService;


    public void postNewBasic(GrabDomainBasicInfo basicInfo) {
        basicInfoDao.postNewBasic(basicInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBasicById(String id) {
        List<GrabDomainProcedureInfo> procedureById = procedureService.getProcedureById(id);
        for (GrabDomainProcedureInfo procedureInfo: procedureById) {
            String proceid = String.valueOf(procedureInfo.getId());
            methodService.deleteMethodByProcedureId(proceid);
            procedureService.deleteProcedureById(proceid);
        }
        basicInfoDao.deleteBasicById(id);
    }

    public void putBasicById(GrabDomainBasicInfo basicInfo) {
        basicInfoDao.putBasicById(basicInfo);
    }

    public GrabDomainBasicInfo getBasicById(String id) {
        return basicInfoDao.getBasicById(id);
    }

    public List<GrabDomainBasicInfo> getAllBasic(){
        return basicInfoDao.getAllBasic();
    }
}
