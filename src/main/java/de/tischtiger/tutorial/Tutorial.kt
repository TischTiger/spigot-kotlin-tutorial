package de.tischtiger.tutorial

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class Person {
    var vorname = ""
    var nachname = ""

    fun vollername() : String {
        return "$vorname $nachname"
    }
}

class Tutorial : JavaPlugin() {
    override fun onEnable() {
        // class(Klassen) und fun(Funktionen/Methoden)
        output("Hallo Welt!")
        // Tutorial: Hallo Welt!
        val p1 = Person()
        p1.vorname = "Eva"
        p1.nachname = "Musterfrau"
        val p2 = Person()
        p2.vorname = "Max"
        p2.nachname = "Mustermann"
        output("${p1.vollername()} liebt ${p2.vollername()}")
        // Tutorial: Eva Musterfrau liebt Max Mustermann
    }

    override fun onDisable() {
        output("Ciao")
        // Tutorial: Ciao
    }

    fun output(msg: String) {
        Bukkit.getConsoleSender().sendMessage("Tutorial: $msg")
    }
}