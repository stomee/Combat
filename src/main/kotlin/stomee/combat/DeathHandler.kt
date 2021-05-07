package stomee.combat

import net.kyori.adventure.text.Component
import net.minestom.server.entity.Player
import net.minestom.server.entity.damage.EntityDamage
import net.minestom.server.event.entity.EntityDeathEvent
import net.minestom.server.event.player.PlayerDeathEvent

fun handleDeath(event: PlayerDeathEvent) = with(event) {

    if (player.lastDamageSource is EntityDamage) {
        val entityDamageSource = player.lastDamageSource as EntityDamage

        if (entityDamageSource.source is Player) {

            val playerSource = entityDamageSource.source as Player

            player.inventory.itemStacks.forEach {
                playerSource.inventory.addItemStack(it)
            }
        }
    }

    player.inventory.clear()

    deathText = player.name
        .append(Component.space())
        .append(Component.text("died"))
}