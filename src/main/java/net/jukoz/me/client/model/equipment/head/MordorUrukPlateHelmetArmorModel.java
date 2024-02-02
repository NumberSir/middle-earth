package net.jukoz.me.client.model.equipment.head;

import net.jukoz.me.MiddleEarth;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class MordorUrukPlateHelmetArmorModel<T extends LivingEntity> extends CustomHelmetModel<T> {
    private static final float MAX_ANGLE_HAIR = 75f;

    public final ModelPart skull;

    public MordorUrukPlateHelmetArmorModel(ModelPart root) {
        super(root);
        skull = root.getChild("head").getChild("skull_parts");

        HELMET_ADDON_TEXTURE = new Identifier(MiddleEarth.MOD_ID, "textures/models/armor/mordor_uruk_plate_helmet_addon.png");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData skull_parts = head.addChild("skull_parts", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        skull_parts.addChild("skull", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -41.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.8F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        skull_parts.addChild("skull_right_support", ModelPartBuilder.create().uv(28, 24).cuboid(3.3F, -38.2698F, -0.8F, 0.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        skull_parts.addChild("skull_left_support", ModelPartBuilder.create().uv(28, 24).mirrored().cuboid(-3.4F, -38.4698F, -1.0F, 0.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}