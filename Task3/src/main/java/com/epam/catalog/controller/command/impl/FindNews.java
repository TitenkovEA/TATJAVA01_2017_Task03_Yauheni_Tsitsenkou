package com.epam.catalog.controller.command.impl;

import com.epam.catalog.been.Category;
import com.epam.catalog.been.News;
import com.epam.catalog.controller.command.Command;
import com.epam.catalog.service.NewsService;
import com.epam.catalog.service.exception.ServiceException;
import com.epam.catalog.service.factory.ServiceFactory;

import java.util.Map;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public class FindNews implements Command {
    public String execute(Map<String, String> request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        News newNews = new News();
        String response = null;

        try {
            NewsService newsService = serviceFactory.getNewsService();

            newNews.setCategory(Category.valueOf(request.get(CATEGORY).toUpperCase()));
            newNews.setTitle(request.get(TITLE));
            newNews.setAuthor(request.get(AUTHOR));

            response = newsService.findNews(newNews);
        } catch (ServiceException | NullPointerException | IllegalArgumentException e) {
            response = "Error during searching!";
        }

        return response;
    }
}
