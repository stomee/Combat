package stomee.combat

import net.minestom.server.entity.Entity
import net.minestom.server.entity.Player
import net.minestom.server.utils.Vector
import world.cepi.kstom.addEventCallback

fun applyKnockback(victim: Entity, attacker: Entity) {
    val velocity: Vector = attacker.position.direction.multiply(6)
    velocity.y = 4.0
    victim.velocity = velocity
}

fun hook(player: Player) {
    player.addEventCallback(::handleAttack)
    player.addEventCallback(::handleDeath)
}