package com.murph.portfolio.DAO;

import com.murph.portfolio.DAO.interfaces.iOtherDAO;
import com.murph.portfolio.models.other;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OtherDAO implements iOtherDAO
{
    private final EntityManager entityManager;

    @Autowired
    public OtherDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<other> getAll()
    {
        Session currSession = entityManager.unwrap(Session.class);
        Query<other> query = currSession.createQuery("from other");
        return query.getResultList();
    }
}
