package com.murph.portfolio.models;

import javax.persistence.*;

@Entity
@Table(name="other")
public class other
{
    @Id
    @Column(name="id")
    private int id;

    @Column(name="othertype")
    private String othertype;

    @Column(name="othername")
    private String othername;

    public other() {}
    public other(int id, String othertype, String othername)
    {
        this.id = id;
        this.othertype = othertype;
        this.othername = othername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getOthertype() {
        return othertype;
    }

    public void setOthertype(String othertype) {
        this.othertype = othertype;
    }
}
