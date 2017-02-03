package com.epam.catalog.controller.command;

import com.epam.catalog.been.News;

import java.util.Map;

public interface Command {
    Map<String, String> execute(Map<String, String> request);
}
