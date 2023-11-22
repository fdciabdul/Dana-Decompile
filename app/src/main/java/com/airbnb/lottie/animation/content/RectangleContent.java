package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    private final BaseKeyframeAnimation<?, PointF> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LottieDrawable PlaceComponentResult;
    private final BaseKeyframeAnimation<?, Float> getAuthRequestContext;
    private final BaseKeyframeAnimation<?, PointF> getErrorConfigVersion;
    private final Path moveToNextValue = new Path();
    private final RectF scheduleImpl = new RectF();
    private final CompoundTrimPathContent GetContactSyncConfig = new CompoundTrimPathContent();
    private BaseKeyframeAnimation<Float, Float> lookAheadTest = null;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = rectangleShape.KClassImpl$Data$declaredNonStaticMembers$2;
        this.MyBillsEntityDataFactory = rectangleShape.MyBillsEntityDataFactory();
        this.PlaceComponentResult = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> MyBillsEntityDataFactory = rectangleShape.getAuthRequestContext.MyBillsEntityDataFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory;
        BaseKeyframeAnimation<PointF, PointF> MyBillsEntityDataFactory2 = rectangleShape.PlaceComponentResult.MyBillsEntityDataFactory();
        this.getErrorConfigVersion = MyBillsEntityDataFactory2;
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(rectangleShape.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
        this.getAuthRequestContext = floatKeyframeAnimation;
        baseLayer.MyBillsEntityDataFactory.add(MyBillsEntityDataFactory);
        baseLayer.MyBillsEntityDataFactory.add(MyBillsEntityDataFactory2);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation);
        MyBillsEntityDataFactory.MyBillsEntityDataFactory.add(this);
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory.add(this);
        floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.BuiltInFictitiousFunctionClassFactory == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory.add(trimPathContent);
                    trimPathContent.PlaceComponentResult.add(this);
                }
            }
            if (content instanceof RoundedCornersContent) {
                this.lookAheadTest = ((RoundedCornersContent) content).BuiltInFictitiousFunctionClassFactory;
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return this.moveToNextValue;
        }
        this.moveToNextValue.reset();
        if (this.MyBillsEntityDataFactory) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            return this.moveToNextValue;
        }
        PointF NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0();
        float f = NetworkUserEntityData$$ExternalSyntheticLambda0.x / 2.0f;
        float f2 = NetworkUserEntityData$$ExternalSyntheticLambda0.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.getAuthRequestContext;
        float lookAheadTest = baseKeyframeAnimation2 == null ? 0.0f : ((FloatKeyframeAnimation) baseKeyframeAnimation2).lookAheadTest();
        if (lookAheadTest == 0.0f && (baseKeyframeAnimation = this.lookAheadTest) != null) {
            lookAheadTest = Math.min(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue(), Math.min(f, f2));
        }
        float min = Math.min(f, f2);
        if (lookAheadTest > min) {
            lookAheadTest = min;
        }
        PointF NetworkUserEntityData$$ExternalSyntheticLambda02 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda0();
        this.moveToNextValue.moveTo(NetworkUserEntityData$$ExternalSyntheticLambda02.x + f, (NetworkUserEntityData$$ExternalSyntheticLambda02.y - f2) + lookAheadTest);
        this.moveToNextValue.lineTo(NetworkUserEntityData$$ExternalSyntheticLambda02.x + f, (NetworkUserEntityData$$ExternalSyntheticLambda02.y + f2) - lookAheadTest);
        if (lookAheadTest > 0.0f) {
            float f3 = lookAheadTest * 2.0f;
            this.scheduleImpl.set((NetworkUserEntityData$$ExternalSyntheticLambda02.x + f) - f3, (NetworkUserEntityData$$ExternalSyntheticLambda02.y + f2) - f3, NetworkUserEntityData$$ExternalSyntheticLambda02.x + f, NetworkUserEntityData$$ExternalSyntheticLambda02.y + f2);
            this.moveToNextValue.arcTo(this.scheduleImpl, 0.0f, 90.0f, false);
        }
        this.moveToNextValue.lineTo((NetworkUserEntityData$$ExternalSyntheticLambda02.x - f) + lookAheadTest, NetworkUserEntityData$$ExternalSyntheticLambda02.y + f2);
        if (lookAheadTest > 0.0f) {
            float f4 = lookAheadTest * 2.0f;
            this.scheduleImpl.set(NetworkUserEntityData$$ExternalSyntheticLambda02.x - f, (NetworkUserEntityData$$ExternalSyntheticLambda02.y + f2) - f4, (NetworkUserEntityData$$ExternalSyntheticLambda02.x - f) + f4, NetworkUserEntityData$$ExternalSyntheticLambda02.y + f2);
            this.moveToNextValue.arcTo(this.scheduleImpl, 90.0f, 90.0f, false);
        }
        this.moveToNextValue.lineTo(NetworkUserEntityData$$ExternalSyntheticLambda02.x - f, (NetworkUserEntityData$$ExternalSyntheticLambda02.y - f2) + lookAheadTest);
        if (lookAheadTest > 0.0f) {
            float f5 = lookAheadTest * 2.0f;
            this.scheduleImpl.set(NetworkUserEntityData$$ExternalSyntheticLambda02.x - f, NetworkUserEntityData$$ExternalSyntheticLambda02.y - f2, (NetworkUserEntityData$$ExternalSyntheticLambda02.x - f) + f5, (NetworkUserEntityData$$ExternalSyntheticLambda02.y - f2) + f5);
            this.moveToNextValue.arcTo(this.scheduleImpl, 180.0f, 90.0f, false);
        }
        this.moveToNextValue.lineTo((NetworkUserEntityData$$ExternalSyntheticLambda02.x + f) - lookAheadTest, NetworkUserEntityData$$ExternalSyntheticLambda02.y - f2);
        if (lookAheadTest > 0.0f) {
            float f6 = lookAheadTest * 2.0f;
            this.scheduleImpl.set((NetworkUserEntityData$$ExternalSyntheticLambda02.x + f) - f6, NetworkUserEntityData$$ExternalSyntheticLambda02.y - f2, NetworkUserEntityData$$ExternalSyntheticLambda02.x + f, (NetworkUserEntityData$$ExternalSyntheticLambda02.y - f2) + f6);
            this.moveToNextValue.arcTo(this.scheduleImpl, 270.0f, 90.0f, false);
        }
        this.moveToNextValue.close();
        this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue);
        this.BuiltInFictitiousFunctionClassFactory = true;
        return this.moveToNextValue;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.MyBillsEntityDataFactory(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.PlaceComponentResult.invalidateSelf();
    }
}
