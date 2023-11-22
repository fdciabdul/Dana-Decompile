package androidx.constraintlayout.core.parser;

/* loaded from: classes6.dex */
public class CLToken extends CLElement {

    /* loaded from: classes6.dex */
    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[Type.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Type.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Type.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Type.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
