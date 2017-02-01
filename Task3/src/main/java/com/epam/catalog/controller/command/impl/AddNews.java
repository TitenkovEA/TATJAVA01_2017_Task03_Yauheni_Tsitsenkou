package com.epam.catalog.controller.command.impl;

import com.epam.catalog.been.News;
import com.epam.catalog.controller.command.Command;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public class AddNews implements Command {
    public String execute(News news) {
        return "lolo";
    }
}
