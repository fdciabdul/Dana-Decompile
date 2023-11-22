package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.MeanCalculator;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    final Matrix BuiltInFictitiousFunctionClassFactory;
    private final Paint DatabaseTableConfigUtil;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    BlurMaskFilter KClassImpl$Data$declaredNonStaticMembers$2;
    public final List<BaseKeyframeAnimation<?, ?>> MyBillsEntityDataFactory;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private BaseLayer NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda4;
    private BaseLayer NetworkUserEntityData$$ExternalSyntheticLambda5;
    private Paint NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final RectF NetworkUserEntityData$$ExternalSyntheticLambda8;
    FloatKeyframeAnimation PlaceComponentResult;
    float getAuthRequestContext;
    private final RectF getCallingPid;
    final TransformKeyframeAnimation getErrorConfigVersion;
    private List<BaseLayer> getSupportButtonTintMode;
    private final String initRecordTimeStamp;
    private MaskKeyframeAnimation isLayoutRequested;
    final LottieDrawable lookAheadTest;
    private final RectF moveToNextValue;
    private final RectF newProxyInstance;
    private final RectF readMicros;
    final Layer scheduleImpl;
    private final Path whenAvailable = new Path();
    private final Matrix NetworkUserEntityData$$ExternalSyntheticLambda7 = new Matrix();
    private final Matrix GetContactSyncConfig = new Matrix();
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda1 = new LPaint(1);
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda2 = new LPaint(PorterDuff.Mode.DST_IN, (byte) 0);
    private final Paint PrepareContext = new LPaint(PorterDuff.Mode.DST_OUT, (byte) 0);

    abstract void BuiltInFictitiousFunctionClassFactory(Canvas canvas, Matrix matrix, int i);

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
    }

    void getAuthRequestContext(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        LPaint lPaint = new LPaint(1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = lPaint;
        this.DatabaseTableConfigUtil = new LPaint(PorterDuff.Mode.CLEAR);
        this.getCallingPid = new RectF();
        this.moveToNextValue = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new RectF();
        this.newProxyInstance = new RectF();
        this.readMicros = new RectF();
        this.BuiltInFictitiousFunctionClassFactory = new Matrix();
        this.MyBillsEntityDataFactory = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.getAuthRequestContext = 0.0f;
        this.lookAheadTest = lottieDrawable;
        this.scheduleImpl = layer;
        StringBuilder sb = new StringBuilder();
        sb.append(layer.moveToNextValue);
        sb.append("#draw");
        this.initRecordTimeStamp = sb.toString();
        if (layer.NetworkUserEntityData$$ExternalSyntheticLambda0 == Layer.MatteType.INVERT) {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(layer.FragmentBottomSheetPaymentSettingBinding);
        this.getErrorConfigVersion = transformKeyframeAnimation;
        transformKeyframeAnimation.BuiltInFictitiousFunctionClassFactory(this);
        if (layer.scheduleImpl != null && !layer.scheduleImpl.isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.scheduleImpl);
            this.isLayoutRequested = maskKeyframeAnimation;
            Iterator<BaseKeyframeAnimation<ShapeData, Path>> it = maskKeyframeAnimation.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                it.next().MyBillsEntityDataFactory.add(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation : this.isLayoutRequested.BuiltInFictitiousFunctionClassFactory) {
                if (baseKeyframeAnimation != null) {
                    this.MyBillsEntityDataFactory.add(baseKeyframeAnimation);
                }
                baseKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            }
        }
        if (!this.scheduleImpl.MyBillsEntityDataFactory.isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.scheduleImpl.MyBillsEntityDataFactory);
            this.PlaceComponentResult = floatKeyframeAnimation;
            floatKeyframeAnimation.PlaceComponentResult = true;
            this.PlaceComponentResult.MyBillsEntityDataFactory.add(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.model.layer.BaseLayer$$ExternalSyntheticLambda0
                @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
                public final void PlaceComponentResult() {
                    BaseLayer baseLayer = BaseLayer.this;
                    boolean z = baseLayer.PlaceComponentResult.lookAheadTest() == 1.0f;
                    if (z != baseLayer.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                        baseLayer.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
                        baseLayer.lookAheadTest.invalidateSelf();
                    }
                }
            });
            boolean z = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue() == 1.0f;
            if (z != this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
                this.lookAheadTest.invalidateSelf();
            }
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.PlaceComponentResult;
            if (floatKeyframeAnimation2 != null) {
                this.MyBillsEntityDataFactory.add(floatKeyframeAnimation2);
            }
        } else if (true != this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            this.lookAheadTest.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (z && this.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new LPaint();
        }
        this.FragmentBottomSheetPaymentSettingBinding = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(BaseLayer baseLayer) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = baseLayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3 != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(BaseLayer baseLayer) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = baseLayer;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        this.getCallingPid.set(0.0f, 0.0f, 0.0f, 0.0f);
        moveToNextValue();
        this.BuiltInFictitiousFunctionClassFactory.set(matrix);
        if (z) {
            List<BaseLayer> list = this.getSupportButtonTintMode;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.BuiltInFictitiousFunctionClassFactory.preConcat(this.getSupportButtonTintMode.get(size).getErrorConfigVersion.PlaceComponentResult());
                }
            } else {
                BaseLayer baseLayer = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (baseLayer != null) {
                    this.BuiltInFictitiousFunctionClassFactory.preConcat(baseLayer.getErrorConfigVersion.PlaceComponentResult());
                }
            }
        }
        this.BuiltInFictitiousFunctionClassFactory.preConcat(this.getErrorConfigVersion.PlaceComponentResult());
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        float f;
        Paint paint;
        L.getAuthRequestContext(this.initRecordTimeStamp);
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 || this.scheduleImpl.BuiltInFictitiousFunctionClassFactory()) {
            L.MyBillsEntityDataFactory(this.initRecordTimeStamp);
            return;
        }
        moveToNextValue();
        L.getAuthRequestContext("Layer#parentMatrix");
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.reset();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.set(matrix);
        int i2 = 1;
        for (int size = this.getSupportButtonTintMode.size() - 1; size >= 0; size--) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.preConcat(this.getSupportButtonTintMode.get(size).getErrorConfigVersion.PlaceComponentResult());
        }
        L.MyBillsEntityDataFactory("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * (this.getErrorConfigVersion.MyBillsEntityDataFactory == null ? 100 : this.getErrorConfigVersion.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue())) / 100.0f) * 255.0f);
        if (!NetworkUserEntityData$$ExternalSyntheticLambda0() && !MyBillsEntityDataFactory()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.preConcat(this.getErrorConfigVersion.PlaceComponentResult());
            L.getAuthRequestContext("Layer#drawLayer");
            BuiltInFictitiousFunctionClassFactory(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7, intValue);
            L.MyBillsEntityDataFactory("Layer#drawLayer");
            PlaceComponentResult(L.MyBillsEntityDataFactory(this.initRecordTimeStamp));
            return;
        }
        L.getAuthRequestContext("Layer#computeBounds");
        getAuthRequestContext(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda7, false);
        RectF rectF = this.getCallingPid;
        if (NetworkUserEntityData$$ExternalSyntheticLambda0() && this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0 != Layer.MatteType.INVERT) {
            this.newProxyInstance.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.getAuthRequestContext(this.newProxyInstance, matrix, true);
            if (!rectF.intersect(this.newProxyInstance)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.preConcat(this.getErrorConfigVersion.PlaceComponentResult());
        RectF rectF2 = this.getCallingPid;
        Matrix matrix2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i3 = 3;
        int i4 = 2;
        if (MyBillsEntityDataFactory()) {
            int size2 = this.isLayoutRequested.getAuthRequestContext.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    Mask mask = this.isLayoutRequested.getAuthRequestContext.get(i5);
                    Path NetworkUserEntityData$$ExternalSyntheticLambda0 = this.isLayoutRequested.MyBillsEntityDataFactory.get(i5).NetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                        this.whenAvailable.set(NetworkUserEntityData$$ExternalSyntheticLambda0);
                        this.whenAvailable.transform(matrix2);
                        int i6 = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[mask.MyBillsEntityDataFactory.ordinal()];
                        if (i6 == i2 || i6 == i4 || ((i6 == i3 || i6 == 4) && mask.BuiltInFictitiousFunctionClassFactory())) {
                            break;
                        }
                        this.whenAvailable.computeBounds(this.readMicros, false);
                        if (i5 == 0) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda8.set(this.readMicros);
                        } else {
                            RectF rectF3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                            rectF3.set(Math.min(rectF3.left, this.readMicros.left), Math.min(this.NetworkUserEntityData$$ExternalSyntheticLambda8.top, this.readMicros.top), Math.max(this.NetworkUserEntityData$$ExternalSyntheticLambda8.right, this.readMicros.right), Math.max(this.NetworkUserEntityData$$ExternalSyntheticLambda8.bottom, this.readMicros.bottom));
                        }
                    }
                    i5++;
                    i2 = 1;
                    i3 = 3;
                    i4 = 2;
                } else if (!rectF2.intersect(this.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
                    f = 0.0f;
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        }
        f = 0.0f;
        this.moveToNextValue.set(f, f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.GetContactSyncConfig);
        if (!this.GetContactSyncConfig.isIdentity()) {
            Matrix matrix3 = this.GetContactSyncConfig;
            matrix3.invert(matrix3);
            this.GetContactSyncConfig.mapRect(this.moveToNextValue);
        }
        if (!this.getCallingPid.intersect(this.moveToNextValue)) {
            this.getCallingPid.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        L.MyBillsEntityDataFactory("Layer#computeBounds");
        if (this.getCallingPid.width() >= 1.0f && this.getCallingPid.height() >= 1.0f) {
            L.getAuthRequestContext("Layer#saveLayer");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha(255);
            Utils.getAuthRequestContext(canvas, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            L.MyBillsEntityDataFactory("Layer#saveLayer");
            PlaceComponentResult(canvas);
            L.getAuthRequestContext("Layer#drawLayer");
            BuiltInFictitiousFunctionClassFactory(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7, intValue);
            L.MyBillsEntityDataFactory("Layer#drawLayer");
            if (MyBillsEntityDataFactory()) {
                Matrix matrix4 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                L.getAuthRequestContext("Layer#saveLayer");
                Utils.getAuthRequestContext(canvas, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2, 19);
                if (Build.VERSION.SDK_INT < 28) {
                    PlaceComponentResult(canvas);
                }
                L.MyBillsEntityDataFactory("Layer#saveLayer");
                for (int i7 = 0; i7 < this.isLayoutRequested.getAuthRequestContext.size(); i7++) {
                    Mask mask2 = this.isLayoutRequested.getAuthRequestContext.get(i7);
                    BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation = this.isLayoutRequested.MyBillsEntityDataFactory.get(i7);
                    BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.isLayoutRequested.BuiltInFictitiousFunctionClassFactory.get(i7);
                    int i8 = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[mask2.MyBillsEntityDataFactory.ordinal()];
                    if (i8 != 1) {
                        if (i8 == 2) {
                            if (i7 == 0) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda1.setColor(-16777216);
                                this.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha(255);
                                canvas.drawRect(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            }
                            if (mask2.BuiltInFictitiousFunctionClassFactory()) {
                                Utils.getAuthRequestContext(canvas, this.getCallingPid, this.PrepareContext);
                                canvas.drawRect(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                this.PrepareContext.setAlpha((int) (baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue() * 2.55f));
                                this.whenAvailable.set(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
                                this.whenAvailable.transform(matrix4);
                                canvas.drawPath(this.whenAvailable, this.PrepareContext);
                                canvas.restore();
                            } else {
                                this.whenAvailable.set(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
                                this.whenAvailable.transform(matrix4);
                                canvas.drawPath(this.whenAvailable, this.PrepareContext);
                            }
                        } else if (i8 != 3) {
                            if (i8 == 4) {
                                if (mask2.BuiltInFictitiousFunctionClassFactory()) {
                                    Utils.getAuthRequestContext(canvas, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                    canvas.drawRect(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                    this.whenAvailable.set(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
                                    this.whenAvailable.transform(matrix4);
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha((int) (baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue() * 2.55f));
                                    canvas.drawPath(this.whenAvailable, this.PrepareContext);
                                    canvas.restore();
                                } else {
                                    this.whenAvailable.set(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
                                    this.whenAvailable.transform(matrix4);
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha((int) (baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue() * 2.55f));
                                    canvas.drawPath(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                }
                            }
                        } else if (mask2.BuiltInFictitiousFunctionClassFactory()) {
                            Utils.getAuthRequestContext(canvas, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                            canvas.drawRect(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            this.PrepareContext.setAlpha((int) (baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue() * 2.55f));
                            this.whenAvailable.set(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
                            this.whenAvailable.transform(matrix4);
                            canvas.drawPath(this.whenAvailable, this.PrepareContext);
                            canvas.restore();
                        } else {
                            Utils.getAuthRequestContext(canvas, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                            this.whenAvailable.set(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
                            this.whenAvailable.transform(matrix4);
                            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha((int) (baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue() * 2.55f));
                            canvas.drawPath(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            canvas.restore();
                        }
                    } else if (scheduleImpl()) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha(255);
                        canvas.drawRect(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    }
                }
                L.getAuthRequestContext("Layer#restoreLayer");
                canvas.restore();
                L.MyBillsEntityDataFactory("Layer#restoreLayer");
            }
            if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                L.getAuthRequestContext("Layer#drawMatte");
                L.getAuthRequestContext("Layer#saveLayer");
                Utils.getAuthRequestContext(canvas, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda4, 19);
                L.MyBillsEntityDataFactory("Layer#saveLayer");
                PlaceComponentResult(canvas);
                this.NetworkUserEntityData$$ExternalSyntheticLambda3.getAuthRequestContext(canvas, matrix, intValue);
                L.getAuthRequestContext("Layer#restoreLayer");
                canvas.restore();
                L.MyBillsEntityDataFactory("Layer#restoreLayer");
                L.MyBillsEntityDataFactory("Layer#drawMatte");
            }
            L.getAuthRequestContext("Layer#restoreLayer");
            canvas.restore();
            L.MyBillsEntityDataFactory("Layer#restoreLayer");
        }
        if (this.FragmentBottomSheetPaymentSettingBinding && (paint = this.NetworkUserEntityData$$ExternalSyntheticLambda6) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.setColor(-251901);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.setStrokeWidth(4.0f);
            canvas.drawRect(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.setStyle(Paint.Style.FILL);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.setColor(1357638635);
            canvas.drawRect(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        }
        PlaceComponentResult(L.MyBillsEntityDataFactory(this.initRecordTimeStamp));
    }

    private void PlaceComponentResult(float f) {
        PerformanceTracker performanceTracker = this.lookAheadTest.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str = this.scheduleImpl.moveToNextValue;
        if (performanceTracker.PlaceComponentResult) {
            MeanCalculator meanCalculator = performanceTracker.getAuthRequestContext.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                performanceTracker.getAuthRequestContext.put(str, meanCalculator);
            }
            float f2 = meanCalculator.BuiltInFictitiousFunctionClassFactory + f;
            meanCalculator.BuiltInFictitiousFunctionClassFactory = f2;
            int i = meanCalculator.MyBillsEntityDataFactory + 1;
            meanCalculator.MyBillsEntityDataFactory = i;
            if (i == Integer.MAX_VALUE) {
                meanCalculator.BuiltInFictitiousFunctionClassFactory = f2 / 2.0f;
                meanCalculator.MyBillsEntityDataFactory = i / 2;
            }
            if (str.equals("__container")) {
                for (PerformanceTracker.FrameListener frameListener : performanceTracker.KClassImpl$Data$declaredNonStaticMembers$2) {
                }
            }
        }
    }

    private void PlaceComponentResult(Canvas canvas) {
        L.getAuthRequestContext("Layer#clearLayer");
        canvas.drawRect(this.getCallingPid.left - 1.0f, this.getCallingPid.top - 1.0f, this.getCallingPid.right + 1.0f, this.getCallingPid.bottom + 1.0f, this.DatabaseTableConfigUtil);
        L.MyBillsEntityDataFactory("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private boolean scheduleImpl() {
        if (this.isLayoutRequested.MyBillsEntityDataFactory.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.isLayoutRequested.getAuthRequestContext.size(); i++) {
            if (this.isLayoutRequested.getAuthRequestContext.get(i).MyBillsEntityDataFactory != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.isLayoutRequested;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.MyBillsEntityDataFactory.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.getErrorConfigVersion;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = transformKeyframeAnimation.MyBillsEntityDataFactory;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = transformKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = transformKeyframeAnimation.PlaceComponentResult;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = transformKeyframeAnimation.KClassImpl$Data$declaredNonStaticMembers$2;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = transformKeyframeAnimation.BuiltInFictitiousFunctionClassFactory;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = transformKeyframeAnimation.lookAheadTest;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = transformKeyframeAnimation.getAuthRequestContext;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = transformKeyframeAnimation.moveToNextValue;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = transformKeyframeAnimation.getErrorConfigVersion;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        if (this.isLayoutRequested != null) {
            for (int i = 0; i < this.isLayoutRequested.MyBillsEntityDataFactory.size(); i++) {
                this.isLayoutRequested.MyBillsEntityDataFactory.get(i).KClassImpl$Data$declaredNonStaticMembers$2(f);
            }
        }
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.PlaceComponentResult;
        if (floatKeyframeAnimation3 != null) {
            floatKeyframeAnimation3.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        BaseLayer baseLayer = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (baseLayer != null) {
            baseLayer.KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
        for (int i2 = 0; i2 < this.MyBillsEntityDataFactory.size(); i2++) {
            this.MyBillsEntityDataFactory.get(i2).KClassImpl$Data$declaredNonStaticMembers$2(f);
        }
    }

    private void moveToNextValue() {
        if (this.getSupportButtonTintMode != null) {
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda5 == null) {
            this.getSupportButtonTintMode = Collections.emptyList();
            return;
        }
        this.getSupportButtonTintMode = new ArrayList();
        for (BaseLayer baseLayer = this.NetworkUserEntityData$$ExternalSyntheticLambda5; baseLayer != null; baseLayer = baseLayer.NetworkUserEntityData$$ExternalSyntheticLambda5) {
            this.getSupportButtonTintMode.add(baseLayer);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.scheduleImpl.moveToNextValue;
    }

    public BlurEffect BuiltInFictitiousFunctionClassFactory() {
        return this.scheduleImpl.PlaceComponentResult;
    }

    public final BlurMaskFilter getAuthRequestContext(float f) {
        if (this.getAuthRequestContext == f) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = blurMaskFilter;
        this.getAuthRequestContext = f;
        return blurMaskFilter;
    }

    public DropShadowEffect KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        BaseLayer baseLayer = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (baseLayer != null) {
            String str = baseLayer.scheduleImpl.moveToNextValue;
            KeyPath keyPath3 = new KeyPath(keyPath2);
            keyPath3.KClassImpl$Data$declaredNonStaticMembers$2.add(str);
            if (keyPath.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda3.scheduleImpl.moveToNextValue, i)) {
                BaseLayer baseLayer2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                KeyPath keyPath4 = new KeyPath(keyPath3);
                keyPath4.BuiltInFictitiousFunctionClassFactory = baseLayer2;
                list.add(keyPath4);
            }
            if (keyPath.MyBillsEntityDataFactory(this.scheduleImpl.moveToNextValue, i)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda3.getAuthRequestContext(keyPath, keyPath.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3.scheduleImpl.moveToNextValue, i) + i, list, keyPath3);
            }
        }
        if (keyPath.getAuthRequestContext(this.scheduleImpl.moveToNextValue, i)) {
            if (!"__container".equals(this.scheduleImpl.moveToNextValue)) {
                String str2 = this.scheduleImpl.moveToNextValue;
                KeyPath keyPath5 = new KeyPath(keyPath2);
                keyPath5.KClassImpl$Data$declaredNonStaticMembers$2.add(str2);
                if (keyPath.PlaceComponentResult(this.scheduleImpl.moveToNextValue, i)) {
                    KeyPath keyPath6 = new KeyPath(keyPath5);
                    keyPath6.BuiltInFictitiousFunctionClassFactory = this;
                    list.add(keyPath6);
                }
                keyPath2 = keyPath5;
            }
            if (keyPath.MyBillsEntityDataFactory(this.scheduleImpl.moveToNextValue, i)) {
                getAuthRequestContext(keyPath, i + keyPath.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl.moveToNextValue, i), list, keyPath2);
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(t, lottieValueCallback);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.lookAheadTest.invalidateSelf();
    }
}
