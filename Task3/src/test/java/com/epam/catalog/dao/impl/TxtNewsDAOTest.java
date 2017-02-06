package com.epam.catalog.dao.impl;

import com.epam.catalog.been.Category;
import com.epam.catalog.been.News;
import com.epam.catalog.dao.exception.DAOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Evgeny on 06.02.2017.
 */
public class TxtNewsDAOTest {
    private TxtNewsDAO txtNewsDAO;

    @BeforeClass
    public void setUp() {
        txtNewsDAO = new TxtNewsDAO();
    }

    @DataProvider(name = "illegalNews")
    public Object[][] getIllegalNewsToFind() {
        return new Object[][] {
                {null},
                {new News()},
                {new News(null, "", "")},
                {new News(Category.BOOK, null, "")},
                {new News(Category.BOOK, "", null)},
                {new News(Category.BOOK, null, null)},
        };
    }

    @Test(expectedExceptions = DAOException.class, dataProvider = "illegalNews")
    public void negativeAddNews(News news) throws Exception {
        txtNewsDAO.addNews(news);
    }

    @Test(expectedExceptions = DAOException.class, dataProvider = "illegalNews")
    public void negativeFindNews(News news) throws Exception {
        txtNewsDAO.findNews(news);
    }

}