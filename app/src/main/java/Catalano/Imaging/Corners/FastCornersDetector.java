package Catalano.Imaging.Corners;

/* loaded from: classes6.dex */
public class FastCornersDetector implements ICornersFeatureDetector {
    private int getAuthRequestContext = 20;
    private boolean MyBillsEntityDataFactory = true;
    private Algorithm BuiltInFictitiousFunctionClassFactory = Algorithm.FAST_9;

    /* loaded from: classes6.dex */
    public enum Algorithm {
        FAST_9,
        FAST_12
    }

    /* renamed from: Catalano.Imaging.Corners.FastCornersDetector$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Algorithm.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Algorithm.FAST_9.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.FAST_12.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
