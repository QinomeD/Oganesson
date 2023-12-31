package qinomed.oganesson;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.system.Platform;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Oganesson.MODID)
public class Oganesson {
    static {
        load("oganesson_native");
    }

    private static void load(String name) {
        String os = Platform.get().getName().toLowerCase();

        try {
            name = System.mapLibraryName(name);
            File libDir = new File("lib");

            if (!libDir.exists()) {
                libDir.mkdirs();
            }

            File object = new File("lib", name);
            InputStream is = Oganesson.class.getClassLoader().getResourceAsStream("/META-INF/natives/" + os + "/x86_64/" + name);

            if (is != null)
                Files.copy(is, object.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.load(object.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsatisfiedLinkError e) {
            throw new RuntimeException("Native library could not be loaded: " + name);
        }
    }

    // Define mod id in a common place for everything to reference
    public static final String MODID = "oganesson";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Oganesson() {
        // IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
