package com.github.kaydogz.happycarmod.client.renderer;

import com.github.kaydogz.happycarmod.HappyCarMod;
import com.github.kaydogz.happycarmod.client.model.CarModel;
import com.github.kaydogz.happycarmod.entity.CarEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CarRenderer<T extends CarEntity> extends EntityRenderer<T> {

    private static final ResourceLocation CAR_TEXTURES = HappyCarMod.modLocation("textures/entity/car.png");
    private final CarModel<T> modelCar = new CarModel<>();

    protected CarRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();

        matrixStackIn.translate(0.0D, 1.65D, -0.1D);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(-MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));

        matrixStackIn.scale(-1.1F, -1.1F, 1.1F);
        this.modelCar.setRotationAngles(entityIn, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.modelCar.getRenderType(this.getEntityTexture(entityIn)));
        this.modelCar.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return CAR_TEXTURES;
    }

    public static class RenderFactory<T extends CarEntity> implements IRenderFactory<T> {

        @Override
        public EntityRenderer<? super T> createRenderFor(EntityRendererManager manager) {
            return new CarRenderer<>(manager);
        }
    }
}
