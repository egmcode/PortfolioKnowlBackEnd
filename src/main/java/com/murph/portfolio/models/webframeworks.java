package com.murph.portfolio.models;

import javax.persistence.*;

@Entity
@Table(name="webframeworks")
public class webframeworks
{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="framework1")
    private String framework1;

    @Column(name="framework2")
    private String framework2;

    @Column(name="framework3")
    private String framework3;

    public webframeworks() {}
    public webframeworks(String framework1, String framework2, String framework3)
    {
        this.framework1 = framework1;
        this.framework2 = framework2;
        this.framework3 = framework3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFramework1() {
        return framework1;
    }

    public void setFramework1(String framework1) {
        this.framework1 = framework1;
    }

    public String getFramework2() {
        return framework2;
    }

    public void setFramework2(String framework2) {
        this.framework2 = framework2;
    }

    public String getFramework3() {
        return framework3;
    }

    public void setFramework3(String framework3) {
        this.framework3 = framework3;
    }
}
