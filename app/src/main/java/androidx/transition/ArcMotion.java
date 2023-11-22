package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes6.dex */
public class ArcMotion extends PathMotion {
    private static final float getAuthRequestContext = (float) Math.tan(Math.toRadians(35.0d));
    private float BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    private float getErrorConfigVersion;
    private float scheduleImpl;

    public ArcMotion() {
        this.PlaceComponentResult = 0.0f;
        this.getErrorConfigVersion = 0.0f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 70.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.scheduleImpl = 0.0f;
        this.MyBillsEntityDataFactory = getAuthRequestContext;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = 0.0f;
        this.getErrorConfigVersion = 0.0f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 70.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.scheduleImpl = 0.0f;
        this.MyBillsEntityDataFactory = getAuthRequestContext;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.KClassImpl$Data$declaredNonStaticMembers$2);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        float KClassImpl$Data$declaredNonStaticMembers$2 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f);
        this.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2;
        this.scheduleImpl = BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
        float KClassImpl$Data$declaredNonStaticMembers$22 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f);
        this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$22;
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$22);
        float KClassImpl$Data$declaredNonStaticMembers$23 = TypedArrayUtils.KClassImpl$Data$declaredNonStaticMembers$2(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$23;
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$23);
        obtainStyledAttributes.recycle();
    }

    private static float BuiltInFictitiousFunctionClassFactory(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        Path path = new Path();
        path.moveTo(f, f2);
        float f8 = f3 - f;
        float f9 = f4 - f2;
        float f10 = (f8 * f8) + (f9 * f9);
        float f11 = (f + f3) / 2.0f;
        float f12 = (f2 + f4) / 2.0f;
        float f13 = 0.25f * f10;
        boolean z = f2 > f4;
        if (Math.abs(f8) < Math.abs(f9)) {
            float abs = Math.abs(f10 / (f9 * 2.0f));
            if (z) {
                f6 = abs + f4;
                f5 = f3;
            } else {
                f6 = abs + f2;
                f5 = f;
            }
            f7 = this.scheduleImpl;
        } else {
            float f14 = f10 / (f8 * 2.0f);
            if (z) {
                f6 = f2;
                f5 = f14 + f;
            } else {
                f5 = f3 - f14;
                f6 = f4;
            }
            f7 = this.BuiltInFictitiousFunctionClassFactory;
        }
        float f15 = f13 * f7 * f7;
        float f16 = f11 - f5;
        float f17 = f12 - f6;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.MyBillsEntityDataFactory;
        float f20 = f13 * f19 * f19;
        if (f18 >= f15) {
            f15 = f18 > f20 ? f20 : 0.0f;
        }
        if (f15 != 0.0f) {
            float sqrt = (float) Math.sqrt(f15 / f18);
            f5 = ((f5 - f11) * sqrt) + f11;
            f6 = f12 + (sqrt * (f6 - f12));
        }
        path.cubicTo((f + f5) / 2.0f, (f2 + f6) / 2.0f, (f5 + f3) / 2.0f, (f6 + f4) / 2.0f, f3, f4);
        return path;
    }
}
