package Catalano.Imaging.Filters;

/* loaded from: classes6.dex */
public class DistanceTransform {
    private float BuiltInFictitiousFunctionClassFactory = 0.0f;
    private Distance getAuthRequestContext = Distance.Euclidean;

    /* loaded from: classes6.dex */
    public enum Distance {
        Chessboard,
        Euclidean,
        Manhattan,
        SquaredEuclidean
    }

    /* renamed from: Catalano.Imaging.Filters.DistanceTransform$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[Distance.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Distance.Euclidean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Distance.Manhattan.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Distance.Chessboard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Distance.SquaredEuclidean.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
