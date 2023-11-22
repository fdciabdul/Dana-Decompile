package fsimpl;

/* renamed from: fsimpl.dt  reason: case insensitive filesystem */
/* loaded from: classes.dex */
/* synthetic */ class C0322dt {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7946a;
    static final /* synthetic */ int[] b;
    static final /* synthetic */ int[] c;

    static {
        int[] iArr = new int[dI.values().length];
        c = iArr;
        try {
            iArr[dI.CONFIRM_READY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            c[dI.DELETE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[dD.values().length];
        b = iArr2;
        try {
            iArr2[dD.END.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[dD.CONTINUE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[dD.DELETE_CONTINUE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr3 = new int[dL.values().length];
        f7946a = iArr3;
        try {
            iArr3[dL.NATURAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f7946a[dL.MONOTONIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
