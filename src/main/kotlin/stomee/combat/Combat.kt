package stomee.combat

import net.minestom.server.extensions.Extension;
import world.cepi.kstom.Manager

class Combat : Extension() {

    override fun initialize() {

        Manager.connection.addPlayerInitialization(::hook)

        logger.info("[Combat] has been enabled!")
    }

    override fun terminate() {

        Manager.connection.addPlayerInitialization(::hook)

        logger.info("[Combat] has been disabled!")
    }

}