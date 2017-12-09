package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.GrabDomainMethodInfoDao;
import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import com.hoomsun.reptile.util.ProductionFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *GrabDomainMethodService
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Service
public class GrabDomainMethodService {
    @Autowired
    private GrabDomainMethodInfoDao methodInfoDao;

    public void postNewMethod(GrabDomainMethodInfo methodDao){
        boolean addmehod = ProductionFunction.Addmehod(methodDao);
        if(addmehod){
            methodInfoDao.postNewMethod(methodDao);
        }
    }

    public void deleteMethodById(String id){
        methodInfoDao.deleteMethodById(id);
    }

   public  void putMethodById(GrabDomainMethodInfo info){
        methodInfoDao.putMethodById(info);
    }

    public List<GrabDomainMethodInfo> getMethodById(int grabDomainProcedureId){
        return methodInfoDao.getMethodById(grabDomainProcedureId);
    }
}
