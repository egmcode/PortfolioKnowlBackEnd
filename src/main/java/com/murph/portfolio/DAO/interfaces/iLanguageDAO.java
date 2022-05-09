package com.murph.portfolio.DAO.interfaces;

import com.murph.portfolio.models.*;
import com.murph.portfolio.models.helpermodels.languageWF;
import java.util.List;

public interface iLanguageDAO
{
    public List<languageWF> getAll();
    public languageWF findById(int Id);
    public void save(language lang);
    public void deleteById(int Id);
}
