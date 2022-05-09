package com.murph.portfolio.DAO;

import com.murph.portfolio.DAO.interfaces.iDBKnowledgeDAO;
import com.murph.portfolio.models.dbknowledge;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DBKnowledgeDAO implements iDBKnowledgeDAO
{
    private final EntityManager entityManager;

    @Autowired
    public DBKnowledgeDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<dbknowledge> getAll()
    {
        Session currSession = entityManager.unwrap(Session.class);
        Query<dbknowledge> query = currSession.createQuery("from dbknowledge");
        return query.getResultList();
    }
}
