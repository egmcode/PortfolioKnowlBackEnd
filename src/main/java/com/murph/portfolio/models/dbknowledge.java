package com.murph.portfolio.models;

import javax.persistence.*;

@Entity
@Table(name="dbknowledge")
public class dbknowledge
{
    @Id
    @Column(name="id")
    private int id;

    @Column(name="dbname")
    private String dbname;

    public dbknowledge() {}
    public dbknowledge(int id, String dbname)
    {
        this.id = id;
        this.dbname = dbname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
}
