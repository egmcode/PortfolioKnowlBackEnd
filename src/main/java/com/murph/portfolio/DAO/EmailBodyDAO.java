package com.murph.portfolio.DAO;

import com.murph.portfolio.DAO.interfaces.iEmailBodyDAO;
import com.murph.portfolio.models.emailbody;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmailBodyDAO implements iEmailBodyDAO
{
    private final EntityManager entityManager;

    @Autowired
    public EmailBodyDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public String getBodyById(int id)
    {
        Session currSession = entityManager.unwrap(Session.class);
        emailbody body = currSession.get(emailbody.class, id);
        return body.getBody();
    }
}
