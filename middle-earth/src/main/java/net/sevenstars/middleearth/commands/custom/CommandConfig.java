package net.sevenstars.middleearth.commands.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.sevenstars.middleearth.commands.CommandRegistryME;
import net.sevenstars.middleearth.config.ClientConfigME;
import net.sevenstars.middleearth.config.ServerConfigME;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandConfig {
    private static final String CONFIG_BASE_COMMAND = "config";
    private static final String RELOAD = "reload";

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        // [CONFIG]
        dispatcher.register(
            literal(CommandRegistryME.BASE_COMMAND)
                .then(literal(CONFIG_BASE_COMMAND)
                    .then(literal(RELOAD)
                        .executes(CommandConfig::reloadConfig)
                    )
                )
        );
    }
    private static int reloadConfig(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();

        ClientConfigME.reload();

        if (source.hasPermissionLevel(2)) {
            ServerConfigME.reload();
            source.sendMessage(Text.literal("Reloaded Middle-earth CLIENT and SERVER configs."));
        } else {
            source.sendMessage(Text.literal("Reloaded Middle-earth CLIENT config (server config requires OP)."));
        }
        return 1;
    }
}