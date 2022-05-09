package com.murph.portfolio.models;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="language")
public class language
{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="languageName")
    private String languageName;

    @Column(name="levelOfExpertise")
    private String levelOfExpertise;

    @Column(name="yearsOfExperience")
    private int yearsOfExperience;

    @Column(name="webframeworkId")
    private int webframeworkId;

    public language() {}
    public language(String languageName, List<String> webFrameworks, String levelOfExpertise, int yearsOfExperience, int webframeworkId)
    {
        this.languageName = languageName;
        this.levelOfExpertise = levelOfExpertise;
        this.yearsOfExperience = yearsOfExperience;
        this.webframeworkId = webframeworkId;
    }

    public String getLanguageName() {
        return this.languageName;
    }
    public void setLanguageName(String languageName) { this.languageName = languageName; }

    public String getLevelOfExpertise() {
        return levelOfExpertise;
    }
    public void setLevelOfExpertise(String levelOfExpertise) { this.levelOfExpertise = levelOfExpertise; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public int getWebframeworkId() { return webframeworkId; }
    public void setWebframeworkId(int webframeworkId) { this.webframeworkId = webframeworkId; }
}
