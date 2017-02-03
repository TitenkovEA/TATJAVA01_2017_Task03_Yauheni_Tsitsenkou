package com.epam.catalog.controller;

import com.epam.catalog.controller.command.Command;

import java.util.Map;

/**
 * Created by Yauheni_Tsitsenkou on 2/1/2017.
 */
public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final String COMMAND_NAME = "COMMAND_NAME";

    public Map<String, String> executeCommand(Map<String, String> request) {
        String commandName = request.get(COMMAND_NAME).toUpperCase();

        Command command = provider.getCommand(commandName);

        Map<String, String> response = command.execute(request);
        return response;
    }
}
