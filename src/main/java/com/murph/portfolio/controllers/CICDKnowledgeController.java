package com.murph.portfolio.controllers;
import com.murph.portfolio.DAO.interfaces.iEmailBodyDAO;
import com.murph.portfolio.models.DTOModels.ReqByEmail;
import com.murph.portfolio.services.*;
import com.murph.portfolio.services.interfaces.*;
import com.murph.portfolio.services.interfaces.iLangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/knowledge")
public class CICDKnowledgeController
{
    private iOthService iothService;
    private iDBService idbService;
    private iWFService iwfService;
    private iLangService ilangService;
    private iEmailBodyDAO iemailBodyDAO;
    private EmailService emailService;

    public CICDKnowledgeController(
            iOthService iothService,
            iDBService idbService,
            iWFService iwfService,
            iLangService ilangService,
            EmailService emailService,
            iEmailBodyDAO iemailBodyDAO)
    {
        this.iothService = iothService;
        this.idbService = idbService;
        this.iwfService = iwfService;
        this.ilangService = ilangService;
        this.emailService = emailService;
        this.iemailBodyDAO = iemailBodyDAO;
    }

    @CrossOrigin
    @GetMapping("/other")
    public ResponseEntity<List<String>> getOther()
    {
        try
        {
            return new ResponseEntity<>(iothService.getOther(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("ERROR " + e.getMessage());

            List<String> err = new ArrayList<>();
            err.add("Internal Server Error");
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(path="/wf")
    public ResponseEntity<List<String>> getWF()
    {
        try
        {
            return new ResponseEntity<>(iwfService.getWF(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("ERROR " + e.getMessage());
            List<String> err = new ArrayList<>();
            err.add("Internal Server Error");
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(path="/db")
    public ResponseEntity<List<String>> getDB()
    {
        try
        {
            return new ResponseEntity<>(idbService.getDB(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("ERROR " + e.getMessage());
            List<String> err = new ArrayList<>();
            err.add("Internal Server Error");
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(path="/language")
    public ResponseEntity<List<String>> getLang()
    {
        try
        {
            return new ResponseEntity<>(ilangService.getLang(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println("ERROR " + e.getMessage());
            List<String> err = new ArrayList<>();
            err.add("Internal Server Error");
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping(path="/Contact")
    public ResponseEntity<Map<String, String>> contactMe(@RequestBody ReqByEmail reqByEmail)
    {
        try
        {
            emailService.sendContactEmail(emailService.FormatContactReq(reqByEmail));
            Map<String, String> body = new HashMap<>();
            body.put("message", "You made contact");
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("ERROR " + e.getMessage());
            Map<String, String> err = new HashMap<>();
            err.put("Error", "Internal Server Error");
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping(path="/Resume")
    public ResponseEntity<Map<String, String>> sendResume(@RequestBody ReqByEmail reqByEmail)
    {
        try
        {
            emailService.sendResumeEmail(emailService.FormatResumeReq(reqByEmail));
            Map<String, String> body = new HashMap<>();
            body.put("message", "resume sent");
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("ERROR " + e.getMessage());
            Map<String, String> err = new HashMap<>();
            err.put("Error", "Internal Server Error");
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
