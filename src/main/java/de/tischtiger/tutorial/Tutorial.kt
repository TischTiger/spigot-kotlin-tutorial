package de.tischtiger.tutorial

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Tutorial : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("Hallo Welt!")
        // Plugin startup logic
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("Ciao")
        // Plugin shutdown logic
    }
}