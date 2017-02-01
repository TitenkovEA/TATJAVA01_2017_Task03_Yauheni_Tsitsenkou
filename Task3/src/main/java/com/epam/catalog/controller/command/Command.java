package com.epam.catalog.controller.command;

import com.epam.catalog.been.News;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public interface Command {
    String execute(News news);
}
