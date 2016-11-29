package com.github.hexocraft.addlight.configuration;

/*
 * Copyright 2016 hexosse
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

import com.github.hexocraftapi.configuration.Configuration;
import com.github.hexocraftapi.configuration.annotation.ConfigFooter;
import com.github.hexocraftapi.configuration.annotation.ConfigHeader;
import com.github.hexocraftapi.configuration.annotation.ConfigPath;
import com.github.hexocraftapi.configuration.annotation.ConfigValue;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

@ConfigHeader(comment = {
"# ===--- SoundEffect ---------------------------------------------------------------------------------------------=== #",
"#                                                                                                                      ",
"#     Quickly add invisible light sources                                                                              ",
"#                                                                                                                      ",
"# ===------------------------------------------------------------------------------------------ © 2016 Hexosse ---=== #"
})
@ConfigFooter(comment = {
" ",
"# ===--- Enjoy -------------------------------------------------------------------------------- © 2016 Hexosse ---=== #"
})
public class Messages extends Configuration
{
    /* Chat */
    @ConfigPath(path = "chat")
    @ConfigValue(path = "chat.prefix")                          public String chatPrefix = "&3[&bAddLight&3]&r";

    /* Commands */
    @ConfigPath(path = "commands", 		comment = "List of Messages used in commands")
    @ConfigValue(path = "commands.help.cmd")					public List<String>   cHelp    = Arrays.asList("Display AddLigh help");
    @ConfigValue(path = "commands.reload.cmd")					public List<String>   cReload  = Arrays.asList("Reload AddLigh");
    @ConfigValue(path = "commands.eanble.cmd")                  public String         cEnable  = "Enable lights creation!";
    @ConfigValue(path = "commands.disable.cmd")                 public String         cDisable = "Disable lights creation!";
    @ConfigValue(path = "commands.light.level.cmd")             public String         cLightLevel = "LightsApi intensity must be between 1 and 15.";
    @ConfigValue(path = "commands.connectedblocks")             public String         cConnectedBlock = "Toggle connected blocks mode";


    /* Messages */
    @ConfigPath(path = "messages", 		comment = "List of messages")
    @ConfigValue(path = "messages.HelpNumber")                  public String helpNumber = "Define light intensity (1 - 15)";
    @ConfigValue(path = "messages.HelpReload")                  public String helpReload = "Reload AddLight!";

	/* Success */
    @ConfigPath(path = "success", 		comment = "List of Messages used after a sucess command")
    @ConfigValue(path = "success.relaod")		                public String sReload = "AddLight has been reloaded";

    /* Errors */
    @ConfigPath(path = "errors", 		comment = "List of error messages")
    @ConfigValue(path = "errors.AccesDenied")                   public String AccesDenied = "You don't have permission to do that!";
    @ConfigValue(path = "errors.UseConnected")                  public String eUseConnected = "You don't have permission to use connected blocks!";
    @ConfigValue(path = "errors.intensity.number")              public String eIntensityNumber = "LightsApi intensity must be between 1 and 15";

    /* Messages */
    @ConfigPath(path = "messages")
    @ConfigValue(path = "messages.enable")                      public String enable     = "is enable!";
    @ConfigValue(path = "messages.disable")                     public String disable    = "is disable!";
    @ConfigValue(path = "messages.leftClick")                   public String leftClick  = "left click an item with glowstone dust to add light!";
    @ConfigValue(path = "messages.rightClick")                  public String rightClick = "right click an item with glowstone dust to remove light!";
    @ConfigValue(path = "messages.LightsIntensity")             public String lightsIntensity = "LightsApi intensity";

    @ConfigValue(path = "messages.LightsCreated")               public String lightsCreated = "lights created";
    @ConfigValue(path = "messages.LightsDeleted")               public String lightsDeleted = "lights deleted";
    @ConfigValue(path = "messages.Connectedblocks")             public String connectedblocks = "Connected blocks";


    public Messages(JavaPlugin plugin, String fileName, boolean load)
    {
        super(plugin, fileName);

        if(load) load();
    }
}