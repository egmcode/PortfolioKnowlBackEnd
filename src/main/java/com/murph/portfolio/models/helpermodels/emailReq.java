package com.murph.portfolio.models.helpermodels;

public class emailReq
{
    private String destEmail;
    private String destMsg;
    private String destSubject;

    public emailReq(String destEmail, String destMsg, String destSubject)
    {
        this.destEmail = destEmail;
        this.destMsg = destMsg;
        this.destSubject = destSubject;
    }

    public String getDestEmail()
    {
        return destEmail;
    }

    public String getDestMsg()
    {
        return destMsg;
    }

    public String getDestSubject() { return destSubject; }
}
