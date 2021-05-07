package stomee.combat

import net.minestom.server.entity.Player
import net.minestom.server.entity.damage.EntityDamage
import net.minestom.server.event.entity.EntityDeathEvent

fun handleDeath(event: EntityDeathEvent) = with(event) {
    if (entity is Player) {
        val player = entity as Player

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
    }


}