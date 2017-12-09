package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.GrabDomainBasicInfoDao;
import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class GrabDomainBasicService {
    @Resource
    private GrabDomainBasicInfoDao basicInfoDao;

    public void postNewBasic(GrabDomainBasicInfo basicInfo) {
        basicInfoDao.postNewBasic(basicInfo);
    }

    public void deleteBasicById(String id) {
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
