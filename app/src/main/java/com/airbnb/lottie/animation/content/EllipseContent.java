package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final CircleShape BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean PlaceComponentResult;
    private final LottieDrawable getAuthRequestContext;
    private final BaseKeyframeAnimation<?, PointF> getErrorConfigVersion;
    private final BaseKeyframeAnimation<?, PointF> moveToNextValue;
    private final Path MyBillsEntityDataFactory = new Path();
    private final CompoundTrimPathContent scheduleImpl = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleShape.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getAuthRequestContext = lottieDrawable;
        PointKeyframeAnimation pointKeyframeAnimation = new PointKeyframeAnimation(circleShape.PlaceComponentResult.PlaceComponentResult);
        this.moveToNextValue = pointKeyframeAnimation;
        BaseKeyframeAnimation<PointF, PointF> MyBillsEntityDataFactory = circleShape.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        this.getErrorConfigVersion = MyBillsEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = circleShape;
        baseLayer.MyBillsEntityDataFactory.add(pointKeyframeAnimation);
        baseLayer.MyBillsEntityDataFactory.add(MyBillsEntityDataFactory);
        pointKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        MyBillsEntityDataFactory.MyBillsEntityDataFactory.add(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.BuiltInFictitiousFunctionClassFactory == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.add(trimPathContent);
                    trimPathContent.PlaceComponentResult.add(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.PlaceComponentResult) {
            return this.MyBillsEntityDataFactory;
        }
        this.MyBillsEntityDataFactory.reset();
        if (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) {
            this.PlaceComponentResult = true;
            return this.MyBillsEntityDataFactory;
        }
        PointF NetworkUserEntityData$$ExternalSyntheticLambda0 = this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0();
        float f = NetworkUserEntityData$$ExternalSyntheticLambda0.x / 2.0f;
        float f2 = NetworkUserEntityData$$ExternalSyntheticLambda0.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.MyBillsEntityDataFactory.reset();
        if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()) {
            float f5 = -f2;
            this.MyBillsEntityDataFactory.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.MyBillsEntityDataFactory.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.MyBillsEntityDataFactory.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.MyBillsEntityDataFactory.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.MyBillsEntityDataFactory.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.MyBillsEntityDataFactory.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.MyBillsEntityDataFactory.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.MyBillsEntityDataFactory.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.MyBillsEntityDataFactory.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.MyBillsEntityDataFactory.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF NetworkUserEntityData$$ExternalSyntheticLambda02 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0();
        this.MyBillsEntityDataFactory.offset(NetworkUserEntityData$$ExternalSyntheticLambda02.x, NetworkUserEntityData$$ExternalSyntheticLambda02.y);
        this.MyBillsEntityDataFactory.close();
        this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
        this.PlaceComponentResult = true;
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.MyBillsEntityDataFactory(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.scheduleImpl) {
            this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.PlaceComponentResult = false;
        this.getAuthRequestContext.invalidateSelf();
    }
}
