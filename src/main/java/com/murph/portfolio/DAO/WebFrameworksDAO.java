package com.murph.portfolio.DAO;

import com.murph.portfolio.DAO.interfaces.iWebFrameworksDAO;
import com.murph.portfolio.models.webframeworks;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WebFrameworksDAO implements iWebFrameworksDAO
{
    private final EntityManager entityManager;

    @Autowired
    public WebFrameworksDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<webframeworks> getAll()
    {
        Session currSession = entityManager.unwrap(Session.class);
        Query<webframeworks> query = currSession.createQuery("from webframeworks ");
        return query.getResultList();
    }

}
