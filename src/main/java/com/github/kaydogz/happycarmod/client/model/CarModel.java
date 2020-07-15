package com.github.kaydogz.happycarmod.client.model;

import com.github.kaydogz.happycarmod.entity.CarEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CarModel<T extends CarEntity> extends EntityModel<T> {

	private final ModelRenderer Interior;
	private final ModelRenderer SteeringWheel;
	private final ModelRenderer Seat;
	private final ModelRenderer TireCovers;
	private final ModelRenderer TopRightCover;
	private final ModelRenderer TopLeftCover;
	private final ModelRenderer Body;
	private final ModelRenderer Hood;
	private final ModelRenderer Windshield;
	private final ModelRenderer Roof;
	private final ModelRenderer Back;
	private final ModelRenderer Spoiler;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightSide;
	private final ModelRenderer RightBorder;
	private final ModelRenderer FrontRightBorder;
	private final ModelRenderer BackRightBorder;
	private final ModelRenderer RightInner;
	private final ModelRenderer RightWindow;
	private final ModelRenderer RightMirror;
	private final ModelRenderer RightCircle;
	private final ModelRenderer LeftSide;
	private final ModelRenderer LeftBorder;
	private final ModelRenderer FrontLeftBorder;
	private final ModelRenderer BackLeftBorder;
	private final ModelRenderer LeftInner;
	private final ModelRenderer LeftWindow;
	private final ModelRenderer LeftMirror;
	private final ModelRenderer LeftCircle;
	private final ModelRenderer Bumpers;
	private final ModelRenderer FrontBumper;
	private final ModelRenderer FrontShell;
	private final ModelRenderer RightShell;
	private final ModelRenderer LeftShell;
	private final ModelRenderer BumperInterior;
	private final ModelRenderer Mouth;
	private final ModelRenderer Lips;
	private final ModelRenderer BackBumper;
	private final ModelRenderer Skirts;
	private final ModelRenderer Skeleton;
	private final ModelRenderer Fenders;
	private final ModelRenderer FenderFR;
	private final ModelRenderer FenderBR;
	private final ModelRenderer FenderBL;
	private final ModelRenderer FenderRL;
	private final ModelRenderer Tires;
	private final ModelRenderer TireFR;
	private final ModelRenderer TireFL;
	private final ModelRenderer TireBL;
	private final ModelRenderer TireBR;

	public CarModel() {
		textureWidth = 512;
		textureHeight = 512;

		Interior = new ModelRenderer(this);
		Interior.setRotationPoint(0.0F, 24.0F, -6.0F);
		

		SteeringWheel = new ModelRenderer(this);
		SteeringWheel.setRotationPoint(0.0F, -14.0F, -6.0F);
		Interior.addChild(SteeringWheel);
		SteeringWheel.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(-2.0F, 2.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(2.0F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		SteeringWheel.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Seat = new ModelRenderer(this);
		Seat.setRotationPoint(0.0F, 0.0F, 0.0F);
		Interior.addChild(Seat);
		Seat.setTextureOffset(0, 0).addBox(-2.0F, -8.0F, 5.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		Seat.setTextureOffset(0, 156).addBox(-5.0F, -9.0F, 2.0F, 9.0F, 1.0F, 7.0F, 0.0F, false);
		Seat.setTextureOffset(0, 168).addBox(-5.0F, -10.0F, 9.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		Seat.setTextureOffset(0, 184).addBox(-5.0F, -19.0F, 10.0F, 9.0F, 9.0F, 1.0F, 0.0F, false);

		TireCovers = new ModelRenderer(this);
		TireCovers.setRotationPoint(0.0F, 0.0F, 0.0F);
		Interior.addChild(TireCovers);
		TireCovers.setTextureOffset(143, 194).addBox(7.0F, -10.0F, 18.0F, 1.0F, 4.0F, 10.0F, 0.0F, false);
		TireCovers.setTextureOffset(143, 194).addBox(-8.0F, -10.0F, 18.0F, 1.0F, 4.0F, 10.0F, 0.0F, false);

		TopRightCover = new ModelRenderer(this);
		TopRightCover.setRotationPoint(0.0F, 0.0F, 0.0F);
		TireCovers.addChild(TopRightCover);
		TopRightCover.setTextureOffset(143, 211).addBox(-8.0F, -8.0F, -10.0F, 1.0F, 2.0F, 11.0F, 0.0F, false);
		TopRightCover.setTextureOffset(143, 228).addBox(-8.0F, -9.0F, -9.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		TopRightCover.setTextureOffset(143, 242).addBox(-8.0F, -10.0F, -8.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);

		TopLeftCover = new ModelRenderer(this);
		TopLeftCover.setRotationPoint(15.0F, 0.0F, 0.0F);
		TireCovers.addChild(TopLeftCover);
		TopLeftCover.setTextureOffset(143, 211).addBox(-8.0F, -8.0F, -10.0F, 1.0F, 2.0F, 11.0F, 0.0F, false);
		TopLeftCover.setTextureOffset(143, 228).addBox(-8.0F, -9.0F, -9.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		TopLeftCover.setTextureOffset(143, 242).addBox(-8.0F, -10.0F, -8.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, -6.0F);
		Body.setTextureOffset(0, 84).addBox(-8.0F, -6.0F, -11.0F, 16.0F, 1.0F, 39.0F, 0.0F, false);

		Hood = new ModelRenderer(this);
		Hood.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Hood);
		Hood.setTextureOffset(100, 0).addBox(-8.0F, -14.0F, -11.0F, 16.0F, 8.0F, 1.0F, 0.0F, false);
		Hood.setTextureOffset(144, 0).addBox(-10.0F, -15.0F, -10.0F, 20.0F, 7.0F, 1.0F, 0.0F, false);
		Hood.setTextureOffset(0, 128).addBox(-11.0F, -20.0F, -9.0F, 7.0F, 11.0F, 1.0F, 0.0F, false);
		Hood.setTextureOffset(18, 128).addBox(4.0F, -20.0F, -9.0F, 7.0F, 11.0F, 1.0F, 0.0F, false);
		Hood.setTextureOffset(108, 16).addBox(-4.0F, -17.0F, -9.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);

		Windshield = new ModelRenderer(this);
		//Windshield.setRotationPoint(0.0F, 0.0F, -1.0F);
		//Body.addChild(Windshield);
		//Windshield.setTextureOffset(64, 64).addBox(-4.0F, -20.0F, -8.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
		//Windshield.setTextureOffset(64, 64).addBox(-8.0F, -22.0F, -7.0F, 16.0F, 2.0F, 1.0F, 0.0F, false);
		//Windshield.setTextureOffset(64, 64).addBox(-8.0F, -24.0F, -6.0F, 16.0F, 2.0F, 1.0F, 0.0F, false);
		//Windshield.setTextureOffset(64, 64).addBox(-8.0F, -25.0F, -5.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);
		//Windshield.setTextureOffset(64, 64).addBox(-8.0F, -26.0F, -4.0F, 16.0F, 1.0F, 2.0F, 0.0F, false);
		//Windshield.setTextureOffset(64, 64).addBox(-7.0F, -27.0F, -2.0F, 14.0F, 1.0F, 2.0F, 0.0F, false);

		Roof = new ModelRenderer(this);
		Roof.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Roof);
		Roof.setTextureOffset(64, 36).addBox(-7.0F, -28.0F, -2.0F, 14.0F, 1.0F, 3.0F, 0.0F, false);
		Roof.setTextureOffset(64, 36).addBox(-8.0F, -27.0F, -3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Roof.setTextureOffset(64, 36).addBox(7.0F, -27.0F, -3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Roof.setTextureOffset(172, 0).addBox(-8.0F, -27.0F, 1.0F, 16.0F, 1.0F, 20.0F, 0.0F, false);
		Roof.setTextureOffset(292, 0).addBox(-7.0F, -28.0F, 1.0F, 14.0F, 1.0F, 19.0F, 0.0F, false);

		Back = new ModelRenderer(this);
		Back.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Back);
		Back.setTextureOffset(232, 0).addBox(-8.0F, -27.0F, 21.0F, 16.0F, 3.0F, 1.0F, 0.0F, false);
		Back.setTextureOffset(232, 0).addBox(-8.0F, -21.0F, 23.0F, 16.0F, 2.0F, 1.0F, 0.0F, false);
		Back.setTextureOffset(270, 0).addBox(-8.0F, -19.0F, 24.0F, 16.0F, 1.0F, 3.0F, 0.0F, false);
		Back.setTextureOffset(232, 0).addBox(-8.0F, -18.0F, 27.0F, 16.0F, 5.0F, 1.0F, 0.0F, false);
		Back.setTextureOffset(232, 0).addBox(-8.0F, -24.0F, 22.0F, 16.0F, 3.0F, 1.0F, 0.0F, false);
		Back.setTextureOffset(232, 0).addBox(-8.0F, -13.0F, 28.0F, 16.0F, 8.0F, 1.0F, 0.0F, false);

		Spoiler = new ModelRenderer(this);
		Spoiler.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Spoiler);
		Spoiler.setTextureOffset(108, 32).addBox(-6.0F, -10.0F, 29.0F, 12.0F, 4.0F, 2.0F, 0.0F, false);
		Spoiler.setTextureOffset(108, 32).addBox(-5.0F, -9.0F, 31.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		Spoiler.setTextureOffset(108, 46).addBox(-7.0F, -15.0F, 37.0F, 14.0F, 1.0F, 3.0F, 0.0F, false);
		Spoiler.setTextureOffset(144, 32).addBox(-7.0F, -17.0F, 37.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Spoiler.setTextureOffset(144, 32).addBox(5.0F, -17.0F, 37.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		Spoiler.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 141).addBox(-4.0F, -10.0F, 32.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 141).addBox(-4.0F, -12.0F, 34.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 141).addBox(-4.0F, -14.0F, 36.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(6.0F, 0.0F, 0.0F);
		Spoiler.addChild(LeftLeg);
		LeftLeg.setTextureOffset(0, 141).addBox(-4.0F, -10.0F, 32.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 141).addBox(-4.0F, -12.0F, 34.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 141).addBox(-4.0F, -14.0F, 36.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		RightSide = new ModelRenderer(this);
		RightSide.setRotationPoint(0.0F, 0.0F, 6.0F);
		Body.addChild(RightSide);
		RightSide.setTextureOffset(0, 0).addBox(-12.0F, -14.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightBorder = new ModelRenderer(this);
		RightBorder.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSide.addChild(RightBorder);
		RightBorder.setTextureOffset(128, 64).addBox(-10.0F, -26.0F, -10.0F, 2.0F, 2.0F, 25.0F, 0.0F, false);
		RightBorder.setTextureOffset(159, 64).addBox(-11.0F, -25.0F, -11.0F, 1.0F, 1.0F, 19.0F, 0.0F, false);

		FrontRightBorder = new ModelRenderer(this);
		FrontRightBorder.setRotationPoint(-8.0F, -20.0F, -14.0F);
		RightBorder.addChild(FrontRightBorder);
		FrontRightBorder.setTextureOffset(142, 134).addBox(-3.0F, -2.0F, 0.0F, 3.0F, 6.0F, 1.0F, 0.0F, false);
		FrontRightBorder.setTextureOffset(142, 135).addBox(-3.0F, -5.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		FrontRightBorder.setTextureOffset(128, 134).addBox(-2.0F, -6.0F, 3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		FrontRightBorder.setTextureOffset(142, 135).addBox(-3.0F, -4.0F, 1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		BackRightBorder = new ModelRenderer(this);
		BackRightBorder.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightBorder.addChild(BackRightBorder);
		BackRightBorder.setTextureOffset(128, 54).addBox(-10.0F, -14.0F, 21.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		BackRightBorder.setTextureOffset(128, 103).addBox(-10.0F, -19.0F, 18.0F, 2.0F, 9.0F, 3.0F, 0.0F, false);
		BackRightBorder.setTextureOffset(128, 11).addBox(-10.0F, -20.0F, 17.0F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		BackRightBorder.setTextureOffset(128, 62).addBox(-10.0F, -22.0F, 16.0F, 2.0F, 12.0F, 1.0F, 0.0F, false);
		BackRightBorder.setTextureOffset(128, 116).addBox(-10.0F, -25.0F, 15.0F, 2.0F, 15.0F, 1.0F, 0.0F, false);

		RightInner = new ModelRenderer(this);
		RightInner.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSide.addChild(RightInner);
		RightInner.setTextureOffset(136, 128).addBox(-11.0F, -16.0F, -14.0F, 3.0F, 6.0F, 29.0F, 0.0F, false);
		RightInner.setTextureOffset(0, 184).addBox(-11.0F, -10.0F, -7.0F, 3.0F, 1.0F, 21.0F, 0.0F, false);
		RightInner.setTextureOffset(0, 207).addBox(-11.0F, -9.0F, -6.0F, 3.0F, 1.0F, 19.0F, 0.0F, false);
		RightInner.setTextureOffset(42, 180).addBox(-11.0F, -8.0F, -5.0F, 3.0F, 3.0F, 17.0F, 0.0F, false);
		RightInner.setTextureOffset(128, 136).addBox(-11.0F, -24.0F, 7.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);

		RightWindow = new ModelRenderer(this);
		//RightWindow.setRotationPoint(0.0F, 0.0F, 0.0F);
		//RightSide.addChild(RightWindow);
		//RightWindow.setTextureOffset(156, 164).addBox(-11.0F, -21.0F, -13.0F, 1.0F, 5.0F, 20.0F, 0.0F, false);
		//RightWindow.setTextureOffset(156, 168).addBox(-11.0F, -23.0F, -12.0F, 1.0F, 2.0F, 19.0F, 0.0F, false);
		//RightWindow.setTextureOffset(156, 168).addBox(-11.0F, -24.0F, -11.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);

		RightMirror = new ModelRenderer(this);
		RightMirror.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSide.addChild(RightMirror);
		RightMirror.setTextureOffset(116, 183).addBox(-13.0F, -17.0F, -15.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		RightMirror.setTextureOffset(126, 183).addBox(-16.0F, -20.0F, -15.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		RightCircle = new ModelRenderer(this);
		RightCircle.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSide.addChild(RightCircle);
		RightCircle.setTextureOffset(110, 128).addBox(-12.0F, -14.0F, -3.0F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		RightCircle.setTextureOffset(123, 128).addBox(-12.0F, -13.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightCircle.setTextureOffset(123, 128).addBox(-12.0F, -13.0F, 1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightCircle.setTextureOffset(118, 128).addBox(-12.0F, -12.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightCircle.setTextureOffset(118, 128).addBox(-12.0F, -12.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftSide = new ModelRenderer(this);
		LeftSide.setRotationPoint(0.0F, 0.0F, 6.0F);
		Body.addChild(LeftSide);
		LeftSide.setTextureOffset(0, 0).addBox(11.0F, -14.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		LeftBorder = new ModelRenderer(this);
		LeftBorder.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSide.addChild(LeftBorder);
		LeftBorder.setTextureOffset(128, 64).addBox(8.0F, -26.0F, -10.0F, 2.0F, 2.0F, 25.0F, 0.0F, true);
		LeftBorder.setTextureOffset(159, 64).addBox(10.0F, -25.0F, -11.0F, 1.0F, 1.0F, 19.0F, 0.0F, true);

		FrontLeftBorder = new ModelRenderer(this);
		FrontLeftBorder.setRotationPoint(8.0F, -20.0F, -14.0F);
		LeftBorder.addChild(FrontLeftBorder);
		FrontLeftBorder.setTextureOffset(142, 134).addBox(0.0F, -2.0F, 0.0F, 3.0F, 6.0F, 1.0F, 0.0F, true);
		FrontLeftBorder.setTextureOffset(142, 135).addBox(0.0F, -5.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);
		FrontLeftBorder.setTextureOffset(128, 134).addBox(0.0F, -6.0F, 3.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		FrontLeftBorder.setTextureOffset(142, 135).addBox(0.0F, -4.0F, 1.0F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		BackLeftBorder = new ModelRenderer(this);
		BackLeftBorder.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftBorder.addChild(BackLeftBorder);
		BackLeftBorder.setTextureOffset(128, 54).addBox(8.0F, -14.0F, 21.0F, 2.0F, 5.0F, 1.0F, 0.0F, true);
		BackLeftBorder.setTextureOffset(128, 103).addBox(8.0F, -19.0F, 18.0F, 2.0F, 9.0F, 3.0F, 0.0F, true);
		BackLeftBorder.setTextureOffset(128, 11).addBox(8.0F, -20.0F, 17.0F, 2.0F, 10.0F, 1.0F, 0.0F, true);
		BackLeftBorder.setTextureOffset(128, 62).addBox(8.0F, -22.0F, 16.0F, 2.0F, 12.0F, 1.0F, 0.0F, true);
		BackLeftBorder.setTextureOffset(128, 116).addBox(8.0F, -25.0F, 15.0F, 2.0F, 15.0F, 1.0F, 0.0F, true);

		LeftInner = new ModelRenderer(this);
		LeftInner.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSide.addChild(LeftInner);
		LeftInner.setTextureOffset(136, 128).addBox(8.0F, -16.0F, -14.0F, 3.0F, 6.0F, 29.0F, 0.0F, true);
		LeftInner.setTextureOffset(0, 184).addBox(8.0F, -10.0F, -7.0F, 3.0F, 1.0F, 21.0F, 0.0F, true);
		LeftInner.setTextureOffset(0, 207).addBox(8.0F, -9.0F, -6.0F, 3.0F, 1.0F, 19.0F, 0.0F, true);
		LeftInner.setTextureOffset(42, 180).addBox(8.0F, -8.0F, -5.0F, 3.0F, 3.0F, 17.0F, 0.0F, true);
		LeftInner.setTextureOffset(128, 136).addBox(10.0F, -24.0F, 7.0F, 1.0F, 8.0F, 8.0F, 0.0F, true);

		LeftWindow = new ModelRenderer(this);
		//LeftWindow.setRotationPoint(0.0F, 0.0F, 0.0F);
		//LeftSide.addChild(LeftWindow);
		//LeftWindow.setTextureOffset(156, 164).addBox(10.0F, -21.0F, -13.0F, 1.0F, 5.0F, 20.0F, 0.0F, true);
		//LeftWindow.setTextureOffset(156, 168).addBox(10.0F, -23.0F, -12.0F, 1.0F, 2.0F, 19.0F, 0.0F, true);
		//LeftWindow.setTextureOffset(156, 168).addBox(10.0F, -24.0F, -11.0F, 1.0F, 1.0F, 18.0F, 0.0F, true);

		LeftMirror = new ModelRenderer(this);
		LeftMirror.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSide.addChild(LeftMirror);
		LeftMirror.setTextureOffset(116, 183).addBox(11.0F, -17.0F, -15.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		LeftMirror.setTextureOffset(126, 183).addBox(12.0F, -20.0F, -15.0F, 4.0F, 3.0F, 2.0F, 0.0F, true);

		LeftCircle = new ModelRenderer(this);
		LeftCircle.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSide.addChild(LeftCircle);
		LeftCircle.setTextureOffset(100, 128).addBox(11.0F, -14.0F, -3.0F, 1.0F, 7.0F, 4.0F, 0.0F, true);
		LeftCircle.setTextureOffset(123, 128).addBox(11.0F, -13.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);
		LeftCircle.setTextureOffset(123, 128).addBox(11.0F, -13.0F, 1.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);
		LeftCircle.setTextureOffset(118, 128).addBox(11.0F, -12.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		LeftCircle.setTextureOffset(118, 128).addBox(11.0F, -12.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		Bumpers = new ModelRenderer(this);
		Bumpers.setRotationPoint(0.0F, 24.0F, -6.0F);
		

		FrontBumper = new ModelRenderer(this);
		FrontBumper.setRotationPoint(0.0F, -1.0F, 0.0F);
		Bumpers.addChild(FrontBumper);
		

		FrontShell = new ModelRenderer(this);
		FrontShell.setRotationPoint(0.0F, 0.0F, 0.0F);
		FrontBumper.addChild(FrontShell);
		FrontShell.setTextureOffset(63, 0).addBox(-8.0F, -4.0F, -13.0F, 16.0F, 1.0F, 2.0F, 0.0F, false);
		FrontShell.setTextureOffset(63, 0).addBox(7.0F, -7.0F, -13.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		FrontShell.setTextureOffset(63, 0).addBox(-8.0F, -7.0F, -13.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		FrontShell.setTextureOffset(63, 0).addBox(-8.0F, -8.0F, -13.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);

		RightShell = new ModelRenderer(this);
		RightShell.setRotationPoint(0.0F, 0.0F, 0.0F);
		FrontBumper.addChild(RightShell);
		RightShell.setTextureOffset(64, 0).addBox(-11.0F, -8.0F, -12.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		RightShell.setTextureOffset(64, 0).addBox(-8.0F, -7.0F, -12.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightShell.setTextureOffset(64, 0).addBox(-11.0F, -7.0F, -12.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightShell.setTextureOffset(64, 0).addBox(-11.0F, -4.0F, -12.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		RightShell.setTextureOffset(64, 0).addBox(-12.0F, -8.0F, -11.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		RightShell.setTextureOffset(64, 0).addBox(-10.0F, -8.0F, -11.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		LeftShell = new ModelRenderer(this);
		LeftShell.setRotationPoint(18.0F, 0.0F, 0.0F);
		FrontBumper.addChild(LeftShell);
		LeftShell.setTextureOffset(64, 0).addBox(-18.0F, -8.0F, -12.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		LeftShell.setTextureOffset(64, 0).addBox(-8.0F, -7.0F, -12.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		LeftShell.setTextureOffset(64, 0).addBox(-11.0F, -7.0F, -12.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		LeftShell.setTextureOffset(64, 0).addBox(-10.0F, -4.0F, -12.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		LeftShell.setTextureOffset(64, 0).addBox(-8.0F, -8.0F, -11.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		LeftShell.setTextureOffset(64, 0).addBox(-10.0F, -8.0F, -11.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		BumperInterior = new ModelRenderer(this);
		BumperInterior.setRotationPoint(0.0F, 0.0F, 0.0F);
		FrontBumper.addChild(BumperInterior);
		BumperInterior.setTextureOffset(64, 8).addBox(-10.0F, -7.0F, -11.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		BumperInterior.setTextureOffset(64, 8).addBox(8.0F, -7.0F, -11.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		BumperInterior.setTextureOffset(64, 8).addBox(-7.0F, -7.0F, -12.0F, 14.0F, 3.0F, 1.0F, 0.0F, false);

		Mouth = new ModelRenderer(this);
		Mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		FrontBumper.addChild(Mouth);
		Mouth.setTextureOffset(0, 77).addBox(-5.0F, -3.0F, -13.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Mouth.setTextureOffset(0, 79).addBox(-4.0F, -2.0F, -12.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Mouth.setTextureOffset(72, 0).addBox(-5.0F, -3.0F, -12.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Mouth.setTextureOffset(72, 0).addBox(-4.0F, -2.0F, -11.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Lips = new ModelRenderer(this);
		Lips.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mouth.addChild(Lips);
		Lips.setTextureOffset(72, 0).addBox(0.0F, -3.0F, -13.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		Lips.setTextureOffset(72, 0).addBox(-4.0F, -1.0F, -13.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		Lips.setTextureOffset(72, 0).addBox(-6.0F, -3.0F, -13.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		Lips.setTextureOffset(72, 0).addBox(-5.0F, -2.0F, -13.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		BackBumper = new ModelRenderer(this);
		BackBumper.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bumpers.addChild(BackBumper);
		BackBumper.setTextureOffset(65, 16).addBox(-8.0F, -5.0F, 28.0F, 16.0F, 2.0F, 3.0F, 0.0F, false);
		BackBumper.setTextureOffset(65, 25).addBox(8.0F, -4.0F, 28.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		BackBumper.setTextureOffset(65, 25).addBox(-11.0F, -4.0F, 28.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		Skirts = new ModelRenderer(this);
		Skirts.setRotationPoint(0.0F, 24.0F, -6.0F);
		Skirts.setTextureOffset(0, 42).addBox(-13.0F, -5.0F, 0.0F, 5.0F, 2.0F, 19.0F, 0.0F, false);
		Skirts.setTextureOffset(0, 42).addBox(8.0F, -5.0F, 0.0F, 5.0F, 2.0F, 19.0F, 0.0F, false);

		Skeleton = new ModelRenderer(this);
		Skeleton.setRotationPoint(0.0F, 24.0F, -6.0F);
		Skeleton.setTextureOffset(14, 0).addBox(-8.0F, -4.0F, -5.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);
		Skeleton.setTextureOffset(14, 0).addBox(-8.0F, -4.0F, 23.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);
		Skeleton.setTextureOffset(0, 14).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 1.0F, 27.0F, 0.0F, false);
		Skeleton.setTextureOffset(0, 64).addBox(-1.0F, -5.0F, -11.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);

		Fenders = new ModelRenderer(this);
		Fenders.setRotationPoint(0.0F, 24.0F, -6.0F);
		

		FenderFR = new ModelRenderer(this);
		FenderFR.setRotationPoint(0.0F, 0.0F, 0.0F);
		Fenders.addChild(FenderFR);
		FenderFR.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderFR.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, -10.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		FenderFR.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -1.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderFR.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -9.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderFR.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderFR.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderFR.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -7.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		FenderBR = new ModelRenderer(this);
		FenderBR.setRotationPoint(0.0F, 0.0F, 28.0F);
		Fenders.addChild(FenderBR);
		FenderBR.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, 0.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		FenderBR.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, -10.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBR.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -1.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBR.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -9.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBR.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBR.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBR.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -7.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		FenderBL = new ModelRenderer(this);
		FenderBL.setRotationPoint(21.0F, 0.0F, 28.0F);
		Fenders.addChild(FenderBL);
		FenderBL.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, 0.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		FenderBL.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, -10.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBL.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -1.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBL.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -9.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBL.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBL.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderBL.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -7.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		FenderRL = new ModelRenderer(this);
		FenderRL.setRotationPoint(21.0F, 0.0F, 0.0F);
		Fenders.addChild(FenderRL);
		FenderRL.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderRL.setTextureOffset(48, 0).addBox(-13.0F, -8.0F, -10.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		FenderRL.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -1.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderRL.setTextureOffset(48, 0).addBox(-13.0F, -9.0F, -9.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderRL.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderRL.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		FenderRL.setTextureOffset(48, 0).addBox(-13.0F, -10.0F, -7.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		Tires = new ModelRenderer(this);
		Tires.setRotationPoint(0.0F, 24.0F, -6.0F);
		

		TireFR = new ModelRenderer(this);
		TireFR.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Tires.addChild(TireFR);
		TireFR.setTextureOffset(0, 0).addBox(-11.0F, -6.0F, -7.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		TireFR.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireFR.setTextureOffset(0, 0).addBox(-11.0F, -7.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		TireFR.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireFR.setTextureOffset(0, 0).addBox(-11.0F, -1.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		TireFL = new ModelRenderer(this);
		TireFL.setRotationPoint(19.0F, 0.0F, 0.0F);
		Tires.addChild(TireFL);
		TireFL.setTextureOffset(0, 0).addBox(-11.0F, -6.0F, -7.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		TireFL.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireFL.setTextureOffset(0, 0).addBox(-11.0F, -7.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		TireFL.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireFL.setTextureOffset(0, 0).addBox(-11.0F, -1.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		TireBL = new ModelRenderer(this);
		TireBL.setRotationPoint(19.0F, 0.0F, 28.0F);
		Tires.addChild(TireBL);
		TireBL.setTextureOffset(0, 0).addBox(-11.0F, -6.0F, -7.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		TireBL.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireBL.setTextureOffset(0, 0).addBox(-11.0F, -7.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		TireBL.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireBL.setTextureOffset(0, 0).addBox(-11.0F, -1.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		TireBR = new ModelRenderer(this);
		TireBR.setRotationPoint(-2.0F, 0.0F, 28.0F);
		Tires.addChild(TireBR);
		TireBR.setTextureOffset(0, 0).addBox(-11.0F, -6.0F, -7.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		TireBR.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireBR.setTextureOffset(0, 0).addBox(-11.0F, -7.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		TireBR.setTextureOffset(0, 0).addBox(-11.0F, -5.0F, -8.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		TireBR.setTextureOffset(0, 0).addBox(-11.0F, -1.0F, -6.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		SteeringWheel.rotateAngleZ = (float) (-entity.getWheelRotation() * Math.PI / 2);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Interior.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Bumpers.render(matrixStack, buffer, packedLight, packedOverlay);
		Skirts.render(matrixStack, buffer, packedLight, packedOverlay);
		Skeleton.render(matrixStack, buffer, packedLight, packedOverlay);
		Fenders.render(matrixStack, buffer, packedLight, packedOverlay);
		Tires.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}