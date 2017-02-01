package com.epam.catalog.controller.command;

import com.epam.catalog.been.News;

public interface Command {
    String execute(News news);
}
