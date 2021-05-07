package stomee.combat

import net.minestom.server.extensions.Extension;
import world.cepi.kstom.Manager
import world.cepi.kstom.command.register
import world.cepi.kstom.command.unregister

class Combat : Extension() {

    override fun initialize() {

        Manager.connection.addPlayerInitialization(::hook)

        SuicideCommand.register()

        logger.info("[Combat] has been enabled!")
    }

    override fun terminate() {

        Manager.connection.addPlayerInitialization(::hook)

        SuicideCommand.unregister()

        logger.info("[Combat] has been disabled!")
    }

}