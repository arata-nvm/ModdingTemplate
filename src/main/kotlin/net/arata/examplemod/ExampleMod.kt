package net.arata.examplemod

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.arata.common.CommonProxy
import org.apache.logging.log4j.LogManager

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
class ExampleMod {

    companion object {
        const val MODID = "examplemod"
        const val VERSION = "0.0.1"

        @SidedProxy(clientSide = "net.arata.client.ClientProxy", serverSide = "net.arata.common.CommonProxy")
        lateinit var proxy: CommonProxy

        @Mod.Instance(MODID)
        lateinit var instance: ExampleMod

        val logger = LogManager.getLogger("net.arata.examplemod.ExampleMod")
    }

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        proxy.preInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        proxy.init(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }

}