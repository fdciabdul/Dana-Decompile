package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* loaded from: classes3.dex */
public class TransformKeyframeAnimation {
    public BaseKeyframeAnimation<?, PointF> BuiltInFictitiousFunctionClassFactory;
    private final float[] DatabaseTableConfigUtil;
    private final Matrix GetContactSyncConfig;
    public BaseKeyframeAnimation<PointF, PointF> KClassImpl$Data$declaredNonStaticMembers$2;
    public BaseKeyframeAnimation<Integer, Integer> MyBillsEntityDataFactory;
    public BaseKeyframeAnimation<?, Float> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Matrix NetworkUserEntityData$$ExternalSyntheticLambda1;
    public BaseKeyframeAnimation<?, Float> PlaceComponentResult;
    public BaseKeyframeAnimation<Float, Float> getAuthRequestContext;
    public FloatKeyframeAnimation getErrorConfigVersion;
    private final Matrix initRecordTimeStamp;
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> lookAheadTest;
    public FloatKeyframeAnimation moveToNextValue;
    private final Matrix scheduleImpl = new Matrix();

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableTransform.MyBillsEntityDataFactory == null ? null : animatableTransform.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory = animatableTransform.PlaceComponentResult == null ? null : animatableTransform.PlaceComponentResult.MyBillsEntityDataFactory();
        this.lookAheadTest = animatableTransform.getErrorConfigVersion == null ? null : new ScaleKeyframeAnimation(animatableTransform.getErrorConfigVersion.PlaceComponentResult);
        this.getAuthRequestContext = animatableTransform.KClassImpl$Data$declaredNonStaticMembers$2 == null ? null : new FloatKeyframeAnimation(animatableTransform.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.lookAheadTest == null ? null : new FloatKeyframeAnimation(animatableTransform.lookAheadTest.PlaceComponentResult);
        this.moveToNextValue = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.GetContactSyncConfig = new Matrix();
            this.initRecordTimeStamp = new Matrix();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Matrix();
            this.DatabaseTableConfigUtil = new float[9];
        } else {
            this.GetContactSyncConfig = null;
            this.initRecordTimeStamp = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
            this.DatabaseTableConfigUtil = null;
        }
        this.getErrorConfigVersion = animatableTransform.NetworkUserEntityData$$ExternalSyntheticLambda0 == null ? null : new FloatKeyframeAnimation(animatableTransform.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult);
        if (animatableTransform.getAuthRequestContext != null) {
            this.MyBillsEntityDataFactory = new IntegerKeyframeAnimation(animatableTransform.getAuthRequestContext.PlaceComponentResult);
        }
        if (animatableTransform.scheduleImpl != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new FloatKeyframeAnimation(animatableTransform.scheduleImpl.PlaceComponentResult);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        }
        if (animatableTransform.BuiltInFictitiousFunctionClassFactory != null) {
            this.PlaceComponentResult = new FloatKeyframeAnimation(animatableTransform.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
        } else {
            this.PlaceComponentResult = null;
        }
    }

