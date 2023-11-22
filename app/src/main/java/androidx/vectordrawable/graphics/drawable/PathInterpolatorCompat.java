package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {
    private float[] BuiltInFictitiousFunctionClassFactory;
    private float[] MyBillsEntityDataFactory;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.moveToNextValue);
        MyBillsEntityDataFactory(authRequestContext, xmlPullParser);
        authRequestContext.recycle();
    }

    private void MyBillsEntityDataFactory(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "pathData")) {
            String BuiltInFictitiousFunctionClassFactory = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(typedArray, xmlPullParser, "pathData", 4);
            Path MyBillsEntityDataFactory = PathParser.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            if (MyBillsEntityDataFactory == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("The path is null, which is created from ");
                sb.append(BuiltInFictitiousFunctionClassFactory);
                throw new InflateException(sb.toString());
            }
            MyBillsEntityDataFactory(MyBillsEntityDataFactory);
        } else if (!TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else {
            if (!TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "controlY1")) {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            }
            float KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float KClassImpl$Data$declaredNonStaticMembers$22 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean BuiltInFictitiousFunctionClassFactory2 = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "controlX2");
            if (BuiltInFictitiousFunctionClassFactory2 != TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            if (!BuiltInFictitiousFunctionClassFactory2) {
                getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22);
            } else {
                MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            }
        }
    }

    private void getAuthRequestContext(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        MyBillsEntityDataFactory(path);
    }

    private void MyBillsEntityDataFactory(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        MyBillsEntityDataFactory(path);
    }

    private void MyBillsEntityDataFactory(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("The Path has a invalid length ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        this.MyBillsEntityDataFactory = new float[min];
        this.BuiltInFictitiousFunctionClassFactory = new float[min];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((i2 * length) / ((float) (min - 1)), fArr, null);
            this.MyBillsEntityDataFactory[i2] = fArr[0];
            this.BuiltInFictitiousFunctionClassFactory[i2] = fArr[1];
        }
        if (Math.abs(this.MyBillsEntityDataFactory[0]) <= 1.0E-5d && Math.abs(this.BuiltInFictitiousFunctionClassFactory[0]) <= 1.0E-5d) {
            int i3 = min - 1;
            if (Math.abs(this.MyBillsEntityDataFactory[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.BuiltInFictitiousFunctionClassFactory[i3] - 1.0f) <= 1.0E-5d) {
                float f = 0.0f;
                int i4 = 0;
                while (i < min) {
                    float[] fArr2 = this.MyBillsEntityDataFactory;
                    float f2 = fArr2[i4];
                    if (f2 < f) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("The Path cannot loop back on itself, x :");
                        sb2.append(f2);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    fArr2[i] = f2;
                    i++;
                    i4++;
                    f = f2;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb3.append(this.MyBillsEntityDataFactory[0]);
        sb3.append(",");
        sb3.append(this.BuiltInFictitiousFunctionClassFactory[0]);
        sb3.append(" end:");
        int i5 = min - 1;
        sb3.append(this.MyBillsEntityDataFactory[i5]);
        sb3.append(",");
        sb3.append(this.BuiltInFictitiousFunctionClassFactory[i5]);
        throw new IllegalArgumentException(sb3.toString());
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.MyBillsEntityDataFactory.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.MyBillsEntityDataFactory[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.MyBillsEntityDataFactory;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.BuiltInFictitiousFunctionClassFactory[i];
        }
        float[] fArr2 = this.BuiltInFictitiousFunctionClassFactory;
        float f5 = fArr2[i];
        return f5 + (((f - f3) / f4) * (fArr2[length] - f5));
    }
}
