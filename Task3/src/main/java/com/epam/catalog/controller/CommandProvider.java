package com.epam.catalog.controller;

import com.epam.catalog.controller.command.Command;
import com.epam.catalog.controller.command.impl.AddNews;
import com.epam.catalog.controller.command.impl.FindNews;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public class CommandProvider {
    private final Map<CommandName, Command> commandMap = new HashMap<CommandName, Command>();

    CommandProvider() {
        commandMap.put(CommandName.ADD_NEWS, new AddNews());
        commandMap.put(CommandName.FIND_NEWS, new FindNews());
    }
}
