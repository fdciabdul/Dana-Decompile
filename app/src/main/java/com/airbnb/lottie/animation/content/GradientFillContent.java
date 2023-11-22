package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final RectF BuiltInFictitiousFunctionClassFactory;
    private final BaseLayer DatabaseTableConfigUtil;
    private final BaseKeyframeAnimation<Integer, Integer> GetContactSyncConfig;
    float KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private final BaseKeyframeAnimation<PointF, PointF> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LottieDrawable NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final GradientType NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final BaseKeyframeAnimation<PointF, PointF> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final List<PathContent> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> PlaceComponentResult;
    private BaseKeyframeAnimation<Float, Float> getAuthRequestContext;
    private ValueCallbackKeyframeAnimation getErrorConfigVersion;
    private final String initRecordTimeStamp;
    private final Paint isLayoutRequested;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> lookAheadTest;
    private final boolean moveToNextValue;
    private final Path newProxyInstance;
    private DropShadowKeyframeAnimation scheduleImpl;
    private final LongSparseArray<LinearGradient> NetworkUserEntityData$$ExternalSyntheticLambda2 = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> PrepareContext = new LongSparseArray<>();

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        Path path = new Path();
        this.newProxyInstance = path;
        this.isLayoutRequested = new LPaint(1);
        this.BuiltInFictitiousFunctionClassFactory = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.DatabaseTableConfigUtil = baseLayer;
        this.initRecordTimeStamp = gradientFill.PlaceComponentResult;
        this.moveToNextValue = gradientFill.KClassImpl$Data$declaredNonStaticMembers$2();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lottieDrawable;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = gradientFill.MyBillsEntityDataFactory;
        path.setFillType(gradientFill.getAuthRequestContext);
        LottieComposition lottieComposition = lottieDrawable.getAuthRequestContext;
        this.MyBillsEntityDataFactory = (int) ((((lottieComposition.MyBillsEntityDataFactory - lottieComposition.DatabaseTableConfigUtil) / lottieComposition.PlaceComponentResult) * 1000.0f) / 32.0f);
        GradientColorKeyframeAnimation gradientColorKeyframeAnimation = new GradientColorKeyframeAnimation(gradientFill.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        this.PlaceComponentResult = gradientColorKeyframeAnimation;
        gradientColorKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(gradientColorKeyframeAnimation);
        IntegerKeyframeAnimation integerKeyframeAnimation = new IntegerKeyframeAnimation(gradientFill.getErrorConfigVersion.PlaceComponentResult);
        this.GetContactSyncConfig = integerKeyframeAnimation;
        integerKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(integerKeyframeAnimation);
        PointKeyframeAnimation pointKeyframeAnimation = new PointKeyframeAnimation(gradientFill.lookAheadTest.PlaceComponentResult);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = pointKeyframeAnimation;
        pointKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(pointKeyframeAnimation);
        PointKeyframeAnimation pointKeyframeAnimation2 = new PointKeyframeAnimation(gradientFill.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pointKeyframeAnimation2;
        pointKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(pointKeyframeAnimation2);
        if (baseLayer.BuiltInFictitiousFunctionClassFactory() != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(baseLayer.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext.PlaceComponentResult);
            this.getAuthRequestContext = floatKeyframeAnimation;
            floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.getAuthRequestContext;
            if (baseKeyframeAnimation != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation);
            }
        }
        if (baseLayer.KClassImpl$Data$declaredNonStaticMembers$2() != null) {
            this.scheduleImpl = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.add((PathContent) content);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        RadialGradient MyBillsEntityDataFactory;
        if (this.moveToNextValue) {
            return;
        }
        L.getAuthRequestContext("GradientFillContent#draw");
        this.newProxyInstance.reset();
        for (int i2 = 0; i2 < this.NetworkUserEntityData$$ExternalSyntheticLambda8.size(); i2++) {
            this.newProxyInstance.addPath(this.NetworkUserEntityData$$ExternalSyntheticLambda8.get(i2).KClassImpl$Data$declaredNonStaticMembers$2(), matrix);
        }
        this.newProxyInstance.computeBounds(this.BuiltInFictitiousFunctionClassFactory, false);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == GradientType.LINEAR) {
            long MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
            MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory(MyBillsEntityDataFactory2, null);
            if (MyBillsEntityDataFactory == null) {
                PointF NetworkUserEntityData$$ExternalSyntheticLambda0 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0();
                PointF NetworkUserEntityData$$ExternalSyntheticLambda02 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda0();
                GradientColor NetworkUserEntityData$$ExternalSyntheticLambda03 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0();
                LinearGradient linearGradient = new LinearGradient(NetworkUserEntityData$$ExternalSyntheticLambda0.x, NetworkUserEntityData$$ExternalSyntheticLambda0.y, NetworkUserEntityData$$ExternalSyntheticLambda02.x, NetworkUserEntityData$$ExternalSyntheticLambda02.y, MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda03.BuiltInFictitiousFunctionClassFactory), NetworkUserEntityData$$ExternalSyntheticLambda03.getAuthRequestContext, Shader.TileMode.CLAMP);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(MyBillsEntityDataFactory2, linearGradient);
                MyBillsEntityDataFactory = linearGradient;
            }
        } else {
            long MyBillsEntityDataFactory3 = MyBillsEntityDataFactory();
            MyBillsEntityDataFactory = this.PrepareContext.MyBillsEntityDataFactory(MyBillsEntityDataFactory3, null);
            if (MyBillsEntityDataFactory == null) {
                PointF NetworkUserEntityData$$ExternalSyntheticLambda04 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0();
                PointF NetworkUserEntityData$$ExternalSyntheticLambda05 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda0();
                GradientColor NetworkUserEntityData$$ExternalSyntheticLambda06 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0();
                int[] MyBillsEntityDataFactory4 = MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda06.BuiltInFictitiousFunctionClassFactory);
                float[] fArr = NetworkUserEntityData$$ExternalSyntheticLambda06.getAuthRequestContext;
                float f = NetworkUserEntityData$$ExternalSyntheticLambda04.x;
                float f2 = NetworkUserEntityData$$ExternalSyntheticLambda04.y;
                float hypot = (float) Math.hypot(NetworkUserEntityData$$ExternalSyntheticLambda05.x - f, NetworkUserEntityData$$ExternalSyntheticLambda05.y - f2);
                MyBillsEntityDataFactory = new RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, MyBillsEntityDataFactory4, fArr, Shader.TileMode.CLAMP);
                this.PrepareContext.getAuthRequestContext(MyBillsEntityDataFactory3, MyBillsEntityDataFactory);
            }
        }
        MyBillsEntityDataFactory.setLocalMatrix(matrix);
        this.isLayoutRequested.setShader(MyBillsEntityDataFactory);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.lookAheadTest;
        if (baseKeyframeAnimation != null) {
            this.isLayoutRequested.setColorFilter(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.getAuthRequestContext;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            if (floatValue == 0.0f) {
                this.isLayoutRequested.setMaskFilter(null);
            } else if (floatValue != this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.isLayoutRequested.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.scheduleImpl;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested);
        }
        this.isLayoutRequested.setAlpha(MiscUtils.getAuthRequestContext((int) ((((i / 255.0f) * this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue()) / 100.0f) * 255.0f)));
        canvas.drawPath(this.newProxyInstance, this.isLayoutRequested);
        L.MyBillsEntityDataFactory("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        this.newProxyInstance.reset();
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda8.size(); i++) {
            this.newProxyInstance.addPath(this.NetworkUserEntityData$$ExternalSyntheticLambda8.get(i).KClassImpl$Data$declaredNonStaticMembers$2(), matrix);
        }
        this.newProxyInstance.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.initRecordTimeStamp;
    }

    private int MyBillsEntityDataFactory() {
        int round = Math.round(this.NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2() * this.MyBillsEntityDataFactory);
        int round2 = Math.round(this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2() * this.MyBillsEntityDataFactory);
        int round3 = Math.round(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2() * this.MyBillsEntityDataFactory);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private int[] MyBillsEntityDataFactory(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.getErrorConfigVersion;
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

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.MyBillsEntityDataFactory(keyPath, i, list, keyPath2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t == LottieProperty.GetContactSyncConfig) {
            this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.BuiltInFictitiousFunctionClassFactory) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.lookAheadTest;
            if (baseKeyframeAnimation != null) {
                this.DatabaseTableConfigUtil.MyBillsEntityDataFactory.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.lookAheadTest = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.lookAheadTest = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer = this.DatabaseTableConfigUtil;
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.lookAheadTest;
            if (baseKeyframeAnimation2 != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        } else if (t == LottieProperty.DatabaseTableConfigUtil) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.getErrorConfigVersion;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.DatabaseTableConfigUtil.MyBillsEntityDataFactory.remove(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.getErrorConfigVersion = null;
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext();
            this.PrepareContext.getAuthRequestContext();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.getErrorConfigVersion = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer2 = this.DatabaseTableConfigUtil;
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = this.getErrorConfigVersion;
            if (valueCallbackKeyframeAnimation4 != null) {
                baseLayer2.MyBillsEntityDataFactory.add(valueCallbackKeyframeAnimation4);
            }
        } else if (t == LottieProperty.MyBillsEntityDataFactory) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.getAuthRequestContext;
            if (baseKeyframeAnimation3 != null) {
                baseKeyframeAnimation3.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.getAuthRequestContext = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer3 = this.DatabaseTableConfigUtil;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.getAuthRequestContext;
            if (baseKeyframeAnimation4 != null) {
                baseLayer3.MyBillsEntityDataFactory.add(baseKeyframeAnimation4);
            }
        } else if (t != LottieProperty.PlaceComponentResult || (dropShadowKeyframeAnimation5 = this.scheduleImpl) == null) {
            if (t == LottieProperty.moveToNextValue && (dropShadowKeyframeAnimation4 = this.scheduleImpl) != null) {
                if (lottieValueCallback == null) {
                    dropShadowKeyframeAnimation4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(null);
                } else {
                    dropShadowKeyframeAnimation4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(new DropShadowKeyframeAnimation.AnonymousClass1(lottieValueCallback));
                }
            } else if (t != LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda0 || (dropShadowKeyframeAnimation3 = this.scheduleImpl) == null) {
                if (t != LottieProperty.lookAheadTest || (dropShadowKeyframeAnimation2 = this.scheduleImpl) == null) {
                    if (t != LottieProperty.getErrorConfigVersion || (dropShadowKeyframeAnimation = this.scheduleImpl) == null) {
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