    public final void MyBillsEntityDataFactory(BaseLayer baseLayer) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.MyBillsEntityDataFactory;
        if (baseKeyframeAnimation != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseKeyframeAnimation2 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.PlaceComponentResult;
        if (baseKeyframeAnimation3 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation3);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (baseKeyframeAnimation4 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation4);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.BuiltInFictitiousFunctionClassFactory;
        if (baseKeyframeAnimation5 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation5);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.lookAheadTest;
        if (baseKeyframeAnimation6 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation6);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.getAuthRequestContext;
        if (baseKeyframeAnimation7 != null) {
            baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation7);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.moveToNextValue;
        if (floatKeyframeAnimation != null) {
            baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.getErrorConfigVersion;
        if (floatKeyframeAnimation2 != null) {
            baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation2);
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.MyBillsEntityDataFactory;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.MyBillsEntityDataFactory.add(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.MyBillsEntityDataFactory.add(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.PlaceComponentResult;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.MyBillsEntityDataFactory.add(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.MyBillsEntityDataFactory.add(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.BuiltInFictitiousFunctionClassFactory;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.MyBillsEntityDataFactory.add(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.lookAheadTest;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.MyBillsEntityDataFactory.add(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.getAuthRequestContext;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.MyBillsEntityDataFactory.add(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.moveToNextValue;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.MyBillsEntityDataFactory.add(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.getErrorConfigVersion;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.MyBillsEntityDataFactory.add(animationListener);
        }
    }

    public final Matrix PlaceComponentResult() {
        float lookAheadTest;
        PointF NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.scheduleImpl.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.BuiltInFictitiousFunctionClassFactory;
        if (baseKeyframeAnimation != null && (NetworkUserEntityData$$ExternalSyntheticLambda0 = baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0()) != null && (NetworkUserEntityData$$ExternalSyntheticLambda0.x != 0.0f || NetworkUserEntityData$$ExternalSyntheticLambda0.y != 0.0f)) {
            this.scheduleImpl.preTranslate(NetworkUserEntityData$$ExternalSyntheticLambda0.x, NetworkUserEntityData$$ExternalSyntheticLambda0.y);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.getAuthRequestContext;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                lookAheadTest = baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            } else {
                lookAheadTest = ((FloatKeyframeAnimation) baseKeyframeAnimation2).lookAheadTest();
            }
            if (lookAheadTest != 0.0f) {
                this.scheduleImpl.preRotate(lookAheadTest);
            }
        }
        if (this.moveToNextValue != null) {
            float cos = this.getErrorConfigVersion == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.lookAheadTest()) + 90.0f));
            float sin = this.getErrorConfigVersion == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.lookAheadTest()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.lookAheadTest()));
            for (int i = 0; i < 9; i++) {
                this.DatabaseTableConfigUtil[i] = 0.0f;
            }
            float[] fArr = this.DatabaseTableConfigUtil;
            fArr[0] = cos;
            fArr[1] = sin;
            float f = -sin;
            fArr[3] = f;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.GetContactSyncConfig.setValues(fArr);
            for (int i2 = 0; i2 < 9; i2++) {
                this.DatabaseTableConfigUtil[i2] = 0.0f;
            }
            float[] fArr2 = this.DatabaseTableConfigUtil;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.initRecordTimeStamp.setValues(fArr2);
            for (int i3 = 0; i3 < 9; i3++) {
                this.DatabaseTableConfigUtil[i3] = 0.0f;
            }
            float[] fArr3 = this.DatabaseTableConfigUtil;
            fArr3[0] = cos;
            fArr3[1] = f;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setValues(fArr3);
            this.initRecordTimeStamp.preConcat(this.GetContactSyncConfig);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.preConcat(this.initRecordTimeStamp);
            this.scheduleImpl.preConcat(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.lookAheadTest;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY NetworkUserEntityData$$ExternalSyntheticLambda02 = baseKeyframeAnimation3.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda02.KClassImpl$Data$declaredNonStaticMembers$2 != 1.0f || NetworkUserEntityData$$ExternalSyntheticLambda02.MyBillsEntityDataFactory != 1.0f) {
                this.scheduleImpl.preScale(NetworkUserEntityData$$ExternalSyntheticLambda02.KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda02.MyBillsEntityDataFactory);
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (baseKeyframeAnimation4 != null) {
            PointF NetworkUserEntityData$$ExternalSyntheticLambda03 = baseKeyframeAnimation4.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda03.x != 0.0f || NetworkUserEntityData$$ExternalSyntheticLambda03.y != 0.0f) {
                this.scheduleImpl.preTranslate(-NetworkUserEntityData$$ExternalSyntheticLambda03.x, -NetworkUserEntityData$$ExternalSyntheticLambda03.y);
            }
        }
        return this.scheduleImpl;
    }

    public final Matrix KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.BuiltInFictitiousFunctionClassFactory;
        PointF NetworkUserEntityData$$ExternalSyntheticLambda0 = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.lookAheadTest;
        ScaleXY NetworkUserEntityData$$ExternalSyntheticLambda02 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0();
        this.scheduleImpl.reset();
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            this.scheduleImpl.preTranslate(NetworkUserEntityData$$ExternalSyntheticLambda0.x * f, NetworkUserEntityData$$ExternalSyntheticLambda0.y * f);
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda02 != null) {
            double d = f;
            this.scheduleImpl.preScale((float) Math.pow(NetworkUserEntityData$$ExternalSyntheticLambda02.KClassImpl$Data$declaredNonStaticMembers$2, d), (float) Math.pow(NetworkUserEntityData$$ExternalSyntheticLambda02.MyBillsEntityDataFactory, d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.getAuthRequestContext;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PointF NetworkUserEntityData$$ExternalSyntheticLambda03 = baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.NetworkUserEntityData$$ExternalSyntheticLambda0() : null;
            this.scheduleImpl.preRotate(floatValue * f, NetworkUserEntityData$$ExternalSyntheticLambda03 == null ? 0.0f : NetworkUserEntityData$$ExternalSyntheticLambda03.x, NetworkUserEntityData$$ExternalSyntheticLambda03 != null ? NetworkUserEntityData$$ExternalSyntheticLambda03.y : 0.0f);
        }
        return this.scheduleImpl;
    }

    public final <T> boolean BuiltInFictitiousFunctionClassFactory(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.whenAvailable) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (baseKeyframeAnimation == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.A) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.BuiltInFictitiousFunctionClassFactory;
            if (baseKeyframeAnimation2 == null) {
                this.BuiltInFictitiousFunctionClassFactory = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation2.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
            return true;
        } else {
            if (t == LottieProperty.C) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = this.BuiltInFictitiousFunctionClassFactory;
                if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3).getAuthRequestContext(lottieValueCallback);
                    return true;
                }
            }
            if (t == LottieProperty.BottomSheetCardBindingView$watcherCardNumberView$1) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.BuiltInFictitiousFunctionClassFactory;
                if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4).MyBillsEntityDataFactory(lottieValueCallback);
                    return true;
                }
            }
            if (t == LottieProperty.getOnBoardingScenario) {
                BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.lookAheadTest;
                if (baseKeyframeAnimation5 == null) {
                    this.lookAheadTest = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                    return true;
                }
                baseKeyframeAnimation5.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return true;
            } else if (t == LottieProperty.VerifyPinStateManager$executeRiskChallenge$2$2) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.getAuthRequestContext;
                if (baseKeyframeAnimation6 == null) {
                    this.getAuthRequestContext = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                    return true;
                }
                baseKeyframeAnimation6.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return true;
            } else if (t == LottieProperty.B) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.MyBillsEntityDataFactory;
                if (baseKeyframeAnimation7 == null) {
                    this.MyBillsEntityDataFactory = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                    return true;
                }
                baseKeyframeAnimation7.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return true;
            } else if (t == LottieProperty.getValueOfTouchPositionAbsolute) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation8 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (baseKeyframeAnimation8 == null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                    return true;
                }
                baseKeyframeAnimation8.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return true;
            } else if (t == LottieProperty.VerifyPinStateManager$executeRiskChallenge$2$1) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation9 = this.PlaceComponentResult;
                if (baseKeyframeAnimation9 == null) {
                    this.PlaceComponentResult = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                    return true;
                }
                baseKeyframeAnimation9.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return true;
            } else if (t == LottieProperty.E) {
                if (this.moveToNextValue == null) {
                    this.moveToNextValue = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return true;
            } else if (t == LottieProperty.D) {
                if (this.getErrorConfigVersion == null) {
                    this.getErrorConfigVersion = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return true;
            } else {
                return false;
            }
        }
    }
}
