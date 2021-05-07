package stomee.combat

import net.minestom.server.entity.Player
import world.cepi.kstom.addEventCallback

fun hook(player: Player) {
    player.addEventCallback(::handleAttack)
    player.addEventCallback(::handleDeath)
}