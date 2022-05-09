package com.murph.portfolio.services;

import com.murph.portfolio.DAO.interfaces.iWebFrameworksDAO;
import com.murph.portfolio.models.webframeworks;
import com.murph.portfolio.services.interfaces.iWFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WFService implements iWFService
{
    private final iWebFrameworksDAO iwebFrameworksDAO;

    @Autowired
    public WFService(iWebFrameworksDAO iwebFrameworksDAO)
    {
        this.iwebFrameworksDAO = iwebFrameworksDAO;
    }

    @Override
    public List<String> getWF()
    {
        List<String> retArr = new ArrayList<>();
        List<webframeworks> temp = iwebFrameworksDAO.getAll();
        temp.forEach((tmp) -> {
            if(tmp.getFramework1() != null)
            {
                retArr.add(tmp.getFramework1());
            }

            if(tmp.getFramework2() != null)
            {
                retArr.add(tmp.getFramework2());
            }

            if(tmp.getFramework3() != null)
            {
                retArr.add(tmp.getFramework3());
            }
        });

        return retArr;
    }
}
