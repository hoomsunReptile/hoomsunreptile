package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.GrabDomainBasicInfoDao;
import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GrabDomainBasicService {
    @Resource
    private GrabDomainBasicInfoDao basicInfoDao;

    public void postNewBasic(GrabDomainBasicInfo basicInfo) {
        basicInfoDao.postNewBasic(basicInfo);
    }
}
