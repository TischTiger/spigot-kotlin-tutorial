package de.tischtiger.tutorial

import de.tischtiger.tutorial.command.Heal
import de.tischtiger.tutorial.listener.PlayerEventListener
import org.bukkit.plugin.java.JavaPlugin

class Tutorial : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerEventListener, this)
        getCommand("heal")?.setExecutor(Heal)
    }

    override fun onDisable() {
    }
}