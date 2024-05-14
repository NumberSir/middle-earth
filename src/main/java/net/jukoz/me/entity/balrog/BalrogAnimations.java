package net.jukoz.me.entity.balrog;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class BalrogAnimations {

        public static final Animation WALK = Animation.Builder.create(1.92f).looping()
                .addBoneAnimation("leftleg",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(30f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.96f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createRotationalVector(-25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.92f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftwing",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(-2f, -5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.96f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createRotationalVector(-2f, -5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.92f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightwing",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(2f, 5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.96f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createRotationalVector(2f, 5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.92f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftarm",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(-25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.96f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createRotationalVector(25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.92f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightarm",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.96f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createRotationalVector(-25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.92f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightleg",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(-30f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.96f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createRotationalVector(25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.92f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("lowerjaw",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.96f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();
        public static final Animation IDLE = Animation.Builder.create(1.44f).looping()
                .addBoneAnimation("head",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("lowerjaw",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftwing",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightwing",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftarm",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightarm",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("tail",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1.44f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();
        public static final Animation ATTACK = Animation.Builder.create(0.72f)
                .addBoneAnimation("head",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createTranslationalVector(0f, -3f, -9f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("head",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("lowerjaw",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0.48f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createRotationalVector(17.5f, 17.9f, 9.04f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(32.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftwing",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createTranslationalVector(0f, 2f, -6.5f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createTranslationalVector(0f, 4f, -9f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftwing",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(25f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightwing",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createTranslationalVector(0f, 2f, -3.5f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createTranslationalVector(0f, 4f, -9f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightwing",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(20f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftarm",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createTranslationalVector(0f, -2f, -7.5f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createTranslationalVector(0f, -4f, -9f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftarm",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(42.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightarm",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createTranslationalVector(0f, -2.67f, -2.67f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.36f, AnimationHelper.createTranslationalVector(0f, -4f, -10f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightarm",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createRotationalVector(-10.11f, 39.17f, 70.5f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.36f, AnimationHelper.createRotationalVector(-57.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("righthand",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createRotationalVector(0f, 0f, -20f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leftleg",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createTranslationalVector(0f, 0f, -4f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightleg",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createTranslationalVector(0f, -0.25f, 3.13f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.48f, AnimationHelper.createTranslationalVector(0f, 0f, 5f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("rightleg",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.24f, AnimationHelper.createRotationalVector(0f, 36.67f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.72f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();
}