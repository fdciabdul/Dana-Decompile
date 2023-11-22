package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final BaseKeyframeAnimation<Integer, Integer> BuiltInFictitiousFunctionClassFactory;
    private final Paint DatabaseTableConfigUtil;
    private final Path GetContactSyncConfig;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> KClassImpl$Data$declaredNonStaticMembers$2;
    private BaseKeyframeAnimation<Float, Float> MyBillsEntityDataFactory;
    private final BaseLayer NetworkUserEntityData$$ExternalSyntheticLambda0;
    private DropShadowKeyframeAnimation PlaceComponentResult;
    float getAuthRequestContext;
    private final BaseKeyframeAnimation<Integer, Integer> getErrorConfigVersion;
    private final List<PathContent> initRecordTimeStamp;
    private final boolean lookAheadTest;
    private final LottieDrawable moveToNextValue;
    private final String scheduleImpl;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        Path path = new Path();
        this.GetContactSyncConfig = path;
        this.DatabaseTableConfigUtil = new LPaint(1);
        this.initRecordTimeStamp = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = baseLayer;
        this.scheduleImpl = shapeFill.KClassImpl$Data$declaredNonStaticMembers$2;
        this.lookAheadTest = shapeFill.PlaceComponentResult();
        this.moveToNextValue = lottieDrawable;
        if (baseLayer.BuiltInFictitiousFunctionClassFactory() != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(baseLayer.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext.PlaceComponentResult);
            this.MyBillsEntityDataFactory = floatKeyframeAnimation;
            floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.MyBillsEntityDataFactory;
            if (baseKeyframeAnimation != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation);
            }
        }
        if (baseLayer.KClassImpl$Data$declaredNonStaticMembers$2() != null) {
            this.PlaceComponentResult = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        if (shapeFill.getAuthRequestContext == null || shapeFill.PlaceComponentResult == null) {
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.getErrorConfigVersion = null;
            return;
        }
        path.setFillType(shapeFill.BuiltInFictitiousFunctionClassFactory);
        ColorKeyframeAnimation colorKeyframeAnimation = new ColorKeyframeAnimation(shapeFill.getAuthRequestContext.PlaceComponentResult);
        this.BuiltInFictitiousFunctionClassFactory = colorKeyframeAnimation;
        colorKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(colorKeyframeAnimation);
        IntegerKeyframeAnimation integerKeyframeAnimation = new IntegerKeyframeAnimation(shapeFill.PlaceComponentResult.PlaceComponentResult);
        this.getErrorConfigVersion = integerKeyframeAnimation;
        integerKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(integerKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.moveToNextValue.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.initRecordTimeStamp.add((PathContent) content);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.scheduleImpl;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        if (this.lookAheadTest) {
            return;
        }
        L.getAuthRequestContext("FillContent#draw");
        this.DatabaseTableConfigUtil.setColor((MiscUtils.getAuthRequestContext((int) ((((i / 255.0f) * this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue()) / 100.0f) * 255.0f)) << 24) | (((ColorKeyframeAnimation) this.BuiltInFictitiousFunctionClassFactory).moveToNextValue() & FlexItem.MAX_SIZE));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (baseKeyframeAnimation != null) {
            this.DatabaseTableConfigUtil.setColorFilter(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.MyBillsEntityDataFactory;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            if (floatValue == 0.0f) {
                this.DatabaseTableConfigUtil.setMaskFilter(null);
            } else if (floatValue != this.getAuthRequestContext) {
                this.DatabaseTableConfigUtil.setMaskFilter(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(floatValue));
            }
            this.getAuthRequestContext = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.PlaceComponentResult;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil);
        }
        this.GetContactSyncConfig.reset();
        for (int i2 = 0; i2 < this.initRecordTimeStamp.size(); i2++) {
            this.GetContactSyncConfig.addPath(this.initRecordTimeStamp.get(i2).KClassImpl$Data$declaredNonStaticMembers$2(), matrix);
        }
        canvas.drawPath(this.GetContactSyncConfig, this.DatabaseTableConfigUtil);
        L.MyBillsEntityDataFactory("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        this.GetContactSyncConfig.reset();
        for (int i = 0; i < this.initRecordTimeStamp.size(); i++) {
            this.GetContactSyncConfig.addPath(this.initRecordTimeStamp.get(i).KClassImpl$Data$declaredNonStaticMembers$2(), matrix);
        }
        this.GetContactSyncConfig.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.MyBillsEntityDataFactory(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t == LottieProperty.getAuthRequestContext) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.GetContactSyncConfig) {
            this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.BuiltInFictitiousFunctionClassFactory) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (baseKeyframeAnimation != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (baseKeyframeAnimation2 != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        } else if (t == LottieProperty.MyBillsEntityDataFactory) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.MyBillsEntityDataFactory;
            if (baseKeyframeAnimation3 != null) {
                baseKeyframeAnimation3.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.MyBillsEntityDataFactory = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.MyBillsEntityDataFactory;
            if (baseKeyframeAnimation4 != null) {
                baseLayer2.MyBillsEntityDataFactory.add(baseKeyframeAnimation4);
            }
        } else if (t != LottieProperty.PlaceComponentResult || (dropShadowKeyframeAnimation5 = this.PlaceComponentResult) == null) {
            if (t == LottieProperty.moveToNextValue && (dropShadowKeyframeAnimation4 = this.PlaceComponentResult) != null) {
                if (lottieValueCallback == null) {
                    dropShadowKeyframeAnimation4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(null);
                } else {
                    dropShadowKeyframeAnimation4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(new DropShadowKeyframeAnimation.AnonymousClass1(lottieValueCallback));
                }
            } else if (t != LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda0 || (dropShadowKeyframeAnimation3 = this.PlaceComponentResult) == null) {
                if (t != LottieProperty.lookAheadTest || (dropShadowKeyframeAnimation2 = this.PlaceComponentResult) == null) {
                    if (t != LottieProperty.getErrorConfigVersion || (dropShadowKeyframeAnimation = this.PlaceComponentResult) == null) {
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
}
