package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes6.dex */
public class PatternPathMotion extends PathMotion {
    private Path BuiltInFictitiousFunctionClassFactory;
    private final Matrix KClassImpl$Data$declaredNonStaticMembers$2;
    private final Path MyBillsEntityDataFactory;

    public PatternPathMotion() {
        Path path = new Path();
        this.MyBillsEntityDataFactory = path;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.BuiltInFictitiousFunctionClassFactory = path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.MyBillsEntityDataFactory = new Path();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.getAuthRequestContext);
        try {
            String BuiltInFictitiousFunctionClassFactory = TypedArrayUtils.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (BuiltInFictitiousFunctionClassFactory == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            BuiltInFictitiousFunctionClassFactory(PathParser.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        this.MyBillsEntityDataFactory = new Path();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Matrix();
        BuiltInFictitiousFunctionClassFactory(path);
    }

    private void BuiltInFictitiousFunctionClassFactory(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float sqrt = 1.0f / ((float) Math.sqrt((f5 * f5) + (r6 * r6)));
        this.KClassImpl$Data$declaredNonStaticMembers$2.postScale(sqrt, sqrt);
        this.KClassImpl$Data$declaredNonStaticMembers$2.postRotate((float) Math.toDegrees(-Math.atan2(f2 - f4, f5)));
        path.transform(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        this.BuiltInFictitiousFunctionClassFactory = path;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        float f5 = f4 - f2;
        float sqrt = (float) Math.sqrt((r6 * r6) + (f5 * f5));
        double atan2 = Math.atan2(f5, f3 - f);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setScale(sqrt, sqrt);
        this.KClassImpl$Data$declaredNonStaticMembers$2.postRotate((float) Math.toDegrees(atan2));
        this.KClassImpl$Data$declaredNonStaticMembers$2.postTranslate(f, f2);
        Path path = new Path();
        this.MyBillsEntityDataFactory.transform(this.KClassImpl$Data$declaredNonStaticMembers$2, path);
        return path;
    }
}
