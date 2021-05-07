package stomee.combat

import net.minestom.server.entity.Player
import world.cepi.kstom.command.SimpleKommand

object SuicideCommand : SimpleKommand("suicide", "death", process = { sender, _, _ ->

    if (sender is Player) {
        sender.kill()
    }

    true
})