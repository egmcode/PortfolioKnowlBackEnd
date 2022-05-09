package com.murph.portfolio.models;

import javax.persistence.*;

@Entity
@Table(name="emailbody")
public class emailbody
{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="body")
    private String body;

    public emailbody() {}
    public emailbody(String body)
    {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}