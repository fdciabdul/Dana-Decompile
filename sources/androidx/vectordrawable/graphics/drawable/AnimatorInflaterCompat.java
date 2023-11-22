package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AnimatorInflaterCompat {
    private static boolean MyBillsEntityDataFactory(int i) {
        return i >= 28 && i <= 31;
    }

    public static Animator KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return PlaceComponentResult(context, context.getResources(), context.getTheme(), i, 1.0f);
    }

    public static Animator PlaceComponentResult(Context context, Resources resources, Resources.Theme theme, int i, float f) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    return getAuthRequestContext(context, resources, theme, xmlResourceParser, f);
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Can't load animation resource ID #0x");
                    sb.append(Integer.toHexString(i));
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(sb.toString());
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't load animation resource ID #0x");
                sb2.append(Integer.toHexString(i));
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException(sb2.toString());
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] PlaceComponentResult;

        PathDataEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!PathParser.KClassImpl$Data$declaredNonStaticMembers$2(pathDataNodeArr, pathDataNodeArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!PathParser.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, pathDataNodeArr)) {
                this.PlaceComponentResult = PathParser.PlaceComponentResult(pathDataNodeArr);
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                PathParser.PathDataNode pathDataNode = this.PlaceComponentResult[i];
                PathParser.PathDataNode pathDataNode2 = pathDataNodeArr[i];
                PathParser.PathDataNode pathDataNode3 = pathDataNodeArr2[i];
                pathDataNode.getAuthRequestContext = pathDataNode2.getAuthRequestContext;
                int i2 = 0;
                while (true) {
                    float[] fArr = pathDataNode2.BuiltInFictitiousFunctionClassFactory;
                    if (i2 < fArr.length) {
                        pathDataNode.BuiltInFictitiousFunctionClassFactory[i2] = (fArr[i2] * (1.0f - f)) + (pathDataNode3.BuiltInFictitiousFunctionClassFactory[i2] * f);
                        i2++;
                    }
                }
            }
            return this.PlaceComponentResult;
        }
    }

    private static PropertyValuesHolder getAuthRequestContext(TypedArray typedArray, int i, int i2, int i3, String str) {
        int i4;
        PropertyValuesHolder ofInt;
        int i5;
        int i6;
        float f;
        float f2;
        float f3;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && MyBillsEntityDataFactory(i7)) || (z2 && MyBillsEntityDataFactory(i8))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.PathDataNode[] KClassImpl$Data$declaredNonStaticMembers$2 = PathParser.KClassImpl$Data$declaredNonStaticMembers$2(string);
            PathParser.PathDataNode[] KClassImpl$Data$declaredNonStaticMembers$22 = PathParser.KClassImpl$Data$declaredNonStaticMembers$2(string2);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null && KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                return null;
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    return PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), KClassImpl$Data$declaredNonStaticMembers$22);
                }
                return null;
            }
            PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                if (!PathParser.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" Can't morph from ");
                    sb.append(string);
                    sb.append(" to ");
                    sb.append(string2);
                    throw new InflateException(sb.toString());
                }
                return PropertyValuesHolder.ofObject(str, pathDataEvaluator, KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22);
            }
            return PropertyValuesHolder.ofObject(str, pathDataEvaluator, KClassImpl$Data$declaredNonStaticMembers$2);
        }
        ArgbEvaluator MyBillsEntityDataFactory = i == 3 ? ArgbEvaluator.MyBillsEntityDataFactory() : null;
        if (z3) {
            if (z) {
                if (i7 == 5) {
                    f2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    ofInt = PropertyValuesHolder.ofFloat(str, f2, f3);
                } else {
                    ofInt = PropertyValuesHolder.ofFloat(str, f2);
                }
            } else {
                if (i8 == 5) {
                    f = typedArray.getDimension(i3, 0.0f);
                } else {
                    f = typedArray.getFloat(i3, 0.0f);
                }
                ofInt = PropertyValuesHolder.ofFloat(str, f);
            }
        } else if (!z) {
            if (z2) {
                if (i8 == 5) {
                    i4 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (MyBillsEntityDataFactory(i8)) {
                    i4 = typedArray.getColor(i3, 0);
                } else {
                    i4 = typedArray.getInt(i3, 0);
                }
                ofInt = PropertyValuesHolder.ofInt(str, i4);
            }
            if (propertyValuesHolder == null && MyBillsEntityDataFactory != null) {
                propertyValuesHolder.setEvaluator(MyBillsEntityDataFactory);
                return propertyValuesHolder;
            }
        } else {
            if (i7 == 5) {
                i5 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (MyBillsEntityDataFactory(i7)) {
                i5 = typedArray.getColor(i2, 0);
            } else {
                i5 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (MyBillsEntityDataFactory(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                ofInt = PropertyValuesHolder.ofInt(str, i5, i6);
            } else {
                ofInt = PropertyValuesHolder.ofInt(str, i5);
            }
        }
        propertyValuesHolder = ofInt;
        return propertyValuesHolder == null ? propertyValuesHolder : propertyValuesHolder;
    }

    private static void BuiltInFictitiousFunctionClassFactory(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long authRequestContext = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "duration", 1, 300);
        long authRequestContext2 = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "startOffset", 2, 0);
        int authRequestContext3 = TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "valueFrom") && TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "valueTo")) {
            if (authRequestContext3 == 4) {
                authRequestContext3 = PlaceComponentResult(typedArray, 5, 6);
            }
            PropertyValuesHolder authRequestContext4 = getAuthRequestContext(typedArray, authRequestContext3, 5, 6, "");
            if (authRequestContext4 != null) {
                valueAnimator.setValues(authRequestContext4);
            }
        }
        valueAnimator.setDuration(authRequestContext);
        valueAnimator.setStartDelay(authRequestContext2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, LottieParams.KEY_REPEAT_COUNT, 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getAuthRequestContext(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            BuiltInFictitiousFunctionClassFactory(valueAnimator, typedArray2, authRequestContext3, f, xmlPullParser);
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String BuiltInFictitiousFunctionClassFactory = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(typedArray, xmlPullParser, "pathData", 1);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            String BuiltInFictitiousFunctionClassFactory2 = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(typedArray, xmlPullParser, "propertyXName", 2);
            String BuiltInFictitiousFunctionClassFactory3 = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(typedArray, xmlPullParser, "propertyYName", 3);
            if (BuiltInFictitiousFunctionClassFactory2 == null && BuiltInFictitiousFunctionClassFactory3 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(typedArray.getPositionDescription());
                sb.append(" propertyXName or propertyYName is needed for PathData");
                throw new InflateException(sb.toString());
            }
            KClassImpl$Data$declaredNonStaticMembers$2(PathParser.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory), objectAnimator, f * 0.5f, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f3 = 0.0f;
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f3 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f4 = f3 / ((float) (min - 1));
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= min) {
                break;
            }
            pathMeasure2.getPosTan(f2 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f2 += f4;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f2 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else if (ofFloat2 == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, ofFloat2);
        }
    }

    private static Animator getAuthRequestContext(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        return KClassImpl$Data$declaredNonStaticMembers$2(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e5, code lost:
    
        if (r23 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
    
        if (r13 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e9, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f7, code lost:
    
        if (r2.hasNext() == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f9, code lost:
    
        r1[r14] = (android.animation.Animator) r2.next();
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0103, code lost:
    
        if (r24 != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0105, code lost:
    
        r23.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0109, code lost:
    
        r23.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010c, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.animation.Animator KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static PropertyValuesHolder[] PlaceComponentResult(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    String BuiltInFictitiousFunctionClassFactory = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(authRequestContext, xmlPullParser, "propertyName", 3);
                    int authRequestContext2 = TypedArrayUtils.getAuthRequestContext(authRequestContext, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder authRequestContext3 = getAuthRequestContext(context, resources, theme, xmlPullParser, BuiltInFictitiousFunctionClassFactory, authRequestContext2);
                    if (authRequestContext3 == null) {
                        authRequestContext3 = getAuthRequestContext(authRequestContext, authRequestContext2, 0, 1, BuiltInFictitiousFunctionClassFactory);
                    }
                    if (authRequestContext3 != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(authRequestContext3);
                    }
                    authRequestContext.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.KClassImpl$Data$declaredNonStaticMembers$2);
        TypedValue KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "value");
        int i = 0;
        if ((KClassImpl$Data$declaredNonStaticMembers$2 != null) && MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.type)) {
            i = 3;
        }
        authRequestContext.recycle();
        return i;
    }

    private static int PlaceComponentResult(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        return ((z && MyBillsEntityDataFactory(i3)) || (z2 && MyBillsEntityDataFactory(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    private static PropertyValuesHolder getAuthRequestContext(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i == 4) {
                    i = KClassImpl$Data$declaredNonStaticMembers$2(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe authRequestContext = getAuthRequestContext(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i, xmlPullParser);
                if (authRequestContext != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(authRequestContext);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), KClassImpl$Data$declaredNonStaticMembers$2(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, KClassImpl$Data$declaredNonStaticMembers$2(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            KClassImpl$Data$declaredNonStaticMembers$2(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i == 3) {
                propertyValuesHolder.setEvaluator(ArgbEvaluator.MyBillsEntityDataFactory());
            }
        }
        return propertyValuesHolder;
    }

    private static Keyframe KClassImpl$Data$declaredNonStaticMembers$2(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static Keyframe getAuthRequestContext(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe ofInt;
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.KClassImpl$Data$declaredNonStaticMembers$2);
        float KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue KClassImpl$Data$declaredNonStaticMembers$22 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "value");
        boolean z = KClassImpl$Data$declaredNonStaticMembers$22 != null;
        if (i == 4) {
            i = (z && MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22.type)) ? 3 : 0;
        }
        if (z) {
            if (i == 0) {
                ofInt = Keyframe.ofFloat(KClassImpl$Data$declaredNonStaticMembers$2, TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "value", 0, 0.0f));
            } else {
                ofInt = (i == 1 || i == 3) ? Keyframe.ofInt(KClassImpl$Data$declaredNonStaticMembers$2, TypedArrayUtils.getAuthRequestContext(authRequestContext, xmlPullParser, "value", 0, 0)) : null;
            }
        } else if (i == 0) {
            ofInt = Keyframe.ofFloat(KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            ofInt = Keyframe.ofInt(KClassImpl$Data$declaredNonStaticMembers$2);
        }
        int KClassImpl$Data$declaredNonStaticMembers$23 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "interpolator", 1);
        if (KClassImpl$Data$declaredNonStaticMembers$23 > 0) {
            ofInt.setInterpolator(AnimationUtilsCompat.getAuthRequestContext(context, KClassImpl$Data$declaredNonStaticMembers$23));
        }
        authRequestContext.recycle();
        return ofInt;
    }

    private static ObjectAnimator PlaceComponentResult(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        PlaceComponentResult(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator PlaceComponentResult(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.BuiltInFictitiousFunctionClassFactory);
        TypedArray authRequestContext2 = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.lookAheadTest);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        BuiltInFictitiousFunctionClassFactory(valueAnimator, authRequestContext, authRequestContext2, f, xmlPullParser);
        int KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, xmlPullParser, "interpolator", 0);
        if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.getAuthRequestContext(context, KClassImpl$Data$declaredNonStaticMembers$2));
        }
        authRequestContext.recycle();
        if (authRequestContext2 != null) {
            authRequestContext2.recycle();
        }
        return valueAnimator;
    }

    private AnimatorInflaterCompat() {
    }
}
