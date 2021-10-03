package de.tischtiger.tutorial.command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

object HealTabCompleter : TabCompleter {
    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String>? {
        val list: MutableList<String> = ArrayList()
        if (args.size != 1) return list
        if (sender !is Player) return list
        for (player in Bukkit.getOnlinePlayers()) {
            if (player.name.contains(args[0], true)) {
                list.add(player.name)
            }
        }
        return list
    }
}