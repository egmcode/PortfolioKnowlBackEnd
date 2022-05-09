package com.murph.portfolio.services;

import com.murph.portfolio.DAO.interfaces.iDBKnowledgeDAO;
import com.murph.portfolio.models.dbknowledge;
import com.murph.portfolio.services.interfaces.iDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBService implements iDBService
{
    private final iDBKnowledgeDAO idbKnowledgeDAO;

    @Autowired
    public DBService(iDBKnowledgeDAO idbKnowledgeDAO)
    {
        this.idbKnowledgeDAO = idbKnowledgeDAO;
    }

    public List<String> getDB()
    {
        List<String> retArr = new ArrayList<String>();
        List<dbknowledge> temp = idbKnowledgeDAO.getAll();
        temp.forEach((tmp) -> {retArr.add(tmp.getDbname());});

        return retArr;
    }
}
