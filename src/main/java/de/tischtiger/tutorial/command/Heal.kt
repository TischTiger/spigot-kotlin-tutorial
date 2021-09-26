package de.tischtiger.tutorial.command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Heal: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Your not a player")
            return true
        }
        when (args.size) {
            0 -> {
                sender.health = sender.maxHealth
                sender.sendMessage("Your healed")
                return true
            }
            1 -> {
                if (!sender.hasPermission("tutorial.heal.other")) {
                    sender.sendMessage("You don't have the permission to heal others")
                    return true
                }
                val other = Bukkit.getPlayer(args[0])
                if (other == null) {
                    sender.sendMessage("Player ${args[0]} not found!")
                    return true
                }
                other.health = other.maxHealth
                other.sendMessage("Your healed by ${sender.name}")
                sender.sendMessage("You healed ${args[0]}")
                return true
            }
            else -> {
                sender.sendMessage("Wrong parameter count")
                return false
            }
        }
    }
}