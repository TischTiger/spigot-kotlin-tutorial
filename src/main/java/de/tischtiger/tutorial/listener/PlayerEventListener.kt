package de.tischtiger.tutorial.listener

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent

object PlayerEventListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        player.sendMessage("Hallo ${player.name}!")
    }

    @EventHandler
    fun onPlayerBedEnter(event: PlayerBedEnterEvent) {
        val player = event.player
        player.sendMessage("Du kannst auf diesem Server nicht schlafen!")
        event.isCancelled = true

        val world = player.location.world ?: return

        for (other in world.players) {
            if (player == other) {
                continue
            }
            other.sendMessage("Hey, ${player.name} hat versucht zu schlafen.")
        }
    }

    @EventHandler
    fun onPlayerMoveEvent(event: PlayerMoveEvent) {
        val player = event.player
        val from = event.from
        val to = event.to
        when {
            to == null -> return
            (from.blockX != to.blockX) || (from.blockY != to.blockY) || (from.blockZ != to.blockZ) -> {
                Bukkit.getConsoleSender().sendMessage("Move ${player.name}: ${to.blockX} ${to.blockY} ${to.blockZ}")
            }
        }
    }
}