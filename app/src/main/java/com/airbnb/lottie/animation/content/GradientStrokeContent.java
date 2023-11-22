package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    private final int BuiltInFictitiousFunctionClassFactory;
    private final BaseKeyframeAnimation<PointF, PointF> DatabaseTableConfigUtil;
    private final LongSparseArray<RadialGradient> GetContactSyncConfig;
    private final RectF KClassImpl$Data$declaredNonStaticMembers$2;
    private final LongSparseArray<LinearGradient> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GradientType NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final BaseKeyframeAnimation<PointF, PointF> getErrorConfigVersion;
    private final String initRecordTimeStamp;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> lookAheadTest;
    private ValueCallbackKeyframeAnimation moveToNextValue;
    private final boolean scheduleImpl;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        RadialGradient MyBillsEntityDataFactory;
        if (this.scheduleImpl) {
            return;
        }
        getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, matrix, false);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == GradientType.LINEAR) {
            long MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
            MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory(MyBillsEntityDataFactory2, null);
            if (MyBillsEntityDataFactory == null) {
                PointF NetworkUserEntityData$$ExternalSyntheticLambda0 = this.DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda0();
                PointF NetworkUserEntityData$$ExternalSyntheticLambda02 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0();
                GradientColor NetworkUserEntityData$$ExternalSyntheticLambda03 = this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0();
                MyBillsEntityDataFactory = new LinearGradient(NetworkUserEntityData$$ExternalSyntheticLambda0.x, NetworkUserEntityData$$ExternalSyntheticLambda0.y, NetworkUserEntityData$$ExternalSyntheticLambda02.x, NetworkUserEntityData$$ExternalSyntheticLambda02.y, MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda03.BuiltInFictitiousFunctionClassFactory), NetworkUserEntityData$$ExternalSyntheticLambda03.getAuthRequestContext, Shader.TileMode.CLAMP);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(MyBillsEntityDataFactory2, MyBillsEntityDataFactory);
            }
        } else {
            long MyBillsEntityDataFactory3 = MyBillsEntityDataFactory();
            MyBillsEntityDataFactory = this.GetContactSyncConfig.MyBillsEntityDataFactory(MyBillsEntityDataFactory3, null);
            if (MyBillsEntityDataFactory == null) {
                PointF NetworkUserEntityData$$ExternalSyntheticLambda04 = this.DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda0();
                PointF NetworkUserEntityData$$ExternalSyntheticLambda05 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0();
                GradientColor NetworkUserEntityData$$ExternalSyntheticLambda06 = this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0();
                int[] MyBillsEntityDataFactory4 = MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda06.BuiltInFictitiousFunctionClassFactory);
                float[] fArr = NetworkUserEntityData$$ExternalSyntheticLambda06.getAuthRequestContext;
                MyBillsEntityDataFactory = new RadialGradient(NetworkUserEntityData$$ExternalSyntheticLambda04.x, NetworkUserEntityData$$ExternalSyntheticLambda04.y, (float) Math.hypot(NetworkUserEntityData$$ExternalSyntheticLambda05.x - r9, NetworkUserEntityData$$ExternalSyntheticLambda05.y - r10), MyBillsEntityDataFactory4, fArr, Shader.TileMode.CLAMP);
                this.GetContactSyncConfig.getAuthRequestContext(MyBillsEntityDataFactory3, MyBillsEntityDataFactory);
            }
        }
        MyBillsEntityDataFactory.setLocalMatrix(matrix);
        this.PlaceComponentResult.setShader(MyBillsEntityDataFactory);
        super.getAuthRequestContext(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.initRecordTimeStamp;
    }

    private int MyBillsEntityDataFactory() {
        int round = Math.round(this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2() * this.BuiltInFictitiousFunctionClassFactory);
        int round2 = Math.round(this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2() * this.BuiltInFictitiousFunctionClassFactory);
        int round3 = Math.round(this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2() * this.BuiltInFictitiousFunctionClassFactory);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private int[] MyBillsEntityDataFactory(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.moveToNextValue;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        super.PlaceComponentResult(t, lottieValueCallback);
        if (t == LottieProperty.DatabaseTableConfigUtil) {
            if (this.moveToNextValue != null) {
                BaseLayer baseLayer = this.MyBillsEntityDataFactory;
                baseLayer.MyBillsEntityDataFactory.remove(this.moveToNextValue);
            }
            if (lottieValueCallback == null) {
                this.moveToNextValue = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.moveToNextValue = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer2 = this.MyBillsEntityDataFactory;
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.moveToNextValue;
            if (valueCallbackKeyframeAnimation2 != null) {
                baseLayer2.MyBillsEntityDataFactory.add(valueCallbackKeyframeAnimation2);
            }
        }
    }

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.MyBillsEntityDataFactory.toPaintCap(), gradientStroke.NetworkUserEntityData$$ExternalSyntheticLambda0.toPaintJoin(), gradientStroke.scheduleImpl, gradientStroke.moveToNextValue, gradientStroke.GetContactSyncConfig, gradientStroke.getErrorConfigVersion, gradientStroke.KClassImpl$Data$declaredNonStaticMembers$2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LongSparseArray<>();
        this.GetContactSyncConfig = new LongSparseArray<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RectF();
        this.initRecordTimeStamp = gradientStroke.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = gradientStroke.BuiltInFictitiousFunctionClassFactory;
        this.scheduleImpl = gradientStroke.BuiltInFictitiousFunctionClassFactory();
        LottieComposition lottieComposition = lottieDrawable.getAuthRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = (int) ((((lottieComposition.MyBillsEntityDataFactory - lottieComposition.DatabaseTableConfigUtil) / lottieComposition.PlaceComponentResult) * 1000.0f) / 32.0f);
        GradientColorKeyframeAnimation gradientColorKeyframeAnimation = new GradientColorKeyframeAnimation(gradientStroke.getAuthRequestContext.PlaceComponentResult);
        this.lookAheadTest = gradientColorKeyframeAnimation;
        gradientColorKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(gradientColorKeyframeAnimation);
        PointKeyframeAnimation pointKeyframeAnimation = new PointKeyframeAnimation(gradientStroke.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult);
        this.DatabaseTableConfigUtil = pointKeyframeAnimation;
        pointKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(pointKeyframeAnimation);
        PointKeyframeAnimation pointKeyframeAnimation2 = new PointKeyframeAnimation(gradientStroke.PlaceComponentResult.PlaceComponentResult);
        this.getErrorConfigVersion = pointKeyframeAnimation2;
        pointKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(pointKeyframeAnimation2);
    }
}
