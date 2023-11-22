package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GradientColorInflaterCompat {
    private GradientColorInflaterCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader BuiltInFictitiousFunctionClassFactory(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals(FoundationProxy.COMPONENT_GRADIENT)) {
            StringBuilder sb = new StringBuilder();
            sb.append(xmlPullParser.getPositionDescription());
            sb.append(": invalid gradient color tag ");
            sb.append(name);
            throw new XmlPullParserException(sb.toString());
        }
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, R.styleable.getSupportButtonTintMode);
        float KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "startX", R.styleable.D, 0.0f);
        float KClassImpl$Data$declaredNonStaticMembers$22 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "startY", R.styleable.getValueOfTouchPositionAbsolute, 0.0f);
        float KClassImpl$Data$declaredNonStaticMembers$23 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "endX", R.styleable.C, 0.0f);
        float KClassImpl$Data$declaredNonStaticMembers$24 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "endY", R.styleable.getOnBoardingScenario, 0.0f);
        float KClassImpl$Data$declaredNonStaticMembers$25 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "centerX", R.styleable.VerifyPinStateManager$executeRiskChallenge$2$1, 0.0f);
        float KClassImpl$Data$declaredNonStaticMembers$26 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "centerY", R.styleable.B, 0.0f);
        int authRequestContext2 = TypedArrayUtils.getAuthRequestContext(authRequestContext, xmlPullParser, "type", R.styleable.G, 0);
        int authRequestContext3 = TypedArrayUtils.getAuthRequestContext(authRequestContext, xmlPullParser, "startColor", R.styleable.VerifyPinStateManager$executeRiskChallenge$2$2);
        boolean BuiltInFictitiousFunctionClassFactory = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "centerColor");
        int authRequestContext4 = TypedArrayUtils.getAuthRequestContext(authRequestContext, xmlPullParser, "centerColor", R.styleable.A);
        int authRequestContext5 = TypedArrayUtils.getAuthRequestContext(authRequestContext, xmlPullParser, "endColor", R.styleable.BottomSheetCardBindingView$watcherCardNumberView$1);
        int authRequestContext6 = TypedArrayUtils.getAuthRequestContext(authRequestContext, xmlPullParser, "tileMode", R.styleable.I, 0);
        float KClassImpl$Data$declaredNonStaticMembers$27 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "gradientRadius", R.styleable.E, 0.0f);
        authRequestContext.recycle();
        ColorStops authRequestContext7 = getAuthRequestContext(PlaceComponentResult(resources, xmlPullParser, attributeSet, theme), authRequestContext3, authRequestContext5, BuiltInFictitiousFunctionClassFactory, authRequestContext4);
        if (authRequestContext2 != 1) {
            if (authRequestContext2 == 2) {
                return new SweepGradient(KClassImpl$Data$declaredNonStaticMembers$25, KClassImpl$Data$declaredNonStaticMembers$26, authRequestContext7.MyBillsEntityDataFactory, authRequestContext7.BuiltInFictitiousFunctionClassFactory);
            }
            return new LinearGradient(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, KClassImpl$Data$declaredNonStaticMembers$23, KClassImpl$Data$declaredNonStaticMembers$24, authRequestContext7.MyBillsEntityDataFactory, authRequestContext7.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory(authRequestContext6));
        } else if (KClassImpl$Data$declaredNonStaticMembers$27 <= 0.0f) {
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        } else {
            return new RadialGradient(KClassImpl$Data$declaredNonStaticMembers$25, KClassImpl$Data$declaredNonStaticMembers$26, KClassImpl$Data$declaredNonStaticMembers$27, authRequestContext7.MyBillsEntityDataFactory, authRequestContext7.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory(authRequestContext6));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        r8 = new java.lang.StringBuilder();
        r8.append(r9.getPositionDescription());
        r8.append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r8.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops PlaceComponentResult(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L83
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L83
        L21:
            r6 = 2
            if (r3 != r6) goto L12
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L12
            int[] r3 = androidx.core.R.styleable.whenAvailable
            android.content.res.TypedArray r3 = androidx.core.content.res.TypedArrayUtils.getAuthRequestContext(r8, r11, r10, r3)
            int r5 = androidx.core.R.styleable.readMicros
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R.styleable.getCallingPid
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L68
            if (r6 == 0) goto L68
            int r5 = androidx.core.R.styleable.readMicros
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R.styleable.getCallingPid
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L68:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r8.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r8.append(r9)
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L83:
            int r8 = r4.size()
            if (r8 <= 0) goto L8f
            androidx.core.content.res.GradientColorInflaterCompat$ColorStops r8 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops
            r8.<init>(r4, r2)
            return r8
        L8f:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.GradientColorInflaterCompat.PlaceComponentResult(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.GradientColorInflaterCompat$ColorStops");
    }

    private static ColorStops getAuthRequestContext(ColorStops colorStops, int i, int i2, boolean z, int i3) {
        if (colorStops != null) {
            return colorStops;
        }
        if (z) {
            return new ColorStops(i, i3, i2);
        }
        return new ColorStops(i, i2);
    }

    private static Shader.TileMode BuiltInFictitiousFunctionClassFactory(int i) {
        if (i != 1) {
            if (i == 2) {
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ColorStops {
        final float[] BuiltInFictitiousFunctionClassFactory;
        final int[] MyBillsEntityDataFactory;

        ColorStops(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.MyBillsEntityDataFactory = new int[size];
            this.BuiltInFictitiousFunctionClassFactory = new float[size];
            for (int i = 0; i < size; i++) {
                this.MyBillsEntityDataFactory[i] = list.get(i).intValue();
                this.BuiltInFictitiousFunctionClassFactory[i] = list2.get(i).floatValue();
            }
        }

        ColorStops(int i, int i2) {
            this.MyBillsEntityDataFactory = new int[]{i, i2};
            this.BuiltInFictitiousFunctionClassFactory = new float[]{0.0f, 1.0f};
        }

        ColorStops(int i, int i2, int i3) {
            this.MyBillsEntityDataFactory = new int[]{i, i2, i3};
            this.BuiltInFictitiousFunctionClassFactory = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
