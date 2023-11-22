package com.alibaba.griver.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.lottie.L;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.LottieProperty;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.alibaba.griver.lottie.model.KeyPath;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.layer.Layer;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class CompositionLayer extends BaseLayer {
    public static final String TAG = "CompositionLayer";
    private Boolean hasMasks;
    private Boolean hasMatte;
    private final List<BaseLayer> layers;
    private final RectF newClipRect;
    private final RectF rect;
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        BaseLayer baseLayer;
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        AnimatableFloatValue timeRemapping = layer.getTimeRemapping();
        if (timeRemapping != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = timeRemapping.createAnimation();
            this.timeRemapping = createAnimation;
            addAnimation(createAnimation);
            this.timeRemapping.addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int i = 0;
        if (list != null) {
            BaseLayer baseLayer2 = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                Layer layer2 = list.get(size);
                BaseLayer forModel = BaseLayer.forModel(layer2, lottieDrawable, lottieComposition);
                if (forModel != null) {
                    longSparseArray.getAuthRequestContext(forModel.getLayerModel().getId(), forModel);
                    if (baseLayer2 != null) {
                        baseLayer2.setMatteLayer(forModel);
                        baseLayer2 = null;
                    } else {
                        this.layers.add(0, forModel);
                        int i2 = AnonymousClass1.$SwitchMap$com$alibaba$griver$lottie$model$layer$Layer$MatteType[layer2.getMatteType().ordinal()];
                        if (i2 == 1 || i2 == 2) {
                            baseLayer2 = forModel;
                        }
                    }
                }
            }
        }
        while (true) {
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            if (i >= longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2) {
                break;
            }
            if (longSparseArray.MyBillsEntityDataFactory) {
                longSparseArray.BuiltInFictitiousFunctionClassFactory();
            }
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.MyBillsEntityDataFactory(longSparseArray.PlaceComponentResult[i], null);
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.MyBillsEntityDataFactory(baseLayer3.getLayerModel().getParentId(), null)) != null) {
                baseLayer3.setParentLayer(baseLayer);
            }
            i++;
        }
        if (lottieDrawable.isEnableDynamicLayer()) {
            for (BaseLayer baseLayer4 : this.layers) {
                if (baseLayer4.getLayerModel().getLayerType() == Layer.LayerType.SOLID) {
                    String name = baseLayer4.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith(BaseLayer.DYNAMIC_NAME_PREFIX)) {
                        lottieDrawable.getDynamicLayers().put(name, baseLayer4);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.lottie.model.layer.CompositionLayer$1 */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$lottie$model$layer$Layer$MatteType;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$alibaba$griver$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$model$layer$Layer$MatteType[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i) {
        L.beginSection("CompositionLayer#draw");
        canvas.save();
        this.newClipRect.set(0.0f, 0.0f, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
        matrix.mapRect(this.newClipRect);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            if (!this.newClipRect.isEmpty() ? canvas.clipRect(this.newClipRect) : true) {
                this.layers.get(size).draw(canvas, matrix, i);
            }
        }
        canvas.restore();
        L.endSection("CompositionLayer#draw");
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.layers.get(size).getBounds(this.rect, this.boundsMatrix, true);
            rectF.union(this.rect);
        }
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    public void setProgress(float f) {
        super.setProgress(f);
        if (this.timeRemapping != null) {
            f = (this.timeRemapping.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().getDuration();
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            f /= this.layerModel.getTimeStretch();
        }
        float startProgress = this.layerModel.getStartProgress();
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.layers.get(size).setProgress(f - startProgress);
        }
    }

    public boolean hasMasks() {
        if (this.hasMasks == null) {
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.layers.get(size);
                if (baseLayer instanceof ShapeLayer) {
                    if (baseLayer.hasMasksOnThisLayer()) {
                        this.hasMasks = Boolean.TRUE;
                        return true;
                    }
                } else if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).hasMasks()) {
                    this.hasMasks = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMasks = Boolean.FALSE;
        }
        return this.hasMasks.booleanValue();
    }

    public boolean hasMatte() {
        if (this.hasMatte == null) {
            if (hasMatteOnThisLayer()) {
                this.hasMatte = Boolean.TRUE;
                return true;
            }
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                if (this.layers.get(size).hasMatteOnThisLayer()) {
                    this.hasMatte = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMatte = Boolean.FALSE;
        }
        return this.hasMatte.booleanValue();
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.layers.size(); i2++) {
            this.layers.get(i2).resolveKeyPath(keyPath, i, list, keyPath2);
        }
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                this.timeRemapping = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.timeRemapping = valueCallbackKeyframeAnimation;
            addAnimation(valueCallbackKeyframeAnimation);
        }
    }

    public String hitTestDynamicLayer(float f, float f2, Matrix matrix) {
        if (matrix == null) {
            GriverLogger.d(TAG, "hitTestDynamicLayer, m == null");
            return null;
        }
        for (Map.Entry<String, BaseLayer> entry : this.lottieDrawable.getDynamicLayers().entrySet()) {
            RectF dynamicLayerRect = getDynamicLayerRect(entry.getValue(), matrix);
            if (dynamicLayerRect != null && dynamicLayerRect.contains(f, f2)) {
                return entry.getKey();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hitTestDynamicLayer, not hit, ");
        sb.append(this.lottieDrawable.getDynamicLayers().size());
        GriverLogger.d(TAG, sb.toString());
        return null;
    }

    public RectF getDynamicLayerRect(String str, Matrix matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("getDynamicLayerRect, layerId:");
        sb.append(str);
        sb.append(",m:");
        sb.append(matrix);
        GriverLogger.d(TAG, sb.toString());
        if (TextUtils.isEmpty(str) || matrix == null) {
            return null;
        }
        BaseLayer baseLayer = this.lottieDrawable.getDynamicLayers().get(str);
        if (baseLayer != null) {
            return getDynamicLayerRect(baseLayer, matrix);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDynamicLayerRect, layer == null, ");
        sb2.append(this.lottieDrawable.getDynamicLayers().size());
        GriverLogger.d(TAG, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("getDynamicLayerRect, layer not found:");
        sb3.append(str);
        GriverLogger.d(TAG, sb3.toString());
        return null;
    }

    private RectF getDynamicLayerRect(BaseLayer baseLayer, Matrix matrix) {
        if (baseLayer != null) {
            RectF rectF = new RectF();
            RectF rectF2 = new RectF();
            baseLayer.getBounds(rectF, new Matrix(), true);
            boolean mapRect = matrix.mapRect(rectF2, rectF);
            if (!mapRect) {
                GriverLogger.d(TAG, "getDynamicLayerRect, mapOk == false");
            }
            if (mapRect) {
                return rectF2;
            }
            return null;
        }
        return null;
    }
}
