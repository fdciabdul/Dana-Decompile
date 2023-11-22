package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes3.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final A KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final float PlaceComponentResult() {
        return 1.0f;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, A a2) {
        super(Collections.emptyList());
        BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = a2;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        this.getAuthRequestContext = f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final void getErrorConfigVersion() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            super.getErrorConfigVersion();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final A NetworkUserEntityData$$ExternalSyntheticLambda0() {
        LottieValueCallback<A> lottieValueCallback = this.BuiltInFictitiousFunctionClassFactory;
        A a2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(0.0f, 0.0f, a2, a2, KClassImpl$Data$declaredNonStaticMembers$2(), KClassImpl$Data$declaredNonStaticMembers$2(), KClassImpl$Data$declaredNonStaticMembers$2()));
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final A MyBillsEntityDataFactory(Keyframe<K> keyframe, float f) {
        return NetworkUserEntityData$$ExternalSyntheticLambda0();
    }
}
