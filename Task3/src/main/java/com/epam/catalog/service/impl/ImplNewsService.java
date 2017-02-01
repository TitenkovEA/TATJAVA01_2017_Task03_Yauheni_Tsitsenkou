package com.epam.catalog.service.impl;

import com.epam.catalog.been.News;
import com.epam.catalog.dao.NewsDAO;
import com.epam.catalog.dao.exception.DAOException;
import com.epam.catalog.dao.factory.DAOFactory;
import com.epam.catalog.service.NewsService;
import com.epam.catalog.service.exception.ServiceException;

import java.util.ArrayList;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public class ImplNewsService implements NewsService {

    public void addNews(News news) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        NewsDAO newsDAO = daoFactory.getNewsDAO();
        try {
            newsDAO.addNews(news);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public ArrayList<News> findNews(News news) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        NewsDAO newsDAO = daoFactory.getNewsDAO();
        ArrayList<News> foundedNews = null;
        try {
            foundedNews = newsDAO.findNews(news);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return foundedNews;
    }
}
