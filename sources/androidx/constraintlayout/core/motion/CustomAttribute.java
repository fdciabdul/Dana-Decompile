package androidx.constraintlayout.core.motion;

/* loaded from: classes6.dex */
public class CustomAttribute {
    private int BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    public AttributeType getAuthRequestContext;

    /* loaded from: classes6.dex */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    /* renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[AttributeType.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                getAuthRequestContext[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(float[] fArr) {
        switch (AnonymousClass1.getAuthRequestContext[this.getAuthRequestContext.ordinal()]) {
            case 2:
                fArr[0] = this.MyBillsEntityDataFactory ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i = this.PlaceComponentResult;
                float pow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((i & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = ((i >> 24) & 255) / 255.0f;
                return;
            case 6:
                fArr[0] = this.BuiltInFictitiousFunctionClassFactory;
                return;
            case 7:
                fArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return;
            case 8:
                fArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return;
            default:
                return;
        }
    }
}
