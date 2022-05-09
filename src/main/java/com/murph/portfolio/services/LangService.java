package com.murph.portfolio.services;

import com.murph.portfolio.models.helpermodels.languageWF;
import com.murph.portfolio.services.interfaces.iLangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.murph.portfolio.DAO.interfaces.iLanguageDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class LangService implements iLangService
{
    private final iLanguageDAO ilanguageDAO;

    @Autowired
    public LangService(iLanguageDAO ilanguageDAO)
    {
        this.ilanguageDAO = ilanguageDAO;
    }

    @Override
    public List<String> getLang()
    {
        List<String> retArr = new ArrayList<String>();
        List<languageWF> temp = ilanguageDAO.getAll();
        temp.forEach((tmp) -> {retArr.add(tmp.getLanguageName());});

        return retArr;
    }
}
