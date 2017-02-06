package com.epam.catalog.dao.impl;

import com.epam.catalog.been.Category;
import com.epam.catalog.been.News;
import com.epam.catalog.dao.NewsDAO;
import com.epam.catalog.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public class TxtNewsDAO implements NewsDAO {
    private static final String FILE_PATH = "data.txt";
    private static final String ARGS_DELIMITER = "\\|";

    public void addNews(News news) throws DAOException {
        if (news == null || news.getCategory() == null ||
                news.getTitle() == null || news.getAuthor() == null ) {
            throw new DAOException();
        }

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(news.getCategory() + "|" + news.getTitle() + "|" + news.getAuthor() + "\n");
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    public List<News> findNews(News news) throws DAOException {
        if (news == null || news.getCategory() == null ||
                news.getTitle() == null || news.getAuthor() == null ) {
            throw new DAOException();
        }

        List<News> foundedNews = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Category category = null;
            String title = null;
            String author = null;
            String[] lineArgs = null;
            String line = reader.readLine();
            while (line != null) {
                lineArgs = line.split(ARGS_DELIMITER);
                category = Category.valueOf(lineArgs[0].toUpperCase());
                title = lineArgs[1];
                author = lineArgs[2];

                if (category.equals(news.getCategory()) && title.contains(news.getTitle()) &&
                        author.contains(news.getAuthor())) {
                    foundedNews.add(new News(category, title, author));
                }

                line = reader.readLine();
            }
        } catch (IOException | NullPointerException | IllegalArgumentException |
                ArrayIndexOutOfBoundsException e) {
            throw new DAOException(e);
        }

        return foundedNews;
    }
}
