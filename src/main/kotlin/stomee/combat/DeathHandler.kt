package stomee.combat

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.entity.ItemEntity
import net.minestom.server.entity.Player
import net.minestom.server.entity.damage.EntityDamage
import net.minestom.server.event.entity.EntityDeathEvent
import net.minestom.server.event.player.PlayerDeathEvent
import net.minestom.server.utils.time.TimeUnit

fun handleDeath(event: PlayerDeathEvent) = with(event) {

    player.inventory.itemStacks.forEach {
        val entity = ItemEntity(it, player.position, player.instance!!)

        entity.setInstance(player.instance!!, player.position)

        entity.setPickupDelay(30, TimeUnit.TICK)
    }

    player.inventory.clear()

    val deathMessage = player.name
        .append(Component.space())
        .append(Component.text("died", NamedTextColor.RED))

    deathText = deathMessage
    chatMessage = deathMessage
}