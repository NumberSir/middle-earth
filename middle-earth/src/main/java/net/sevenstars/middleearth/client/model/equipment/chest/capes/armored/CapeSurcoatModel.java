package net.sevenstars.middleearth.client.model.equipment.chest.capes.armored;

import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.sevenstars.middleearth.client.model.equipment.chest.ChestplateAddonModel;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;

public class CapeSurcoatModel extends ChestplateAddonModel {

    public CapeSurcoatModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData head = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData hat = head.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body = modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        body.addChild("cape_shoulder", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -23.5F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(1.1F)),
                ModelTransform.pivot(0.0F, 23.0F, 0.016F));

        ModelPartData right_arm = modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create(),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        right_arm.addChild("right_arm_shoulder_cape", ModelPartBuilder.create().uv(24, 16).cuboid(-4.0F, -2.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(1.1F)), ModelTransform.pivot(-0.0F, -0.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create(),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        left_arm.addChild("left_arm_shoulder_cape", ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(0.0F, -2.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(1.1F)).mirrored(false), ModelTransform.pivot(0.0F, -0.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        right_leg.addChild("right_leg", ModelPartBuilder.create().uv(72, 16).cuboid(-2.1F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(1.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        left_leg.addChild("left_leg", ModelPartBuilder.create().uv(56, 16).mirrored().cuboid(-1.968F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(1.1F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));


        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(BipedEntityRenderState bipedEntityRenderState) {
        super.setAngles(bipedEntityRenderState);
    }
}
