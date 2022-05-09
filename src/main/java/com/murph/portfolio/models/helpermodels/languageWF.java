package com.murph.portfolio.models.helpermodels;

import java.util.List;

public class languageWF
{
    private String languageName;
    private String levelOfExpertise;
    private int yearsOfExperience;
    private List<String> webframeworks;

    public languageWF(String languageName, String levelOfExpertise, int yearsOfExperience, List<String> webframeworks)
    {
        this.languageName = languageName;
        this.levelOfExpertise = levelOfExpertise;
        this.yearsOfExperience = yearsOfExperience;
        this.webframeworks = webframeworks;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public List<String> getWebframeworks() {
        return webframeworks;
    }
}
