package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeStroke implements ContentModel {
    public final float BuiltInFictitiousFunctionClassFactory;
    public final LineJoinType KClassImpl$Data$declaredNonStaticMembers$2;
    public final List<AnimatableFloatValue> MyBillsEntityDataFactory;
    public final AnimatableFloatValue NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LineCapType PlaceComponentResult;
    public final AnimatableColorValue getAuthRequestContext;
    public final String getErrorConfigVersion;
    private final boolean lookAheadTest;
    public final AnimatableFloatValue moveToNextValue;
    public final AnimatableIntegerValue scheduleImpl;

    /* loaded from: classes3.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public final Paint.Cap toPaintCap() {
            int i = AnonymousClass1.getAuthRequestContext[ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return Paint.Cap.ROUND;
                }
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            getAuthRequestContext = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public final Paint.Join toPaintJoin() {
            int i = AnonymousClass1.PlaceComponentResult[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.getErrorConfigVersion = str;
        this.moveToNextValue = animatableFloatValue;
        this.MyBillsEntityDataFactory = list;
        this.getAuthRequestContext = animatableColorValue;
        this.scheduleImpl = animatableIntegerValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = animatableFloatValue2;
        this.PlaceComponentResult = lineCapType;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lineJoinType;
        this.BuiltInFictitiousFunctionClassFactory = f;
        this.lookAheadTest = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
