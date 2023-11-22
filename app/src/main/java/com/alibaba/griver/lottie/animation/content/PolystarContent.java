package com.alibaba.griver.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.LottieProperty;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.model.KeyPath;
import com.alibaba.griver.lottie.model.content.PolystarShape;
import com.alibaba.griver.lottie.model.content.ShapeTrimPath;
import com.alibaba.griver.lottie.model.layer.BaseLayer;
import com.alibaba.griver.lottie.utils.MiscUtils;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes6.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final PolystarShape.Type type;
    private final Path path = new Path();
    private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        this.hidden = polystarShape.isHidden();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = createAnimation5;
        if (type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type == PolystarShape.Type.STAR) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.alibaba.griver.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }

    @Override // com.alibaba.griver.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i == 1) {
            createStarPath();
        } else if (i == 2) {
            createPolygonPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    /* renamed from: com.alibaba.griver.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$alibaba$griver$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.alibaba.griver.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private void createStarPath() {
        float f;
        float f2;
        float f3;
        double d;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        double d2;
        float f15;
        float floatValue = this.pointsAnimation.getValue().floatValue();
        double radians = Math.toRadians((this.rotationAnimation == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : r2.getValue().floatValue()) - 90.0d);
        double d3 = floatValue;
        Double.isNaN(d3);
        float f16 = (float) (6.283185307179586d / d3);
        float f17 = f16 / 2.0f;
        float f18 = floatValue - ((int) floatValue);
        if (f18 != 0.0f) {
            double d4 = (1.0f - f18) * f17;
            Double.isNaN(d4);
            radians += d4;
        }
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float floatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.innerRoundednessAnimation;
        float floatValue4 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.outerRoundednessAnimation;
        float floatValue5 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        if (f18 != 0.0f) {
            float f19 = ((floatValue2 - floatValue3) * f18) + floatValue3;
            f2 = floatValue2;
            double d5 = f19;
            double cos = Math.cos(radians);
            Double.isNaN(d5);
            f4 = (float) (d5 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d5);
            f5 = (float) (d5 * sin);
            this.path.moveTo(f4, f5);
            double d6 = (f16 * f18) / 2.0f;
            Double.isNaN(d6);
            d = radians + d6;
            f6 = f19;
            f3 = f17;
            f = floatValue3;
        } else {
            double d7 = floatValue2;
            double cos2 = Math.cos(radians);
            Double.isNaN(d7);
            f = floatValue3;
            float f20 = (float) (d7 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d7);
            float f21 = (float) (d7 * sin2);
            this.path.moveTo(f20, f21);
            f2 = floatValue2;
            f3 = f17;
            double d8 = f3;
            Double.isNaN(d8);
            d = radians + d8;
            f4 = f20;
            f5 = f21;
            f6 = 0.0f;
        }
        double ceil = Math.ceil(d3) * 2.0d;
        int i = 0;
        float f22 = f4;
        float f23 = f5;
        boolean z = false;
        while (true) {
            double d9 = i;
            if (d9 < ceil) {
                float f24 = z ? f2 : f;
                float f25 = (f6 == 0.0f || d9 != ceil - 2.0d) ? f3 : (f16 * f18) / 2.0f;
                if (f6 == 0.0f || d9 != ceil - 1.0d) {
                    f7 = f16;
                    f8 = f6;
                    f9 = f24;
                    f10 = f3;
                } else {
                    f7 = f16;
                    f10 = f3;
                    f9 = f6;
                    f8 = f9;
                }
                double d10 = f9;
                double cos3 = Math.cos(d);
                Double.isNaN(d10);
                float f26 = (float) (d10 * cos3);
                double sin3 = Math.sin(d);
                Double.isNaN(d10);
                float f27 = (float) (d10 * sin3);
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.path.lineTo(f26, f27);
                    d2 = d;
                    f11 = f26;
                    f12 = floatValue4;
                    f13 = f;
                    f14 = floatValue5;
                    f15 = f25;
                } else {
                    f11 = f26;
                    float f28 = f23;
                    f12 = floatValue4;
                    f13 = f;
                    float f29 = f22;
                    f14 = floatValue5;
                    double atan2 = (float) (Math.atan2(f28, f29) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    d2 = d;
                    f15 = f25;
                    double atan22 = (float) (Math.atan2(f27, f11) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f30 = z ? f12 : f14;
                    float f31 = z ? f14 : f12;
                    float f32 = z ? f13 : f2;
                    float f33 = z ? f2 : f13;
                    float f34 = f32 * f30 * POLYSTAR_MAGIC_NUMBER;
                    float f35 = cos4 * f34;
                    float f36 = f34 * sin4;
                    float f37 = f33 * f31 * POLYSTAR_MAGIC_NUMBER;
                    float f38 = cos5 * f37;
                    float f39 = f37 * sin5;
                    if (f18 != 0.0f) {
                        if (i == 0) {
                            f35 *= f18;
                            f36 *= f18;
                        } else if (d9 == ceil - 1.0d) {
                            f38 *= f18;
                            f39 *= f18;
                        }
                    }
                    this.path.cubicTo(f29 - f35, f28 - f36, f11 + f38, f27 + f39, f11, f27);
                }
                double d11 = f15;
                z = !z;
                i++;
                Double.isNaN(d11);
                d = d2 + d11;
                floatValue5 = f14;
                floatValue4 = f12;
                f3 = f10;
                f16 = f7;
                f = f13;
                f23 = f27;
                f22 = f11;
                f6 = f8;
            } else {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void createPolygonPath() {
        int i;
        double d;
        double d2;
        double d3;
        int floor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        double radians = Math.toRadians((this.rotationAnimation == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : r2.getValue().floatValue()) - 90.0d);
        double d4 = floor;
        Double.isNaN(d4);
        float floatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d5 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d5);
        float f = (float) (cos * d5);
        double sin = Math.sin(radians);
        Double.isNaN(d5);
        float f2 = (float) (sin * d5);
        this.path.moveTo(f, f2);
        double d6 = (float) (6.283185307179586d / d4);
        Double.isNaN(d6);
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < ceil) {
            double cos2 = Math.cos(d7);
            Double.isNaN(d5);
            float f3 = (float) (cos2 * d5);
            double sin2 = Math.sin(d7);
            Double.isNaN(d5);
            double d8 = ceil;
            float f4 = (float) (d5 * sin2);
            if (floatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double atan2 = (float) (Math.atan2(f2, f) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d3 = d6;
                double atan22 = (float) (Math.atan2(f4, f3) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f5 = floatValue2 * floatValue * POLYGON_MAGIC_NUMBER;
                this.path.cubicTo(f - (cos3 * f5), f2 - (sin3 * f5), f3 + (cos4 * f5), f4 + (f5 * sin4), f3, f4);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.path.lineTo(f3, f4);
            }
            Double.isNaN(d3);
            d7 = d + d3;
            i2 = i + 1;
            f2 = f4;
            f = f3;
            ceil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    @Override // com.alibaba.griver.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.alibaba.griver.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }
}
