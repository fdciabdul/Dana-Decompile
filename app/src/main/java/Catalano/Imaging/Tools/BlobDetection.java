package Catalano.Imaging.Tools;

/* loaded from: classes6.dex */
public class BlobDetection {
    private Algorithm MyBillsEntityDataFactory = Algorithm.FourWay;
    private int scheduleImpl = 0;
    private int moveToNextValue = 0;
    private int lookAheadTest = 0;
    private int PlaceComponentResult = 0;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private int getAuthRequestContext = 1;
    private int BuiltInFictitiousFunctionClassFactory = 0;

    /* loaded from: classes6.dex */
    public enum Algorithm {
        FourWay,
        EightWay
    }

    /* renamed from: Catalano.Imaging.Tools.BlobDetection$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[Algorithm.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Algorithm.FourWay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Algorithm.EightWay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
