package stomee.combat

import net.minestom.server.entity.Entity
import net.minestom.server.entity.GameMode
import net.minestom.server.entity.LivingEntity
import net.minestom.server.entity.Player
import net.minestom.server.entity.damage.DamageType
import net.minestom.server.event.entity.EntityAttackEvent
import net.minestom.server.utils.Vector

fun applyKnockback(victim: Entity, attacker: Entity) {
    val velocity: Vector = attacker.position.direction.multiply(6)
    velocity.y = 4.0
    victim.velocity = velocity
}

fun handleAttack(event: EntityAttackEvent) = with(event) {

    // Dead entities can't take damage
    if (target.isRemoved)
        return

    // Players in creative can't take damage
    if (target is Player && (target as Player).gameMode == GameMode.CREATIVE)
        return

    // If it can't be attacked return
    if (ImmunityHandler.isImmune(target))
        return

    if (target is LivingEntity) {

        // Cast as target is changeable
        val livingTarget = target as LivingEntity

        // Damage and apply knockback to the target.
        livingTarget.damage(DamageType.fromEntity(entity), 1f)
        applyKnockback(livingTarget, entity)
    }

    ImmunityHandler.triggerImmune(target)


}