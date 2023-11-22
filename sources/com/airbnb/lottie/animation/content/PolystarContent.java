package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes3.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final BaseKeyframeAnimation<?, Float> DatabaseTableConfigUtil;
    private final BaseKeyframeAnimation<?, Float> GetContactSyncConfig;
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final BaseKeyframeAnimation<?, Float> MyBillsEntityDataFactory;
    private final Path NetworkUserEntityData$$ExternalSyntheticLambda0 = new Path();
    private final CompoundTrimPathContent NetworkUserEntityData$$ExternalSyntheticLambda1 = new CompoundTrimPathContent();
    private final PolystarShape.Type NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final BaseKeyframeAnimation<?, Float> PlaceComponentResult;
    private boolean getAuthRequestContext;
    private final BaseKeyframeAnimation<?, Float> getErrorConfigVersion;
    private final BaseKeyframeAnimation<?, PointF> initRecordTimeStamp;
    private final LottieDrawable lookAheadTest;
    private final String moveToNextValue;
    private final BaseKeyframeAnimation<?, Float> scheduleImpl;

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lookAheadTest = lottieDrawable;
        this.moveToNextValue = polystarShape.BuiltInFictitiousFunctionClassFactory;
        PolystarShape.Type type = polystarShape.moveToNextValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = type;
        this.BuiltInFictitiousFunctionClassFactory = polystarShape.BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = polystarShape.KClassImpl$Data$declaredNonStaticMembers$2();
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(polystarShape.getErrorConfigVersion.PlaceComponentResult);
        this.GetContactSyncConfig = floatKeyframeAnimation;
        BaseKeyframeAnimation<PointF, PointF> MyBillsEntityDataFactory = polystarShape.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
        this.initRecordTimeStamp = MyBillsEntityDataFactory;
        FloatKeyframeAnimation floatKeyframeAnimation2 = new FloatKeyframeAnimation(polystarShape.scheduleImpl.PlaceComponentResult);
        this.DatabaseTableConfigUtil = floatKeyframeAnimation2;
        FloatKeyframeAnimation floatKeyframeAnimation3 = new FloatKeyframeAnimation(polystarShape.PlaceComponentResult.PlaceComponentResult);
        this.getErrorConfigVersion = floatKeyframeAnimation3;
        FloatKeyframeAnimation floatKeyframeAnimation4 = new FloatKeyframeAnimation(polystarShape.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        this.scheduleImpl = floatKeyframeAnimation4;
        if (type == PolystarShape.Type.STAR) {
            this.PlaceComponentResult = new FloatKeyframeAnimation(polystarShape.MyBillsEntityDataFactory.PlaceComponentResult);
            this.MyBillsEntityDataFactory = new FloatKeyframeAnimation(polystarShape.getAuthRequestContext.PlaceComponentResult);
        } else {
            this.PlaceComponentResult = null;
            this.MyBillsEntityDataFactory = null;
        }
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation);
        baseLayer.MyBillsEntityDataFactory.add(MyBillsEntityDataFactory);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation2);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation3);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation4);
        if (type == PolystarShape.Type.STAR) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.PlaceComponentResult;
            if (baseKeyframeAnimation != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation);
            }
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.MyBillsEntityDataFactory;
            if (baseKeyframeAnimation2 != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        }
        floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        MyBillsEntityDataFactory.MyBillsEntityDataFactory.add(this);
        floatKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
        floatKeyframeAnimation3.MyBillsEntityDataFactory.add(this);
        floatKeyframeAnimation4.MyBillsEntityDataFactory.add(this);
        if (type == PolystarShape.Type.STAR) {
            this.PlaceComponentResult.MyBillsEntityDataFactory.add(this);
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.add(this);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.BuiltInFictitiousFunctionClassFactory == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory.add(trimPathContent);
                    trimPathContent.PlaceComponentResult.add(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path KClassImpl$Data$declaredNonStaticMembers$2() {
        float f;
        float f2;
        float f3;
        double d;
        float f4;
        float f5;
        float f6;
        double d2;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        double d3;
        int i;
        double d4;
        if (this.getAuthRequestContext) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.reset();
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.getAuthRequestContext = true;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        int i2 = AnonymousClass1.getAuthRequestContext[this.NetworkUserEntityData$$ExternalSyntheticLambda2.ordinal()];
        double d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        float f12 = 0.0f;
        if (i2 == 1) {
            float floatValue = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.DatabaseTableConfigUtil;
            if (baseKeyframeAnimation != null) {
                d5 = baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            }
            double radians = Math.toRadians(d5 - 90.0d);
            double d6 = floatValue;
            Double.isNaN(d6);
            float f13 = (float) (6.283185307179586d / d6);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                f13 *= -1.0f;
            }
            float f14 = f13 / 2.0f;
            float f15 = floatValue - ((int) floatValue);
            if (f15 != 0.0f) {
                double d7 = (1.0f - f15) * f14;
                Double.isNaN(d7);
                radians += d7;
            }
            float floatValue2 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            float floatValue3 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.MyBillsEntityDataFactory;
            float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / 100.0f : 0.0f;
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.scheduleImpl;
            float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / 100.0f : 0.0f;
            if (f15 != 0.0f) {
                float f16 = ((floatValue2 - floatValue3) * f15) + floatValue3;
                double d8 = f16;
                double cos = Math.cos(radians);
                Double.isNaN(d8);
                float f17 = (float) (d8 * cos);
                double sin = Math.sin(radians);
                Double.isNaN(d8);
                f2 = (float) (d8 * sin);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.moveTo(f17, f2);
                double d9 = (f13 * f15) / 2.0f;
                Double.isNaN(d9);
                d = radians + d9;
                f4 = f16;
                f = f17;
                f3 = f14;
            } else {
                double d10 = floatValue2;
                double cos2 = Math.cos(radians);
                Double.isNaN(d10);
                f = (float) (cos2 * d10);
                double sin2 = Math.sin(radians);
                Double.isNaN(d10);
                f2 = (float) (d10 * sin2);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.moveTo(f, f2);
                f3 = f14;
                double d11 = f3;
                Double.isNaN(d11);
                d = radians + d11;
                f4 = 0.0f;
            }
            double ceil = Math.ceil(d6) * 2.0d;
            float f18 = f3;
            float f19 = f2;
            float f20 = f;
            int i3 = 0;
            boolean z = false;
            while (true) {
                double d12 = i3;
                if (d12 >= ceil) {
                    break;
                }
                float f21 = z ? floatValue2 : floatValue3;
                if (f4 == 0.0f || d12 != ceil - 2.0d) {
                    f5 = f13;
                    f6 = f18;
                } else {
                    f5 = f13;
                    f6 = (f13 * f15) / 2.0f;
                }
                if (f4 == 0.0f || d12 != ceil - 1.0d) {
                    d2 = d12;
                    f7 = floatValue2;
                    f8 = f21;
                } else {
                    d2 = d12;
                    f7 = floatValue2;
                    f8 = f4;
                }
                float f22 = f6;
                double d13 = f8;
                double cos3 = Math.cos(d);
                Double.isNaN(d13);
                double d14 = ceil;
                float f23 = (float) (d13 * cos3);
                double sin3 = Math.sin(d);
                Double.isNaN(d13);
                float f24 = (float) (d13 * sin3);
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.lineTo(f23, f24);
                    d3 = d;
                    f9 = floatValue5;
                    f10 = floatValue3;
                    f11 = floatValue4;
                } else {
                    float f25 = f19;
                    f9 = floatValue5;
                    f10 = floatValue3;
                    double atan2 = (float) (Math.atan2(f25, f20) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    f11 = floatValue4;
                    d3 = d;
                    double atan22 = (float) (Math.atan2(f24, f23) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f26 = z ? f11 : f9;
                    float f27 = z ? f9 : f11;
                    float f28 = (z ? f10 : f7) * f26 * 0.47829f;
                    float f29 = cos4 * f28;
                    float f30 = f28 * sin4;
                    float f31 = (z ? f7 : f10) * f27 * 0.47829f;
                    float f32 = cos5 * f31;
                    float f33 = f31 * sin5;
                    if (f15 != 0.0f) {
                        if (i3 == 0) {
                            f29 *= f15;
                            f30 *= f15;
                        } else if (d2 == d14 - 1.0d) {
                            f32 *= f15;
                            f33 *= f15;
                        }
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.cubicTo(f20 - f29, f25 - f30, f23 + f32, f24 + f33, f23, f24);
                }
                double d15 = f22;
                z = !z;
                i3++;
                Double.isNaN(d15);
                d = d3 + d15;
                f20 = f23;
                floatValue4 = f11;
                floatValue3 = f10;
                floatValue5 = f9;
                floatValue2 = f7;
                ceil = d14;
                f19 = f24;
                f13 = f5;
            }
            PointF NetworkUserEntityData$$ExternalSyntheticLambda0 = this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda0();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.offset(NetworkUserEntityData$$ExternalSyntheticLambda0.x, NetworkUserEntityData$$ExternalSyntheticLambda0.y);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.close();
        } else if (i2 == 2) {
            int floor = (int) Math.floor(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue());
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.DatabaseTableConfigUtil;
            if (baseKeyframeAnimation4 != null) {
                d5 = baseKeyframeAnimation4.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            }
            double radians2 = Math.toRadians(d5 - 90.0d);
            double d16 = floor;
            Double.isNaN(d16);
            float floatValue6 = this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / 100.0f;
            float floatValue7 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            double d17 = floatValue7;
            double cos6 = Math.cos(radians2);
            Double.isNaN(d17);
            float f34 = (float) (cos6 * d17);
            double sin6 = Math.sin(radians2);
            Double.isNaN(d17);
            float f35 = (float) (sin6 * d17);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.moveTo(f34, f35);
            double d18 = (float) (6.283185307179586d / d16);
            Double.isNaN(d18);
            double d19 = radians2 + d18;
            double ceil2 = Math.ceil(d16);
            float f36 = f34;
            int i4 = 0;
            while (i4 < ceil2) {
                double cos7 = Math.cos(d19);
                Double.isNaN(d17);
                float f37 = (float) (cos7 * d17);
                double sin7 = Math.sin(d19);
                Double.isNaN(d17);
                double d20 = ceil2;
                float f38 = (float) (d17 * sin7);
                if (floatValue6 != f12) {
                    d4 = d17;
                    double atan23 = (float) (Math.atan2(f35, f36) - 1.5707963267948966d);
                    float cos8 = (float) Math.cos(atan23);
                    float sin8 = (float) Math.sin(atan23);
                    i = i4;
                    double atan24 = (float) (Math.atan2(f38, f37) - 1.5707963267948966d);
                    float f39 = floatValue7 * floatValue6 * 0.25f;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.cubicTo(f36 - (cos8 * f39), f35 - (sin8 * f39), f37 + (((float) Math.cos(atan24)) * f39), f38 + (f39 * ((float) Math.sin(atan24))), f37, f38);
                } else {
                    i = i4;
                    d4 = d17;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.lineTo(f37, f38);
                }
                Double.isNaN(d18);
                d19 += d18;
                i4 = i + 1;
                f36 = f37;
                f35 = f38;
                ceil2 = d20;
                d17 = d4;
                f12 = 0.0f;
            }
            PointF NetworkUserEntityData$$ExternalSyntheticLambda02 = this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda0();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.offset(NetworkUserEntityData$$ExternalSyntheticLambda02.x, NetworkUserEntityData$$ExternalSyntheticLambda02.y);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.close();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.close();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.getAuthRequestContext = true;
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.moveToNextValue;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.MyBillsEntityDataFactory(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.PrepareContext) {
            this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.initRecordTimeStamp && (baseKeyframeAnimation2 = this.PlaceComponentResult) != null) {
            baseKeyframeAnimation2.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.newProxyInstance) {
            this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda1 && (baseKeyframeAnimation = this.MyBillsEntityDataFactory) != null) {
            baseKeyframeAnimation.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.isLayoutRequested) {
            this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.getAuthRequestContext = false;
        this.lookAheadTest.invalidateSelf();
    }
}
