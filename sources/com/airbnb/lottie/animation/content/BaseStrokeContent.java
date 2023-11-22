package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {
    private BaseKeyframeAnimation<Float, Float> BuiltInFictitiousFunctionClassFactory;
    private final BaseKeyframeAnimation<?, Integer> DatabaseTableConfigUtil;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> KClassImpl$Data$declaredNonStaticMembers$2;
    protected final BaseLayer MyBillsEntityDataFactory;
    private DropShadowKeyframeAnimation NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Paint PlaceComponentResult;
    private final BaseKeyframeAnimation<?, Float> PrepareContext;
    float getAuthRequestContext;
    private final List<BaseKeyframeAnimation<?, Float>> getErrorConfigVersion;
    private final LottieDrawable lookAheadTest;
    private final BaseKeyframeAnimation<?, Float> moveToNextValue;
    private final float[] scheduleImpl;
    private final PathMeasure NetworkUserEntityData$$ExternalSyntheticLambda2 = new PathMeasure();
    private final Path GetContactSyncConfig = new Path();
    private final Path newProxyInstance = new Path();
    private final RectF initRecordTimeStamp = new RectF();
    private final List<PathGroup> NetworkUserEntityData$$ExternalSyntheticLambda1 = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.PlaceComponentResult = lPaint;
        this.getAuthRequestContext = 0.0f;
        this.lookAheadTest = lottieDrawable;
        this.MyBillsEntityDataFactory = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f);
        this.DatabaseTableConfigUtil = new IntegerKeyframeAnimation(animatableIntegerValue.PlaceComponentResult);
        this.PrepareContext = new FloatKeyframeAnimation(animatableFloatValue.PlaceComponentResult);
        if (animatableFloatValue2 == null) {
            this.moveToNextValue = null;
        } else {
            this.moveToNextValue = new FloatKeyframeAnimation(animatableFloatValue2.PlaceComponentResult);
        }
        this.getErrorConfigVersion = new ArrayList(list.size());
        this.scheduleImpl = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.getErrorConfigVersion.add(new FloatKeyframeAnimation(list.get(i).PlaceComponentResult));
        }
        BaseKeyframeAnimation<?, Integer> baseKeyframeAnimation = this.DatabaseTableConfigUtil;
        if (baseKeyframeAnimation != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.PrepareContext;
        if (baseKeyframeAnimation2 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
        }
        for (int i2 = 0; i2 < this.getErrorConfigVersion.size(); i2++) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.getErrorConfigVersion.get(i2);
            if (baseKeyframeAnimation3 != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation3);
            }
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.moveToNextValue;
        if (baseKeyframeAnimation4 != null && baseKeyframeAnimation4 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation4);
        }
        this.DatabaseTableConfigUtil.MyBillsEntityDataFactory.add(this);
        this.PrepareContext.MyBillsEntityDataFactory.add(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.getErrorConfigVersion.get(i3).MyBillsEntityDataFactory.add(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation5 = this.moveToNextValue;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.MyBillsEntityDataFactory.add(this);
        }
        if (baseLayer.BuiltInFictitiousFunctionClassFactory() != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(baseLayer.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext.PlaceComponentResult);
            this.BuiltInFictitiousFunctionClassFactory = floatKeyframeAnimation;
            floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.BuiltInFictitiousFunctionClassFactory;
            if (baseKeyframeAnimation6 != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation6);
            }
        }
        if (baseLayer.KClassImpl$Data$declaredNonStaticMembers$2() != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.lookAheadTest.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        PathGroup pathGroup = null;
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.BuiltInFictitiousFunctionClassFactory == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.PlaceComponentResult.add(this);
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            byte b = 0;
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.BuiltInFictitiousFunctionClassFactory == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(pathGroup);
                    }
                    PathGroup pathGroup2 = new PathGroup(trimPathContent3, b);
                    trimPathContent3.PlaceComponentResult.add(this);
                    pathGroup = pathGroup2;
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent, b);
                }
                pathGroup.getAuthRequestContext.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(pathGroup);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        float f;
        float f2;
        float f3;
        L.getAuthRequestContext("StrokeContent#draw");
        if (Utils.KClassImpl$Data$declaredNonStaticMembers$2(matrix)) {
            L.MyBillsEntityDataFactory("StrokeContent#draw");
            return;
        }
        float f4 = 100.0f;
        this.PlaceComponentResult.setAlpha(MiscUtils.getAuthRequestContext((int) ((((i / 255.0f) * ((IntegerKeyframeAnimation) this.DatabaseTableConfigUtil).moveToNextValue()) / 100.0f) * 255.0f)));
        this.PlaceComponentResult.setStrokeWidth(((FloatKeyframeAnimation) this.PrepareContext).lookAheadTest() * Utils.PlaceComponentResult(matrix));
        if (this.PlaceComponentResult.getStrokeWidth() <= 0.0f) {
            L.MyBillsEntityDataFactory("StrokeContent#draw");
            return;
        }
        L.getAuthRequestContext("StrokeContent#applyDashPattern");
        float f5 = 1.0f;
        boolean z = false;
        if (this.getErrorConfigVersion.isEmpty()) {
            L.MyBillsEntityDataFactory("StrokeContent#applyDashPattern");
        } else {
            float PlaceComponentResult = Utils.PlaceComponentResult(matrix);
            for (int i2 = 0; i2 < this.getErrorConfigVersion.size(); i2++) {
                this.scheduleImpl[i2] = this.getErrorConfigVersion.get(i2).NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
                if (i2 % 2 == 0) {
                    float[] fArr = this.scheduleImpl;
                    if (fArr[i2] < 1.0f) {
                        fArr[i2] = 1.0f;
                    }
                } else {
                    float[] fArr2 = this.scheduleImpl;
                    if (fArr2[i2] < 0.1f) {
                        fArr2[i2] = 0.1f;
                    }
                }
                float[] fArr3 = this.scheduleImpl;
                fArr3[i2] = fArr3[i2] * PlaceComponentResult;
            }
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.moveToNextValue;
            this.PlaceComponentResult.setPathEffect(new DashPathEffect(this.scheduleImpl, baseKeyframeAnimation == null ? 0.0f : PlaceComponentResult * baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue()));
            L.MyBillsEntityDataFactory("StrokeContent#applyDashPattern");
        }
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (baseKeyframeAnimation2 != null) {
            this.PlaceComponentResult.setColorFilter(baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.BuiltInFictitiousFunctionClassFactory;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            if (floatValue == 0.0f) {
                this.PlaceComponentResult.setMaskFilter(null);
            } else if (floatValue != this.getAuthRequestContext) {
                this.PlaceComponentResult.setMaskFilter(this.MyBillsEntityDataFactory.getAuthRequestContext(floatValue));
            }
            this.getAuthRequestContext = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
        }
        int i3 = 0;
        while (i3 < this.NetworkUserEntityData$$ExternalSyntheticLambda1.size()) {
            PathGroup pathGroup = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(i3);
            if (pathGroup.MyBillsEntityDataFactory == null) {
                L.getAuthRequestContext("StrokeContent#buildPath");
                this.GetContactSyncConfig.reset();
                for (int size = pathGroup.getAuthRequestContext.size() - 1; size >= 0; size--) {
                    this.GetContactSyncConfig.addPath(((PathContent) pathGroup.getAuthRequestContext.get(size)).KClassImpl$Data$declaredNonStaticMembers$2(), matrix);
                }
                L.MyBillsEntityDataFactory("StrokeContent#buildPath");
                L.getAuthRequestContext("StrokeContent#drawPath");
                canvas.drawPath(this.GetContactSyncConfig, this.PlaceComponentResult);
                L.MyBillsEntityDataFactory("StrokeContent#drawPath");
            } else {
                L.getAuthRequestContext("StrokeContent#applyTrimPath");
                if (pathGroup.MyBillsEntityDataFactory == null) {
                    L.MyBillsEntityDataFactory("StrokeContent#applyTrimPath");
                } else {
                    this.GetContactSyncConfig.reset();
                    for (int size2 = pathGroup.getAuthRequestContext.size() - 1; size2 >= 0; size2--) {
                        this.GetContactSyncConfig.addPath(((PathContent) pathGroup.getAuthRequestContext.get(size2)).KClassImpl$Data$declaredNonStaticMembers$2(), matrix);
                    }
                    float floatValue2 = pathGroup.MyBillsEntityDataFactory.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / f4;
                    float floatValue3 = pathGroup.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / f4;
                    float floatValue4 = pathGroup.MyBillsEntityDataFactory.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / 360.0f;
                    if (floatValue2 < 0.01f && floatValue3 > 0.99f) {
                        canvas.drawPath(this.GetContactSyncConfig, this.PlaceComponentResult);
                        L.MyBillsEntityDataFactory("StrokeContent#applyTrimPath");
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setPath(this.GetContactSyncConfig, z);
                        float length = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getLength();
                        while (this.NetworkUserEntityData$$ExternalSyntheticLambda2.nextContour()) {
                            length += this.NetworkUserEntityData$$ExternalSyntheticLambda2.getLength();
                        }
                        float f6 = floatValue4 * length;
                        float f7 = (floatValue2 * length) + f6;
                        float min = Math.min((floatValue3 * length) + f6, (f7 + length) - f5);
                        int size3 = pathGroup.getAuthRequestContext.size() - 1;
                        float f8 = 0.0f;
                        while (size3 >= 0) {
                            this.newProxyInstance.set(((PathContent) pathGroup.getAuthRequestContext.get(size3)).KClassImpl$Data$declaredNonStaticMembers$2());
                            this.newProxyInstance.transform(matrix);
                            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setPath(this.newProxyInstance, z);
                            float length2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getLength();
                            if (min > length) {
                                float f9 = min - length;
                                if (f9 < f8 + length2 && f8 < f9) {
                                    float f10 = f7 > length ? (f7 - length) / length2 : 0.0f;
                                    f3 = Math.min(f9 / length2, f5);
                                    f2 = f10;
                                    f = f7;
                                    Utils.getAuthRequestContext(this.newProxyInstance, f2, f3, 0.0f);
                                    canvas.drawPath(this.newProxyInstance, this.PlaceComponentResult);
                                    f8 += length2;
                                    size3--;
                                    f7 = f;
                                    f5 = 1.0f;
                                    z = false;
                                }
                            }
                            float f11 = f8 + length2;
                            if (f11 >= f7 && f8 <= min) {
                                if (f11 <= min && f7 < f8) {
                                    canvas.drawPath(this.newProxyInstance, this.PlaceComponentResult);
                                } else {
                                    f2 = f7 < f8 ? 0.0f : (f7 - f8) / length2;
                                    f3 = min > f11 ? 1.0f : (min - f8) / length2;
                                    f = f7;
                                    Utils.getAuthRequestContext(this.newProxyInstance, f2, f3, 0.0f);
                                    canvas.drawPath(this.newProxyInstance, this.PlaceComponentResult);
                                    f8 += length2;
                                    size3--;
                                    f7 = f;
                                    f5 = 1.0f;
                                    z = false;
                                }
                            }
                            f = f7;
                            f8 += length2;
                            size3--;
                            f7 = f;
                            f5 = 1.0f;
                            z = false;
                        }
                        L.MyBillsEntityDataFactory("StrokeContent#applyTrimPath");
                    }
                }
            }
            i3++;
            f4 = 100.0f;
            f5 = 1.0f;
            z = false;
        }
        L.MyBillsEntityDataFactory("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        L.getAuthRequestContext("StrokeContent#getBounds");
        this.GetContactSyncConfig.reset();
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda1.size(); i++) {
            PathGroup pathGroup = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(i);
            for (int i2 = 0; i2 < pathGroup.getAuthRequestContext.size(); i2++) {
                this.GetContactSyncConfig.addPath(((PathContent) pathGroup.getAuthRequestContext.get(i2)).KClassImpl$Data$declaredNonStaticMembers$2(), matrix);
            }
        }
        this.GetContactSyncConfig.computeBounds(this.initRecordTimeStamp, false);
        float lookAheadTest = ((FloatKeyframeAnimation) this.PrepareContext).lookAheadTest();
        RectF rectF2 = this.initRecordTimeStamp;
        float f = lookAheadTest / 2.0f;
        rectF2.set(rectF2.left - f, this.initRecordTimeStamp.top - f, this.initRecordTimeStamp.right + f, this.initRecordTimeStamp.bottom + f);
        rectF.set(this.initRecordTimeStamp);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.MyBillsEntityDataFactory("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.MyBillsEntityDataFactory(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t == LottieProperty.GetContactSyncConfig) {
            this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            this.PrepareContext.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.BuiltInFictitiousFunctionClassFactory) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (baseKeyframeAnimation != null) {
                this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer = this.MyBillsEntityDataFactory;
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (baseKeyframeAnimation2 != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        } else if (t == LottieProperty.MyBillsEntityDataFactory) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.BuiltInFictitiousFunctionClassFactory;
            if (baseKeyframeAnimation3 != null) {
                baseKeyframeAnimation3.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.BuiltInFictitiousFunctionClassFactory = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer2 = this.MyBillsEntityDataFactory;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.BuiltInFictitiousFunctionClassFactory;
            if (baseKeyframeAnimation4 != null) {
                baseLayer2.MyBillsEntityDataFactory.add(baseKeyframeAnimation4);
            }
        } else if (t != LottieProperty.PlaceComponentResult || (dropShadowKeyframeAnimation5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            if (t == LottieProperty.moveToNextValue && (dropShadowKeyframeAnimation4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
                if (lottieValueCallback == null) {
                    dropShadowKeyframeAnimation4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(null);
                } else {
                    dropShadowKeyframeAnimation4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(new DropShadowKeyframeAnimation.AnonymousClass1(lottieValueCallback));
                }
            } else if (t != LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda0 || (dropShadowKeyframeAnimation3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
                if (t != LottieProperty.lookAheadTest || (dropShadowKeyframeAnimation2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
                    if (t != LottieProperty.getErrorConfigVersion || (dropShadowKeyframeAnimation = this.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
                        return;
                    }
                    dropShadowKeyframeAnimation.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                    return;
                }
                dropShadowKeyframeAnimation2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
            } else {
                dropShadowKeyframeAnimation3.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
            }
        } else {
            dropShadowKeyframeAnimation5.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PathGroup {
        private final TrimPathContent MyBillsEntityDataFactory;
        private final List<PathContent> getAuthRequestContext;

        /* synthetic */ PathGroup(TrimPathContent trimPathContent, byte b) {
            this(trimPathContent);
        }

        private PathGroup(TrimPathContent trimPathContent) {
            this.getAuthRequestContext = new ArrayList();
            this.MyBillsEntityDataFactory = trimPathContent;
        }
    }
}
