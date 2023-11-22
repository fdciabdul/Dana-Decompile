package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final BaseKeyframeAnimation<Float, Float> BuiltInFictitiousFunctionClassFactory;
    private final LottieDrawable KClassImpl$Data$declaredNonStaticMembers$2;
    private ContentGroup MyBillsEntityDataFactory;
    private final boolean PlaceComponentResult;
    private final BaseLayer getAuthRequestContext;
    private final String lookAheadTest;
    private final BaseKeyframeAnimation<Float, Float> moveToNextValue;
    private final TransformKeyframeAnimation scheduleImpl;
    private final Matrix getErrorConfigVersion = new Matrix();
    private final Path NetworkUserEntityData$$ExternalSyntheticLambda0 = new Path();

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lottieDrawable;
        this.getAuthRequestContext = baseLayer;
        this.lookAheadTest = repeater.PlaceComponentResult;
        this.PlaceComponentResult = repeater.PlaceComponentResult();
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(repeater.MyBillsEntityDataFactory.PlaceComponentResult);
        this.BuiltInFictitiousFunctionClassFactory = floatKeyframeAnimation;
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation);
        floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        FloatKeyframeAnimation floatKeyframeAnimation2 = new FloatKeyframeAnimation(repeater.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        this.moveToNextValue = floatKeyframeAnimation2;
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation2);
        floatKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(repeater.getAuthRequestContext);
        this.scheduleImpl = transformKeyframeAnimation;
        transformKeyframeAnimation.MyBillsEntityDataFactory(baseLayer);
        transformKeyframeAnimation.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public final void BuiltInFictitiousFunctionClassFactory(ListIterator<Content> listIterator) {
        if (this.MyBillsEntityDataFactory != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.MyBillsEntityDataFactory = new ContentGroup(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, "Repeater", this.PlaceComponentResult, arrayList, null);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.lookAheadTest;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(list, list2);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path KClassImpl$Data$declaredNonStaticMembers$2() {
        Path KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.reset();
        float floatValue = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
        float floatValue2 = this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.getErrorConfigVersion.set(this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(i + floatValue2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.addPath(KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion);
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
        float floatValue2 = this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
        float floatValue3 = this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / 100.0f;
        float floatValue4 = this.scheduleImpl.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.getErrorConfigVersion.set(matrix);
            float f = i2;
            this.getErrorConfigVersion.preConcat(this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(f + floatValue2));
            this.MyBillsEntityDataFactory.getAuthRequestContext(canvas, this.getErrorConfigVersion, (int) (i * MiscUtils.PlaceComponentResult(floatValue3, floatValue4, f / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.MyBillsEntityDataFactory(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        if (this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(t, lottieValueCallback)) {
            return;
        }
        if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda5) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        }
    }
}
