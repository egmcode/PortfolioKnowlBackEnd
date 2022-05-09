package com.murph.portfolio.services;

import com.murph.portfolio.DAO.interfaces.iOtherDAO;
import com.murph.portfolio.models.other;
import com.murph.portfolio.services.interfaces.iOthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OthService implements iOthService
{
    private final iOtherDAO iotherDAO;

    @Autowired
    public OthService(iOtherDAO iotherDAO)
    {
        this.iotherDAO = iotherDAO;
    }

    @Override
    public List<String> getOther()
    {
        List<String> retArr = new ArrayList<String>();
        List<other> temp = iotherDAO.getAll();
        temp.forEach((tmp) -> {retArr.add(tmp.getOthername());});

        return retArr;
    }
}
