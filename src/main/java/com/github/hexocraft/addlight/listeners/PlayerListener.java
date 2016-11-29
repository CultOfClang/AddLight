package com.github.hexocraft.addlight.listeners;

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

import com.github.hexocraft.addlight.AddLightPlugin;
import com.github.hexocraft.addlight.LightsApi;
import com.github.hexocraftapi.message.predifined.message.SimpleMessage;
import com.github.hexocraftapi.nms.utils.NmsChunkUtil;
import com.github.hexocraftapi.reflection.minecraft.Minecraft;
import com.github.hexocraftapi.util.PlayerUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import static com.github.hexocraft.addlight.AddLightPlugin.isEnable;
import static com.github.hexocraft.addlight.AddLightPlugin.lightlevel;

/**
 * This file is part AddGlow
 *
 * @author <b>hexosse</b> (<a href="https://github.comp/hexosse">hexosse on GitHub</a>))
 */
@SuppressWarnings("unused")
public class PlayerListener implements Listener
{
    public PlayerListener(AddLightPlugin plugin)
    {
        super();
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        final Player player = event.getPlayer();

        if(!isEnable) return;

        //
        if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)
           && PlayerUtil.getItemInHand(player) != null
           && PlayerUtil.getItemInHand(player).getType() == Material.GLOWSTONE_DUST)
        {
            // Clicked location
            Location clickedLoc = event.getClickedBlock().getLocation();

            // Création de la lumière
            LightsApi.createLight(player, clickedLoc, lightlevel);
        }

        //
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)
           && PlayerUtil.getItemInHand(player) != null
           && PlayerUtil.getItemInHand(player).getType() == Material.GLOWSTONE_DUST)
        {
            if(Minecraft.Version.getVersion().newerThan(Minecraft.Version.v1_8_R4))
            {
                EquipmentSlot e = event.getHand();
                if(e.equals(EquipmentSlot.OFF_HAND))
                    return;
            }

            // Clicked location
            Location clickedLoc = event.getClickedBlock().getLocation();

            // Suppression de la lumière
            LightsApi.removeLight(player, clickedLoc);
        }

        //
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)
           && PlayerUtil.getItemInHand(player) != null
           && PlayerUtil.getItemInHand(player).getType() == Material.AIR)
        {
            if(Minecraft.Version.getVersion().newerThan(Minecraft.Version.v1_8_R4))
            {
                EquipmentSlot e = event.getHand();
                if(e.equals(EquipmentSlot.OFF_HAND))
                    return;
            }

            // Clicked location
            Location clickedLoc = event.getClickedBlock().getLocation();

            // Brightness
            SimpleMessage.toPlayer(player, "Block : " + clickedLoc.getBlock().getState().getData());
            SimpleMessage.toPlayer(player, "Location : " + clickedLoc.getBlockX() + " ," + clickedLoc.getBlockY() + " ," + clickedLoc.getBlockZ());
            SimpleMessage.toPlayer(player, "Brightness (SKY) : " + NmsChunkUtil.getBrightness(15, clickedLoc));
            SimpleMessage.toPlayer(player, "Brightness (BLOCK) : " + NmsChunkUtil.getBrightness(0, clickedLoc));
        }
    }
}