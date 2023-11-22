package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TextLayer extends BaseLayer {
    private final Map<FontCharacter, List<ContentGroup>> DatabaseTableConfigUtil;
    private final Paint FragmentBottomSheetPaymentSettingBinding;
    private final Paint GetContactSyncConfig;
    private final LottieComposition NetworkUserEntityData$$ExternalSyntheticLambda1;
    private BaseKeyframeAnimation<Integer, Integer> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private BaseKeyframeAnimation<Float, Float> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final TextKeyframeAnimation NetworkUserEntityData$$ExternalSyntheticLambda4;
    private BaseKeyframeAnimation<Float, Float> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private BaseKeyframeAnimation<Integer, Integer> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Matrix NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final RectF NetworkUserEntityData$$ExternalSyntheticLambda8;
    private BaseKeyframeAnimation<Integer, Integer> PrepareContext;
    private BaseKeyframeAnimation<Float, Float> SubSequence;
    private BaseKeyframeAnimation<Float, Float> getCallingPid;
    private BaseKeyframeAnimation<Typeface, Typeface> getSupportButtonTintMode;
    private BaseKeyframeAnimation<Integer, Integer> initRecordTimeStamp;
    private final LottieDrawable isLayoutRequested;
    private final LongSparseArray<String> moveToNextValue;
    private final StringBuilder newProxyInstance;
    private BaseKeyframeAnimation<Float, Float> whenAvailable;

    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.newProxyInstance = new StringBuilder(2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new Matrix();
        this.GetContactSyncConfig = new Paint() { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            {
                TextLayer.this = this;
                setStyle(Paint.Style.FILL);
            }
        };
        this.FragmentBottomSheetPaymentSettingBinding = new Paint() { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            {
                TextLayer.this = this;
                setStyle(Paint.Style.STROKE);
            }
        };
        this.DatabaseTableConfigUtil = new HashMap();
        this.moveToNextValue = new LongSparseArray<>();
        this.isLayoutRequested = lottieDrawable;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = layer.getAuthRequestContext;
        TextKeyframeAnimation textKeyframeAnimation = new TextKeyframeAnimation(layer.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = textKeyframeAnimation;
        textKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        this.MyBillsEntityDataFactory.add(textKeyframeAnimation);
        AnimatableTextProperties animatableTextProperties = layer.PrepareContext;
        if (animatableTextProperties != null && animatableTextProperties.PlaceComponentResult != null) {
            ColorKeyframeAnimation colorKeyframeAnimation = new ColorKeyframeAnimation(animatableTextProperties.PlaceComponentResult.PlaceComponentResult);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = colorKeyframeAnimation;
            colorKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseKeyframeAnimation != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation);
            }
        }
        if (animatableTextProperties != null && animatableTextProperties.BuiltInFictitiousFunctionClassFactory != null) {
            ColorKeyframeAnimation colorKeyframeAnimation2 = new ColorKeyframeAnimation(animatableTextProperties.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
            this.PrepareContext = colorKeyframeAnimation2;
            colorKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.PrepareContext;
            if (baseKeyframeAnimation2 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        }
        if (animatableTextProperties != null && animatableTextProperties.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(animatableTextProperties.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = floatKeyframeAnimation;
            floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (baseKeyframeAnimation3 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation3);
            }
        }
        if (animatableTextProperties == null || animatableTextProperties.getAuthRequestContext == null) {
            return;
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = new FloatKeyframeAnimation(animatableTextProperties.getAuthRequestContext.PlaceComponentResult);
        this.whenAvailable = floatKeyframeAnimation2;
        floatKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.whenAvailable;
        if (baseKeyframeAnimation4 != null) {
            this.MyBillsEntityDataFactory.add(baseKeyframeAnimation4);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        super.getAuthRequestContext(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2.width(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2.height());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0416  */
    /* JADX WARN: Type inference failed for: r10v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object, java.lang.String] */
    @Override // com.airbnb.lottie.model.layer.BaseLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void BuiltInFictitiousFunctionClassFactory(android.graphics.Canvas r23, android.graphics.Matrix r24, int r25) {
        /*
            Method dump skipped, instructions count: 1256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.BuiltInFictitiousFunctionClassFactory(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = AnonymousClass3.BuiltInFictitiousFunctionClassFactory[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else if (i == 3) {
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    private static void getAuthRequestContext(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        super.PlaceComponentResult(t, lottieValueCallback);
        if (t == LottieProperty.getAuthRequestContext) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.initRecordTimeStamp;
            if (baseKeyframeAnimation != null) {
                this.MyBillsEntityDataFactory.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.initRecordTimeStamp = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.initRecordTimeStamp = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.initRecordTimeStamp;
            if (baseKeyframeAnimation2 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        } else if (t == LottieProperty.FragmentBottomSheetPaymentSettingBinding) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (baseKeyframeAnimation3 != null) {
                this.MyBillsEntityDataFactory.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (baseKeyframeAnimation4 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation4);
            }
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (baseKeyframeAnimation5 != null) {
                this.MyBillsEntityDataFactory.remove(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (baseKeyframeAnimation6 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation6);
            }
        } else if (t == LottieProperty.readMicros) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.SubSequence;
            if (baseKeyframeAnimation7 != null) {
                this.MyBillsEntityDataFactory.remove(baseKeyframeAnimation7);
            }
            if (lottieValueCallback == null) {
                this.SubSequence = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.SubSequence = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation8 = this.SubSequence;
            if (baseKeyframeAnimation8 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation8);
            }
        } else if (t == LottieProperty.SubSequence) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation9 = this.getCallingPid;
            if (baseKeyframeAnimation9 != null) {
                this.MyBillsEntityDataFactory.remove(baseKeyframeAnimation9);
            }
            if (lottieValueCallback == null) {
                this.getCallingPid = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.getCallingPid = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation10 = this.getCallingPid;
            if (baseKeyframeAnimation10 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation10);
            }
        } else if (t == LottieProperty.AppCompatEmojiTextHelper) {
            BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation11 = this.getSupportButtonTintMode;
            if (baseKeyframeAnimation11 != null) {
                this.MyBillsEntityDataFactory.remove(baseKeyframeAnimation11);
            }
            if (lottieValueCallback == null) {
                this.getSupportButtonTintMode = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation6 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.getSupportButtonTintMode = valueCallbackKeyframeAnimation6;
            valueCallbackKeyframeAnimation6.MyBillsEntityDataFactory.add(this);
            BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation12 = this.getSupportButtonTintMode;
            if (baseKeyframeAnimation12 != null) {
                this.MyBillsEntityDataFactory.add(baseKeyframeAnimation12);
            }
        } else if (t == LottieProperty.getCallingPid) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext(lottieValueCallback);
        }
    }
}
