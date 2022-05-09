package com.murph.portfolio;

import com.murph.portfolio.DAO.interfaces.*;
import com.murph.portfolio.services.*;
import com.murph.portfolio.models.*;
import com.murph.portfolio.models.helpermodels.languageWF;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PortfolioApplicationTests {

	@Mock
	iDBKnowledgeDAO idbDAO;

	@Mock
	iLanguageDAO ilangDAO;

	@Mock
	iOtherDAO iothDAO;

	@Mock
	iWebFrameworksDAO iwebDAO;

	@InjectMocks
	DBService db;

	@InjectMocks
	LangService lang;

	@InjectMocks
	OthService oth;

	@InjectMocks
	WFService wf;

	@Before
	public void init()
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getAllDBTest() {
		List<dbknowledge> testDBList = new ArrayList<dbknowledge>();
		dbknowledge db1 = new dbknowledge(1, "Database One");
		dbknowledge db2 = new dbknowledge(2, "Database Two");

		testDBList.add(db1);
		testDBList.add(db2);
		when(idbDAO.getAll()).thenReturn(testDBList);

		List<String> DBList = db.getDB();
		assertEquals(2, DBList.size());
	}

	@Test
	public void getAllLangTest() {
		List<languageWF> testLangList = new ArrayList<languageWF>();
		languageWF lang1 = new languageWF("Language One", "", 0, new ArrayList<>());
		languageWF lang2 = new languageWF("Language Two", "", 0, new ArrayList<>());

		testLangList.add(lang1);
		testLangList.add(lang2);
		when(ilangDAO.getAll()).thenReturn(testLangList);

		List<String> LangList = lang.getLang();
		assertEquals(2, LangList.size());
	}

	@Test
	public void getAllOthTest() {
		List<other> testOtherList = new ArrayList<other>();
		other other1 = new other(1, "", "Other One");
		other other2 = new other(2, "", "Other Two");

		testOtherList.add(other1);
		testOtherList.add(other2);
		when(iothDAO.getAll()).thenReturn(testOtherList);

		List<String> OtherList = oth.getOther();
		assertEquals(2, OtherList.size());
	}

	@Test
	public void getAllWFTest()
	{
		List<webframeworks> testWFList = new ArrayList<webframeworks>();
		webframeworks wf1 = new webframeworks("Webframework One", null, null);
		webframeworks wf2 = new webframeworks("Webframework Two", null, null);

		testWFList.add(wf1);
		testWFList.add(wf2);
		when(iwebDAO.getAll()).thenReturn(testWFList);

		List<String> WFList = wf.getWF();
		assertEquals(2, WFList.size());
	}
}
