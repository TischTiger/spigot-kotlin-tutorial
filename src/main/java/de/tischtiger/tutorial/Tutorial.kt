package de.tischtiger.tutorial

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class Tutorial : JavaPlugin() {
    override fun onEnable() {
        // Strings(Zeichenketten), var(Variablen), val(Werte/Value)
        val name = "TischTiger"
        var output = "Hallo \" \\ \$ \n " + name + "!"
        val output2 = "Hallo \" \\ \$ \n ${name}!"
        val output3 = "${ChatColor.GREEN} Dieser Text ist Grün!${ChatColor.RESET} Dieser nicht!"
        // Hallo " \ $
        //  Welt!
        Bukkit.getConsoleSender().sendMessage(output)
        Bukkit.getConsoleSender().sendMessage(output2)
        Bukkit.getConsoleSender().sendMessage(output3)
        output = "Hallo Welt!"
        output = "$output!"
        Bukkit.getConsoleSender().sendMessage(output)
    }

    override fun onDisable() {
    }
}