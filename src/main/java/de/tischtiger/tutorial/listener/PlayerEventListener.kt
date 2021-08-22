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
        // Boolean true oder false

        // and && Und-Operator
        // true == true && true
        // false == true && false
        // false == false && true
        // false == false && false

        // or || Oder-Operator
        // true == true || true
        // true == true || false
        // true == false || true
        // false == false || false

        // not ! Nicht-Operator
        // true == !false
        // false == !true

        // () Klammern

        event.isCancelled = true
    }

    @EventHandler
    fun onPlayerMoveEvent(event: PlayerMoveEvent) {
        val player = event.player
        val from = event.from
        val to = event.to
        when (from.blockX) {
            100 -> {
                return
            }
            in 1..10 -> {
                event.isCancelled = true
            }
        }
        when {
            to == null -> return
            (from.blockX != to.blockX) || (from.blockY != to.blockY) || (from.blockZ != to.blockZ) -> {
                Bukkit.getConsoleSender().sendMessage("Move ${player.name}: ${to.blockX} ${to.blockY} ${to.blockZ}")
            }
            else -> {
                // Nichts machen
            }
        }
    }
}