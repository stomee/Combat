package stomee.combat

import net.minestom.server.entity.GameMode
import net.minestom.server.entity.LivingEntity
import net.minestom.server.entity.Player
import net.minestom.server.entity.damage.DamageType
import net.minestom.server.event.entity.EntityAttackEvent
import world.cepi.kstom.addEventCallback

fun handleAttack(event: EntityAttackEvent) = with(event) {

    // Dead entities can't take damage
    if (target.isRemoved)
        return

    // Players in creative can't take damage
    if (target is Player && (target as Player).gameMode == GameMode.CREATIVE) {
        return
    }

    if (target is LivingEntity) {

        // Cast as target is changeable
        val livingTarget = target as LivingEntity

        // Damage and apply knockback to the target.
        livingTarget.damage(DamageType.fromEntity(entity), 1f)
        applyKnockback(livingTarget, entity)
    }


}