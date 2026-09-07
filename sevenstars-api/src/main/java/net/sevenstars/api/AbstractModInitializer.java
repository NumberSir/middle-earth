package net.sevenstars.api;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.sevenstars.api.enums.LangCategory;
import net.sevenstars.api.utils.IdentifierUtil;
import net.sevenstars.api.utils.LoggerUtil;

public abstract class AbstractModInitializer implements ModInitializer {
    protected String modId;
    protected boolean isDebug = true;
    protected LoggerUtil logger;
    protected String modVersion = "1.0.2-1.21.8-beta";

    protected AbstractModInitializer(String id) {
        modId = id;
        logger = new LoggerUtil(modId, isDebug);
    }

    public LoggerUtil logger() {
        return logger;
    }

    public String id() {
        return modId;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public String getModVersion() {
        return modVersion;
    }

    public Identifier id(String path) {
        return IdentifierUtil.build(modId, path);
    }

    public Identifier idAggregate(String... names) {
        return IdentifierUtil.buildAggregate(modId, names);
    }

    public String idAggregate(char delimiter, String... names) {
        return IdentifierUtil.createAggregateValue(delimiter, names);
    }

    public Identifier ofId(String stringId) {
        return IdentifierUtil.getIdentifierFromString(stringId);
    }


    // Translation Keys
    public String translationKey(LangCategory category, String value){
        return id(value).toTranslationKey(category.Prefix);
    }
    public String translationKey(LangCategory category, Identifier value){
        return value.toTranslationKey(category.Prefix);
    }

    public void logRegistryMessage(String registry) {
        logger.logDebugMsg("Registering Mod " +  registry + " for " + id());
    }
}
