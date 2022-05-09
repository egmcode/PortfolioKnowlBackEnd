package com.murph.portfolio.services;

import com.murph.portfolio.DAO.interfaces.iEmailBodyDAO;
import com.murph.portfolio.models.DTOModels.ReqByEmail;
import com.murph.portfolio.models.helpermodels.emailReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService
{
    private final JavaMailSender mailSender;
    private final iEmailBodyDAO iemailBodyDAO;

    @Autowired
    public EmailService(JavaMailSender mailSender, iEmailBodyDAO iemailBodyDAO)
    {
        this.mailSender = mailSender;
        this.iemailBodyDAO = iemailBodyDAO;
    }

    @Async
    public void sendContactEmail(emailReq req) throws MessagingException
    {
        SimpleEmail(req);
    }

    @Async
    public void sendResumeEmail(List<emailReq> reqList) throws MessagingException
    {
        for(emailReq req : reqList)
        {
            SimpleEmail(req);
        }
    }

    public List<emailReq> FormatResumeReq(ReqByEmail reqByEmail)
    {
        String body = iemailBodyDAO.getBodyById(1);
        java.util.List<emailReq> retList = new ArrayList<emailReq>();

        emailReq sendER = new emailReq(reqByEmail.getEmailAdd(), body, "EGMCode Resume and Cover Letter");
        emailReq notifyER = new emailReq("murphy.elizabeth351@gmail.com", reqByEmail.getEmailAdd() + " has requested your resume and cover letter", "!!!Resume and Cover Letter Request!!!");
        retList.add(sendER);
        retList.add(notifyER);

        return retList;
    }

    public emailReq FormatContactReq(ReqByEmail reqByEmail)
    {
        emailReq notifyContact = new emailReq("murphy.elizabeth351@gmail.com", "<html>" + reqByEmail.getEmailMsg() + "<br /><br /> From: <br />" + reqByEmail.getEmailAdd() + "</html>", "!!!Contact Me Page!!!");
        return notifyContact;
    }

    private void SimpleEmail(emailReq req) throws MessagingException
    {
        JLabel label = new JLabel();
        label.setFont(label.getFont().deriveFont(Font.PLAIN));
        label.setText(req.getDestMsg());

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("EGMCode DoNotReply <egmcode@email.egmcodes.com>");
        mimeMessageHelper.setTo(req.getDestEmail());
        mimeMessageHelper.setText(label.getText(), true);
        mimeMessageHelper.setSubject(req.getDestSubject());
        mailSender.send(mimeMessage);
    }
}
