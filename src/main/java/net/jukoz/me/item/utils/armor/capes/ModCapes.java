package net.jukoz.me.item.utils.armor.capes;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

public enum ModCapes implements StringIdentifiable {
    BASE_CAPE(0,"base_cape", ModCapeModels.MEDIUM_MODELS),
    SURCOAT(1,"surcoat", ModCapeModels.SURCOAT_MODELS),
    BASE_CLOAK(2,"base_cloak", ModCapeModels.WIDE_MODELS),

    BLACK_FUR_CLOAK(3,"black_fur_cloak", ModCapeModels.FUR_MODELS),
    BROWN_FUR_CLOAK(4,"brown_fur_cloak", ModCapeModels.FUR_MODELS),
    GRAY_FUR_CLOAK(5,"gray_fur_cloak", ModCapeModels.FUR_MODELS),
    TAN_FUR_CLOAK(6,"tan_fur_cloak", ModCapeModels.FUR_MODELS),
    WHITE_FUR_CLOAK(7,"white_fur_cloak", ModCapeModels.FUR_MODELS),

    BLACK_FUR(8,"black_fur", ModCapeModels.FUR_MODELS),
    BROWN_FUR(9,"brown_fur", ModCapeModels.FUR_MODELS),
    GRAY_FUR(10,"gray_fur", ModCapeModels.FUR_MODELS),
    TAN_FUR(11,"tan_fur", ModCapeModels.FUR_MODELS),
    WHITE_FUR(12,"white_fur", ModCapeModels.FUR_MODELS),

    GONDORIAN_CAPTAIN_CAPE(13,"gondorian_captain_cape", ModCapeModels.MEDIUM_MODELS),
    GONDORIAN_HERO_CAPE(14,"gondorian_hero_cape", ModCapeModels.MEDIUM_MODELS),
    GONDORIAN_KINGS_GUARD_CAPE(15,"gondorian_kings_guard_cape", ModCapeModels.MEDIUM_MODELS),
    GONDORIAN_CITADEL_GUARD_CAPE(16,"gondorian_citadel_guard_cape", ModCapeModels.MEDIUM_MODELS),
    GONDORIAN_FOUNTAIN_GUARD_CAPE(17,"gondorian_fountain_guard_cape", ModCapeModels.WIDE_MODELS),

    ROHIRRIC_CAPE(18,"rohirric_cape", ModCapeModels.MEDIUM_MODELS),
    ROHIRRIC_ROYAL_GUARD_CAPE(19,"rohirric_royal_guard_cape", ModCapeModels.MEDIUM_MODELS),
    EORLING_MARSHAL_CAPE(20,"eorling_marshal_cape", ModCapeModels.MEDIUM_MODELS),
    HORSE_LORD_CAPE(21,"horse_lord_cape", ModCapeModels.MEDIUM_MODELS),

    BARDING_SURCOAT(22,"barding_surcoat", ModCapeModels.SURCOAT_MODELS),
    DALISH_HEYDAY_CAPE(23,"dalish_heyday_cape", ModCapeModels.MEDIUM_MODELS),
    BARDING_SERGEANT_CAPE(24,"barding_sergeant_cape", ModCapeModels.MEDIUM_MODELS),

    EREBOR_CAPE(25,"erebor_cape", ModCapeModels.MEDIUM_MODELS),
    RAVENHILL_SENTINEL_CAPE(26,"ravenhill_sentinel_cape", ModCapeModels.WIDE_MODELS),

    LORIEN_MARCHWARDEN_CAPE(27,"lorien_marchwarden_cape", ModCapeModels.MEDIUM_MODELS),
    GALADHRIM_CAPE(28,"galadhrim_cape", ModCapeModels.SLIM_MODELS),
    GALADHRIM_LORD_SURCOAT(29,"galadhrim_lord_surcoat", ModCapeModels.SURCOAT_MODELS),
    ;

    private static final IntFunction<ModCapes> BY_ID = ValueLists.createIdToValueFunction(ModCapes::getId, ModCapes.values(), ValueLists.OutOfBoundsHandling.ZERO);;
    private final String name;
    private final int id;
    private final ModCapeModels models;

    public static final Codec<ModCapes> CODEC = StringIdentifiable.createBasicCodec(ModCapes::values);
    public static final PacketCodec<ByteBuf, ModCapes> PACKET_CODEC = PacketCodecs.indexed(BY_ID, ModCapes::getId);


    ModCapes(int id, String name, ModCapeModels models){
        this.name = name;
        this.models = models;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ModCapeModels getModel() {
        return models;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
