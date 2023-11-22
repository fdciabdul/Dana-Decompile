package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CompositionLayer extends BaseLayer {
    private final RectF DatabaseTableConfigUtil;
    private final Paint GetContactSyncConfig;
    private final List<BaseLayer> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Boolean initRecordTimeStamp;
    private BaseKeyframeAnimation<Float, Float> isLayoutRequested;
    public boolean moveToNextValue;
    private final RectF newProxyInstance;

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        BaseLayer baseLayer;
        BaseLayer shapeLayer;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ArrayList();
        this.newProxyInstance = new RectF();
        this.DatabaseTableConfigUtil = new RectF();
        this.GetContactSyncConfig = new Paint();
        this.moveToNextValue = true;
        AnimatableFloatValue animatableFloatValue = layer.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (animatableFloatValue == null) {
            this.isLayoutRequested = null;
        } else {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(animatableFloatValue.PlaceComponentResult);
            this.isLayoutRequested = floatKeyframeAnimation;
            this.MyBillsEntityDataFactory.add(floatKeyframeAnimation);
            this.isLayoutRequested.MyBillsEntityDataFactory.add(this);
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getErrorConfigVersion.size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            int i = 0;
            if (size >= 0) {
                Layer layer2 = list.get(size);
                switch (BaseLayer.AnonymousClass1.BuiltInFictitiousFunctionClassFactory[layer2.lookAheadTest.ordinal()]) {
                    case 1:
                        shapeLayer = new ShapeLayer(lottieDrawable, layer2, this);
                        break;
                    case 2:
                        shapeLayer = new CompositionLayer(lottieDrawable, layer2, lottieComposition.NetworkUserEntityData$$ExternalSyntheticLambda2.get(layer2.initRecordTimeStamp), lottieComposition);
                        break;
                    case 3:
                        shapeLayer = new SolidLayer(lottieDrawable, layer2);
                        break;
                    case 4:
                        shapeLayer = new ImageLayer(lottieDrawable, layer2);
                        break;
                    case 5:
                        shapeLayer = new NullLayer(lottieDrawable, layer2);
                        break;
                    case 6:
                        shapeLayer = new TextLayer(lottieDrawable, layer2);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown layer type ");
                        sb.append(layer2.lookAheadTest);
                        Logger.getAuthRequestContext(sb.toString());
                        shapeLayer = null;
                        break;
                }
                if (shapeLayer != null) {
                    longSparseArray.getAuthRequestContext(shapeLayer.scheduleImpl.BuiltInFictitiousFunctionClassFactory, shapeLayer);
                    if (baseLayer2 != null) {
                        baseLayer2.PlaceComponentResult(shapeLayer);
                        baseLayer2 = null;
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(0, shapeLayer);
                        int i2 = AnonymousClass1.PlaceComponentResult[layer2.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
                        if (i2 == 1 || i2 == 2) {
                            baseLayer2 = shapeLayer;
                        }
                    }
                }
                size--;
            } else {
                while (true) {
                    if (longSparseArray.MyBillsEntityDataFactory) {
                        longSparseArray.BuiltInFictitiousFunctionClassFactory();
                    }
                    if (i >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                        return;
                    }
                    if (longSparseArray.MyBillsEntityDataFactory) {
                        longSparseArray.BuiltInFictitiousFunctionClassFactory();
                    }
                    BaseLayer baseLayer3 = (BaseLayer) longSparseArray.MyBillsEntityDataFactory(longSparseArray.PlaceComponentResult[i], null);
                    if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.MyBillsEntityDataFactory(baseLayer3.scheduleImpl.getErrorConfigVersion, null)) != null) {
                        baseLayer3.MyBillsEntityDataFactory(baseLayer);
                    }
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(z);
        Iterator<BaseLayer> it = this.NetworkUserEntityData$$ExternalSyntheticLambda1.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    final void BuiltInFictitiousFunctionClassFactory(Canvas canvas, Matrix matrix, int i) {
        L.getAuthRequestContext("CompositionLayer#draw");
        this.DatabaseTableConfigUtil.set(0.0f, 0.0f, this.scheduleImpl.GetContactSyncConfig, this.scheduleImpl.DatabaseTableConfigUtil);
        matrix.mapRect(this.DatabaseTableConfigUtil);
        boolean z = this.lookAheadTest.initRecordTimeStamp() && this.NetworkUserEntityData$$ExternalSyntheticLambda1.size() > 1 && i != 255;
        if (z) {
            this.GetContactSyncConfig.setAlpha(i);
            Utils.getAuthRequestContext(canvas, this.DatabaseTableConfigUtil, this.GetContactSyncConfig);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size() - 1; size >= 0; size--) {
            if (((!this.moveToNextValue && "__container".equals(this.scheduleImpl.moveToNextValue)) || this.DatabaseTableConfigUtil.isEmpty()) ? true : canvas.clipRect(this.DatabaseTableConfigUtil)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(size).getAuthRequestContext(canvas, matrix, i);
            }
        }
        canvas.restore();
        L.MyBillsEntityDataFactory("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        super.getAuthRequestContext(rectF, matrix, z);
        for (int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size() - 1; size >= 0; size--) {
            this.newProxyInstance.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(size).getAuthRequestContext(this.newProxyInstance, this.BuiltInFictitiousFunctionClassFactory, true);
            rectF.union(this.newProxyInstance);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(f);
        if (this.isLayoutRequested != null) {
            LottieComposition lottieComposition = this.lookAheadTest.getAuthRequestContext;
            f = ((this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() * this.scheduleImpl.getAuthRequestContext.PlaceComponentResult) - this.scheduleImpl.getAuthRequestContext.DatabaseTableConfigUtil) / ((lottieComposition.MyBillsEntityDataFactory - lottieComposition.DatabaseTableConfigUtil) + 0.01f);
        }
        if (this.isLayoutRequested == null) {
            Layer layer = this.scheduleImpl;
            float f2 = layer.newProxyInstance;
            LottieComposition lottieComposition2 = layer.getAuthRequestContext;
            f -= f2 / (lottieComposition2.MyBillsEntityDataFactory - lottieComposition2.DatabaseTableConfigUtil);
        }
        if (this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda4 != 0.0f && !"__container".equals(this.scheduleImpl.moveToNextValue)) {
            f /= this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        for (int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size() - 1; size >= 0; size--) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(size).KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
    }

    public final boolean getErrorConfigVersion() {
        if (this.initRecordTimeStamp == null) {
            for (int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(size);
                if (baseLayer instanceof ShapeLayer) {
                    if (baseLayer.MyBillsEntityDataFactory()) {
                        this.initRecordTimeStamp = Boolean.TRUE;
                        return true;
                    }
                } else if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).getErrorConfigVersion()) {
                    this.initRecordTimeStamp = Boolean.TRUE;
                    return true;
                }
            }
            this.initRecordTimeStamp = Boolean.FALSE;
        }
        return this.initRecordTimeStamp.booleanValue();
    }

    public final boolean lookAheadTest() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Boolean.TRUE;
                return true;
            }
            for (int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size() - 1; size >= 0; size--) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(size).NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Boolean.TRUE;
                    return true;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Boolean.FALSE;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected final void getAuthRequestContext(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.NetworkUserEntityData$$ExternalSyntheticLambda1.size(); i2++) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(i2).KClassImpl$Data$declaredNonStaticMembers$2(keyPath, i, list, keyPath2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        super.PlaceComponentResult(t, lottieValueCallback);
        if (t == LottieProperty.getSupportButtonTintMode) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.isLayoutRequested;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.BuiltInFictitiousFunctionClassFactory(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.isLayoutRequested = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.isLayoutRequested;
            if (baseKeyframeAnimation2 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        }
    }
}
