package com.murph.portfolio.DAO;

import com.murph.portfolio.DAO.interfaces.*;
import com.murph.portfolio.models.*;
import com.murph.portfolio.models.helpermodels.languageWF;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LanguageDAO implements iLanguageDAO
{
    private final EntityManager entityManager;

    @Autowired
    public LanguageDAO(EntityManager entityManager) { this.entityManager = entityManager; }

    @Override
    public List<languageWF> getAll()
    {
        Session currSession = entityManager.unwrap(Session.class);
        Query<language> query = currSession.createQuery("from language");
        List<language> results = query.getResultList();
        List<languageWF> returnVal = new ArrayList<>();

        for(language lang : results)
        {
            returnVal.add(new languageWF(
                    lang.getLanguageName(),
                    lang.getLevelOfExpertise(),
                    lang.getYearsOfExperience(),
                    getWF(lang.getWebframeworkId())
            ));
        }

        return returnVal;
    }

    @Override
    public languageWF findById(int Id)
    {
        Session currSession = entityManager.unwrap(Session.class);
        language lang = currSession.get(language.class, Id);
        return new languageWF(
                lang.getLanguageName(),
                lang.getLevelOfExpertise(),
                lang.getYearsOfExperience(),
                getWF(lang.getWebframeworkId())
                );
    }

    @Override
    public void save(language lang)
    {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(lang);
    }

    @Override
    public void deleteById(int Id)
    {
        Session currSession = entityManager.unwrap(Session.class);
        Query query = currSession.createQuery("delete from language where id=:Id");
        query.setParameter("Id", Id);
        query.executeUpdate();
    }

    //helper
    private List<String> getWF(int Id)
    {
        Session currSession = entityManager.unwrap(Session.class);
        webframeworks wf = currSession.get(webframeworks.class, Id);
        List<String> wfs = new ArrayList<>();
        wfs.add(wf.getFramework1());
        wfs.add(wf.getFramework2());
        wfs.add(wf.getFramework3());
        return wfs;
    }
}
