package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    protected LottieValueCallback<A> BuiltInFictitiousFunctionClassFactory;
    private final KeyframesWrapper<K> getErrorConfigVersion;
    public final List<AnimationListener> MyBillsEntityDataFactory = new ArrayList(1);
    public boolean PlaceComponentResult = false;
    protected float getAuthRequestContext = 0.0f;
    private A moveToNextValue = null;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0 = -1.0f;
    private float KClassImpl$Data$declaredNonStaticMembers$2 = -1.0f;

    /* loaded from: classes3.dex */
    public interface AnimationListener {
        void PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface KeyframesWrapper<T> {
        float BuiltInFictitiousFunctionClassFactory();

        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        boolean MyBillsEntityDataFactory(float f);

        Keyframe<T> PlaceComponentResult();

        float getAuthRequestContext();

        boolean getAuthRequestContext(float f);
    }

    abstract A MyBillsEntityDataFactory(Keyframe<K> keyframe, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        KeyframesWrapper keyframesWrapperImpl;
        KeyframesWrapper keyframesWrapper;
        byte b = 0;
        if (list.isEmpty()) {
            keyframesWrapper = new EmptyKeyframeWrapper(b);
        } else {
            if (list.size() == 1) {
                keyframesWrapperImpl = new SingleKeyframeWrapper(list);
            } else {
                keyframesWrapperImpl = new KeyframesWrapperImpl(list);
            }
            keyframesWrapper = keyframesWrapperImpl;
        }
        this.getErrorConfigVersion = keyframesWrapper;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        if (this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == -1.0f) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory();
        }
        float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (f < f2) {
            if (f2 == -1.0f) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory();
            }
            f = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        } else if (f > PlaceComponentResult()) {
            f = PlaceComponentResult();
        }
        if (f == this.getAuthRequestContext) {
            return;
        }
        this.getAuthRequestContext = f;
        if (this.getErrorConfigVersion.MyBillsEntityDataFactory(f)) {
            getErrorConfigVersion();
        }
    }

    public void getErrorConfigVersion() {
        for (int i = 0; i < this.MyBillsEntityDataFactory.size(); i++) {
            this.MyBillsEntityDataFactory.get(i).PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Keyframe<K> BuiltInFictitiousFunctionClassFactory() {
        L.getAuthRequestContext("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> PlaceComponentResult = this.getErrorConfigVersion.PlaceComponentResult();
        L.MyBillsEntityDataFactory("BaseKeyframeAnimation#getCurrentKeyframe");
        return PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float MyBillsEntityDataFactory() {
        if (this.PlaceComponentResult) {
            return 0.0f;
        }
        L.getAuthRequestContext("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> PlaceComponentResult = this.getErrorConfigVersion.PlaceComponentResult();
        L.MyBillsEntityDataFactory("BaseKeyframeAnimation#getCurrentKeyframe");
        if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory()) {
            return 0.0f;
        }
        return (this.getAuthRequestContext - PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2()) / (PlaceComponentResult.getAuthRequestContext() - PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    float PlaceComponentResult() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == -1.0f) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getErrorConfigVersion.getAuthRequestContext();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public A NetworkUserEntityData$$ExternalSyntheticLambda0() {
        A MyBillsEntityDataFactory;
        float MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        if (this.BuiltInFictitiousFunctionClassFactory == null && this.getErrorConfigVersion.getAuthRequestContext(MyBillsEntityDataFactory2)) {
            return this.moveToNextValue;
        }
        L.getAuthRequestContext("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> PlaceComponentResult = this.getErrorConfigVersion.PlaceComponentResult();
        L.MyBillsEntityDataFactory("BaseKeyframeAnimation#getCurrentKeyframe");
        if (PlaceComponentResult.GetContactSyncConfig != null && PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
            MyBillsEntityDataFactory = getAuthRequestContext(PlaceComponentResult, MyBillsEntityDataFactory2, PlaceComponentResult.GetContactSyncConfig.getInterpolation(MyBillsEntityDataFactory2), PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1.getInterpolation(MyBillsEntityDataFactory2));
        } else {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(PlaceComponentResult, getAuthRequestContext());
        }
        this.moveToNextValue = MyBillsEntityDataFactory;
        return MyBillsEntityDataFactory;
    }

    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void BuiltInFictitiousFunctionClassFactory(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.BuiltInFictitiousFunctionClassFactory;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.lookAheadTest = null;
        }
        this.BuiltInFictitiousFunctionClassFactory = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.lookAheadTest = this;
        }
    }

    protected A getAuthRequestContext(Keyframe<K> keyframe, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    /* loaded from: classes3.dex */
    static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float BuiltInFictitiousFunctionClassFactory() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean MyBillsEntityDataFactory(float f) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getAuthRequestContext() {
            return 1.0f;
        }

        private EmptyKeyframeWrapper() {
        }

        /* synthetic */ EmptyKeyframeWrapper(byte b) {
            this();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe<T> PlaceComponentResult() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean getAuthRequestContext(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* loaded from: classes3.dex */
    static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private float BuiltInFictitiousFunctionClassFactory = -1.0f;
        private final Keyframe<T> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return false;
        }

        SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean MyBillsEntityDataFactory(float f) {
            return !this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe<T> PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean getAuthRequestContext(float f) {
            if (this.BuiltInFictitiousFunctionClassFactory == f) {
                return true;
            }
            this.BuiltInFictitiousFunctionClassFactory = f;
            return false;
        }
    }

    /* loaded from: classes3.dex */
    static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        private final List<? extends Keyframe<T>> getAuthRequestContext;
        private Keyframe<T> PlaceComponentResult = null;
        private float MyBillsEntityDataFactory = -1.0f;
        private Keyframe<T> BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(0.0f);

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return false;
        }

        KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.getAuthRequestContext = list;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean MyBillsEntityDataFactory(float f) {
            if (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(f)) {
                return !this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            }
            this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(f);
            return true;
        }

        private Keyframe<T> KClassImpl$Data$declaredNonStaticMembers$2(float f) {
            Keyframe<T> keyframe = this.getAuthRequestContext.get(r0.size() - 1);
            if (f >= keyframe.KClassImpl$Data$declaredNonStaticMembers$2()) {
                return keyframe;
            }
            for (int size = this.getAuthRequestContext.size() - 2; size > 0; size--) {
                Keyframe<T> keyframe2 = this.getAuthRequestContext.get(size);
                if (this.BuiltInFictitiousFunctionClassFactory != keyframe2 && keyframe2.KClassImpl$Data$declaredNonStaticMembers$2(f)) {
                    return keyframe2;
                }
            }
            return this.getAuthRequestContext.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe<T> PlaceComponentResult() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext.get(0).KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float getAuthRequestContext() {
            return this.getAuthRequestContext.get(r0.size() - 1).getAuthRequestContext();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean getAuthRequestContext(float f) {
            Keyframe<T> keyframe = this.PlaceComponentResult;
            Keyframe<T> keyframe2 = this.BuiltInFictitiousFunctionClassFactory;
            if (keyframe == keyframe2 && this.MyBillsEntityDataFactory == f) {
                return true;
            }
            this.PlaceComponentResult = keyframe2;
            this.MyBillsEntityDataFactory = f;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getAuthRequestContext() {
        L.getAuthRequestContext("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> PlaceComponentResult = this.getErrorConfigVersion.PlaceComponentResult();
        L.MyBillsEntityDataFactory("BaseKeyframeAnimation#getCurrentKeyframe");
        if (PlaceComponentResult == null || PlaceComponentResult.BuiltInFictitiousFunctionClassFactory()) {
            return 0.0f;
        }
        return PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.getInterpolation(MyBillsEntityDataFactory());
    }
}
