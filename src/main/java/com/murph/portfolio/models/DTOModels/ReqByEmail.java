package com.murph.portfolio.models.DTOModels;

public class ReqByEmail
{
    private String EmailAdd;
    private String EmailMsg;

    public ReqByEmail(String EmailAdd, String EmailMsg)
    {
        this.EmailAdd = EmailAdd;
        this.EmailMsg = EmailMsg;
    }

    public String getEmailAdd()
    {
        return EmailAdd;
    }

    public String getEmailMsg()
    {
        return EmailMsg;
    }
}
