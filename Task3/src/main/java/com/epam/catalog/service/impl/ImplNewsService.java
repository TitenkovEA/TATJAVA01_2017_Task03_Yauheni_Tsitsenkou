package com.epam.catalog.service.impl;

import com.epam.catalog.been.News;
import com.epam.catalog.dao.NewsDAO;
import com.epam.catalog.dao.exception.DAOException;
import com.epam.catalog.dao.factory.DAOFactory;
import com.epam.catalog.service.NewsService;
import com.epam.catalog.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public class ImplNewsService implements NewsService {

    public void addNews(News news) throws ServiceException {
        if (news.getCategory() == null || news.getTitle() == null || news.getAuthor() == null ) {
            throw new ServiceException("Incorrect news.");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();

        try {
            NewsDAO newsDAO = daoFactory.getNewsDAO();
            newsDAO.addNews(news);
        } catch (DAOException | NullPointerException e) {
            throw new ServiceException(e);
        }
    }

    public String findNews(News news) throws ServiceException {
        List<News> foundedNews = null;
        StringBuilder result = new StringBuilder();
        DAOFactory daoFactory = DAOFactory.getInstance();

        try {
            NewsDAO newsDAO = daoFactory.getNewsDAO();
            foundedNews = newsDAO.findNews(news);
            for (News newsUnit : foundedNews) {
                result.append(newsUnit.toString()).append("\n");
            }
        } catch (DAOException | NullPointerException e) {
            throw new ServiceException(e);
        }

        return result.toString();
    }
}
