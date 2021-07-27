package de.tischtiger.tutorial

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class Person {
    companion object {
        var anzahl = 0
    }
    init {
        anzahl = anzahl + 1
    }
    var vorname = ""
    var nachname = ""

    fun vollername() : String {
        return "$vorname $nachname"
    }
}

class Tutorial : JavaPlugin() {
    override fun onEnable() {
        // object(Objekte) und companion object(Begleitobjekt)
        val p1 = Person()
        p1.vorname = "Eva"
        val p2 = Person()
        p2.vorname = "Max"
        output("${p1.vorname} ${p2.vorname} ${Person.anzahl}")
        // Tutorial: Eva Max 2
    }

    override fun onDisable() {
        output("Ciao")
        // Tutorial: Ciao
    }

    fun output(msg: String) {
        Bukkit.getConsoleSender().sendMessage("Tutorial: $msg")
    }
}