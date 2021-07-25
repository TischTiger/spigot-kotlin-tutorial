package de.tischtiger.tutorial

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class Tutorial : JavaPlugin() {
    override fun onEnable() {
        // Strings(Zeichenketten), val(Value, Werte), var(Variablen)
        val output1 = "Hallo Welt!"
        Bukkit.getConsoleSender().sendMessage(output1)
        // Hallo Welt!
        var output2 = "Hallo Welt!"
        Bukkit.getConsoleSender().sendMessage(output2)
        // Hallo Welt!
        val output3 = " \" \\ \$ \nNeue Zeile"
        Bukkit.getConsoleSender().sendMessage(output3)
        // " \ $
        // Neue Zeile
        val output4 = output1 + " GG"
        Bukkit.getConsoleSender().sendMessage(output4)
        // Hallo Welt! GG
        val vorname = "Max"
        val nachname = "Mustermann"
        val output5 = "Hallo $vorname ${nachname}1!"
        Bukkit.getConsoleSender().sendMessage(output4)
        // Hallo Max Mustermann1!
        val output6 = "${ChatColor.GREEN}Grün§rGrau"
        output2 = "Test"
        Bukkit.getConsoleSender().sendMessage(output2)
        // Test
        Bukkit.getConsoleSender().sendMessage("output2: $output2")
        // output2: Test
    }

    override fun onDisable() {
    }
}