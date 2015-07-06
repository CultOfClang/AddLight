package com.github.hexosse.addlight.commands;

/*
 * Copyright 2015 hexosse
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import com.github.hexosse.addlight.AddLight;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * This file is part of AddLight
 *
 * @author <b>hexosse</b> (<a href="https://github.com/hexosse">hexosse on GitHub</a>).
 * @date 06/07/2015
 */
public class CommandHelp
{
    private final static AddLight plugin = AddLight.getPlugin();

    /**
     * @param sender The sender (should be a player)
     */
    public static void execute(CommandSender sender)
    {
        sender.sendMessage("-----------------------------------------------------");
        sender.sendMessage(ChatColor.RED + plugin.getDescription().getName() + " help");
        sender.sendMessage(ChatColor.AQUA + "/AddLight [enable|on] :" + ChatColor.WHITE + " Enable light creation");
        sender.sendMessage(ChatColor.AQUA + "/AddLight [disable|off] :" + ChatColor.WHITE + " Disable light creation");
        sender.sendMessage(ChatColor.AQUA + "/AddLight <number> :" + ChatColor.WHITE + " Define light intensity");
        sender.sendMessage("-----------------------------------------------------");
    }
}