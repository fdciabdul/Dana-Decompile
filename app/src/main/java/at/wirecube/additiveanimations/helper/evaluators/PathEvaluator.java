package at.wirecube.additiveanimations.helper.evaluators;

import android.graphics.Path;
import android.graphics.PathMeasure;

/* loaded from: classes3.dex */
public class PathEvaluator {
    private float PlaceComponentResult = -1.0f;
    private float[] BuiltInFictitiousFunctionClassFactory = new float[2];
    private float getAuthRequestContext = 0.0f;

    /* loaded from: classes3.dex */
    public enum PathMode {
        X,
        Y,
        ROTATION;

        public static PathMode from(int i) {
            if (i != 1) {
                if (i == 2) {
                    return ROTATION;
                }
                return X;
            }
            return Y;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: at.wirecube.additiveanimations.helper.evaluators.PathEvaluator$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[PathMode.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[PathMode.X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[PathMode.Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[PathMode.ROTATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private float getAuthRequestContext(PathMode pathMode) {
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[pathMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return 0.0f;
                }
                return this.getAuthRequestContext;
            }
            return this.BuiltInFictitiousFunctionClassFactory[1];
        }
        return this.BuiltInFictitiousFunctionClassFactory[0];
    }

    public final float KClassImpl$Data$declaredNonStaticMembers$2(float f, PathMode pathMode, Path path) {
        if (f == this.PlaceComponentResult) {
            return getAuthRequestContext(pathMode);
        }
        PathMeasure pathMeasure = new PathMeasure(path, true);
        pathMeasure.getPosTan(pathMeasure.getLength() * f, this.BuiltInFictitiousFunctionClassFactory, new float[2]);
        this.getAuthRequestContext = (float) ((Math.atan2(r0[1], r0[0]) * 180.0d) / 3.141592653589793d);
        this.PlaceComponentResult = f;
        return getAuthRequestContext(pathMode);
    }
}
